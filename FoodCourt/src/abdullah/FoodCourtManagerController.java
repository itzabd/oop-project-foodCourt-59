package abdullah;

import Saif.StallManager;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.Month;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import java.io.EOFException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Period;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodCourtManagerController implements Initializable {

    @FXML
    private Button saleReport_btn;
    @FXML
    private Button home_btn;
    @FXML
    private Button stallDetails_btn;
    @FXML
    private Button sendUserNotice_btn;
    @FXML
    private Button complaint_btn;
    @FXML
    private Button ResolvePaymentDispute_btn;
    @FXML
    private Button addNewPolicy_btn;
    @FXML
    private Button reviewApplication_Btn;
    @FXML
    private Button regStall_btn;
    @FXML
    private AnchorPane dashboard;
    @FXML
    private AnchorPane stall_managementScene;
    @FXML
    private AnchorPane stall_detailsScene;
    @FXML
    private AnchorPane reviewApplication_scene;
    @FXML
    private AnchorPane salesReportScene;
    @FXML
    private AnchorPane sendUserNotice_scene;
    @FXML
    private AnchorPane resolvePaymentDisputeScene;
    @FXML
    private AnchorPane complaintsScene;
    @FXML
    private AnchorPane addNewPolicy_scene;
    private ArrayList<Stall> StallArr;
    @FXML
    private TextField stallNameTF;
    @FXML
    private DatePicker RentFromTF;
    @FXML
    private DatePicker RentTToTF;
    @FXML
    private TextField contactNumberTF;
    @FXML
    private TableView<Stall> tableView;
    @FXML
    private TableColumn<Stall, String> StallName_TC;
    @FXML
    private TableColumn<Stall, String> contactNo_TC;
    @FXML
    private TableColumn<Stall, String> stallManagerName_TC;
    @FXML
    private TableColumn<Stall, String> stallType_TC;
    @FXML
    private ComboBox<String> stallTypeCB;
    @FXML
    private TableView<Stall> tableView1;
    @FXML
    private TableColumn<Stall, String> S2_StallName_TC;
    @FXML
    private TableColumn<Stall, String> S2_contactNo_TC;
    @FXML
    private TableColumn<Stall, String> S2_stallManagerName_TC;
    @FXML
    private TableColumn<Stall, String> S2_stallType_TC;
    @FXML
    private TextField S2_searchTF;
    @FXML
    private AnchorPane stall_detailsScene1;
    @FXML
    private TextField S2_searchTF1;
    @FXML
    private TableView<Stall> tableView11;
    @FXML
    private TableColumn<Stall, String> S2_StallName_TC1;
    @FXML
    private TableColumn<Stall, String> S2_contactNo_TC1;
    @FXML
    private TableColumn<Stall, String> S2_stallManagerName_TC1;
    @FXML
    private TableColumn<Stall, String> S2_stallType_TC1;
    @FXML
    private TextArea S2_OutTextArea;
    private TableColumn<Stall, LocalDate> S2_stallType_TC2;
    @FXML
    private TableColumn<Stall, LocalDate> S2_rentExpired;
    @FXML
    private TextArea Notice_des_SendNotice;
    @FXML
    private ComboBox<String> userTypeComboBox_SendNotice;
    @FXML
    private TextField NoticeNameTF_SendNotice;
    @FXML
    private DatePicker Date_SendNotice;
    @FXML
    private TextField NoticeAboutTF_SendNotice;
    @FXML
    private TableView<Complaint> ComplaintTableView;
    @FXML
    private TableColumn<Complaint, Integer> complaint_idTC;
    @FXML
    private TableColumn<Complaint, String> complaint_fromTC;
    @FXML
    private TableColumn<Complaint, LocalDate> complaint_dateTC;
    @FXML
    private TextArea complaintDetailsTextArea;
    private ObservableList<Complaint> complaintList = FXCollections.observableArrayList();
    private ComboBox<String> stallManagerNameComboBox;
    @FXML
    private TextField StallManagerNameTF;
    @FXML
    private TableView<StallManager> newSignedStallManagerTableView;
    @FXML
    private TableColumn<StallManager, String> stallManagerTC;
    @FXML
    private TableColumn<StallManager, String> contactNoTC;
    @FXML
    private PieChart pieChart;
    @FXML
    private TableView<RatingAndFeedback> FRtableView;
    @FXML
    private TableColumn<RatingAndFeedback, String> FrStallNameTC;
    @FXML
    private TableColumn<RatingAndFeedback, String> FRRatingTC;
    @FXML
    private TextArea FRtextArea;
    @FXML
    private TextArea polocityDesTextArea;
    @FXML
    private DatePicker policyDate;
    @FXML
    private TextField policyNameTF;
    @FXML
    private TextArea PolicyTA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stallManagerTC.setCellValueFactory(new PropertyValueFactory<StallManager, String>("name"));
        contactNoTC.setCellValueFactory(new PropertyValueFactory<StallManager, String>("contNo"));
        newSignedStallManagerTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObjectInputStream ois1 = null;
        try {
            ObservableList<StallManager> stallManager = FXCollections.observableArrayList();

            //if the file exists before attempting to open it
            File stallObjectsFile = new File("StallObjects.bin");
            if (!stallObjectsFile.exists()) {
                System.out.println("StallObjects.bin does not exist.");
                return;
            }

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(stallObjectsFile));
            ArrayList<Stall> stallList = new ArrayList<>();
            try {
                while (true) {
                    try {
                        Stall s = (Stall) ois2.readObject();
                        stallList.add(s);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } finally {
                ois2.close();
            }

            //Load stall managers from StallManagerList.bin
            ois1 = new ObjectInputStream(new FileInputStream("StallManagerList.bin"));
            while (true) {
                try {
                    StallManager f = (StallManager) ois1.readObject();
                    boolean exists = false;
                    for (Stall stall : stallList) {
                        if (stall.getStallManagerName().equals(f.getName())) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        stallManager.add(f);
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            newSignedStallManagerTableView.setItems(stallManager);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois1 != null) {
                try {
                    ois1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //#for Scene 1 Start
        stallTypeCB.getItems().addAll("Fast Food", "Restaurant",
                "Pizza and Italian Cuisine", "Coffee and Tea");
        StallName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallName"));
        contactNo_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("contactNo"));
        stallManagerName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallManagerName"));
        stallType_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallType"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObjectInputStream ois = null;
        {
            ObservableList<Stall> stalllist = FXCollections.observableArrayList();
            try {
                Stall s;

                ois = new ObjectInputStream(new FileInputStream("StallObjects.bin"));

                while (true) {
                    s = (Stall) ois.readObject();
                    stalllist.add(s);
                    tableView.setItems(stalllist);
                    tableView1.setItems(stalllist);
                }

            } catch (RuntimeException e) {
                e.printStackTrace();

            } catch (Exception ex) {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex1) {
                }
            }

        }//#for Scene 1 END
        //#for Scene 2 Start
        //---------------------------------
        tableView1.setEditable(true);
        S2_StallName_TC.setCellFactory(TextFieldTableCell.forTableColumn());
        S2_stallManagerName_TC.setCellFactory(TextFieldTableCell.forTableColumn());
        S2_contactNo_TC.setCellFactory(TextFieldTableCell.forTableColumn());

        S2_StallName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallName"));
        S2_contactNo_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("contactNo"));
        S2_stallManagerName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallManagerName"));
        S2_stallType_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallType"));
        S2_rentExpired.setCellValueFactory(new PropertyValueFactory<Stall, LocalDate>("RentTo"));
        tableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tableView.getSelectionModel().clearSelection();
                tableView.getSelectionModel().select(newSelection);
            }
        });
        //--------------Send Notice Initialz-------------------
        userTypeComboBox_SendNotice.getItems().addAll("Online Customer", "Stall Manager",
                "Security Department", "Food Supplier");

        //----------------Complaint scene Init----------------------
        ComplaintTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        complaint_idTC.setCellValueFactory(new PropertyValueFactory<>("Id"));
        complaint_fromTC.setCellValueFactory(new PropertyValueFactory<>("NameOfC"));
        complaint_dateTC.setCellValueFactory(new PropertyValueFactory<>("CDate"));
        //-------rating Feedback
        FrStallNameTC.setCellValueFactory(new PropertyValueFactory<>("stallCB"));
        FRRatingTC.setCellValueFactory(new PropertyValueFactory<>("review"));
        FRtableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void sceneSwitch(ActionEvent event) {
        if (event.getSource() == home_btn) {
            dashboard.setVisible(true);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == regStall_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(true);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == stallDetails_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(true);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == reviewApplication_Btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(true);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == saleReport_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(true);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == complaint_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(true);
            addNewPolicy_scene.setVisible(false);    //ResolvePaymentDispute_btn
        } else if (event.getSource() == addNewPolicy_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(true);
        } else if (event.getSource() == ResolvePaymentDispute_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(true);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        } else if (event.getSource() == sendUserNotice_btn) {
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(true);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    //ResolvePaymentDispute_btn
        }
    }

    @FXML
    private void ApproveButtonOnClick(ActionEvent event) {

        StallManager selectedManager = newSignedStallManagerTableView.getSelectionModel().getSelectedItem();

        if (selectedManager != null) {

            StallManagerNameTF.setText(selectedManager.getName());
            contactNumberTF.setText(selectedManager.getContNo());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Manager Approved");
            alert.setHeaderText(null);
            alert.setContentText("The new manager has been approved.");
            alert.showAndWait();

            newSignedStallManagerTableView.getItems().remove(selectedManager);

            removeStallManagerFromFile(selectedManager);
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Stall Manager from the table.");
            alert.showAndWait();
        }
//        StallManager selectedManager = newSignedStallManagerTableView.getSelectionModel().getSelectedItem();
//    if (selectedManager != null) {
//        // Set the Stall Manager Name and Contact in the text fields
//        StallManagerNameTF.setText(selectedManager.getName());
//        contactNumberTF.setText(selectedManager.getContNo());

//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Manager Approved");
//        alert.setHeaderText(null);
//        alert.setContentText("The new manager has been approved.");
//        alert.showAndWait();
//        newSignedStallManagerTableView.getItems().remove(selectedManager);
//    } else {
//        // If no item is selected, show an alert
//        Alert alert = new Alert(AlertType.WARNING);
//        alert.setTitle("No Selection");
//        alert.setHeaderText(null);
//        alert.setContentText("Please select a Stall Manager from the table.");
//        alert.showAndWait();
//    }  
    }

    private void removeStallManagerFromFile(StallManager selectedManager) {
        List<StallManager> updatedManagerList = new ArrayList<>();

        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("StallManagerList.bin"))) {
            while (true) {
                try {
                    StallManager f = (StallManager) ois1.readObject();
                    // If the current manager is not the selected one, add it to the updated list
                    if (!f.equals(selectedManager)) {
                        updatedManagerList.add(f);
                    }
                } catch (EOFException e) {
                    // Reached end of file, exit the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Write the updated list back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StallManagerList.bin"))) {
            for (StallManager manager : updatedManagerList) {
                oos.writeObject(manager);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addButton_regStallOnClick(ActionEvent event) {

        //check if all data fields are entered or not
        if (stallNameTF.getText().isEmpty() || StallManagerNameTF.getText().isEmpty()
                || stallTypeCB.getValue() == null || RentFromTF.getValue() == null
                || RentTToTF.getValue() == null || contactNumberTF.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all required fields");
            alert.showAndWait();
            return;
        }

        ObservableList<Stall> stalllist = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        {

            try {
                Stall s;

                ois = new ObjectInputStream(new FileInputStream("StallObjects.bin"));

                while (true) {
                    s = (Stall) ois.readObject();
                    stalllist.add(s);
                    tableView.setItems(stalllist);
                }

            } catch (RuntimeException e) {
                e.printStackTrace();

            } catch (Exception ex) {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex1) {
                }
            }

        }
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("StallObjects.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Stall s = new Stall(stallNameTF.getText(),
                    StallManagerNameTF.getText(), stallTypeCB.getValue(),
                    RentFromTF.getValue(), RentTToTF.getValue(),
                    contactNumberTF.getText()
            );

            oos.writeObject(s);
            stalllist.add(s);
            tableView.setItems(stalllist);

            stallNameTF.clear();
            StallManagerNameTF.clear();
            stallTypeCB.setValue(null);
            RentFromTF.setValue(null);
            RentTToTF.setValue(null);
            contactNumberTF.clear();
        } catch (IOException ex) {

            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void ChangeContactNumberTC(CellEditEvent edittedCell) {
        Stall stallSelected = tableView.getSelectionModel().getSelectedItem();
        stallSelected.setContactNo((edittedCell.getNewValue().toString()));
        updateFile();

    }

    @FXML
    private void ChangeStallManagerName(CellEditEvent edittedCell) {
        Stall stallSelected = tableView.getSelectionModel().getSelectedItem();
        stallSelected.setStallManagerName((edittedCell.getNewValue().toString()));
        updateFile();
    }

    @FXML
    private void ChangeStallNameCellEvent(CellEditEvent edittedCell) {
        Stall stallSelected = tableView.getSelectionModel().getSelectedItem();
        stallSelected.setStallName((edittedCell.getNewValue().toString()));
        updateFile();

    }

    private void updateFile() {
        try (FileOutputStream fos = new FileOutputStream("StallObjects.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ObservableList<Stall> stallList = tableView.getItems();

            for (Stall stall : stallList) {
                oos.writeObject(stall);
            }
        } catch (IOException ex) {
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeButtonOnclick(ActionEvent event) {
        ObservableList<Stall> selectedStalls, allStalls;
        allStalls = tableView.getItems();
        selectedStalls = tableView.getSelectionModel().getSelectedItems();
        if (selectedStalls.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item to remove.");
            alert.showAndWait();
            return;
        }
        for (Stall stall : selectedStalls) {
            allStalls.remove(stall);
        }
        updateFile();
    }

    private ObservableList<Stall> filteredItems = FXCollections.observableArrayList();

    @FXML
    private void S2_searchButton(ActionEvent event) {
        String X = S2_searchTF.getText().toLowerCase();
        ObservableList<Stall> allItems = tableView.getItems();
        filteredItems.clear();

        for (Stall stall : allItems) {
            if (stall.getStallName().toLowerCase().contains(X)
                    || stall.getStallManagerName().toLowerCase().contains(X)
                    || stall.getContactNo().toLowerCase().contains(X)
                    || stall.getStallType().toLowerCase().contains(X)) {
                filteredItems.add(stall);
            }
        }
        tableView1.setItems(filteredItems);
    }

    @FXML
    private void S2_confirmButton(ActionEvent event) {
    }

    @FXML
    private void S2_stallName_TC(CellEditEvent edittedCell) {
        Stall stallSelected = tableView1.getSelectionModel().getSelectedItem();
        stallSelected.setStallName((edittedCell.getNewValue().toString()));
        updateFile();
        tableView.refresh();
    }

    @FXML
    private void S2_CoontactNumber_TC(CellEditEvent edittedCell) {
        Stall stallSelected = tableView1.getSelectionModel().getSelectedItem();
        stallSelected.setContactNo((edittedCell.getNewValue().toString()));
        updateFile();
        tableView.refresh();
    }

    @FXML
    private void S2_StallManagerName_TC(CellEditEvent edittedCell) {
        Stall stallSelected = tableView1.getSelectionModel().getSelectedItem();
        stallSelected.setStallManagerName((edittedCell.getNewValue().toString()));
        updateFile();
        tableView.refresh();
    }

    private void updateFile1() {
        try (FileOutputStream fos = new FileOutputStream("StallObjects.bin", true); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ObservableList<Stall> stallList = tableView1.getItems();

            for (Stall stall : stallList) {
                oos.writeObject(stall);
            }
        } catch (IOException ex) {
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void S2_StallType_TC(CellEditEvent event) {
    }

    @FXML
    private void S2_loadButton(ActionEvent event) {

        tableView1.setItems(tableView.getItems());
    }

    @FXML
    private void S2_viewDetailsbuttonOnClick(ActionEvent event) {
        Stall selectedStall = tableView1.getSelectionModel().getSelectedItem();
        if (selectedStall != null) {
            LocalDate rentFrom = selectedStall.getRentFrom();
            LocalDate rentTo = selectedStall.getRentTo();

            if (rentFrom != null && rentTo != null) {
                //remaining days
                long remainingDays = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), rentTo);

                S2_OutTextArea.setText("Remaining Rental Days: " + remainingDays);

                if (remainingDays < 0) {
                    //alert to remove
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("Rental period has expired. Remove this stall from the database.");
                    alert.showAndWait();
                } else if (remainingDays < 7) {
                    //alert for re-agreement
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("Remaining rental days are less than 7. Consider re-agreement.");
                    alert.showAndWait();
                }
            } else {
                S2_OutTextArea.setText("Rent dates are not set for this stall.");
            }
        } else {
            S2_OutTextArea.setText("Please select a stall from the table.");
        }
    }

    @FXML
    private void S2_rentExpiredDate_TC(CellEditEvent edittedCell) {

    }

    @FXML
    private void S2_extendRentAgreementButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExtentRentAgreement.fxml"));
        Parent root = loader.load();

        ExtentRentAgreementController controller = loader.getController();
        Stall selectedStall = tableView1.getSelectionModel().getSelectedItem();

        if (selectedStall != null) {
            controller.setSelectedStall(selectedStall);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Extend Rent Agreement");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            tableView1.refresh();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a stall to extend the rent agreement.");
            alert.showAndWait();
        }

    }

    @FXML
    private void S2_ssaveButton(ActionEvent event) {
        try (FileOutputStream fos = new FileOutputStream("StallObjects.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ObservableList<Stall> stallList = tableView1.getItems();

            for (Stall stall : stallList) {
                oos.writeObject(stall);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Data saved successfully.");
            alert.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save data.");
            alert.showAndWait();
            tableView1.refresh();

        }
    }

    @FXML
    private void ClearDescriptionButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void SendNoticeButtonOnClick(ActionEvent event) {
        String userType = userTypeComboBox_SendNotice.getValue();
        LocalDate date = Date_SendNotice.getValue();
        String noticeName = NoticeNameTF_SendNotice.getText();
        String noticeAbout = NoticeAboutTF_SendNotice.getText();
        String noticeDescription = Notice_des_SendNotice.getText();

        if (userType == null || date == null || noticeName.isEmpty() || noticeAbout.isEmpty() || noticeDescription.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all required fields.");
            alert.showAndWait();
            return;
        }

        SendNotice notice = new SendNotice(noticeName, noticeAbout, userType, date, noticeDescription);

        Path filePath = Paths.get("SendNotice.bin");

        try {
            if (Files.exists(filePath)) {
                try (FileOutputStream fos = new FileOutputStream(filePath.toString(), true); AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
                    oos.writeObject(notice);
                }
            } else {

                try (FileOutputStream fos = new FileOutputStream(filePath.toString()); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(notice);
                }
            }

            userTypeComboBox_SendNotice.setValue(null);
            Date_SendNotice.setValue(null);
            NoticeNameTF_SendNotice.clear();
            NoticeAboutTF_SendNotice.clear();
            Notice_des_SendNotice.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice Sent");
            alert.setHeaderText(null);
            alert.setContentText("Notice has been sent successfully.");
            alert.showAndWait();
        } catch (IOException ex) {

            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to send notice.");
            alert.showAndWait();
        }
    }

    @FXML
    private void viewDetailsComplaintOnClick(ActionEvent event) {
        Complaint selectedComplaint = ComplaintTableView.getSelectionModel().getSelectedItem();

        if (selectedComplaint != null) {
            String description = "Complaint about - " + selectedComplaint.getcAbout() + "\n"
                    + "Complaint details - " + "\n\n" + selectedComplaint.getcDetails();
            complaintDetailsTextArea.setText(description);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Complaint from the list.");
            alert.showAndWait();
        }
    }

    @FXML //kaaj  korte hbe
    private void deleteComplaintBAXuttonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        ObjectInputStream ois2 = null;
        {
            ObservableList<Complaint> complaint = FXCollections.observableArrayList();
            try {
                Complaint c;

                ois2 = new ObjectInputStream(new FileInputStream("ComplaintList.bin"));

                while (true) {
                    c = (Complaint) ois2.readObject();
                    complaint.add(c);
                    ComplaintTableView.setItems(complaint);

                }

            } catch (RuntimeException e) {
                e.printStackTrace();

            } catch (Exception ex) {
                try {
                    if (ois2 != null) {
                        ois2.close();
                    }
                } catch (IOException ex1) {
                }
            }

        }
    }

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
        //for foodcourt Manager
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/CreateAccLogInAndForgotPass.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("You have been logged out successfully");
            alert.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

    @FXML
    private void loadPieChart(ActionEvent event) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OnlineCustomerList.bin"))) {

            int under18Count = 0;
            int from18to30Count = 0;
            int from31to45Count = 0;
            int from46to60Count = 0;
            int over60Count = 0;
            while (true) {
                try {
                    OnlineCustomer customer = (OnlineCustomer) ois.readObject();
                    LocalDate dateOfBirth = customer.getDateOfBirth();
                    int age = calculateAge(dateOfBirth);

                    if (age < 18) {
                        under18Count++;
                    } else if (age >= 18 && age <= 30) {
                        from18to30Count++;
                    } else if (age >= 31 && age <= 45) {
                        from31to45Count++;
                    } else if (age >= 46 && age <= 60) {
                        from46to60Count++;
                    } else {
                        over60Count++;
                    }
                } catch (EOFException e) {

                    break;
                }
            }

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Under 18", under18Count),
                    new PieChart.Data("18 to 30", from18to30Count),
                    new PieChart.Data("31 to 45", from31to45Count),
                    new PieChart.Data("46 to 60", from46to60Count),
                    new PieChart.Data("Over 60", over60Count)
            );

            pieChart.setData(pieChartData);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load customer data.");
            alert.showAndWait();
        }

    }

    private int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    @FXML
    private void loadPieChartGender(ActionEvent event) {
        int maleCount = 0;
        int femaleCount = 0;
        int totalCount = 0;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OnlineCustomerList.bin"))) {
            while (true) {
                try {
                    OnlineCustomer customer = (OnlineCustomer) ois.readObject();

                    String gender = customer.getGender().toLowerCase();
                    if (gender.equals("male")) {
                        maleCount++;
                    } else if (gender.equals("female")) {
                        femaleCount++;
                    }
                    totalCount++;
                } catch (EOFException e) {
                    break;
                }
            }

            double malePercentage = (double) maleCount / totalCount * 100;
            double femalePercentage = (double) femaleCount / totalCount * 100;

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Male (" + String.format("%.2f", malePercentage) + "%)", maleCount),
                    new PieChart.Data("Female (" + String.format("%.2f", femalePercentage) + "%)", femaleCount)
            );

            pieChart.setData(pieChartData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load customer data.");
            alert.showAndWait();
        }
    }

    @FXML
    private void LoadFRButtonOnCLick(ActionEvent event) {
        try {

            FRtableView.getItems().clear();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RatingAndFeedback.bin"))) {
                while (true) {
                    try {

                        RatingAndFeedback feedback = (RatingAndFeedback) ois.readObject();

                        FRtableView.getItems().add(feedback);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ViewFRButtonOnCLick1(ActionEvent event) {
        RatingAndFeedback selectedFeedback = FRtableView.getSelectionModel().getSelectedItem();

        if (selectedFeedback != null) {

            FRtextArea.setText(selectedFeedback.getFeedback());
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a row from the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void downloadAsPdfButtonOnCLick(ActionEvent event) {
        try {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File outputFile = fileChooser.showSaveDialog(null);

            if (outputFile != null) {

                PdfWriter writer = new PdfWriter(new FileOutputStream(outputFile));
                PdfDocument pdfDocument = new PdfDocument(writer);
                Document document = new Document(pdfDocument);

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PolicyList.bin"))) {
                    while (true) {
                        try {

                            Policy policy = (Policy) ois.readObject();

                            document.add(new Paragraph("Policy Name: " + policy.getPname()));
                            document.add(new Paragraph("Policy Description: " + policy.getPdes()));
                            document.add(new Paragraph("Policy Date: " + policy.getPdate().toString()));
                            document.add(new Paragraph("-----------------------------------"));
                        } catch (EOFException e) {

                            break;
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }

                document.close();

                showAlert(Alert.AlertType.INFORMATION, "Success", "PDF saved successfully.");
            } else {
                showAlert(Alert.AlertType.INFORMATION, "Information", "PDF saving cancelled.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }

    @FXML
    private void AddPolicybuttonOnclick(ActionEvent event) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("PolicyList.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            String policyName = policyNameTF.getText();
            String policyDescription = polocityDesTextArea.getText();
            LocalDate policyDateValue = policyDate.getValue();

            Policy policy = new Policy(policyName, policyDescription, policyDateValue);

            oos.writeObject(policy);
            policyNameTF.clear();
            polocityDesTextArea.clear();
            policyDate.setValue(null);
        } catch (IOException ex) {
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void ViewPolicybuttonOnClick(ActionEvent event) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("PolicyList.bin");
            ois = new ObjectInputStream(fis);

            StringBuilder policyDetails = new StringBuilder();

            while (true) {
                try {
                    Policy policy = (Policy) ois.readObject();

                    policyDetails.append("Policy Name: ").append(policy.getPname()).append("\n");
                    policyDetails.append("Description: ").append(policy.getPdes()).append("\n");
                    policyDetails.append("Date: ").append(policy.getPdate().toString()).append("\n\n");
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            PolicyTA.setText(policyDetails.toString());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load policy data.");
            alert.showAndWait();
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

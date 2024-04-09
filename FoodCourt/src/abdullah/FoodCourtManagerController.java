package abdullah;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodCourtManagerController implements Initializable {

    @FXML
    private Label userNameAfterLogin;
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
    private TextField stallManagerNameTF;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //#for Scene 1 Start
        stallTypeCB.getItems().addAll("Fast Food", "Restaurant",
                "Pizza and Italian Cuisine", "Coffee and Tea");
        StallName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallName"));
        contactNo_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("contactNo"));
        stallManagerName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallManagerName"));
        stallType_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallType"));
        //This part allows to edit in Table
        tableView1.setEditable(true);
        S2_StallName_TC.setCellFactory(TextFieldTableCell.forTableColumn());
        S2_stallManagerName_TC.setCellFactory(TextFieldTableCell.forTableColumn());
        S2_contactNo_TC.setCellFactory(TextFieldTableCell.forTableColumn());
//        S2_rentExpired.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
//            @Override
//            public String toString(LocalDate object) {
//                return object != null ? object.toString() : "";
//            }
//
//            @Override
//            public LocalDate fromString(String string) {
//                return string != null && !string.isEmpty() ? LocalDate.parse(string) : null;
//            }
//        }));
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
        S2_StallName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallName"));
        S2_contactNo_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("contactNo"));
        S2_stallManagerName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallManagerName"));
        S2_stallType_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallType"));
        S2_rentExpired.setCellValueFactory(new PropertyValueFactory<Stall, LocalDate>("RentTo"));  
        //Sync both tableView cell
        tableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tableView.getSelectionModel().clearSelection();
                tableView.getSelectionModel().select(newSelection);
            }
        });
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
    private void addButton_regStallOnClick(ActionEvent event) {

        // Check if all data fields are entered or not
        if (stallNameTF.getText().isEmpty() || stallManagerNameTF.getText().isEmpty()
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
                    stallManagerNameTF.getText(), stallTypeCB.getValue(),
                    RentFromTF.getValue(), RentTToTF.getValue(),
                    contactNumberTF.getText()
            );

            oos.writeObject(s);
            stalllist.add(s);
            tableView.setItems(stalllist);

            stallNameTF.clear();
            stallManagerNameTF.clear();
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

    @FXML
    private void back_btn(ActionEvent event) {
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
            // Calculate the remaining days
            long remainingDays = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), rentTo);

            // Display the remaining days in the S2_OutTextArea
            S2_OutTextArea.setText("Remaining Rental Days: " + remainingDays);

            if (remainingDays < 0) {
                // Alert to remove from database
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Rental period has expired. Remove this stall from the database.");
                alert.showAndWait();
            } else if (remainingDays < 7) {
                // Alert for re-agreement
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

    // Access the controller of the ExtentRentAgreement.fxml
    ExtentRentAgreementController controller = loader.getController();

    // Get the selected stall from tableView1
    Stall selectedStall = tableView1.getSelectionModel().getSelectedItem();

    if (selectedStall != null) {
        // Pass the selected stall to the controller
        controller.setSelectedStall(selectedStall);

        // Create a new stage for the ExtentRentAgreement.fxml
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Extend Rent Agreement");
        stage.setScene(new Scene(root));
        stage.showAndWait();

        // Update the table view after extending the rent agreement
        tableView1.refresh();
    } else {
        // Show an alert if no stall is selected
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

        // Show a success message or perform any other necessary actions
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Data saved successfully.");
        alert.showAndWait();
    } catch (IOException ex) {
        Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);

        // Show an error message if data saving fails
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to save data.");
        alert.showAndWait();
        tableView1.refresh();
    }
    }
}
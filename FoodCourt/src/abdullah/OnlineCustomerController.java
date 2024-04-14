/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullah;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OnlineCustomerController implements Initializable {

   
    @FXML    private Button OrderManagement_btn;
    @FXML    private Button orderHistory_btn;
    @FXML    private Button setaddress_btn;
    @FXML    private Button Notification_btn;
    @FXML    private Button ratingAndFeedback_btn;
    @FXML    private Button todaysOffer_btn;
    @FXML    private Button customerAssistance_btn;
    @FXML    private Button viewProfile_btn;
    @FXML    private AnchorPane dashboardOC;
    @FXML    private AnchorPane orderManagement_scene;
    @FXML    private AnchorPane orderHistory_Scene;
    @FXML    private AnchorPane setAddress_scene;
    //private AnchorPane Tab_loadAddress_scene;
    @FXML    private AnchorPane ratingAndFeedback_scene;
    @FXML    private AnchorPane todaysOffer_scene;
    @FXML    private Label todaysOffer1_scene;
    @FXML    private AnchorPane notification_scene;
    @FXML    private AnchorPane customerAssistance_scene;
    @FXML    private Button homeBtn;
    @FXML
    private TableView<SendNotice> NotificationTableView;
    @FXML
    private TableColumn<SendNotice, String> NoticeNameTC;
    @FXML
    private TableColumn<SendNotice, String> NoticeAboutTC;
    @FXML
    private TableColumn<SendNotice, LocalDate> NoticeDateTC;
    @FXML
    private TextArea NoticeViewDetailsTextArea;
    @FXML
    private AnchorPane ViewProfile_scene;
    @FXML
    private DatePicker Date_C;
    private TextField subject_C;
    @FXML
    private TextField NameTF_C;
    @FXML
    private ComboBox<String> userType_C;
    @FXML
    private TextArea details_TextArea_C;
    @FXML
    private TextField About_C;
    @FXML
    private TextField name_profileScene;
    @FXML
    private TextField phoneNo_profileScene;
    @FXML
    private TextField gender_profileScene;
    @FXML
    private TextField email_profileScene;
    @FXML
    private TextArea address_profileScene;
    @FXML
    private DatePicker Dobl_profileScene;
    @FXML
    private TextField userNameTF_ProfileScene;
    @FXML
    private TextField HouseNo_Address;
    private TextField postalCode_Address;
    @FXML
    private TextField bloclNo_Address;
    @FXML
    private TextField streetNo_Address;
    @FXML
    private ComboBox<String> selectArea_Address;
    private TextArea NoteAddresscene;
    @FXML
    private TextField postalCode_Address1;
    @FXML
    private TextArea NoteAddresscene1;
    @FXML
    private TextField usernameAddress;
    @FXML
    private TextArea testbox;
    @FXML
    private TextArea dashboardTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NoticeNameTC.setCellValueFactory(new PropertyValueFactory<>("noticeName"));
        NoticeAboutTC.setCellValueFactory(new PropertyValueFactory<>("noticeSubject"));
        NoticeDateTC.setCellValueFactory(new PropertyValueFactory<>("noticeDate"));
    // Set up table columns
        NoticeNameTC.setCellValueFactory(new PropertyValueFactory<>("noticeName"));
        NoticeAboutTC.setCellValueFactory(new PropertyValueFactory<>("noticeSubject"));
        NoticeDateTC.setCellValueFactory(new PropertyValueFactory<>("noticeDate"));
        
        
        NotificationTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //private String loggedInUsername;
//        ObjectInputStream ois = null;
//        {
//            ObservableList<SendNotice> sendnotice = FXCollections.observableArrayList();
//            try {
//                SendNotice s;
//
//                ois = new ObjectInputStream(new FileInputStream("SendNotice.bin"));
//
//                while (true) {
//                    s = (SendNotice) ois.readObject();
//                    sendnotice.add(s);
//                    NotificationTableView.setItems(sendnotice);
//                    
//                }
//
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//
//            } catch (Exception ex) {
//                try {
//                    if (ois != null) {
//                        ois.close();
//                    }
//                } catch (IOException ex1) {
//                }
//            }
//
//        
          ObjectInputStream ois = null;
        ObservableList<SendNotice> sendnotice = FXCollections.observableArrayList();

        try {
            SendNotice s;

            ois = new ObjectInputStream(new FileInputStream("SendNotice.bin"));

            while (true) {
                s = (SendNotice) ois.readObject();

                // Check if the recipient field contains "Online Customer"
                if (s.getNoticeForUserType().equals("Online Customer")
                        || s.getNoticeForUserType().equals("Food Delivery Partner")) {
                    sendnotice.add(s);
                }
            }

        } catch (EOFException eof) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

// Set the items to the TableView after reading all relevant objects
        NotificationTableView.setItems(sendnotice);
        userType_C.getItems().addAll("Online Customer","Stall Manager"
            ,"Security Department","Food Supplier");
      //Address Scene
      selectArea_Address.getItems().addAll("Bashundhara","Rampura",
              "Kuril","Notunbazar");
            
    }
    

    @FXML
    private void sceneSwitch(ActionEvent event) {
        if (event.getSource() == homeBtn) {
            dashboardOC.setVisible(true);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == orderHistory_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(true);
            setAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == setaddress_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(true);
            ViewProfile_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == Notification_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(true);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == ratingAndFeedback_btn) {
            dashboardOC.setVisible(true);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(true);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == viewProfile_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(true);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);    //ResolvePaymentDispute_btn
        } else if (event.getSource() == todaysOffer_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(true);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == customerAssistance_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(true);
        } else if (event.getSource() == OrderManagement_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(true);
            orderHistory_Scene.setVisible(false);
            ViewProfile_scene.setVisible(false);
            setAddress_scene.setVisible(false);
           // Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        }

    }

    @FXML
    private void ViewNoticeDetailsButtonOnCLick(ActionEvent event) {
      
        SendNotice selectedNotice = NotificationTableView.getSelectionModel().getSelectedItem();
    
    if (selectedNotice != null) {
        
        String description = String.join("\n", selectedNotice.getNoticeDescription());
        
        NoticeViewDetailsTextArea.setText(description);
    } else {
        //error msg
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Please select a notice.");
        alert.showAndWait();
    }
    }
    


    @FXML
    private void reportButtonOnClick_C(ActionEvent event) {
        Random rand = new Random();
        int complaintId = 1000 + rand.nextInt(9000); // You can adjust the range as needed

        LocalDate date = Date_C.getValue();
        String subject = About_C.getText();
        String name = NameTF_C.getText();
        String userType = userType_C.getValue();
        String details = details_TextArea_C.getText();

       
         if (userType == null || date == null || subject.isEmpty() || name.isEmpty() || details.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incomplete Data");
        alert.setHeaderText(null);
        alert.setContentText("Please enter all required fields.");
        alert.showAndWait();
        return;
    }

    Complaint compl = new Complaint(name, subject, userType, details, date,complaintId);

    Path filePath = Paths.get("ComplaintList.bin");

    try {
        if (Files.exists(filePath)) {
            
            try (FileOutputStream fos = new FileOutputStream(filePath.toString(), true);
                 AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
                oos.writeObject(compl);
            }
        } else {
            
            try (FileOutputStream fos = new FileOutputStream(filePath.toString());
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(compl);
            }
        }

        
        userType_C.setValue(null);
        Date_C.setValue(null);
        About_C.clear();
        NameTF_C.clear();
        details_TextArea_C.clear();

        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice Sent");
        alert.setHeaderText(null);
        alert.setContentText("Notice has been sent successfully.");
        alert.showAndWait();
    } catch (IOException ex) {
        
        Logger.getLogger(OnlineCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to send notice.");
        alert.showAndWait();
    }  
      
        
    }

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
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
    private void Loadbutton_ProfileScene(ActionEvent event) {
        String username = userNameTF_ProfileScene.getText();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OnlineCustomerList.bin"))) {
            ObservableList<OnlineCustomer> onCustomer = FXCollections.observableArrayList();
            boolean found = false;

            while (true) {
                OnlineCustomer c = (OnlineCustomer) ois.readObject();
                onCustomer.add(c);

                if (c.getName().equals((username))) {
                    
                    name_profileScene.setText(c.getName());
                    phoneNo_profileScene.setText(c.getContNo());
                    gender_profileScene.setText(c.getGender());
                    email_profileScene.setText(c.getEmail());
                    
                    Dobl_profileScene.setValue(c.getDateOfBirth());

                    found = true;
                    break; 
                }
            }

            if (!found) {
               
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User not found");
                alert.showAndWait();
            }
        } catch (EOFException eof) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveAddressButtonOnClick(ActionEvent event) {
    String houseNo = HouseNo_Address.getText();
    String blockNo = bloclNo_Address.getText();
    String streetNo = streetNo_Address.getText();
    String postalCode = postalCode_Address1.getText();
    String selectedArea = selectArea_Address.getValue();
    String note = NoteAddresscene1.getText();
    String username1 = usernameAddress.getText();

    
    if (username1.isEmpty() || houseNo.isEmpty() || blockNo.isEmpty() || streetNo.isEmpty() ||
            postalCode.isEmpty() || selectedArea == null || note.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incomplete Address");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all address details.");
        alert.showAndWait();
        return;
    }

    Address address = new Address(houseNo, blockNo, streetNo,
            selectedArea, note,postalCode, username1);

    try (ObjectOutputStream oos = new ObjectOutputStream(
                                 new FileOutputStream("CustomerAddressFile.bin", true))) {
        oos.writeObject(address);
        oos.flush();
    } catch (IOException e) {
        e.printStackTrace();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to save address.");
        alert.showAndWait();
        return;
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Address Saved");
    alert.setHeaderText(null);
    alert.setContentText("Address saved successfully.");
    alert.showAndWait();
 
    }

   
 
}

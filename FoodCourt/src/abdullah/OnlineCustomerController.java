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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
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

    @FXML    private Label userNameAfterLogin;
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
    @FXML
    private TextField subject_C;
    @FXML
    private TextField NameTF_C;
    @FXML
    private ComboBox<String> userType_C;
    @FXML
    private TextArea details_TextArea_C;

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
        
        ObjectInputStream ois = null;
        {
            ObservableList<SendNotice> sendnotice = FXCollections.observableArrayList();
            try {
                SendNotice s;

                ois = new ObjectInputStream(new FileInputStream("SendNotice.bin"));

                while (true) {
                    s = (SendNotice) ois.readObject();
                    sendnotice.add(s);
                    NotificationTableView.setItems(sendnotice);
                    
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
        userType_C.getItems().addAll("Online Customer","Stall Manager"
            ,"Security Department","Food Supplier");
        
    }

    @FXML
    private void sceneSwitch(ActionEvent event) {
        if (event.getSource() == homeBtn) {
            dashboardOC.setVisible(true);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == orderHistory_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(true);
            setAddress_scene.setVisible(false);
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
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);    //ResolvePaymentDispute_btn
        } else if (event.getSource() == todaysOffer_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
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
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(true);
        } else if (event.getSource() == OrderManagement_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(true);
            orderHistory_Scene.setVisible(false);
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
    
    private int generateRandomID() {
        Random random = new Random();
        int id = random.nextInt(9000) + 1000;
        return id;
    }

    @FXML
    private void reportButtonOnClick_C(ActionEvent event) {
        
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
}

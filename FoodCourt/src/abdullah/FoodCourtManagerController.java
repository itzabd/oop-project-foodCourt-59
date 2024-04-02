/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodCourtManagerController implements Initializable {

    @FXML    private Label userNameAfterLogin;
    @FXML    private Button saleReport_btn;
    @FXML    private AnchorPane stall_managementScene;
    @FXML    private AnchorPane reviewApplication_scene;
    @FXML    private Button stallManagement_btn;
    @FXML    private Button stallDetails_btn;
    @FXML    private Button sendUserNotice_btn;
    @FXML    private Button complaint_btn;
    @FXML    private Button ResolvePaymentDispute_btn;
    @FXML    private Button addNewPolicy_btn;
    @FXML    private Button reviewApplication_Btn;
    @FXML    private AnchorPane stall_detailsScene;
    @FXML    private AnchorPane salesReportScene;
    @FXML    private AnchorPane complaintsScene;
    @FXML    private AnchorPane resolvePaymentDisputeScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sceneSwitch(ActionEvent event) {
    }
    
}

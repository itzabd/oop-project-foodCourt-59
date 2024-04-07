/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CreateAccLogInAndForgotPassController implements Initializable {

    @FXML  private AnchorPane logInPageFrame;
    @FXML  private ComboBox<String> logInPageUserTypeCombox;
    @FXML  private TextField loginPageUserName;
    @FXML  private PasswordField loginPagePswdField;
    @FXML  private Hyperlink forgotPassHyprLink;
    @FXML  private Button createAccbtn;
    @FXML  private AnchorPane forgotPassFrame;
    @FXML  private Button forgotPassTologinPage;
    @FXML  private AnchorPane createNewUserFrame;
    @FXML  private Button createUserPageToLoginPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logInPageUserTypeCombox.getItems().addAll("Security Depertment","Food Supplier");
    }    

    @FXML
    private void logInPageUserTypeComboxOnClick(ActionEvent event) {
        
    }

    @FXML
    private void switchToOtherFrame(ActionEvent event) {
        if(event.getSource() == forgotPassHyprLink){
            logInPageFrame.setVisible(false);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(true);
        }
        
        else if(event.getSource() == createAccbtn){
            logInPageFrame.setVisible(false);
            createNewUserFrame.setVisible(true);
            forgotPassFrame.setVisible(false);
        }
        
        else if(event.getSource() == createUserPageToLoginPage){
            logInPageFrame.setVisible(true);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(false);
        }
        
        else if(event.getSource() == forgotPassTologinPage){
            logInPageFrame.setVisible(true);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(false);
        }
    }

    @FXML
    private void logInPageSignInBtn(ActionEvent event) throws Exception{
        if(logInPageUserTypeCombox.getValue()=="Security Depertment"){
            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/SecurityDeptDashBoard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        
        else if(logInPageUserTypeCombox.getValue()=="Food Supplier"){
            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/FoodSupplierDashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    
}

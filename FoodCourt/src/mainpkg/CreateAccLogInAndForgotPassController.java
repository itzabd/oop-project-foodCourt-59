/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CreateAccLogInAndForgotPassController implements Initializable {

    @FXML
    private AnchorPane logInPageFrame;
    @FXML
    private ComboBox<?> logInPageUserTypeCombox;
    @FXML
    private TextField loginPageUserName;
    @FXML
    private PasswordField loginPagePswdField;
    @FXML
    private Hyperlink forgotPassHyprLink;
    @FXML
    private Button createAccbtn;
    @FXML
    private AnchorPane forgotPassFrame;
    @FXML
    private Button forgotPassTologinPage;
    @FXML
    private AnchorPane createNewUserFrame;
    @FXML
    private Button createUserPageToLoginPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logInPageUserTypeComboxOnClick(ActionEvent event) {
    }

    @FXML
    private void switchToOtherFrame(ActionEvent event) {
    }

    @FXML
    private void logInPageSignInBtn(ActionEvent event) {
    }
    
}

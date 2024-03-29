/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Shahrier;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SecurityDeptDashBoardController implements Initializable {

    @FXML
    private Button empManageBtn;
    @FXML
    private Button empReportBtn;
    @FXML
    private Button newVehicleRgBtn;
    @FXML
    private Button vehicleInfoTakingBtn;
    @FXML
    private Button reportForVechilebtn;
    @FXML
    private Button emgAlertSendingBtn;
    @FXML
    private Button responseToOtherUsersBtn;
    @FXML
    private Button empSessionManageBtn;
    @FXML
    private Label securityDeptDashboardUserNameLabel;
    @FXML
    private Button seqdeptHomeBtn;
    @FXML
    private AnchorPane empManagementFrame;
    @FXML
    private TextArea empManagementCommentTextArea;
    @FXML
    private AnchorPane reportGenerateForDailyEmpFrame;
    @FXML
    private TextArea empDailyReportGenerateShownArea;
    @FXML
    private Label dailyEmpReportShownAreaLabel;
    @FXML
    private AnchorPane empSessionManagementFrame;
    @FXML
    private AnchorPane newVehcileRegisterFrame;
    @FXML
    private AnchorPane vehicleInfoTakingFrame;
    @FXML
    private AnchorPane generateReportForDailyVehicle;
    @FXML
    private AnchorPane emgAlertSendingFrame;
    @FXML
    private AnchorPane giveOtherUsersResponseFrame;
    @FXML
    private AnchorPane seqdeptFontFrame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToOtherFrameBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void seqDashBoardBackBtn(ActionEvent event) {
    }

    @FXML
    private void empDataConfirmBtn(ActionEvent event) {
    }
    
}

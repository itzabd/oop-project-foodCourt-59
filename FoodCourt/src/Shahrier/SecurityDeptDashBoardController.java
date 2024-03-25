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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author $abit
 */
public class SecurityDeptDashBoardController implements Initializable {

    @FXML  private Button empManageBtn;
    @FXML  private Button empReportBtn;
    @FXML  private Button newVehicleRgBtn;
    @FXML  private Button vehicleInfoTakingBtn;
    @FXML  private Button reportForVechilebtn;
    @FXML  private Button emgAlertSendingBtn;
    @FXML  private Button responseToOtherUsersBtn;
    @FXML  private Button empSessionManageBtn;
    @FXML  private AnchorPane empManagementFrame;
    @FXML  private AnchorPane reportGenerateForDailyEmpFrame;
    @FXML  private AnchorPane empSessionManagementFrame;
    @FXML  private AnchorPane newVehcileRegisterFrame;
    @FXML  private AnchorPane vehicleInfoTakingFrame;
    @FXML  private AnchorPane generateReportForDailyVehicle;
    @FXML  private AnchorPane emgAlertSendingFrame;
    @FXML  private AnchorPane giveOtherUsersResponseFrame;
    @FXML  private Label securityDeptDashboardUserNameLabel;
    @FXML  private Button seqdeptHomeBtn;
    @FXML  private AnchorPane seqdeptFontFrame;
    @FXML  private TextArea empManagementCommentTextArea;
    @FXML  private TextArea empDailyReportGenerateShownArea;
    @FXML  private Label dailyEmpReportShownAreaLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToOtherFrameBtnOnClick(ActionEvent event) {
        if(event.getSource()==empManageBtn){
            empManagementFrame.setVisible(true);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==empReportBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(true);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==empSessionManageBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(true);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==newVehicleRgBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(true);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==vehicleInfoTakingBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(true);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==reportForVechilebtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(true);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==emgAlertSendingBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(true);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==responseToOtherUsersBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(true);
            seqdeptFontFrame.setVisible(false);
        }
        else if(event.getSource()==seqdeptHomeBtn){
            empManagementFrame.setVisible(false);
            reportGenerateForDailyEmpFrame.setVisible(false);
            empSessionManagementFrame.setVisible(false);
            newVehcileRegisterFrame.setVisible(false);
            vehicleInfoTakingFrame.setVisible(false);
            generateReportForDailyVehicle.setVisible(false);
            emgAlertSendingFrame.setVisible(false);
            giveOtherUsersResponseFrame.setVisible(false);
            seqdeptFontFrame.setVisible(true);
        }
    }


    @FXML
    private void empDataConfirmBtn(ActionEvent event) {
    }

    @FXML
    private void seqDashBoardBackBtn(ActionEvent event) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("CreateAccLogInAndForgotPass.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

    
}

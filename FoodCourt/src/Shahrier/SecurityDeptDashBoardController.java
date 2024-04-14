/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Shahrier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class SecurityDeptDashBoardController implements Initializable {

    @FXML  private Button empManageBtn;
    @FXML  private Button empReportBtn;
    @FXML  private Button newVehicleRgBtn;
    @FXML  private Button vehicleInfoTakingBtn;
    @FXML  private Button reportForVechilebtn;
    @FXML  private Button emgAlertSendingBtn;
    @FXML  private Button responseToOtherUsersBtn;
    @FXML  private Button empSessionManageBtn;
    @FXML  private Label securityDeptDashboardUserNameLabel;
    @FXML  private Button seqdeptHomeBtn;
    @FXML  private AnchorPane empManagementFrame;
    @FXML  private TextArea empManagementCommentTextArea;
    @FXML  private AnchorPane reportGenerateForDailyEmpFrame;
    @FXML  private TextArea empDailyReportGenerateShownArea;
    private Label dailyEmpReportShownAreaLabel;
    @FXML  private AnchorPane empSessionManagementFrame;
    @FXML  private AnchorPane newVehcileRegisterFrame;
    @FXML  private AnchorPane vehicleInfoTakingFrame;
    @FXML  private AnchorPane generateReportForDailyVehicle;
    @FXML  private AnchorPane emgAlertSendingFrame;
    @FXML  private AnchorPane giveOtherUsersResponseFrame;
    @FXML  private AnchorPane seqdeptFontFrame;
    @FXML  private DatePicker empManagementDatePicker;
    @FXML  private ComboBox<String> empManagementEmpTypeComBox;
    @FXML  private TextField empManagementEmpNameTextField;
    @FXML  private TextField empManagementEmpIdTextFIeld;
    @FXML  private ComboBox<Integer> empManagementEmpEntryTimeComBox;
    @FXML  private TableView<EmpManagementData> empManagementTableViewData;
    @FXML  private TableColumn<EmpManagementData, String> empNameColumn;
    @FXML  private TableColumn<EmpManagementData, String> empIDColumn;
    @FXML  private TableColumn<EmpManagementData, String> entryTimeColumn;
    @FXML  private TableColumn<EmpManagementData, String> sessionExpierColumn;
    @FXML  private ComboBox<Integer> empManagementSessionExpierComBox;
    @FXML  private ComboBox<String> sessionManagementSelectEmpComBox;
    private ArrayList<EmpManagementData> empManagementDataArr;
    @FXML  private ComboBox<Integer> sessionManagementExitTimeCombox;
    @FXML  private TextField sessionManagementSessionStartTextField;
    @FXML  private TextField sessionManagementSessionExpiryTextField;
    @FXML  private TextField sessionManagementEmpRoleTextField;
    @FXML  private DatePicker selectDateforDailyEmpReport;
    @FXML  private CheckBox grFoodSupplierCheckBox;
    @FXML  private CheckBox grSecurityDeptCheckBox;
    @FXML  private CheckBox grOnlineCustomerCheckBox;
    @FXML  private CheckBox grFoodCourtManagerCheckBox;
    @FXML  private TextField sessionManagementFeedbackBtn;
    @FXML  private DatePicker sessionManagementDatePicker;
    private ArrayList<ReportGeneratingData> reportGenerateDataArr;
    @FXML  private DatePicker newVehicleRegDatePicker;
    @FXML  private TextField newVehicleRegCarModelTextField;
    @FXML  private TextField newVehicleRegLicenseNum;
    @FXML  private TextField newVehicleRegOwnerNameTextField;
    @FXML  private TextField newVehicleRegOwnerContactNum;
    @FXML  private ComboBox<Integer> newVehicleRegDurationCombox;
    @FXML  private TableView<NewVehicleRegData> newVehicleRegTableView;
    @FXML  private TableColumn<NewVehicleRegData, String> vPlateNumColumn;
    @FXML  private TableColumn<NewVehicleRegData, LocalDate> vRegDateColumn;
    @FXML  private TableColumn<NewVehicleRegData, Integer> vRegDurationColumn;
    @FXML  private TableColumn<NewVehicleRegData, String> vOwnersConColumn;
    @FXML  private ComboBox<String> takeVechileInfoSelectLicenseNumCombox;
    private ArrayList<NewVehicleRegData> newVehicleRegDataArr;
    @FXML  private TextField takeVechileInfoParkingTime;
    @FXML  private TextField takeVechileIeInfoParkingCost;
    @FXML  private TextField takeVechileInfoOwnersNameField;
    @FXML  private TextField takeVechileInfoOwnersContactField;
    @FXML  private TextArea takeVechileInfoComplineBox;
    @FXML  private TableView<ParkingAreaVechileData> takeVechileInfoTableView;
    @FXML  private TableColumn<ParkingAreaVechileData, String> takeVechileInfoVechileColumn;
    @FXML  private TableColumn<ParkingAreaVechileData, String> takeVechileInfoParkingTimeColumn;
    @FXML  private TableColumn<ParkingAreaVechileData, String> takeVechileIeInfoCostColumn;
    @FXML  private TableColumn<ParkingAreaVechileData, String> takeVechileInfoCommColumn;
    @FXML  private ComboBox<Integer> takeVechileInfoPerMinCostCombox;
    private ArrayList<ParkingAreaVechileData> parkingAreaVechileDataArr;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reportGenerateDataArr = new ArrayList<>();
        newVehicleRegDataArr = new ArrayList<>();
        empManagementDataArr = new ArrayList<>();
        parkingAreaVechileDataArr = new ArrayList<>();
        
        empNameColumn.setCellValueFactory(new PropertyValueFactory<EmpManagementData,String>("mngEmpDate"));
        empIDColumn.setCellValueFactory(new PropertyValueFactory<EmpManagementData,String>("empId"));
        entryTimeColumn.setCellValueFactory(new PropertyValueFactory<EmpManagementData,String>("empEntryTime"));
        sessionExpierColumn.setCellValueFactory(new PropertyValueFactory<EmpManagementData,String>("empSessionExpieryTime"));
        
        vPlateNumColumn.setCellValueFactory(new PropertyValueFactory<NewVehicleRegData,String>("vehicleLicenseNum"));
        vRegDateColumn.setCellValueFactory(new PropertyValueFactory<NewVehicleRegData,LocalDate>("regDate"));
        vRegDurationColumn.setCellValueFactory(new PropertyValueFactory<NewVehicleRegData,Integer>("regDuration"));
        vOwnersConColumn.setCellValueFactory(new PropertyValueFactory<NewVehicleRegData,String>("vehicleOwnerContact"));
        
        takeVechileInfoVechileColumn.setCellValueFactory(new PropertyValueFactory<ParkingAreaVechileData,String>("vhInfoLicenseNum"));
        takeVechileInfoParkingTimeColumn.setCellValueFactory(new PropertyValueFactory<ParkingAreaVechileData,String>("vhInfoParkingTime"));
        takeVechileIeInfoCostColumn.setCellValueFactory(new PropertyValueFactory<ParkingAreaVechileData,String>("vhInfoParkingCost"));
        takeVechileInfoCommColumn.setCellValueFactory(new PropertyValueFactory<ParkingAreaVechileData,String>("vhInfoComplain"));
        
        newVehicleRegDurationCombox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        
        for(int i=5;i<=15;i++){
            takeVechileInfoPerMinCostCombox.getItems().add(i);
        }
        for(int i=1;i<=24;i++){
            empManagementEmpEntryTimeComBox.getItems().add(i);
        }
        for(int i=1;i<=24;i++){
            empManagementSessionExpierComBox.getItems().add(i);
        }
        for(int i=1;i<=24;i++){
            sessionManagementExitTimeCombox.getItems().add(i);
        }
        
        empManagementEmpTypeComBox.getItems().addAll("Security Depertment","Food Supplier"
                                                     ,"Food Court Manager", "Online Customer");
        ObjectInputStream ois = null;
        try{
            EmpManagementData e;
            
            ois = new ObjectInputStream(new FileInputStream("empManageDataobj.bin"));
            while(true){
               e =  (EmpManagementData) ois.readObject();
               empManagementDataArr.add(e);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oInps = null;
        try{
            ReportGeneratingData r;
            
            oInps = new ObjectInputStream(new FileInputStream("reportGenerateDataobj.bin"));
            while(true){
               r =  (ReportGeneratingData) oInps.readObject();
               reportGenerateDataArr.add(r);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForVehicle = null;
        try{
            NewVehicleRegData nv;
            
            oisForVehicle = new ObjectInputStream(new FileInputStream("newVehicleRegDataobj.bin"));
            while(true){
               nv =  (NewVehicleRegData) oisForVehicle.readObject();
               newVehicleRegDataArr.add(nv);
               if (takeVechileInfoSelectLicenseNumCombox.getItems().contains(nv.getVehicleLicenseNum())){
                   System.out.println("lalalala");
               }
               else{
                   takeVechileInfoSelectLicenseNumCombox.getItems().add(nv.getVehicleLicenseNum());
               }
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        for(EmpManagementData e:empManagementDataArr){
            empManagementTableViewData.getItems().add(e);
        }
        
        for(NewVehicleRegData nv:newVehicleRegDataArr){
            newVehicleRegTableView.getItems().add(nv);
        }
        
        
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
    private void seqDashBoardBackBtn(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/CreateAccLogInAndForgotPass.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void empManagementDataConfirmBtn(ActionEvent event) {
        EmpManagementData empData = new EmpManagementData(empManagementEmpNameTextField.getText(),
                                            empManagementEmpIdTextFIeld.getText(),
                                        empManagementEmpTypeComBox.getValue(),
                                    empManagementEmpEntryTimeComBox.getValue(),
                                    empManagementSessionExpierComBox.getValue(),
                                     empManagementDatePicker.getValue() );
        
        
        empManagementDataArr.add(empData);
        
        for(EmpManagementData e:empManagementDataArr){
            if(empManagementTableViewData.getItems().contains(e)){
                System.out.println("Already Contain");
            }
            else{
                empManagementTableViewData.getItems().add(e);
            }
        }
        
        
        try{
            FileOutputStream fos = new FileOutputStream("empManageDataobj.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(EmpManagementData i:empManagementDataArr){
                oos.writeObject(i);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        empManagementEmpNameTextField.clear();
        empManagementEmpIdTextFIeld.clear();
    }


    @FXML
    private void sessionManagementSelectEmpComBoxOnSelect(ActionEvent event) {
        ObjectInputStream ois = null;
        try{
            EmpManagementData e;
            ois = new ObjectInputStream(new FileInputStream("empManageDataobj.bin"));
            while(true){
                e = (EmpManagementData) ois.readObject();
                if(sessionManagementSelectEmpComBox.getValue().equals(e.getEmpName())){
                    sessionManagementEmpRoleTextField.setText(e.getEmpType());
                    sessionManagementSessionStartTextField.setText(Integer.toString(e.getEmpEntryTime()));
                    sessionManagementSessionExpiryTextField.setText(Integer.toString(e.getEmpSessionExpieryTime()));
                }
            }
        }
        catch(Exception x){
            System.out.println(x);
        }
    }


    @FXML
    private void sessionManagementConfirmBtn(ActionEvent event) {
        ReportGeneratingData data = new ReportGeneratingData(sessionManagementDatePicker.getValue(),
                Integer.parseInt(sessionManagementSessionStartTextField.getText()),
                Integer.parseInt(sessionManagementSessionExpiryTextField.getText()),
                sessionManagementExitTimeCombox.getValue(),
                sessionManagementSelectEmpComBox.getValue(),
                sessionManagementEmpRoleTextField.getText(),
                sessionManagementFeedbackBtn.getText());
        reportGenerateDataArr.add(data);
        
        try{
            FileOutputStream fos = new FileOutputStream("reportGenerateDataobj.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(ReportGeneratingData r:reportGenerateDataArr){
                oos.writeObject(r);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        ObjectInputStream oInps = null;
        try{
            ReportGeneratingData r;
            
            oInps = new ObjectInputStream(new FileInputStream("reportGenerateDataobj.bin"));
            while(true){
               r =  (ReportGeneratingData) oInps.readObject();
               System.out.println(r.getSelectEmpID());
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void sessionManagementClearBtn(ActionEvent event) {
        
    }

    @FXML
    private void grFoodSupplierCheckBoxOnSelect(ActionEvent event) {
        if (grFoodSupplierCheckBox.isSelected()){
            empDailyReportGenerateShownArea.clear();
            ObjectInputStream oInps = null;
            try{
                ReportGeneratingData r;
                oInps = new ObjectInputStream(new FileInputStream("reportGenerateDataobj.bin"));
                while(true){
                   r =  (ReportGeneratingData) oInps.readObject();
                   System.out.println("");
                   if(r.getReportDate().equals(selectDateforDailyEmpReport.getValue()) && r.getEmpRole().equals("Food Supplier")){
                       empDailyReportGenerateShownArea.appendText(r.toString());
                   }
                   else{

                   }
                }   

            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
                
        }
        
        
    }

    @FXML
    private void grSecurityDeptCheckBoxOnSelect(ActionEvent event) {
    }

    @FXML
    private void grOnlineCustomerCheckBoxOnSelect(ActionEvent event) {
    }

    @FXML
    private void grFoodCourtManagerCheckBoxOnSelect(ActionEvent event) {
    }

    @FXML
    private void saveDailyEmpReportBtn(ActionEvent event) {
    }

    @FXML
    private void clearDailyEmpReportBtn(ActionEvent event) {
        empDailyReportGenerateShownArea.clear();
    }

    @FXML
    private void sessionManagementDatePickerOnSelect(ActionEvent event) {
        sessionManagementSelectEmpComBox.getItems().clear();
        ObjectInputStream ois = null;
        try{
            EmpManagementData e;
            ois = new ObjectInputStream(new FileInputStream("empManageDataobj.bin"));
            while(true){
                e = (EmpManagementData) ois.readObject();
                if(e.getMngEmpDate().equals(sessionManagementDatePicker.getValue())){
                    sessionManagementSelectEmpComBox.getItems().add(e.getEmpName());
                }
                else{
                    System.out.println("");
                }
            }
        }
        catch(Exception x){
            System.out.println(x);
        }
    }

    @FXML
    private void selectDateforDailyEmpReportOnSelect(ActionEvent event) {
        empDailyReportGenerateShownArea.clear();
        ObjectInputStream oInps = null;
        try{
            ReportGeneratingData r;
            oInps = new ObjectInputStream(new FileInputStream("reportGenerateDataobj.bin"));
            while(true){
               r =  (ReportGeneratingData) oInps.readObject();
               if(r.getReportDate().equals(selectDateforDailyEmpReport.getValue())){
                   empDailyReportGenerateShownArea.appendText(r.toString());
               }
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }

    }

    @FXML
    private void newVehicleRegConfirmBtn(ActionEvent event) {
        NewVehicleRegData nd = new NewVehicleRegData(newVehicleRegDatePicker.getValue(),
                                                     newVehicleRegDurationCombox.getValue(),
                                                     newVehicleRegCarModelTextField.getText(),
                                                     newVehicleRegLicenseNum.getText(),
                                                     newVehicleRegOwnerNameTextField.getText(),
                                                     newVehicleRegOwnerContactNum.getText());
        
        newVehicleRegDataArr.add(nd);
        
        for(NewVehicleRegData v:newVehicleRegDataArr){
            if(newVehicleRegTableView.getItems().contains(v)){
                System.out.println("Already Contain");
            }
            else{
                newVehicleRegTableView.getItems().add(v);
            }
            
        }
        
        try{
            FileOutputStream fos = new FileOutputStream("newVehicleRegDataobj.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(NewVehicleRegData nv:newVehicleRegDataArr){
                oos.writeObject(nv);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForVehicle = null;
        try{
            NewVehicleRegData nv;
            
            oisForVehicle = new ObjectInputStream(new FileInputStream("newVehicleRegDataobj.bin"));
            while(true){
               nv =  (NewVehicleRegData) oisForVehicle.readObject();
               if (takeVechileInfoSelectLicenseNumCombox.getItems().contains(nv.getVehicleLicenseNum())){
                   System.out.println("lalalala");
               }
               else{
                   takeVechileInfoSelectLicenseNumCombox.getItems().add(nv.getVehicleLicenseNum());
               }
               
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        newVehicleRegCarModelTextField.clear();
        newVehicleRegOwnerNameTextField.clear();
        newVehicleRegOwnerContactNum.clear();
        
        
    }

    @FXML
    private void newVehicleRegNextBtn(ActionEvent event) {
        
    }

    @FXML
    private void takeVechileInfoSelectLicenseNumComboxOnSelect(ActionEvent event) {
        
        ObjectInputStream oisForVehicle = null;
        try{
            NewVehicleRegData nv;
            
            oisForVehicle = new ObjectInputStream(new FileInputStream("newVehicleRegDataobj.bin"));
            while(true){
               nv =  (NewVehicleRegData) oisForVehicle.readObject();
               if (takeVechileInfoSelectLicenseNumCombox.getItems().contains(nv.getVehicleLicenseNum())){
                   takeVechileInfoOwnersNameField.setText(nv.getVehicleOwnerName());
                   takeVechileInfoOwnersContactField.setText(nv.getVehicleOwnerContact());
               }
               else{
                   takeVechileInfoSelectLicenseNumCombox.getItems().add(nv.getVehicleLicenseNum());
               }
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void takeVechileInfoDoneBtn(ActionEvent event) {
        ParkingAreaVechileData pvd =  new ParkingAreaVechileData(takeVechileInfoSelectLicenseNumCombox.getValue(),
                                                                takeVechileInfoOwnersNameField.getText(),
                                                                takeVechileInfoOwnersContactField.getText(),
                                                                takeVechileInfoComplineBox.getText(),
                                                                Integer.parseInt(takeVechileInfoParkingTime.getText()),
                                                                takeVechileInfoPerMinCostCombox.getValue(),
                                                                Integer.parseInt(takeVechileIeInfoParkingCost.getText()));
        parkingAreaVechileDataArr.add(pvd);
        
        for(ParkingAreaVechileData p:parkingAreaVechileDataArr){
            takeVechileInfoTableView.getItems().add(p);
        }
    }

    @FXML
    private void takeVechileInfoToNewVechileRgBtn(ActionEvent event) {
        
    }

    @FXML
    private void takeVechileInfoPerMinCostComboxOnSelect(ActionEvent event) {
        takeVechileIeInfoParkingCost.setText(Integer.toHexString(100));       
        System.out.println("ddddddddd");
    }
    
}

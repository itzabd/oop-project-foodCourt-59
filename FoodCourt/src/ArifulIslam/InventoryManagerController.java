/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ArifulIslam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
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
 * @author HP
 */
public class InventoryManagerController implements Initializable {

    @FXML
    private Button RealTimeSalesAnalysisButton;
    @FXML
    private Button InventoryReportsButton;
    @FXML
    private Button InventoryAlertsButton;
    @FXML
    private Button CostAnalysisButton;
    @FXML
    private Button SupplierManagmentButton;
    @FXML
    private Button VendorPerformanceEvaluationButton;
    @FXML
    private Button SupportTeamBUtton;
    @FXML
    private Button NewSupplierRegistrationButton;
    @FXML
    private Button InventoryManagerDashboardReturnButton;
    @FXML
    private AnchorPane RealTimeSalesAnalysisFrame;
    @FXML
    private AnchorPane InventoryReportsFrame;
    @FXML
    private AnchorPane InventoryAlertsFrame;
    @FXML
    private AnchorPane CostAnalysisFrame;
    @FXML
    private AnchorPane SupplierManagementFrame;
    @FXML
    private AnchorPane VendorPerformanceEvaluationFrame;
    @FXML
    private AnchorPane SupprtTeamFrame;
    @FXML
    private AnchorPane NewSupplierRegistrationFrame;
    @FXML
    private AnchorPane InventoryManagerDashboardReturnFrame;
    @FXML
    private ComboBox<?> RealTimeSalesAnalysisStallNameComboBox;
    @FXML
    private TableView<?> RealTimeSalesAnalysisTableView;
    @FXML
    private TableColumn<?, ?> RealTimeSalesAnalysisTableViewStallNameTableColumn;
    @FXML
    private TableColumn<?, ?> RealTimeSalesAnalysisTableViewItemTableColumn;
    @FXML
    private TableColumn<?, ?> RealTimeSalesAnalysisTableViewTotalSaleTableColumn;
    @FXML
    private ComboBox<?> InventoryReportSelectStallComboBox;
    @FXML
    private TextArea InventoryReportTextArea;
    @FXML
    private TextArea SeeAlertsAndTakeOrderTextArea;
    @FXML
    private ComboBox<?> SeeAlertsAndTakeOrderStallNameComboBox;
    @FXML
    private TextField SeeAlertsAndTakeOrderItemTextField;
    @FXML
    private TextField SeeAlertsAndTakeOrderQuantityTextField;
    @FXML
    private TextArea SeeAlertsAndTakeOrderCreateAnOrderTextArea;
    @FXML
    private ComboBox<?> CostAnalysisSelectAStallComboBox;
    @FXML
    private TextArea CostAnalysisTextArea;
    @FXML
    private ComboBox<?> SupplierManagementSelectASupplierComboBox;
    @FXML
    private TextField SupplierManagementNameTextField;
    @FXML
    private TextField SupplierManagementEmailTextField;
    @FXML
    private TextField SupplierManagementContactNumberTextField;
    @FXML
    private TextField SupplierManagementPasswordTextField;
    @FXML
    private ComboBox<?> NewSupplierRegistrationListComboBox;
    @FXML
    private TextArea NewSupplierRegistrationTextArea;
    @FXML
    private ComboBox<String> ManageStockLevelSelectAStallComboBox;
    @FXML
    private TextField ManageStockLevelQuantityTableField;
    @FXML
    private TextField ManageStockLevelProductTableField;
    @FXML
    private TableView<ManageStockA> ManageStockLevelTableView;
    @FXML
    private TableColumn<ManageStockA, String> ManageStockLevelTableViewStallNameTableColumn;
    @FXML
    private TableColumn<ManageStockA, String> ManageStockLevelTableViewProductTableColumn;
    @FXML
    private TableColumn<ManageStockA, String> ManageStockLevelTableViewQuantityTableColumn;
    
    private ArrayList<ManageStockA> stockArray;
    @FXML
    private ComboBox<?> SupportTeamStallNameComboBox;
    @FXML
    private TextArea SupportTeamViewSupportRequestTextArea;
    @FXML
    private TextArea SupportTeamCreateAssignTextArea;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // Array crate kora hoice
        stockArray = new ArrayList<>(); 
        
        // ComboBox a value add korar kaj
        ManageStockLevelSelectAStallComboBox.getItems().addAll("ABC1", "ABC2", "ABC3");
        
        
        // Read code start
        ObjectInputStream ois = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            ManageStockA e;
            
            ois = new ObjectInputStream(new FileInputStream("manageStockFile.bin"));
            while(true){
               e =  (ManageStockA) ois.readObject();
               stockArray.add(e);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end 
        
        
        // table er column golor kaj korar code
        ManageStockLevelTableViewStallNameTableColumn.setCellValueFactory(new PropertyValueFactory<ManageStockA,String>("stallName"));
        ManageStockLevelTableViewProductTableColumn.setCellValueFactory(new PropertyValueFactory<ManageStockA,String>("productName"));
        ManageStockLevelTableViewQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<ManageStockA,String>("quantity"));
    }    

@FXML
    private void switchingFrame(ActionEvent event) {
        
        
        if(event.getSource()==InventoryManagerDashboardReturnButton){
            InventoryManagerDashboardReturnFrame.setVisible(true);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        
        else if(event.getSource()==RealTimeSalesAnalysisButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(true);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
                       
        else if(event.getSource()==InventoryReportsButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(true);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        
        
        
        else if(event.getSource()==InventoryAlertsButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(true);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);           
            
        }
        else if(event.getSource()==CostAnalysisButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(true);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        else if(event.getSource()==SupplierManagmentButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(true);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        else if(event.getSource()==VendorPerformanceEvaluationButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(true);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        else if(event.getSource()==SupportTeamBUtton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(true);
            NewSupplierRegistrationFrame.setVisible(false);            
        }
        else if(event.getSource()==NewSupplierRegistrationButton){
            InventoryManagerDashboardReturnFrame.setVisible(false);
            RealTimeSalesAnalysisFrame.setVisible(false);
            InventoryReportsFrame.setVisible(false);
            InventoryAlertsFrame.setVisible(false);
            CostAnalysisFrame.setVisible(false);
            SupplierManagementFrame.setVisible(false);
            VendorPerformanceEvaluationFrame.setVisible(false);
            SupprtTeamFrame.setVisible(false);
            NewSupplierRegistrationFrame.setVisible(true);            
        }
       
    }   
       
    @FXML
    private void InventoryManagerDashBoardBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccLogInAndForgotPass.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void RealTimeSalesAnalysisShowButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void InventoryReportSaveButton(ActionEvent event) {
    }

    @FXML
    private void InventoryReportClearButton(ActionEvent event) {
    }

    @FXML
    private void InventoryReportShowButton(ActionEvent event) {
    }

    @FXML
    private void SeeAlertsAndTakeOrderOrderButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void CostAnalysisShowButton(ActionEvent event) {
    }

    @FXML
    private void CostAnalysisReportGenerateButton(ActionEvent event) {
    }

    @FXML
    private void CostAnalysisClearButton(ActionEvent event) {
    }

    @FXML
    private void SupplierManagementSelectASupplierComboBoxOnAction(ActionEvent event) {
    }

    @FXML
    private void SupplierManagementUpdateButton(ActionEvent event) {
    }

    @FXML
    private void NewSupplierRegistrationInfoShowButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void NewSupplierRegistrationAcceptButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void NewSupplierRegistrationRejectedButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void ManageStockLevelAddThisProductToStallButton(ActionEvent event) {
        
        ManageStockA mn = new ManageStockA(ManageStockLevelSelectAStallComboBox.getValue(), ManageStockLevelProductTableField.getText(), Integer.parseInt(ManageStockLevelQuantityTableField.getText()));
        //System.out.println(MenuCreationItemNameTextField.getText());
        stockArray.add(mn);
        
        
        // write code start
        try{
            FileOutputStream fos = new FileOutputStream("manageStockFile.bin");     // Write a object name change korte hobe nah, Class name R array name change korte hobe
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(ManageStockA r:stockArray){
                oos.writeObject(r);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // write code end
        
        
        // table View add korar kaj
        for(ManageStockA e:stockArray){
            if(ManageStockLevelTableView.getItems().contains(e)){
                System.out.println("Already Contain");
            }
            else{
                ManageStockLevelTableView.getItems().add(e);
            }
        }
        
    }

    @FXML
    private void SupportTeamViewSupportRequestsButton(ActionEvent event) {
    }

    @FXML
    private void SupportTeamAssignTaskButton(ActionEvent event) {
    }
}
    
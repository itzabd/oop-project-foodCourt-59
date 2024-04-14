/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ArifulIslam;

import java.io.IOException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
    
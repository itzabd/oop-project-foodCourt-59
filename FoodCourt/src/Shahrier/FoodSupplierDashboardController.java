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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class FoodSupplierDashboardController implements Initializable {

    @FXML  private Button contractManagementBtn;
    @FXML  private Button invoiceGenerationBtn;
    @FXML  private Button paymentProcessingBtn;
    @FXML  private Button ratingAndFeedbackBtn;
    @FXML  private Button viewInventoryStallBtn;
    @FXML  private Button orderTakingBtn;
    @FXML  private Button monthlyReportGenerateBtn;
    @FXML  private Button productManagementBtn;
    @FXML  private Label securityDeptDashboardUserNameLabel;
    @FXML  private Button homeReturnBtn;
    @FXML  private AnchorPane productManagementFrame;
    @FXML  private AnchorPane orderTakingFrame;
    @FXML  private AnchorPane paymentProcessingFrame;
    @FXML  private AnchorPane invoiceGenerationFrame;
    @FXML  private AnchorPane contractManagementFrame;
    @FXML  private AnchorPane viewInventoryFrame;
    @FXML  private AnchorPane generateMonthlyReportBtn;
    @FXML  private AnchorPane ratingAndFeedbackFrame;
    @FXML  private AnchorPane homePageFoodsupplier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchingFrame(ActionEvent event) {
        if(event.getSource()==homeReturnBtn){
            homePageFoodsupplier.setVisible(true);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==productManagementBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(true);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==orderTakingBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(true);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==paymentProcessingBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(true);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==invoiceGenerationBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(true);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==contractManagementBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(true);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==viewInventoryStallBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(true);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==monthlyReportGenerateBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(true);
            ratingAndFeedbackFrame.setVisible(false);           
            
        }
        
        else if(event.getSource()==ratingAndFeedbackBtn){
            homePageFoodsupplier.setVisible(false);
            productManagementFrame.setVisible(false);
            orderTakingFrame.setVisible(false);
            paymentProcessingFrame.setVisible(false);
            invoiceGenerationFrame.setVisible(false);
            contractManagementFrame.setVisible(false);
            viewInventoryFrame.setVisible(false);
            generateMonthlyReportBtn.setVisible(false);
            ratingAndFeedbackFrame.setVisible(true);           
            
        }
    }

    @FXML
    private void foodSupplierDashBoardBackBtn(ActionEvent event) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("CreateAccLogInAndForgotPass.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}

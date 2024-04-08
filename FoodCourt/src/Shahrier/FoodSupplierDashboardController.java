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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodSupplierDashboardController implements Initializable {

    @FXML private Button contractManagementBtn;
    @FXML private Button invoiceGenerationBtn;
    @FXML private Button paymentProcessingBtn;
    @FXML private Button ratingAndFeedbackBtn;
    @FXML private Button viewInventoryStallBtn;
    @FXML private Button orderTakingBtn;
    @FXML private Button monthlyReportGenerateBtn;
    @FXML private Button productManagementBtn;
    @FXML private Label securityDeptDashboardUserNameLabel;
    @FXML private Button homeReturnBtn;
    @FXML private AnchorPane productManagementFrame;
    @FXML private AnchorPane orderTakingFrame;
    @FXML private AnchorPane paymentProcessingFrame;
    @FXML private AnchorPane invoiceGenerationFrame;
    @FXML private AnchorPane contractManagementFrame;
    @FXML private AnchorPane viewInventoryFrame;
    @FXML private AnchorPane generateMonthlyReportBtn;
    @FXML private AnchorPane ratingAndFeedbackFrame;
    @FXML private AnchorPane homePageFoodsupplier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchingFrame(ActionEvent event) {
    }

    @FXML
    private void foodSupplierDashBoardBackBtn(ActionEvent event) {
    }
    
}

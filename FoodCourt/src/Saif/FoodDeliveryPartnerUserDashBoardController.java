
package Saif;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class FoodDeliveryPartnerUserDashBoardController implements Initializable {

    
    @FXML
    private Button checkDeliveryButtonId;
    @FXML
    private Button shareDeliveryPartnerButtonId;
    @FXML
    private Button notifyCustomerButtonId;
    @FXML
    private Button applyForEquipmentButtonId;
    @FXML
    private Button generateIncomeButtonId;
    @FXML
    private Button applicationButtonId;
    @FXML
    private Button reportButtonId;
    @FXML
    private AnchorPane contractAPane;
    @FXML
    private AnchorPane checkDeliveryAPane;
    @FXML
    private TextField contractFDPName;
    @FXML
    private TextField contractFDPNumber;
    @FXML
    private TextField contractFDPEmail;
    @FXML
    private ComboBox<String> contractFDPComboBDeliveryType;
    @FXML
    private ComboBox<String> contractFDPComboBDeliveryShift;
    @FXML
    private DatePicker contractFDPDateStart;
    @FXML
    private DatePicker contractFDPDateEnd;
    @FXML
    private Button renewContractButtonId;
    @FXML
    private Button loadInTableButtonId;
    @FXML
    private Button submitButtonId;
    @FXML
    private TableView<Contract> contractTableView;
    @FXML
    private TableColumn<Contract, String> contractSelectedFieldColumn;
    @FXML
    private TableColumn<Contract, String> contractDataInputColumn;
    
    private ObservableList<Contract> contract;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contractAPane.setVisible(false);
        checkDeliveryAPane.setVisible(false);
        
        ObservableList deliveryType = FXCollections.observableArrayList("By Walking", "By Cycling", "By biking");
        contractFDPComboBDeliveryType.setItems(deliveryType);
        
        ObservableList deliveryShift = FXCollections.observableArrayList("Morning","Noon","Evening","Night");
        contractFDPComboBDeliveryShift.setItems(deliveryShift);
                
        
        
        
    }    

    @FXML
    private void editProfileMenuItem(ActionEvent event) {
        
    }

    @FXML
    private void logOutMenuItem(ActionEvent event) {
    }

    @FXML
    private void renewContractButton(ActionEvent event) {
        // Anchor Pane visibility ..
        contractAPane.setVisible(true);
        checkDeliveryAPane.setVisible(false);
        
        // button color changing .. 
        renewContractButtonId.setStyle("-fx-background-color : #98a2b0;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4" );
    }

    @FXML
    private void checkDeliveryButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #98a2b0;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        
    }

    @FXML
    private void shareDeliveryPartnerButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #98a2b0;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
               
    }

    @FXML
    private void notifyCustomerButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #98a2b0;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
   
    }

    @FXML
    private void applyForEquipmentButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #98a2b0;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
       
    }

    @FXML
    private void generateIncomeButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #98a2b0;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
   
    }

    @FXML
    private void applicationButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #98a2b0;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
   
    }

    @FXML
    private void reportButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #98a2b0;" );
   
    }

    @FXML
    private void backButton(ActionEvent event) {
        
        // Anchor visibility ..
        contractAPane.setVisible(false);
        checkDeliveryAPane.setVisible(false);
        
        // button color changing..
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;" );    
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");    
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;" );
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;" );
    }

    @FXML
    private void loadInTableButton(ActionEvent event) {
        loadInTableButtonId.setStyle("-fx-background-color : #98a2b0;" );
        
        contract = FXCollections.observableArrayList();
        contractTableView.setItems(contract);
        String FDPName = contractFDPName.getText();
        contract.add(new Contract("Name",FDPName));
        contractSelectedFieldColumn.setCellValueFactory(new PropertyValueFactory("selectedField"));
        contractDataInputColumn.setCellValueFactory(new PropertyValueFactory("dataInput"));
        
        
        
        
//        String dataInputname = contractFDPName.getText();
//        String selectedFieldnumber = "Phone Number";
//        String dataInputnumber = contractFDPNumber.getText();
//        String selectedFieldemail = "Email";
//        String dataInputemail = contractFDPEmail.getText();
//        String selectedFieldDeliverytype = "Delivery Type";
//        String dataInputDeliverytype = contractFDPComboBDeliveryType.getValue();
//        String selectedFieldDeliveryshift = "Shift Type";
//        String dataInputDeliveryshift = contractFDPComboBDeliveryShift.getValue();
//        String selectedFieldStartdate = "Starting Date";
//        String dataInputStartdate = contractFDPDateStart.getValue().toString();
//        String selectedFieldEnddate = "Ending Date";
//        String dataInputEnddate = contractFDPDateEnd.getValue().toString();


//        contract.add(new Contract(selectedFieldname,dataInputname,selectedFieldnumber,dataInputnumber,selectedFieldemail,dataInputemail,selectedFieldDeliverytype,dataInputDeliverytype,selectedFieldDeliveryshift,dataInputDeliveryshift,selectedFieldStartdate,dataInputStartdate,selectedFieldEnddate,dataInputEnddate));
//        contractSelectedFieldColumn.setCellValueFactory(new PropertyValueFactory<> ("selectedFieldName"));
//        contractDataInputColumn.setCellValueFactory(new PropertyValueFactory<>("dataInputName"));
//        contractSelectedFieldColumn.setCellValueFactory(new PropertyValueFactory<> ("selectedFieldNumber"));
//        contractDataInputColumn.setCellValueFactory(new PropertyValueFactory<>("dataInputNumber"));
//        contractSelectedFieldColumn.setCellValueFactory(new PropertyValueFactory<> ("selectedFieldEmail"));
//        contractDataInputColumn.setCellValueFactory(new PropertyValueFactory<>("dataInputEmail"));
//        
    
    }

    @FXML
    private void submitButton(ActionEvent event) {
        loadInTableButtonId.setStyle("-fx-background-color : #b4c6fa;");
        
    }

    
}



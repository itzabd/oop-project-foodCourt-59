package Saif;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.fill;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
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

    private ObservableList<Contract> contract = FXCollections.observableArrayList();
    private ObservableList<FDPInfo> FDPContract = FXCollections.observableArrayList();
    //
    @FXML
    private Label alertLabelId;
    @FXML
    private Button loadSubmittedFileButtonId;

    File contractFile = new File("contractFile.bin");
    private ArrayList<FDPInfo> FDPInfoArr = new ArrayList<FDPInfo>();

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        contractAPane.setVisible(false);
        checkDeliveryAPane.setVisible(false);
        applicationAPane.setVisible(false);

        ObservableList deliveryType = FXCollections.observableArrayList("By Walking", "By Cycling", "By biking");
        contractFDPComboBDeliveryType.setItems(deliveryType);

        ObservableList deliveryShift = FXCollections.observableArrayList("Morning", "Noon", "Evening", "Night");
        contractFDPComboBDeliveryShift.setItems(deliveryShift);

        // for adding in the table view ..
        contractTableView.setItems(contract);
        contractSelectedFieldColumn.setCellValueFactory(new PropertyValueFactory("selectedField"));
        contractDataInputColumn.setCellValueFactory(new PropertyValueFactory("dataInput"));
        
        // adding null values to the table
        contractTableView.getItems().clear();
        // adding direct data to the table .. 
        FDPInfo f = new FDPInfo();
        contract.add(new Contract("Name", f.getName()));
        contract.add(new Contract("Phone Number", f.getPhoneNumber()));
        contract.add(new Contract("Email", f.getEmail()));
        contract.add(new Contract("Delivery Type", f.getDeliveryType()));
        contract.add(new Contract("Delivery Shift", f.getDeliveryShift()));
        contract.add(new Contract("Starting From", f.getStartDate()));
        contract.add(new Contract("Ending", f.getEndDate()));

        // for editing the table .. 
        contractFDPName.setText("");
        contractFDPNumber.setText("");
        contractFDPEmail.setText("");
        contractFDPComboBDeliveryShift.setValue("");
        contractFDPComboBDeliveryType.setValue("");
        contractFDPDateStart.setValue(null) ;
        contractFDPDateEnd.setValue(null);
        
    }


    // ...............reading file into textArea................
    @FXML
    private void loadSubmittedFileButton(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        //editing table view ..
        contractTableView.getItems().clear();
        File f = null;
        FileInputStream fis = new FileInputStream(contractFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        FDPInfo FDP = null;

        try {

            while (true) {//fis.available() > 0
                FDP = (FDPInfo) ois.readObject();

            }

        } catch (Exception e) {
            ois.close();
            contract.add(new Contract("Name", FDP.getName()));
            contract.add(new Contract("Phone Number", FDP.getPhoneNumber()));
            contract.add(new Contract("Email", FDP.getEmail()));
            contract.add(new Contract("Delivery Type", FDP.getDeliveryType()));
            contract.add(new Contract("Delivery Shift", FDP.getDeliveryShift()));
            contract.add(new Contract("Starting From", FDP.getStartDate()));
            contract.add(new Contract("Ending", FDP.getEndDate()));

        }

    }

    // ................... creating bin File ................
//    contractFDPName == null || contractFDPNumber.getText() == null || contractFDPEmail.getText() == null
//                || contractFDPComboBDeliveryType.getValue() == null || contractFDPComboBDeliveryShift.getValue() == null
//                || contractFDPDateStart.getValue().toString() == null || contractFDPDateEnd.getValue().toString() == null
    @FXML
    private void submitButton(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObservableList<Contract> fdp = contractTableView.getItems();

        if (fdp == null || fdp.get(0).getDataInput().equals("") || fdp.get(0).getDataInput() == null ||
                           fdp.get(1).getDataInput().equals("") || fdp.get(1).getDataInput() == null ||
                           fdp.get(2).getDataInput().equals("") || fdp.get(2).getDataInput() == null ||
                           fdp.get(3).getDataInput().equals("") || fdp.get(3).getDataInput() == null ||
                           fdp.get(4).getDataInput().equals("") || fdp.get(4).getDataInput() == null ||
                           fdp.get(5).getDataInput().equals("") || fdp.get(5).getDataInput() == null ||
                           fdp.get(6).getDataInput().equals("") || fdp.get(6).getDataInput() == null   ) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("One or more fields to be filled in the table.");
            a.showAndWait();
            submitButtonId.setStyle("-fx-text-fill : #a82d2d");

        }
        
        
        
        // reading the file and adding to FDPInfoArr .. 
        else{
            
            FileInputStream fis = null;
            FDPInfo FDP = null;
            FDPInfoArr.clear();
            if (contractFile.length() != 0 && contractFile.exists())
            {
                try
                    {
                        fis = new FileInputStream(contractFile);
                        ObjectInputStream ois = new ObjectInputStream(fis);
            
                        while (true) {//fis.available() > 0
                            FDP = (FDPInfo) ois.readObject();
                            FDPInfoArr.add(FDP);
                            
                    }
                }catch(IOException | ClassNotFoundException e){
                    fis.close();
                    e.printStackTrace();
                }
            }
            
            
            // loading the info into FDPInfo objecct . .
            FDPInfo FDPinfo = new FDPInfo(fdp.get(0).getDataInput(), fdp.get(1).getDataInput(), fdp.get(2).getDataInput(),
        fdp.get(3).getDataInput(), fdp.get(4).getDataInput(),
        fdp.get(5).getDataInput(), fdp.get(6).getDataInput());
            
            // checking if the info exists in the FDPInfoArr  .. 
            if (! FDPInfoArr.isEmpty()){
                    for (FDPInfo i : FDPInfoArr) {

                        if (i.toString().equals(FDPinfo.toString())) {
                            FDPinfo = null;
                            alertLabelId.setText("Duplicate Info is found.");
                        }
                    }
                }
            
            // object Writing if Possible .. 
            ObjectOutputStream oos = null;
            
            try {

                alertLabelId.setText("");
                if (contractFile.exists()) {
                    FileOutputStream fos = new FileOutputStream(contractFile, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    FileOutputStream fos = new FileOutputStream(contractFile, true);
                    oos = new ObjectOutputStream(fos);
                }
                
                

//                FDPInfo FDPinfo = new FDPInfo(contractFDPName.getText(), contractFDPNumber.getText(), contractFDPEmail.getText(),
//                        contractFDPComboBDeliveryType.getValue(), contractFDPComboBDeliveryShift.getValue(),
//                        contractFDPComboBDeliveryShift.getValue(), contractFDPDateEnd.getValue().toString());
                
                if (FDPinfo != null){
                oos.writeObject(FDPinfo);
                alertLabelId.setText("Your New Info submission is Successful.");
                submitButtonId.setStyle("-fx-text-fill : #b4c6fa");
                loadInTableButtonId.setStyle("-fx-background-color : #b4c6fa;");
                submitButtonId.setStyle("-fx-background-color : #b4c6fa;");
                oos.close();
                }
//                    
//                        }
//                
//                    }
//                }

                 
//                    if (        contractFDPName.getText().equals(fdp.get(0).getDataInput())  &&
//                                contractFDPNumber.getText().equals(fdp.get(1).getDataInput()) &&
//                                contractFDPEmail.getText().equals(fdp.get(2).getDataInput()) &&
//                                contractFDPComboBDeliveryType.getValue().equals(fdp.get(3).getDataInput()) &&
//                                contractFDPComboBDeliveryShift.getValue().equals(fdp.get(4).getDataInput()) &&
//                                contractFDPComboBDeliveryShift.getValue().equals(fdp.get(5).getDataInput()) &&
//                                contractFDPDateEnd.getValue().toString().equals(fdp.get(6).getDataInput())
//                                )
//                        {
//                            for(FDPInfo i :FDPInfoArr){
//                                /////////////////////
//                                if(i.toString().equals(FDPinfo.toString()))
//                                {
//                                    FDPinfo = null;
//                                    alertLabelId.setText("Duplicate Info is found.");
//
//                                }

//                            }
//                            if(FDPinfo != null){
//                                FDPInfoArr.add(FDPinfo);
//,,,,,,,,,,,,,,,,,,,,,,,,,
//                    oos.writeObject(FDPinfo);
//                    alertLabelId.setText("Your New Info submission is Successful.");
//                    submitButtonId.setStyle("-fx-text-fill : #b4c6fa");
//                    loadInTableButtonId.setStyle("-fx-background-color : #b4c6fa;");
//                    submitButtonId.setStyle("-fx-background-color : #b4c6fa;");
//                    oos.close();
                    

                 //                            else{
                //                                Alert a = new Alert(AlertType.ERROR);
                //                                a.setContentText("The info exists.Can't submit the same info");
                //                                a.showAndWait();
                //                                oos.close();
                //                                }
                //                        }
                else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("The info exists.Can't submit the same info");
                    a.showAndWait();
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (oos != null) {
                        oos.flush();
                        oos.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }
            
          /// checking table cells, match with the fields  or not .. 
            
//            String startDate = "",endDate = "";
//            if(contractFDPDateStart.getValue() != null){
//                 startDate = contractFDPDateStart.getValue().toString();
//            }
//            if(contractFDPDateEnd.getValue() != null){
//                 endDate = contractFDPDateEnd.getValue().toString();
//            }
//            
//            if (        !contractFDPName.getText().equals(fdp.get(0).getDataInput())  ||
//                                !contractFDPNumber.getText().equals(fdp.get(1).getDataInput()) ||
//                                !contractFDPEmail.getText().equals(fdp.get(2).getDataInput()) ||
//                                !contractFDPComboBDeliveryType.getValue().equals(fdp.get(3).getDataInput()) ||
//                                !contractFDPComboBDeliveryShift.getValue().equals(fdp.get(4).getDataInput()) ||
//                                !startDate.equals(fdp.get(5).getDataInput()) || startDate == "" ||
//                                !endDate.equals(fdp.get(6).getDataInput()) || endDate == "")
//                                {
//            Alert a = new Alert(AlertType.ERROR);
//            a.setContentText("Load the info to table 1st.");
//            a.showAndWait();
//            loadInTableButtonId.setStyle("-fx-text-fill : #a82d2d");
//                
//            }
//            
//            else{
//
//        }
        
        }
    }

    @FXML
    private void loadInTableButton(ActionEvent event) {
        loadInTableButtonId.setStyle("-fx-background-color : #98a2b0;");

        // name ..
        ObservableList<Contract> fdp = contractTableView.getItems();
        String fdpName = fdp.get(0).getDataInput();
        String fdpNumber = fdp.get(1).getDataInput();
        String fdpEmail = fdp.get(2).getDataInput();
        String fdpType = fdp.get(3).getDataInput();
        String fdpShift = fdp.get(4).getDataInput();
        String fdpStarting = fdp.get(5).getDataInput();
        String fdpEnding = fdp.get(6).getDataInput();
        
        // deleting tableView..
        contractTableView.getItems().clear();
        
        
        // loading data ..
        if (contractFDPName.getText().equals("") || contractFDPName.getText() == null){
            contract.add(new Contract("Name", fdpName));
        }
        else{
            contract.add(new Contract("Name", contractFDPName.getText()));
        }
        
        // number 
        if (contractFDPNumber.getText().equals("") || contractFDPNumber.getText() == null ){
            contract.add(new Contract("Phone Number", fdpNumber));
        }
        else{
            contract.add(new Contract("Phone Number", contractFDPNumber.getText()));
        }
        
        // Email
        if (contractFDPEmail.getText().equals("") || contractFDPEmail.getText() == null){
            contract.add(new Contract("Email", fdpEmail));
        }
        else{
            contract.add(new Contract("Email", contractFDPEmail.getText()));
        }
        
        // Delivery Type
        if (contractFDPComboBDeliveryType.getValue().equals("") || contractFDPComboBDeliveryType.getValue() == null){
            contract.add(new Contract("Delivery Type", fdpType));
        }
        else{
            contract.add(new Contract("Delivery Type", contractFDPComboBDeliveryType.getValue()));
        }
        
        // Delivery Shift
        if (contractFDPComboBDeliveryShift.getValue().equals("") || contractFDPComboBDeliveryShift.getValue() == null){
            contract.add(new Contract("Delivery Shift", fdpShift));
        }
        else{
            contract.add(new Contract("Delivery Shift", contractFDPComboBDeliveryShift.getValue()));
        }
        
        // Strating 
        if (contractFDPDateStart.getValue() == null || contractFDPDateStart.getValue().toString().equals("")){
            contract.add(new Contract("Starting From", fdpStarting));
        }
        else{
            contract.add(new Contract("Starting From", contractFDPDateStart.getValue().toString()));
        }
        
        // ending
        if (contractFDPDateEnd.getValue() == null ||  contractFDPDateStart.getValue().toString().equals("")){
            contract.add(new Contract("Ending", fdpEnding));
        }
        else{
            contract.add(new Contract("Ending", contractFDPDateEnd.getValue().toString()));
        }
        
        
        
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
        applicationAPane.setVisible(false);

        // button color changing .. 
        renewContractButtonId.setStyle("-fx-background-color : #98a2b0;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4");
    }

    @FXML
    private void checkDeliveryButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #98a2b0;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }

    @FXML
    private void shareDeliveryPartnerButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #98a2b0;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }

    @FXML
    private void notifyCustomerButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #98a2b0;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }

    @FXML
    private void applyForEquipmentButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #98a2b0;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }

    @FXML
    private void generateIncomeButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #98a2b0;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }

    

    @FXML
    private void reportButton(ActionEvent event) {
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #98a2b0;");

    }

    @FXML
    private void backButton(ActionEvent event) {

        // Anchor visibility ..
        contractAPane.setVisible(false);
        checkDeliveryAPane.setVisible(false);
        applicationAPane.setVisible(false);


        // button color changing..
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #a7bfe4;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");
    }

    @FXML
    private void rowClicked1(MouseEvent event) {
        Contract fieldValue = contractTableView.getSelectionModel().getSelectedItem();

        if (fieldValue.getSelectedField().equals("Name")) {
            contractFDPName.setText(fieldValue.getDataInput());

        }
        if (fieldValue.getSelectedField() == "Phone Number") {
            contractFDPNumber.setText(fieldValue.getDataInput());

        }
        if (fieldValue.getSelectedField() == "Email") {
            contractFDPEmail.setText(fieldValue.getDataInput());

        }
        if (fieldValue.getSelectedField() == "Delivery Shift") {
            contractFDPComboBDeliveryShift.setValue(fieldValue.getDataInput());

        }
        if (fieldValue.getSelectedField() == "Delivery Type") {
            contractFDPComboBDeliveryType.setValue(fieldValue.getDataInput());

        }
        if (fieldValue.getSelectedField() == "Delivery Shift") {
            contractFDPComboBDeliveryShift.setValue(fieldValue.getDataInput());

        }

        if (fieldValue.getSelectedField() == "Starting From") {
            String dateStr = fieldValue.getDataInput();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);
            contractFDPDateStart.setValue(localDate);

        }
        if (fieldValue.getSelectedField() == "Ending") {
            String dateStr = fieldValue.getDataInput();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);
            contractFDPDateEnd.setValue(localDate);

        }

    }

    @FXML
    private void rowClicked(MouseEvent event) {
    }

//    @FXML
//    private void showButton(ActionEvent event) throws FileNotFoundException, IOException {
//    
//    // this codes reads directly from table..     
//    
////    ObservableList<Contract>  fdp  = contractTableView.getItems();
////    FDPInfo FDPinfo = new FDPInfo(fdp.get(0).getDataInput(),fdp.get(1).getDataInput(),fdp.get(2).getDataInput(),
////                               fdp.get(3).getDataInput(), fdp.get(4).getDataInput(),
////                                  fdp.get(5).getDataInput(),fdp.get(6).getDataInput());
////        
////        
//    
//    
//    File f = null;
//        FileInputStream fis = new FileInputStream(contractFile);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        FDPInfo FDP = null ;
//        
//    try
//    {   textAreaId.setText("Hello");
//
//        while(true)
//        {//fis.available() > 0
//            FDP = (FDPInfo) ois.readObject();
//            FDPInfoArr.add(FDP);
//        }
//
//    }
//    catch(Exception e)
//    {
//        ois.close();
//    }
//    
//    for(FDPInfo i : FDPInfoArr)
//    {
//    textAreaId.appendText(i.toString());
////        if(i.toString().equals(i.toString()))
////        {
////        textAreaId.appendText(i.toString());
////        i = null;
////        textAreaId.setText("got a match");
////    }
//
//    }
//    }
    
    
    
    
//    @FXML
//    private void contractUpdateButton(ActionEvent event) throws FileNotFoundException, IOException {
//        // reading from tableview and creating a new class Object ..
//
//        ObservableList<Contract> fdp = contractTableView.getItems();
//        // reading .. 
//        FileInputStream fis = null;
//        FDPInfo FDP = null;
//        FDPInfoArr.clear();
//        if (contractFile.length() != 0 && contractFile.exists())
//        {
//            try
//                {
//                    fis = new FileInputStream(contractFile);
//                    ObjectInputStream ois = new ObjectInputStream(fis);
//                    
//                    while (true) {//fis.available() > 0
//                        try{
//                            FDP = (FDPInfo) ois.readObject();
//                            FDPInfoArr.add(FDP);
//                        }
//                        catch(EOFException e){
//                            break;
//                            
//                        }}
//
//            }catch(IOException | ClassNotFoundException e){
//                
//                fis.close();
//                e.printStackTrace();
//            }
//        }
//        if (! FDPInfoArr.isEmpty()){
//            FDPInfoArr.remove(FDPInfoArr.size()-1);
//        
//        }
//        
//        
//        
//        if (fdp == null || fdp.get(0).getDataInput().equals("") || fdp.get(0).getDataInput() == null ||
//                           fdp.get(1).getDataInput().equals("") || fdp.get(1).getDataInput() == null ||
//                           fdp.get(2).getDataInput().equals("") || fdp.get(2).getDataInput() == null ||
//                           fdp.get(3).getDataInput().equals("") || fdp.get(3).getDataInput() == null ||
//                           fdp.get(4).getDataInput().equals("") || fdp.get(4).getDataInput() == null ||
//                           fdp.get(5).getDataInput().equals("") || fdp.get(5).getDataInput() == null ||
//                           fdp.get(6).getDataInput().equals("") || fdp.get(6).getDataInput() == null   ) {
//            Alert a = new Alert(AlertType.ERROR);
//            a.setContentText("One or more fields to be filled in the table.");
//            a.showAndWait();
//            contractUpdateButtonId.setStyle("-fx-text-fill : #a82d2d");
//
//        }
//        else{
//        FDPInfo FDPinfo = new FDPInfo(fdp.get(0).getDataInput(), fdp.get(1).getDataInput(), fdp.get(2).getDataInput(),
//                    fdp.get(3).getDataInput(), fdp.get(4).getDataInput(),
//                    fdp.get(5).getDataInput(), fdp.get(6).getDataInput());
//        for (FDPInfo i : FDPInfoArr) {
//                if (i.toString().equals(FDPinfo.toString())) {
//                    Alert a = new Alert(AlertType.ERROR);
//                    a.setContentText("The info exists.Can't Submit the same info.");
//                    a.showAndWait();
//                    FDPinfo = null;
//                    return;
//                }
//            }
//        if(FDPinfo != null){
//
//        // objectFile Writing .. 
//        ObjectOutputStream oos = null;
//
//        try {
//            FileOutputStream fos = new FileOutputStream(contractFile, true);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(FDPinfo);
//            Alert a = new Alert(AlertType.INFORMATION);
//                    a.setContentText("Your File is Updated.");
//                    a.showAndWait();
//            submitButtonId.setStyle("-fx-text-fill : #b4c6fa");
//            loadInTableButtonId.setStyle("-fx-background-color : #b4c6fa;");
//            submitButtonId.setStyle("-fx-background-color : #b4c6fa;");
//            
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (oos != null) {
//                    oos.flush();
//                    oos.close();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//
//            }
//        }
//
//        }
//        else{
//             Alert a = new Alert(AlertType.ERROR);
//                    a.setContentText("The info exists.Can't submit the same info");
//                    a.showAndWait();
//                    
//            
//        }
//        }
//    }

    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //                                                       Application Layout
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private AnchorPane applicationAPane;
    @FXML
    private TextField applicationTextFieldId;
    @FXML
    private TextArea ApplicationTextArea;
    
    File applicationFile = new File("application.bin");
    
    @FXML
    private void applicationButton(ActionEvent event) {
        contractAPane.setVisible(false);
        checkDeliveryAPane.setVisible(false);
        applicationAPane.setVisible(true);
        
        renewContractButtonId.setStyle("-fx-background-color : #a7bfe4;");
        checkDeliveryButtonId.setStyle("-fx-background-color : #a7bfe4;");
        shareDeliveryPartnerButtonId.setStyle("-fx-background-color : #a7bfe4;");
        notifyCustomerButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applyForEquipmentButtonId.setStyle("-fx-background-color : #a7bfe4;");
        generateIncomeButtonId.setStyle("-fx-background-color :  #a7bfe4;");
        applicationButtonId.setStyle("-fx-background-color : #98a2b0;");
        reportButtonId.setStyle("-fx-background-color : #a7bfe4;");

    }
    
    

    @FXML
    private void applicationSendButton(ActionEvent event) throws IOException,FileNotFoundException {
            ObjectOutputStream oos = null;
            Application apl = new Application(applicationTextFieldId.getText());
            if( ! apl.getApplicationBody().equals("") )
            {
            try {
                ApplicationTextArea.setText(apl.getApplicationBody());

                if (applicationFile.exists()) {
                    FileOutputStream fos = new FileOutputStream(applicationFile, true);
                    oos = new AppendableObjectOutputStream(fos);
                } 
                else {
                    FileOutputStream fos = new FileOutputStream(applicationFile, true);
                    oos = new ObjectOutputStream(fos);
                }
                
                oos.writeObject(apl);
                Alert a = new Alert(AlertType.INFORMATION);
                a.setContentText("Your Submission is successful.");
                a.showAndWait();
                applicationButtonId.setStyle("-fx-text-fill : #b4c6fa");
                applicationButtonId.setStyle("-fx-background-color : #b4c6fa;");
                oos.close();
                }



            catch (IOException e) {
                e.printStackTrace();

            } 
            finally {
                try {
                    if (oos != null) {
                        oos.flush();
                        oos.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }}
            else{        
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Can't Submit an empty Application.");
                a.showAndWait();
               
                }
            }

    @FXML
    private void applicationClearButton(ActionEvent event) {
        applicationTextFieldId.clear();
        
    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Shahrier;

import abdullah.Stall;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML private ComboBox<String> selectItemForUpdateComboBox;
    @FXML private TextField availableQuantityTextField;
    @FXML private TextField addUpdatedQuantityTextField;
    @FXML private TextField priceUpdateTextField;
    @FXML private TextField supplierItemNameTextField;
    @FXML private TextField supplierItemQuantityTextField;
    @FXML private TextField supplierPerItemPriceTextField;
    private ArrayList<SupplierItem> supplierItems;
    private ArrayList<SupplierItem> tempArr;
    private ArrayList<SupplierItem> tempArr2;
    private ArrayList<ContractData> tempArr3;
    @FXML private PieChart pieChart;
    @FXML private TextArea spacificItemQuantityTextArea;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
    @FXML  private TextArea availableOrderShowingArea;
    @FXML  private ComboBox<String> takeOrderItemNameCombox;
    @FXML  private ComboBox<Integer> takeOrderQuantityCombox;
    @FXML  private Label takeOrderPerItemPriceshowArea;
    @FXML  private ComboBox<Integer> takeOrderDelivertTime;
    @FXML  private ComboBox<String> takeOrderSelectStallCombox;
    @FXML  private DatePicker takeOrderDatePicker;
    @FXML  private TableView<TakeOrder> takeOrderShowingTableView;
    @FXML  private TableColumn<TakeOrder, String> stallColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> itemColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> quantityColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> priceColumnOftakeOrder;
    @FXML  private TextField orderIDFortakeOrder;
    private ArrayList<TakeOrder> takeOrderItemArr;
    @FXML private Label invoceGenerationTotalPriceLabel;
    @FXML private ComboBox<String> invoiceGenerationSelectStallComBox;
    @FXML private TextArea invoiceGeneratingShowArea;
    @FXML private ComboBox<String> paymentProcessSelectStallComBox;
    @FXML private Label paymentProcessTotalAmmountArea;
    @FXML private TextField paymentProcessReciveAmountArea;
    @FXML private CheckBox duePaymentShowCheckBox;
    @FXML private CheckBox duePaymentHideCheckBox;
    @FXML private DatePicker paymentProcessDate;
    @FXML private TableView<PaymentData> paymentShowingTableView;
    @FXML private TableColumn<PaymentData, String> paymentProcessStallCol;
    @FXML private TableColumn<PaymentData, String> paymentProcessTotalAmountCol;
    @FXML private TableColumn<PaymentData, String> paymentProcessReciveAmountColumn;
    @FXML private TableColumn<PaymentData, String> paymentProcessingDuePaymentColumn;
    @FXML private Label paymentProcessDueAmountArea;
    private ArrayList<PaymentData> paymentDataArr;
    @FXML private ComboBox<String> contractManagementSelectStallComBox;
    @FXML private DatePicker contractStartDatePicker;
    @FXML private DatePicker contractEndDatePicker;
    @FXML private Label contractDurationShowArea;
    @FXML private TextField advanceReciveTextField;
    @FXML private TableView<ContractData> contractTableView;
    @FXML private TableColumn<ContractData, String> contractStallNameColumn;
    @FXML private TableColumn<ContractData, String> contractStartTimeColumn;
    @FXML private TableColumn<ContractData, String> contractEndTimeColumn;
    @FXML private TableColumn<ContractData, String> advancePaymentReciveColumn;
    private ArrayList<ContractData> contractArr;
    @FXML private ComboBox<?> selectStallComBoxForViewInventory;
    @FXML private TextArea inventoryShowingTextArea;
    @FXML private TextField lowStokeItemName;
    @FXML private TextField lowStokeQuantity;
    @FXML private TextArea lowStokeMsz;
    @FXML private Label paymentProcessingContractPaymentShowArea;
    @FXML
    private CheckBox reciveAmmountFromContractPaymentCheckBox;
    @FXML
    private ComboBox<?> generateReportTypeSelectComBox;
    @FXML
    private TextArea generateReportShowingArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        supplierItems = new ArrayList<>();
        takeOrderItemArr = new ArrayList<>();
        paymentDataArr = new ArrayList<>();
        contractArr = new ArrayList<>();
        takeOrderQuantityCombox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        takeOrderDelivertTime.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        
        stallColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("stallName"));
        itemColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("itemName"));
        quantityColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("itemQuantity"));
        priceColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("totalPrice"));
        
        paymentProcessStallCol.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("stallName"));
        paymentProcessTotalAmountCol.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("totalAmount"));
        paymentProcessReciveAmountColumn.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("recAmount"));
        paymentProcessingDuePaymentColumn.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("dueAmount"));
        
        contractStallNameColumn.setCellValueFactory(new PropertyValueFactory<ContractData,String>("contractStall"));
        contractStartTimeColumn.setCellValueFactory(new PropertyValueFactory<ContractData,String>("startTime"));
        contractEndTimeColumn.setCellValueFactory(new PropertyValueFactory<ContractData,String>("endTime"));
        advancePaymentReciveColumn.setCellValueFactory(new PropertyValueFactory<ContractData,String>("advancePay"));
        
        ObjectInputStream ois = null;
        pieChart.getData().clear();
        try{
            SupplierItem s;
            
            ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
            while(true){
               s = (SupplierItem) ois.readObject();
               supplierItems.add(s);
               list.add(new PieChart.Data(s.getSupItemName(),s.getSupItemQuantity()));
               selectItemForUpdateComboBox.getItems().add(s.getSupItemName()); 
               pieChart.setData(list);
               takeOrderItemNameCombox.getItems().add(s.getSupItemName());
            }
            
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        spacificItemQuantityTextArea.setText(String.valueOf(data.getPieValue()));
                        
                    }
                }
            );  
        }
        
        //check for seq alerts =================================================================================================
        ObjectInputStream oisForAlert = null;
        try{
            SeqAlerts s;
            
            oisForAlert = new ObjectInputStream(new FileInputStream("allAlertsobj.bin"));
            while(true){
               s =  (SeqAlerts) oisForAlert.readObject();
               //System.out.println(s.getAlertReciver());
               if(s.getAlertReciver().equals("Food Supplier")){
                   //System.out.println(s.getAlertReciver());
                   //System.out.println(s.getAlertReciver());
                   Alert a = new Alert(Alert.AlertType.WARNING);
                   a.setTitle("Security Alert Message");
                   a.setContentText(s.getAlertMsg());
                   a.setHeaderText(null);
                   a.showAndWait();
               }
            }    
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForStall = null;
        try{
            Stall st;
            
            oisForStall = new ObjectInputStream(new FileInputStream("StallObjects.bin"));
            while(true){
               st =  (Stall) oisForStall.readObject();
               takeOrderSelectStallCombox.getItems().add(st.getStallName());
               invoiceGenerationSelectStallComBox.getItems().add(st.getStallName());
               paymentProcessSelectStallComBox.getItems().add(st.getStallName());
               contractManagementSelectStallComBox.getItems().add(st.getStallName());
            }    
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForOrderData = null;
        try{
            TakeOrder t;
            
            oisForOrderData = new ObjectInputStream(new FileInputStream("orderItemDataobj.bin"));
            while(true){
               t =  (TakeOrder) oisForOrderData.readObject();
               takeOrderItemArr.add(t);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForPdata = null;
        try{
            PaymentData pd;
            oisForStall = new ObjectInputStream(new FileInputStream("paymentDataobj.bin"));
            while(true){
               pd =  (PaymentData) oisForStall.readObject();
               paymentDataArr.add(pd);
            }    
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForContract = null;
        try{
            ContractData c;
            oisForContract = new ObjectInputStream(new FileInputStream("contractData.bin"));
            while(true){
               c =  (ContractData) oisForContract.readObject();
               contractArr.add(c);
            }    
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        for(TakeOrder t:takeOrderItemArr){
            takeOrderShowingTableView.getItems().add(t);
        }
        for(PaymentData p:paymentDataArr){
            paymentShowingTableView.getItems().add(p);
        }
        for(ContractData c:contractArr){
            contractTableView.getItems().add(c);
        }
        
        
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
            
            ObjectInputStream ois = null;
            //supplierItems = new ArrayList<>();
            try{
                SupplierItem s;
                ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
                pieChart.getData().clear();
                while(true){
                   s =  (SupplierItem) ois.readObject();
                   list.add(new PieChart.Data(s.getSupItemName(),s.getSupItemQuantity()));
                   pieChart.setData(list);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
            for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        spacificItemQuantityTextArea.setText(String.valueOf(data.getPieValue()));
                        
                    }
                }
            );  
        }

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
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/CreateAccLogInAndForgotPass.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void selectItemForUpdateComboBoxOnSelect(ActionEvent event) {
    }

    @FXML
    private void upgradeTheItemStokeBtn(ActionEvent event) {
        if(selectItemForUpdateComboBox.getValue()==null || availableQuantityTextField.getText()== null ||
           addUpdatedQuantityTextField.getText()==null ||  priceUpdateTextField.getText()==null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Fill All The Blank Form");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            tempArr = new ArrayList<>();
            ObjectInputStream ois = null;
            try{
                SupplierItem s;
                ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
                while(true){
                   s =  (SupplierItem) ois.readObject();
                   tempArr.add(s);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }

            for(SupplierItem item:tempArr){
               if(item.getSupItemName().equals(selectItemForUpdateComboBox.getValue())){
                   item.supItemQuantity = item.supItemQuantity+Integer.parseInt(addUpdatedQuantityTextField.getText());
               }     
            }

            try{
                FileOutputStream fos = new FileOutputStream("supplierItemObj.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for(SupplierItem i:tempArr){
                    oos.writeObject(i);
                }
                oos.close();

            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        
        
    }

    @FXML
    private void addSupplierItemObjToArrayAndFile(ActionEvent event) {
        
        if(supplierItemNameTextField.getText()==null || supplierItemQuantityTextField.getText()==null || supplierPerItemPriceTextField.getText() == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Fill All The Blank Form");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            SupplierItem item = new SupplierItem(supplierItemNameTextField.getText(),
                                             Integer.parseInt(supplierItemQuantityTextField.getText()),
                                             Integer.parseInt(supplierPerItemPriceTextField.getText()));
        
            supplierItems.add(item);
            supplierItemNameTextField.clear();
            supplierItemQuantityTextField.clear();
            supplierPerItemPriceTextField.clear();

            //selectItemForUpdateComboBox.getItems().add();

            try{
                FileOutputStream fos = new FileOutputStream("supplierItemObj.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for(SupplierItem i:supplierItems){
                    oos.writeObject(i);
                }
                oos.close();

            }
            catch(Exception ex){
                System.out.println(ex);
            }

            ObjectInputStream ois = null;
            try{
                SupplierItem s;
                ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
                while(true){
                    s = (SupplierItem) ois.readObject();
                    if(selectItemForUpdateComboBox.getItems().contains(s.getSupItemName())){
                        System.out.println("Already Have");
                    }
                    else{
                        selectItemForUpdateComboBox.getItems().add(s.getSupItemName());
                    }
                }
            }
            catch(Exception x){
                System.out.println(x);
            }
        }
        
    }

    @FXML
    private void spacificItemQuantityTextAreaClearBtn(ActionEvent event) {
        spacificItemQuantityTextArea.clear();
    }

    @FXML
    private void takeOrderItemNameComboxOnSelect(ActionEvent event) {
        ObjectInputStream ois = null;
        try{
            SupplierItem s;
            ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
            while(true){
               s =  (SupplierItem) ois.readObject();
               if(s.getSupItemName().equals(takeOrderItemNameCombox.getValue())){
                   takeOrderPerItemPriceshowArea.setText(Integer.toString(s.getSupPerItemPrice()));
               }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void takeOrderAndSaveToArr(ActionEvent event) {
         
        if(orderIDFortakeOrder.getText()==null || takeOrderSelectStallCombox.getValue()== null ||
           takeOrderItemNameCombox.getValue() == null || takeOrderDelivertTime.getValue() == null ||
           takeOrderDatePicker.getValue() == null || takeOrderQuantityCombox.getValue() == null ||
           takeOrderPerItemPriceshowArea.getText() == null){
            
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Fill All The Blank Form");
            a.setHeaderText(null);
            a.showAndWait();
        } 
        
        else{
            if(takeOrderDelivertTime.getValue()<10){
            TakeOrder t = new TakeOrder(orderIDFortakeOrder.getText(),
                                    takeOrderSelectStallCombox.getValue(),
                                    takeOrderItemNameCombox.getValue(),
                                    takeOrderDelivertTime.getValue(),
                                    takeOrderDatePicker.getValue(),
                                    takeOrderQuantityCombox.getValue(),
                                    Integer.parseInt(takeOrderPerItemPriceshowArea.getText()));
            
            boolean flag = false;
        
            for(TakeOrder o:takeOrderItemArr){
                if(takeOrderItemArr.contains(t)){
                    flag = true;
                }
            }

            if(flag==false){
                takeOrderItemArr.add(t);
            }
            else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Error");
                a.setContentText("Already Taken");
                a.setHeaderText(null);
                a.showAndWait();
            }
               
            }

            else{
                TakeOrder t = new TakeOrder(
                                        takeOrderSelectStallCombox.getValue(),
                                        takeOrderItemNameCombox.getValue(),
                                        takeOrderDelivertTime.getValue(),
                                        takeOrderDatePicker.getValue(),
                                        takeOrderQuantityCombox.getValue(),
                                        Integer.parseInt(takeOrderPerItemPriceshowArea.getText()));

                boolean flag = false;
        
                for(TakeOrder o:takeOrderItemArr){
                    if(takeOrderItemArr.contains(t)){
                        flag = true;
                    }
                }

                if(flag==false){
                    takeOrderItemArr.add(t);
                }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Error");
                    a.setContentText("Already Taken");
                    a.setHeaderText(null);
                    a.showAndWait();
                }

            }
        }

        for(TakeOrder o:takeOrderItemArr){
            if(takeOrderShowingTableView.getItems().contains(o)){
                System.out.println("Already Contain");
            }
            else{
                takeOrderShowingTableView.getItems().add(o);
            }
        }
        
        try{
            FileOutputStream fos = new FileOutputStream("orderItemDataobj.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(TakeOrder t:takeOrderItemArr){
                oos.writeObject(t);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        //=============================
        
        tempArr2 = new ArrayList<>();
        ObjectInputStream ois = null;
        try{
            SupplierItem s;
            ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
            while(true){
                s =  (SupplierItem) ois.readObject();
                tempArr2.add(s);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        for(SupplierItem item:tempArr2){
            if(item.getSupItemName().equals(takeOrderItemNameCombox.getValue())){
                item.supItemQuantity = item.supItemQuantity-takeOrderQuantityCombox.getValue();
            }     
        }

        try{
            FileOutputStream fos = new FileOutputStream("supplierItemObj.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for(SupplierItem i:tempArr2){
                oos.writeObject(i);
            }
            oos.close();

        }
        catch(Exception ex){
            System.out.println(ex);
        }
               
    }
        
       

    @FXML
    private void invoiceGenerationSelectStallComBoxOnSelect(ActionEvent event) {
        ObjectInputStream oisForOrderData = null;
        try{
            TakeOrder t;
            int p = 0;
            oisForOrderData = new ObjectInputStream(new FileInputStream("orderItemDataobj.bin"));
            while(true){
               t =  (TakeOrder) oisForOrderData.readObject();
               if(t.getStallName().equals(invoiceGenerationSelectStallComBox.getValue())){
                   invoiceGeneratingShowArea.appendText(t.toString());
                   p = p+t.getTotalPrice();
               }
               invoceGenerationTotalPriceLabel.setText(Integer.toString(p));
            }
            
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }        
        
    }

    @FXML
    private void invoiceSaveBtn(ActionEvent event) {
        //code for pdf====
    }

    @FXML
    private void invoiceClearBtn(ActionEvent event) {
        invoiceGeneratingShowArea.clear();
        invoceGenerationTotalPriceLabel.setText("");
    }

    @FXML
    private void paymentProcessSelectStallComBoxOnSelect(ActionEvent event) {
        ObjectInputStream oisForOrderData = null;
        try{
            TakeOrder t;
            int p = 0;
            oisForOrderData = new ObjectInputStream(new FileInputStream("orderItemDataobj.bin"));
            while(true){
               t =  (TakeOrder) oisForOrderData.readObject();
               if(t.getStallName().equals(paymentProcessSelectStallComBox.getValue())){
                   p = p+t.getTotalPrice();
                   System.out.println(t.toString());
               }
               paymentProcessTotalAmmountArea.setText(Integer.toString(p));
            }
            
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        ObjectInputStream oisForContractData = null;
        try{
            ContractData cd;
            oisForContractData = new ObjectInputStream(new FileInputStream("contractData.bin"));
            while(true){
               cd =  (ContractData) oisForContractData.readObject();
               if(cd.getContractStall().equals(paymentProcessSelectStallComBox.getValue())){
                   paymentProcessingContractPaymentShowArea.setText(Integer.toString(cd.getAdvancePay()));
               }
               
            }
            
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        
        
    }


    @FXML
    private void duePaymentShowCheckBoxOnSelect(ActionEvent event) {
        if (duePaymentShowCheckBox.isSelected()){
            int result = Integer.parseInt(paymentProcessTotalAmmountArea.getText()) - Integer.parseInt(paymentProcessReciveAmountArea.getText());
            paymentProcessDueAmountArea.setText(Integer.toString(result));
        }
        else{
           paymentProcessDueAmountArea.setText("");
        }
    }

    @FXML
    private void duePaymentHideCheckBoxOnSelect(ActionEvent event) {
        if (duePaymentHideCheckBox.isSelected()){
            paymentProcessDueAmountArea.setText("");
        }
        else{
           paymentProcessDueAmountArea.setText("");
        }
    }

    @FXML
    private void paymentProcessConfirmBtn(ActionEvent event) {
        if(paymentProcessTotalAmmountArea.getText()==null || paymentProcessTotalAmmountArea.getText() == null || paymentProcessReciveAmountArea.getText() == null || paymentProcessDueAmountArea.getText() == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Fill All The Blank Form");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            PaymentData d  = new PaymentData(paymentProcessSelectStallComBox.getValue(),
                                            Integer.parseInt(paymentProcessTotalAmmountArea.getText()),
                                            Integer.parseInt(paymentProcessReciveAmountArea.getText()),
                                            Integer.parseInt(paymentProcessDueAmountArea.getText()),
                                            Integer.parseInt(paymentProcessReciveAmountArea.getText()));
            
            paymentDataArr.add(d);

            try{
                FileOutputStream fos = new FileOutputStream("paymentDataobj.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for(PaymentData p:paymentDataArr){
                    oos.writeObject(p);
                }
                oos.close();

            }
            catch(Exception ex){
                System.out.println(ex);
            }

            for(PaymentData p:paymentDataArr){
                if(paymentShowingTableView.getItems().contains(p)){
                    System.out.println("aLREADY In Table");
                }
                else{
                    paymentShowingTableView.getItems().add(p);
                }
            }
            //==================================================================================================================================================
            if(reciveAmmountFromContractPaymentCheckBox.isSelected()){
                tempArr3 = new ArrayList<>();
                ObjectInputStream oisForContract = null;
                try{
                    ContractData cData;
                    oisForContract = new ObjectInputStream(new FileInputStream("contractData.bin"));
                    while(true){
                        cData =  (ContractData) oisForContract.readObject();
                        tempArr3.add(cData);
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }

                for(ContractData item:tempArr3){
                    if(item.getContractStall().equals(paymentProcessSelectStallComBox.getValue())){
                        item.advancePay = item.advancePay-Integer.parseInt(paymentProcessReciveAmountArea.getText());
                    }     
                }

                try{
                    FileOutputStream fos = new FileOutputStream("contractData.bin");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    for(ContractData i:tempArr3){
                        oos.writeObject(i);
                    }
                    oos.close();

                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                tempArr3.clear();
                ObjectInputStream oisForContractD = null;
                try{
                    ContractData cData;
                    oisForContract = new ObjectInputStream(new FileInputStream("contractData.bin"));
                    while(true){
                        cData =  (ContractData) oisForContract.readObject();
                        tempArr3.add(cData);
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                contractTableView.getItems().clear();
                for(ContractData c:tempArr3){
                    contractTableView.getItems().add(c);
                }
            }
            
        }
        
        
        
    }

    @FXML
    private void contractEndDatePickerOnSelect(ActionEvent event) {
        //online
        long daysDifference = ChronoUnit.DAYS.between( contractEndDatePicker.getValue(),contractStartDatePicker.getValue());
        contractDurationShowArea.setText(Long.toString(daysDifference) + " Days");
    }

    @FXML
    private void cotractConfirmBtn(ActionEvent event) {
        if(contractStartDatePicker.getValue()== null || contractEndDatePicker.getValue() == null || contractManagementSelectStallComBox.getValue() == null || advanceReciveTextField.getText() == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Fill All The Blank Form");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            ContractData cd = new ContractData(contractStartDatePicker.getValue(),contractEndDatePicker.getValue(),contractManagementSelectStallComBox.getValue(),Integer.parseInt(advanceReciveTextField.getText()));
            contractArr.add(cd);
          
            for(ContractData c:contractArr){
                if(contractTableView.getItems().contains(c)){
                    System.out.println("aLREADY In Table");
                }
                else{
                    contractTableView.getItems().add(c);
                }
            }
            
            try{
                FileOutputStream fos = new FileOutputStream("contractData.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for(ContractData c:contractArr){
                    oos.writeObject(c);
                }
                oos.close();

            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
        }
        
    }

    @FXML
    private void lowStokeAlertSendBtn(ActionEvent event) {
    }

    @FXML
    private void inventoryShowingTextAreaClearBtn(ActionEvent event) {
    }

    @FXML
    private void generateReportTypeSelectComBoxOnSelect(ActionEvent event) {
    }

    @FXML
    private void generateReportSaveBtn(ActionEvent event) {
    }

    @FXML
    private void generateReportClearBtn(ActionEvent event) {
    }
    

    
}

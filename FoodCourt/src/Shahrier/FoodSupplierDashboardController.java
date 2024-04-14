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
    @FXML private PieChart pieChart;
    @FXML private TextArea spacificItemQuantityTextArea;
    private ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
    @FXML  private TextArea availableOrderShowingArea;
    @FXML  private ComboBox<String> takeOrderItemNameCombox;
    @FXML  private ComboBox<Integer> takeOrderQuantityCombox;
    @FXML  private Label takeOrderPerItemPriceshowArea;
    @FXML  private TextField takeOrderDelivertTime;
    @FXML  private ComboBox<String> takeOrderSelectStallCombox;
    @FXML  private DatePicker takeOrderDatePicker;
    @FXML  private TableView<TakeOrder> takeOrderShowingTableView;
    @FXML  private TableColumn<TakeOrder, String> orderIDColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> stallColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> itemColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> quantityColumnOftakeOrder;
    @FXML  private TableColumn<TakeOrder, String> priceColumnOftakeOrder;
    @FXML  private TextField orderIDFortakeOrder;
    private ArrayList<TakeOrder> takeOrderItemArr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        supplierItems = new ArrayList<>();
        takeOrderItemArr = new ArrayList<>();
        takeOrderQuantityCombox.getItems().addAll(1,2,3,4,5,6,7,8,9);
        
        orderIDColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("orderID"));
        stallColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("stallName"));
        itemColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("itemName"));
        quantityColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("itemQuantity"));
        priceColumnOftakeOrder.setCellValueFactory(new PropertyValueFactory<TakeOrder,String>("totalPrice"));
        
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
        
        //check for seq alerts
        ObjectInputStream oisForAlert = null;
        try{
            SeqAlerts s;
            
            oisForAlert = new ObjectInputStream(new FileInputStream("allAlertsobj.bin"));
            while(true){
               s =  (SeqAlerts) oisForAlert.readObject();
               if(s.getAlertReciver().equals("Food Supplier")){
                   System.out.println(s.getAlertReciver());
                   //System.out.println(s.getAlertReciver());
                   Alert a = new Alert(Alert.AlertType.WARNING);
                   a.setTitle("Security Alert");
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
            }    
        }
        catch(Exception ex){
            System.out.println(ex);
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
        ObjectInputStream ois = null;
        try{
            SupplierItem s;
            ois = new ObjectInputStream(new FileInputStream("supplierItemObj.bin"));
            while(true){
               s =  (SupplierItem) ois.readObject();
               if(s.getSupItemName().equals(selectItemForUpdateComboBox.getValue())){
                   availableQuantityTextField.setText(Integer.toString(s.getSupItemQuantity()));
                   priceUpdateTextField.setText(Integer.toString(s.getSupPerItemPrice()));
               }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void upgradeTheItemStokeBtn(ActionEvent event) {
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

    @FXML
    private void addSupplierItemObjToArrayAndFile(ActionEvent event) {
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
        TakeOrder t = new TakeOrder(orderIDFortakeOrder.getText(),
                                    takeOrderSelectStallCombox.getValue(),
                                    takeOrderItemNameCombox.getValue(),
                                    takeOrderDelivertTime.getText(),
                                    takeOrderDatePicker.getValue(),
                                    takeOrderQuantityCombox.getValue(),
                                    Integer.parseInt(takeOrderPerItemPriceshowArea.getText()),
                                    t.totalPriceCalculation());
       
        
        takeOrderItemArr.add(t);
        
        for(TakeOrder o:takeOrderItemArr){
            takeOrderShowingTableView.getItems().add(o);
        }
        
    }
    
}

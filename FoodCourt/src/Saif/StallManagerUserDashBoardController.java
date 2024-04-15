/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Saif;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sakib
 */
public class StallManagerUserDashBoardController implements Initializable {

    @FXML
    private AnchorPane editMenuAPane;
    @FXML
    private TextField stallNametextFieldId;
    @FXML
    private TextField menuManageFoodNameTextFieldId;
    @FXML
    private TextField menuManageFoodPriceTextFieldId;
    @FXML
    private TextField menumanageAddOfferTextFieldId;
    @FXML
    private TableView<MenuManagement> menuManageTableView;
    @FXML
    private TableColumn<MenuManagement, String> menuManageFoodNameTableColumnId;
    @FXML
    private TableColumn<MenuManagement, String> menuManageFoodPriceTableColumnId;
    ObservableList <MenuManagement> menuInfoObl = FXCollections.observableArrayList();
    File menuManageFile = new File("Menu1.bin");
    
    @FXML
    private Button menuManageAddToViewId;
    @FXML
    private TableColumn<MenuManagement, String> menuManageStallNameTableColumnId;
    @FXML
    private TableColumn<MenuManagement, String> menuManageOffersTableColumnId1d;
    @FXML
    private Label label;
    @FXML
    private Button menuManageDeleteButtonId;
    @FXML
    private Button menuManageLoadMenuButtonId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // edit anchorPane ...
        editMenuAPane.setVisible(false);
        
        // adding stall name from the file to stall name text field
        
//        FileInputStream fis = null;
//        if(menuManageFile.exists()){
//            
//        try{
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(menuManageFile)); 
//            MenuManagement menuObject = (MenuManagement) ois.readObject();
//            stallNametextFieldId.setText(menuObject.stallName);
//        }catch(IOException | ClassNotFoundException ex){
//            Logger.getLogger(StallManagerUserDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        // table view adds ..         
        menuManageTableView.setItems(menuInfoObl);
        menuManageFoodNameTableColumnId.setCellValueFactory(new PropertyValueFactory("foodName"));
        menuManageFoodPriceTableColumnId.setCellValueFactory(new PropertyValueFactory("price"));
        menuManageStallNameTableColumnId.setCellValueFactory(new PropertyValueFactory("stallName"));
        menuManageOffersTableColumnId1d.setCellValueFactory(new PropertyValueFactory("addOffer"));
    }    
    
    @FXML
    private void menuManageAddToView(ActionEvent event) {
        
        if (menuManageFoodNameTextFieldId.getText().equals("") || menuManageFoodPriceTextFieldId.getText().equals("")
                || stallNametextFieldId.getText().equals("")){
            Alert b = new Alert(Alert.AlertType.ERROR);
            b.setContentText("May be Food Name/Food Price /Stall Name  to be filled.");
            b.showAndWait();
            menuManageAddToViewId.setStyle("-fx-text-fill : ##a51313");
        }
        else{boolean i = true;
            
            ObservableList<MenuManagement> menuList = menuManageTableView.getItems();
            for(MenuManagement m : menuList){
                if (m.getFoodName().equals(menuManageFoodNameTextFieldId.getText())){
                    i = false;
                    if (menumanageAddOfferTextFieldId.getText() == null || menumanageAddOfferTextFieldId.getText().equals(""))
                    {
                        menumanageAddOfferTextFieldId.setText("Not Given");
                        menuManageTableView.getItems().remove(m);
                        menuInfoObl.add(new MenuManagement(stallNametextFieldId.getText(),menuManageFoodNameTextFieldId.getText(),menumanageAddOfferTextFieldId.getText(),menuManageFoodPriceTextFieldId.getText()));
                    }
                    else{
                        menuManageTableView.getItems().remove(m);
                        menuInfoObl.add(new MenuManagement(stallNametextFieldId.getText(),menuManageFoodNameTextFieldId.getText(),menumanageAddOfferTextFieldId.getText(),menuManageFoodPriceTextFieldId.getText()));                       
                    }
                }
            }
            
            if( i == false){       
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("Same named Food can not inserted into TableView.But offer can be Updated.");
            b.showAndWait();
            menuManageAddToViewId.setStyle("-fx-text-fill : #a51313");
                
            }
            else{
                if (menumanageAddOfferTextFieldId.getText() == null || menumanageAddOfferTextFieldId.getText().equals(""))
                {menumanageAddOfferTextFieldId.setText("Not Given");}
                
                menuInfoObl.add(new MenuManagement(stallNametextFieldId.getText(),menuManageFoodNameTextFieldId.getText(),menumanageAddOfferTextFieldId.getText(),menuManageFoodPriceTextFieldId.getText()));
                menuManageAddToViewId.setStyle("-fx-text-fill : #000066");
            }
        }
        
        
    }
    @FXML
    private void menuManageAddToFile(ActionEvent event) throws IOException {
        ArrayList<MenuManagement>  itemRejectedArr = new ArrayList<MenuManagement >();
        ArrayList<MenuManagement> itemAcceptedArr = new ArrayList<MenuManagement >();
        ArrayList<MenuManagement> itemsList = new ArrayList<MenuManagement >();
        
        
        // reading file . .
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MenuManagement menuObject = null;
        ObservableList<MenuManagement> menuList = menuManageTableView.getItems();
        
        if(menuInfoObl.isEmpty()){
            Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("The table is currently empty now.");
                    a.showAndWait();}
            
            
        
        else{
        if (menuManageFile.exists() && menuManageFile.length() != 0){
        try {
            Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("got into reading File");
                    a.showAndWait();
            fis = new FileInputStream(menuManageFile );
            ois = new ObjectInputStream(fis);
            // before adding clearing the arraLists .  .. 
              itemAcceptedArr.clear();
              itemRejectedArr.clear();
            // File Reading .. 
            while (true) {//fis.available() > 0
                try{  
                menuObject = (MenuManagement) ois.readObject();
                itemsList.add(menuObject);
//                for(MenuManagement m : menuList){
//                    if (m.getFoodName().equals( menuObject.foodName)){
//                        itemRejectedArr.add(m);  
//                        Alert b = new Alert(AlertType.INFORMATION);
//                    b.setContentText("got a rejected File while reading");
//                    b.showAndWait();
//                        }
//                    else{
//                        itemAcceptedArr.add(m);
//                        Alert c = new Alert(AlertType.INFORMATION);
//                    c.setContentText("got an Accepted File while reading");
//                    c.showAndWait();
//                    }
//                }
                
                
                }
                catch(IOException e){
                    Alert g = new Alert(AlertType.INFORMATION);
                    g.setContentText("No file read. break occured");
                    g.show();
                    break;
                }
            }
            for(MenuManagement tableMenu : menuList){
                boolean i = true;
                for (MenuManagement fileMenu : itemsList){
                    if(tableMenu.getFoodName().equals(fileMenu.getFoodName())){
                        itemRejectedArr.add(tableMenu); 
                        i = false;
                        
                    }
                }
                if(i == true){
                    itemAcceptedArr.add(tableMenu);
                    
                }
            }
//                    if (m.getFoodName().equals( menuObject.foodName)){
//                        itemRejectedArr.add(m);  
//                        Alert b = new Alert(AlertType.INFORMATION);
//                    b.setContentText("got a rejected File while reading");
//                    b.showAndWait();
//                        }
//                    else{
//                        itemAcceptedArr.add(m);
//                        Alert c = new Alert(AlertType.INFORMATION);
//                    c.setContentText("got an Accepted File while reading");
//                    c.showAndWait();
//                    }
//                }
            ois.close();      
        }

        catch (IOException | ClassNotFoundException e) {
            fis.close();
            ois.close();
            e.printStackTrace();
        }
        }
        // File Writing .. 
        ObjectOutputStream oos = null;
            
            try {
                if (! menuManageFile.exists()) {
                    FileOutputStream fos = new FileOutputStream(menuManageFile, true);
                    oos = new ObjectOutputStream(fos);
                } else {
                    FileOutputStream fos = new FileOutputStream(menuManageFile, true);                    
                    oos = new AppendableObjectOutputStream(fos);
                }
                
                if ( ! itemAcceptedArr.isEmpty() ){      
                    Alert b = new Alert(AlertType.INFORMATION);
                    b.setContentText("itemAcceptedArr is not empty");
                    b.showAndWait();
                for (MenuManagement m : itemAcceptedArr){
                    oos.writeObject(m);
                    label.setText(m.toString());
                    Alert g = new Alert(AlertType.INFORMATION);
                    g.setContentText("writing to list from itemAcceptdArr");
                    g.showAndWait();
                    
                    
                }
                Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("A new Item Added to the Menu");
                    a.show();
                }
                else{
                    if ( itemRejectedArr.isEmpty() ){
//                        if(! menuList.isEmpty())
                      for(MenuManagement m : menuList){
                          oos.writeObject(m);
                          Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("A new Item Added,as rejected and accepted both array are empty");
                    a.showAndWait();
                          
                      }  
                    
                    }else{
                    Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("No Item Added ,Try successful.");
                    a.show();}
                    
                }
                }

             catch (IOException e) {
                e.printStackTrace();
                Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("File Never Opened,Try Failed");
                    a.show();
                    
                    oos.close();

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
    }
    }    

    @FXML
    private void menuManageDeleteButton(ActionEvent event) {
        MenuManagement fieldValue = menuManageTableView.getSelectionModel().getSelectedItem();
        menuManageTableView.getItems().remove(fieldValue);
//        menuManageTableView.getItems().remove(fieldValue.getPrice());
//        menuManageTableView.getItems().remove(fieldValue.getAddOffer());
//        menuManageTableView.getItems().remove(fieldValue.getPrice());
        
        
    }

    

    @FXML
    private void MenuManageRowClicked(MouseEvent event) {
        menuManageTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MenuManagement fieldValue = menuManageTableView.getSelectionModel().getSelectedItem();

        menuManageFoodNameTextFieldId.setText(fieldValue.getFoodName());
        menuManageFoodPriceTextFieldId.setText((fieldValue.getPrice()));
        stallNametextFieldId.setText(fieldValue.getStallName());
        menumanageAddOfferTextFieldId.setText(fieldValue.getAddOffer());
        
    }

    



    @FXML
    private void editMenuButton(ActionEvent event) {
        editMenuAPane.setVisible(true);
    
    }


    @FXML
    private void menuManageReplaceDataButton(ActionEvent event) throws IOException {
        ObjectOutputStream oos = null;
        if (menuManageTableView.getItems().isEmpty()){
            Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("There is nothing in the Table View.");
                    a.showAndWait(); 
        }
        else{   
            try {                
                FileOutputStream fos = new FileOutputStream(menuManageFile, false);
                ObservableList<MenuManagement> menuList = menuManageTableView.getItems();
                oos = new ObjectOutputStream(fos);

                for (MenuManagement m : menuList){
                    oos.writeObject(m);
                    label.setText(m.toString());
                    Alert g = new Alert(AlertType.INFORMATION);
                    g.setContentText("writing to list from table");
                    g.showAndWait();
                }
            }

             catch (IOException e) {
                e.printStackTrace();
                Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("File not rewritten,Try Failed");
                    a.show();   


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
     
         } 
    }

    @FXML
    private void menuManageLoadMenuButton(ActionEvent event) throws IOException {
        menuManageTableView.getItems().clear();
        // reading file . .
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MenuManagement menuObject = null;
        
        if ( stallNametextFieldId.getText().isEmpty() || stallNametextFieldId.getText().equals("") || stallNametextFieldId.getText() == null){
            Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("Fill the Stall Name Text Field to Load Stall Items");
                    a.showAndWait();
        }
        else{
            menuInfoObl.clear();
        if (menuManageFile.exists() && menuManageFile.length() != 0){
        try {// File Reading ..
            Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("got into reading File");
                    a.showAndWait();
            fis = new FileInputStream(menuManageFile );
            ois = new ObjectInputStream(fis);
                                     
                while(true){
                try{  
                menuObject = (MenuManagement) ois.readObject();
                if (menuObject.getStallName().equals(stallNametextFieldId.getText())){
                menuInfoObl.add(new MenuManagement(menuObject.getStallName(),menuObject.getFoodName(),menuObject.getAddOffer(),menuObject.getPrice()));
                }
                
                    
                }
                catch(IOException e){
                    Alert g = new Alert(AlertType.INFORMATION);
                    g.setContentText("No file read. break occured Or file is empty");
                    g.show();
                    break;
                }
            }
                if(menuInfoObl.isEmpty()){
                    Alert c = new Alert(AlertType.ERROR);
                    c.setContentText("No such Stall is Found.Set Your Shop 1st.");
                    c.showAndWait();}
            fis.close();
            ois.close();      
        }

        catch (IOException | ClassNotFoundException e) {
            fis.close();
            ois.close();
            e.printStackTrace();
        }
        
        
    }
        else{Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("No File to be Loaded.");
                    a.showAndWait();
            
        }}
    

    }

    
    
    @FXML
    private void EditProfileMenuItem(ActionEvent event) {
    }

    @FXML
    private void logOutMenuItem(ActionEvent event) {
    }

    @FXML
    private void contractOfFoodDeliveryPartner(ActionEvent event) {
    }

    @FXML
    private void contractOfFoodCourtManager(ActionEvent event) {
    }

    @FXML
    private void reviewContractButton(ActionEvent event) {
    }

    @FXML
    private void addOfferButton(ActionEvent event) {
    }

    @FXML
    private void reviewApplicationButton(ActionEvent event) {
    }

    @FXML
    private void prepareBillButton(ActionEvent event) {
    }

    @FXML
    private void GenerateReportButton(ActionEvent event) {
    }

    @FXML
    private void reviewRatingButton(ActionEvent event) {
    }

    @FXML
    private void reportButton(ActionEvent event) {
    }

}
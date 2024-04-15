
package Saif;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class MenuController implements Initializable {

    @FXML
    private Button removeSelectedButtonId;
    @FXML
    private TableColumn<Menu, String> stallNameTableColumnId;
    @FXML
    private TableColumn<Menu, String> foodNameTableColumnId;
    @FXML
    private TableColumn<Menu, Integer> quantityTableColumnId;
    @FXML
    private TableColumn<Menu, String> preferredTimeTableColumnId;
    @FXML
    private TableColumn<Menu, Float> AmountTableColumnId;
    @FXML
    private ComboBox<String> stallSelectionCB;
    private ComboBox<String> foodSelectionCB;
    @FXML
    private ComboBox<Integer> quantitySelectionCB;
    @FXML
    private ComboBox<String> timeSelectionCB;
    @FXML
    private TableView<Menu> tableVIewId;
    File menuManageFile = new File("Menu1.bin");
    ArrayList<MenuManagement> itemsList = new ArrayList<MenuManagement >();
    ObservableList <MenuManagement> menuListNow = FXCollections.observableArrayList();
    ObservableList <Menu> addToCartList = FXCollections.observableArrayList();
    @FXML
    private TableView<MenuManagement> tableViewRuff;
    @FXML
    private TableColumn<MenuManagement, String> foodnameRuff;
    @FXML
    private TableColumn<MenuManagement, String> foodPriceRuff;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList quantity = FXCollections.observableArrayList("1", "2", "2","4","5");
        quantitySelectionCB.setItems(quantity);

        ObservableList time = FXCollections.observableArrayList("10AM -12 AM", "12PM - 2PM", "2PM - 4PM", "4PM - 6PM", "6PM - 8PM" ,"8PM - 10PM");
        timeSelectionCB.setItems(time);
        
        
        // ruff table 
        tableViewRuff.setItems(menuListNow);//MenuManagement
        foodnameRuff.setCellValueFactory(new PropertyValueFactory("foodName"));
        foodPriceRuff.setCellValueFactory(new PropertyValueFactory("price"));
        
        // Add tot cart table ..
        tableVIewId.setItems(addToCartList);
        stallNameTableColumnId.setCellValueFactory(new PropertyValueFactory("stallName"));
        foodNameTableColumnId.setCellValueFactory(new PropertyValueFactory("foodName"));
        quantityTableColumnId.setCellValueFactory(new PropertyValueFactory("quantity"));
        preferredTimeTableColumnId.setCellValueFactory(new PropertyValueFactory("preferredTime"));
        AmountTableColumnId.setCellValueFactory(new PropertyValueFactory("costPerUnit"));
        
        
        
        
        ArrayList<MenuManagement> itemsList = new ArrayList<MenuManagement >();
      
        // reading file . .

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MenuManagement menuObject = null;
        itemsList = null;
//        ObservableList<MenuManagement> menuList = menuManageTableView.getItems();

        
        if (menuManageFile.exists() && menuManageFile.length() != 0){
        try {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("got into reading File");
                    a.showAndWait();
            fis = new FileInputStream(menuManageFile );
            ois = new ObjectInputStream(fis);
            
            // File Reading .. 
            while (true) {//fis.available() > 0
                try{  
                menuObject = (MenuManagement) ois.readObject();
                itemsList.add(menuObject);           
                }
                catch(IOException e){
                    Alert g = new Alert(Alert.AlertType.INFORMATION);
                    g.setContentText("No file read. break occured");
                    g.show();
                    break;
                }
            }
            // adding stallNames in the comboBox ..
            ObservableList stallNameArr = FXCollections.observableArrayList();
            for(MenuManagement m :itemsList){  
                stallNameArr.add(m.getStallName());
            }
            stallSelectionCB.setItems(stallNameArr);
       
            ois.close();      
        }

        catch (IOException | ClassNotFoundException e) {
            try {
                fis.close();
            } catch (IOException ex) {
                Alert g = new Alert(Alert.AlertType.INFORMATION);
                    g.setContentText("didnt make it to try");
                    g.showAndWait();
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                Alert g = new Alert(Alert.AlertType.INFORMATION);
                    g.setContentText("didnt make it to try");
                    g.showAndWait();
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }

        
    }    

    @FXML
    private void addToCartButton(ActionEvent event) {
    }

    @FXML
    private void removeSelectedButton(ActionEvent event) {
    }

    @FXML
    private void placeOrderButton(ActionEvent event) {
    }

    @FXML
    private void backButton(ActionEvent event) {
    }

    @FXML
    private void stallSelectionCBAction(ActionEvent event) { // adding Food ..
            
    }

    @FXML
    private void loadFoodbutton(ActionEvent event) {
        if (stallSelectionCB.getValue().equals("") || stallSelectionCB.getValue().equals(null) ){
            Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Select Stall please.");
                    a.showAndWait();
        }
        else{
            
//        ObservableList foodNamePriceArr = FXCollections.observableArrayList();
            String Stallname = stallSelectionCB.getValue();
            for(MenuManagement n :itemsList){
                if(n.getStallName().equals(stallSelectionCB.getValue())){
                   menuListNow.add(new MenuManagement(n.getStallName(),n.getFoodName(),n.getPrice()));
                }
            }
            
            
    }}
    
}

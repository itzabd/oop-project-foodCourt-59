/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ArifulIslam;

import Shahrier.ReportGeneratingData;
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
public class ChefController implements Initializable {

    @FXML
    private Button seasonalMenuUpdatesButton;
    @FXML
    private Button specialsAndPromotionsButton;
    @FXML
    private Button customerFeedbackAnalysisButton;
    @FXML
    private Button ingredientManagementButton;
    @FXML
    private Button menuCustomizationButton;
    @FXML
    private Button orderQueueButton;
    @FXML
    private Button menuCreationButton;
    @FXML
    private Button ChefDashboardReturnButton;
    @FXML
    private AnchorPane menuCreationFrame;
    @FXML
    private ComboBox<String> MenuCreationSelectStallComboBox;
    @FXML
    private TextField MenuCreationItemNameTextField;
    @FXML
    private TextField MenuCreationPriceTextField;
    @FXML
    private TableView<MenuCreation> MenuCreationTableView;
    @FXML
    private TableColumn<MenuCreation, String> StallNameTableColumnOfMenuCreation;
    @FXML
    private TableColumn<MenuCreation, String> ItemNameTableColumn;
    @FXML
    private TableColumn<MenuCreation, String> PriceTableColumnOfMenuCreation;
    @FXML
    private AnchorPane menuCustomizationFrame;
    @FXML
    private AnchorPane specialAndPromotionsFrame;
    @FXML
    private TableColumn<SpecialAndPromotionA, String> OfferTableColumn;
    @FXML
    private AnchorPane seasonalMenuUpdatesFrame;
    @FXML
    private ComboBox<String> SeasonalMenuSelectAStallComboBox;
    @FXML
    private TextField NewSeasonalItemTextField;
    @FXML
    private TextField NewSeasonalItemPriceTextField;
    /*
    private TableColumn<?, ?> SpecailAndPromotionsStallNameTableColumn;
    private TableColumn<?, ?> SpecailAndPromotionsNewSeasonalItemTableColumn;
    private TableColumn<?, ?> SpecailAndPromotionsNewSeasonalItemPriceTableColumn;
    */
    @FXML
    private AnchorPane recipeManagementFrame;
    @FXML
    private AnchorPane ingredientManagementFrame;
    @FXML
    private ComboBox<String> IngredientManagementSelectStallComboBox;
    @FXML
    private AnchorPane orderQueueFrame;
    @FXML
    private AnchorPane customerFeedbackAnalysisFrame;
    @FXML
    private AnchorPane ChefDashboardReturnFrame;
    @FXML
    private ComboBox<?> CustomerFeedbackAnalysisSelectAStallComboBox;
    @FXML
    private TableView<?> CustomerFeedbackAnalysisTableView;
    @FXML
    private TableColumn<?, ?> CustomerFeedbackAnalysisStallNameTableColumn;
    @FXML
    private TableColumn<?, ?> CustomerFeedbackAnalysisCustomerFeedbackTableColumn;
    @FXML
    private TableColumn<?, ?> CustomerFeedbackAnalysisReviewTableColumn;
    @FXML
    private ComboBox<?> MenuCustomizationStallNameComboBox;
    @FXML
    private ComboBox<?> MenuCustomizationItemsComboBox;
    @FXML
    private TextField MenuCustomizationAvailableQuantityTextField;
    @FXML
    private TextField MenuCustomizationAddedQuantityTextField;
    @FXML
    private TextField MenuCustomizationItemPriceTextField;
    @FXML
    private TextField MenuCustomizationChangeItemPriceIfNeededTextField;
    @FXML
    private Button InventoryAlertsButton;
    @FXML
    private ComboBox<?> InventoryAlertsStallNameComboBox;
    @FXML
    private TextArea InventoryAlertsTextArea;
    
    @FXML
    private TableView<SeasonalMenuA> SeasonalMenuUpdateTableView;
    @FXML
    private TableColumn<SeasonalMenuA, String> SeasonalMenuStallNameTableColumn;
    @FXML
    private TableColumn<SeasonalMenuA, String> SeasonalMenuNewSeasonalItemTableColumn;
    @FXML
    private TableColumn<SeasonalMenuA, String> SeasonalMenuNewSeasonalItemPriceTableColumn;
    @FXML
    private ComboBox<String> SpecailAndPromotionsSelectAStallComboBoxNewId;
    @FXML
    private TextField SpecailAndPromotionsSpecialItemTextFieldNewId;
    @FXML
    private TextField SpecailAndPromotionsPriceTextFieldNewId;
    @FXML
    private TextField SpecailAndPromotionsOfferTextFieldNewId;
    @FXML
    private TableView<SpecialAndPromotionA> SpecailAndPromotionTableViewNewId;
    @FXML
    private TableColumn<SpecialAndPromotionA, String> StallNameTableColumnOfSpecialAndPromotionNewId;
    @FXML
    private TableColumn<SpecialAndPromotionA, String> SpecialItemTableColumnNewId;
    @FXML
    private TableColumn<SpecialAndPromotionA, String> PriceTableColumnOfSpecialAndPromotionNewId;
    
    
    private ArrayList<MenuCreation> menuArray;
    
    private ArrayList<SpecialAndPromotionA> specialArray;
    
    private ArrayList<SeasonalMenuA> seasonalArray;
    @FXML
    private TextArea IngredientManagementTextArea;
    
    

    /**
     * Initializes the controller class.
     */
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller
        
        // Array crate kora hoice
        menuArray = new ArrayList<>(); 
        
        // ComboBox a value add korar kaj
        MenuCreationSelectStallComboBox.getItems().addAll("ABC1", "ABC2", "ABC3");
        
        
        // Read code start
        ObjectInputStream ois = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            MenuCreation e;
            
            ois = new ObjectInputStream(new FileInputStream("menuCreationFile.bin"));
            while(true){
               e =  (MenuCreation) ois.readObject();
               menuArray.add(e);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end 
        
       
        
        
        // table er column golor kaj korar code
        StallNameTableColumnOfMenuCreation.setCellValueFactory(new PropertyValueFactory<MenuCreation,String>("stallName"));
        ItemNameTableColumn.setCellValueFactory(new PropertyValueFactory<MenuCreation,String>("itemName"));
        PriceTableColumnOfMenuCreation.setCellValueFactory(new PropertyValueFactory<MenuCreation,String>("price"));
        
   
        
        
        // Special And Promotion Start
        
        // Array crate kora hoice
        specialArray = new ArrayList<>(); 
        
        // ComboBox a value add korar kaj
        SpecailAndPromotionsSelectAStallComboBoxNewId.getItems().addAll("ABC1", "ABC2", "ABC3");
        
        
        // Read code start
        ObjectInputStream oisb = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            SpecialAndPromotionA e;
            
            oisb = new ObjectInputStream(new FileInputStream("specialFile.bin"));
            while(true){
               e =  (SpecialAndPromotionA) oisb.readObject();
               specialArray.add(e);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end 
        
        
        // table er column golor kaj korar code
        StallNameTableColumnOfSpecialAndPromotionNewId.setCellValueFactory(new PropertyValueFactory<SpecialAndPromotionA,String>("stallName"));
        SpecialItemTableColumnNewId.setCellValueFactory(new PropertyValueFactory<SpecialAndPromotionA,String>("specialitemName"));
        OfferTableColumn.setCellValueFactory(new PropertyValueFactory<SpecialAndPromotionA,String>("offer"));
        PriceTableColumnOfSpecialAndPromotionNewId.setCellValueFactory(new PropertyValueFactory<SpecialAndPromotionA,String>("price"));
        
        
        
        
        // Special And promotion end
        
        
        // Seasonal Menu Update start
        
        // Array crate kora hoice
        seasonalArray = new ArrayList<>(); 
        
        // ComboBox a value add korar kaj
        SeasonalMenuSelectAStallComboBox.getItems().addAll("ABC1", "ABC2", "ABC3");
        
        
        // Read code start
        ObjectInputStream oisc = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            SeasonalMenuA e;
            
            oisc = new ObjectInputStream(new FileInputStream("seasonalFile.bin"));
            while(true){
               e =  (SeasonalMenuA) oisc.readObject();
               seasonalArray.add(e);
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end 
        
        
        // table er column golor kaj korar code
        SeasonalMenuStallNameTableColumn.setCellValueFactory(new PropertyValueFactory<SeasonalMenuA,String>("stallNameA"));
        SeasonalMenuNewSeasonalItemTableColumn.setCellValueFactory(new PropertyValueFactory<SeasonalMenuA,String>("newSeasonalItemName"));
        SeasonalMenuNewSeasonalItemPriceTableColumn.setCellValueFactory(new PropertyValueFactory<SeasonalMenuA,String>("priceA"));
        
        // Seasonal Menu Update End
        
        
        
       
        // Ingredient er Initialization part start
        
         // Read code start
        ObjectInputStream oisIngredient = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            ManageStockA e;
            
            oisIngredient = new ObjectInputStream(new FileInputStream("manageStockFile.bin"));
            while(true){
               e =  (ManageStockA) oisIngredient.readObject();
                System.out.println(e.toString());
               IngredientManagementSelectStallComboBox.getItems().add(e.getStallName());
               
       
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end
        
        
        
        
        
    }

    @FXML
    private void switchingFrame(ActionEvent event) {
        if(event.getSource()==ChefDashboardReturnButton){
            ChefDashboardReturnFrame.setVisible(true);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==InventoryAlertsButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(true);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==menuCreationButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(true);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==menuCustomizationButton){
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(true);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==specialsAndPromotionsButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(true);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==seasonalMenuUpdatesButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(true);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==ingredientManagementButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(true);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==orderQueueButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(true);
            customerFeedbackAnalysisFrame.setVisible(false);
        }
        else if(event.getSource()==customerFeedbackAnalysisButton){
            ChefDashboardReturnFrame.setVisible(false);
            recipeManagementFrame.setVisible(false);
            menuCreationFrame.setVisible(false);
            menuCustomizationFrame.setVisible(false);
            specialAndPromotionsFrame.setVisible(false);
            seasonalMenuUpdatesFrame.setVisible(false);
            ingredientManagementFrame.setVisible(false);
            orderQueueFrame.setVisible(false);
            customerFeedbackAnalysisFrame.setVisible(true);
        }
               
        
        
    }

    
    

    @FXML
    private void chefDashBoardBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccLogInAndForgotPass.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void MenuCreationSaveButton(ActionEvent event) {
        MenuCreation mn = new MenuCreation(MenuCreationSelectStallComboBox.getValue(), MenuCreationItemNameTextField.getText(), Integer.parseInt(MenuCreationPriceTextField.getText()));
        //System.out.println(MenuCreationItemNameTextField.getText());
        menuArray.add(mn);
        
        
        // write code start
        try{
            FileOutputStream fos = new FileOutputStream("menuCreationFile.bin");     // Write a object name change korte hobe nah, Class name R array name change korte hobe
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(MenuCreation r:menuArray){
                oos.writeObject(r);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // write code end
        
        
        // table View add korar kaj
        for(MenuCreation e:menuArray){
            if(MenuCreationTableView.getItems().contains(e)){
                System.out.println("Already Contain");
            }
            else{
                MenuCreationTableView.getItems().add(e);
            }
        }
    }
    
    
    


    @FXML
    private void SeasonalMenuUpdatesSaveButton(ActionEvent event) {
        SeasonalMenuA mn = new SeasonalMenuA(SeasonalMenuSelectAStallComboBox.getValue(), NewSeasonalItemTextField.getText(), Integer.parseInt(NewSeasonalItemPriceTextField.getText()));
        //System.out.println(MenuCreationItemNameTextField.getText());
        seasonalArray.add(mn);
        
        
        // write code start
        try{
            FileOutputStream fos = new FileOutputStream("seasonalFile.bin");     // Write a object name change korte hobe nah, Class name R array name change korte hobe
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(SeasonalMenuA r:seasonalArray){
                oos.writeObject(r);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // write code end
        
        
        // table View add korar kaj
        for(SeasonalMenuA e:seasonalArray){
            if(SeasonalMenuUpdateTableView.getItems().contains(e)){
                System.out.println("Already Contain");
            }
            else{
                SeasonalMenuUpdateTableView.getItems().add(e);
            }
        }
       
    }

    @FXML
    private void IngredientManagementSelectStallOnAction(ActionEvent event) {
        
        // Read code start
        ObjectInputStream oisIngredient = null;      // ei khane ois holo variable name, onno read a abar different name dhite hobe
        try{
            ManageStockA e;
            
            oisIngredient = new ObjectInputStream(new FileInputStream("manageStockFile.bin"));
            while(true){
               e =  (ManageStockA) oisIngredient.readObject();
                System.out.println(e.toString());
               if (e.getStallName().equals(IngredientManagementSelectStallComboBox.getValue())){
                   IngredientManagementTextArea.appendText(e.toString());
               }
               
       
            }   
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // Read code end
    }


    @FXML
    private void CustomerFeedbackAnalysisSelectAStallComboBoxShowButton(ActionEvent event) {
    }

    @FXML
    private void MenuCustomizationStallNameComboBoxOnAction(ActionEvent event) {
    }

    @FXML
    private void MenuCustomizationItemsComboBoxOnAction(ActionEvent event) {
    }

    @FXML
    private void MenuCustomizationUpdateButton(ActionEvent event) {
    }

    @FXML
    private void InventoryAlertsSendButton(ActionEvent event) {
    }

    @FXML
    private void InventoryAlertsLoadButton(ActionEvent event) {
    }

    @FXML
    private void SpecailAndPromotionsSaveButtonNewId(ActionEvent event) {
        SpecialAndPromotionA mn = new SpecialAndPromotionA(SpecailAndPromotionsSelectAStallComboBoxNewId.getValue(), SpecailAndPromotionsSpecialItemTextFieldNewId.getText(), SpecailAndPromotionsOfferTextFieldNewId.getText(), Integer.parseInt(SpecailAndPromotionsPriceTextFieldNewId.getText()));
        //System.out.println(MenuCreationItemNameTextField.getText());
        specialArray.add(mn);
        
        
        // write code start
        try{
            FileOutputStream fos = new FileOutputStream("specialFile.bin");     // Write a object name change korte hobe nah, Class name R array name change korte hobe
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(SpecialAndPromotionA r:specialArray){
                oos.writeObject(r);
            }
            oos.close();
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        // write code end
        
        
        // table View add korar kaj
        for(SpecialAndPromotionA e:specialArray){
            if(SpecailAndPromotionTableViewNewId.getItems().contains(e)){
                System.out.println("Already Contain");
            }
            else{
                SpecailAndPromotionTableViewNewId.getItems().add(e);
            }
        }
        
    }
    
}

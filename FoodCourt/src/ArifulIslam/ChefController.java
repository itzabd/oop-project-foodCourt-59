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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChefController implements Initializable {

    @FXML  private Button recipeManagementButton;
    @FXML  private Button seasonalMenuUpdatesButton;
    @FXML  private Button specialsAndPromotionsButton;
    @FXML  private Button customerFeedbackAnalysisButton;
    @FXML  private Button ingredientManagementButton;
    @FXML  private Button menuCustomizationButton;
    @FXML  private Button orderQueueButton;
    @FXML  private Button menuCreationButton;
    @FXML  private AnchorPane menuCreationFrame;
    @FXML  private AnchorPane menuCustomizationFrame;
    @FXML  private AnchorPane specialAndPromotionsFrame;
    @FXML  private AnchorPane seasonalMenuUpdatesFrame;
    @FXML  private AnchorPane recipeManagementFrame;
    @FXML  private AnchorPane ingredientManagementFrame;
    @FXML  private AnchorPane orderQueueFrame;
    @FXML  private AnchorPane customerFeedbackAnalysisFrame;
    @FXML  private Button ChefDashboardReturnButton;
    @FXML
    private AnchorPane ChefDashboardReturnFrame;
    @FXML
    private ComboBox<?> MenuCreationSelectStallComboBox;
    @FXML
    private TextField MenuCreationItemNameTextField;
    @FXML
    private TextField MenuCreationPriceTextField;
    @FXML
    private Button MenuCreationSaveButton;
    @FXML
    private TableView<?> MenuCreationTableView;
    @FXML
    private TableColumn<?, ?> ItemNameTableColumn;
    @FXML
    private ComboBox<?> SpecailAndPromotionsSelectAStallComboBox;
    @FXML
    private TextField SpecailAndPromotionsSpecialItemTextField;
    @FXML
    private TextField SpecailAndPromotionsPriceTextField;
    @FXML
    private TextField SpecailAndPromotionsOfferTextField;
    @FXML
    private Button SpecailAndPromotionsSaveButton;
    @FXML
    private TableView<?> SpecailAndPromotionsTableView;
    @FXML
    private TableColumn<?, ?> SpecialItemTableColumn;
    @FXML
    private TableColumn<?, ?> OfferTableColumn;
    @FXML
    private TableColumn<?, ?> StallNameTableColumnOfMenuCreation;
    @FXML
    private TableColumn<?, ?> PriceTableColumnOfMenuCreation;
    @FXML
    private TableColumn<?, ?> StallNameTableColumnOfSpecialAndPromotion;
    @FXML
    private TableColumn<?, ?> PriceTableColumnOfSpecialAndPromotion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller
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
        else if(event.getSource()==recipeManagementButton){
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
}

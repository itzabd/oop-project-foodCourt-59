/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ArifulIslam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ChefController implements Initializable {

    @FXML
    private Button recipeManagementButton;
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
    private ComboBox<?> MenuCreationSelectStallComboBox;
    @FXML
    private TextField MenuCreationItemNameTextField;
    @FXML
    private TextField MenuCreationPriceTextField;
    @FXML
    private TableView<?> MenuCreationTableView;
    @FXML
    private TableColumn<?, ?> StallNameTableColumnOfMenuCreation;
    @FXML
    private TableColumn<?, ?> ItemNameTableColumn;
    @FXML
    private TableColumn<?, ?> PriceTableColumnOfMenuCreation;
    @FXML
    private AnchorPane menuCustomizationFrame;
    @FXML
    private AnchorPane specialAndPromotionsFrame;
    @FXML
    private ComboBox<?> SpecailAndPromotionsSelectAStallComboBox;
    @FXML
    private TextField SpecailAndPromotionsSpecialItemTextField;
    @FXML
    private TextField SpecailAndPromotionsPriceTextField;
    @FXML
    private TextField SpecailAndPromotionsOfferTextField;
    @FXML
    private TableView<?> SpecailAndPromotionsTableView;
    @FXML
    private TableColumn<?, ?> StallNameTableColumnOfSpecialAndPromotion;
    @FXML
    private TableColumn<?, ?> SpecialItemTableColumn;
    @FXML
    private TableColumn<?, ?> PriceTableColumnOfSpecialAndPromotion;
    @FXML
    private TableColumn<?, ?> OfferTableColumn;
    @FXML
    private AnchorPane seasonalMenuUpdatesFrame;
    @FXML
    private ComboBox<?> SeasonalMenuSelectAStallComboBox;
    @FXML
    private TextField NewSeasonalItemTextField;
    @FXML
    private TextField NewSeasonalItemPriceTextField;
    @FXML
    private TableColumn<?, ?> SpecailAndPromotionsStallNameTableColumn;
    @FXML
    private TableColumn<?, ?> SpecailAndPromotionsNewSeasonalItemTableColumn;
    @FXML
    private TableColumn<?, ?> SpecailAndPromotionsNewSeasonalItemPriceTableColumn;
    @FXML
    private AnchorPane recipeManagementFrame;
    @FXML
    private AnchorPane ingredientManagementFrame;
    @FXML
    private ComboBox<?> IngredientManagementSelectStallComboBox;
    @FXML
    private AnchorPane orderQueueFrame;
    @FXML
    private AnchorPane customerFeedbackAnalysisFrame;
    @FXML
    private AnchorPane ChefDashboardReturnFrame;

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
    private void chefDashBoardBackButton(ActionEvent event) {
    }

    @FXML
    private void MenuCreationSaveButton(ActionEvent event) {
    }

    @FXML
    private void SpecailAndPromotionsSaveButton(ActionEvent event) {
    }

    @FXML
    private void SeasonalMenuUpdatesSaveButton(ActionEvent event) {
    }

    @FXML
    private void IngredientManagementSelectStallOnAction(ActionEvent event) {
    }
    
}

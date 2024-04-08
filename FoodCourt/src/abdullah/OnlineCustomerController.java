/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullah;

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
public class OnlineCustomerController implements Initializable {

    @FXML    private Label userNameAfterLogin;
    @FXML    private Button OrderManagement_btn;
    @FXML    private Button orderHistory_btn;
    @FXML    private Button setaddress_btn;
    @FXML    private Button Notification_btn;
    @FXML    private Button ratingAndFeedback_btn;
    @FXML    private Button todaysOffer_btn;
    @FXML    private Button customerAssistance_btn;
    @FXML    private Button viewProfile_btn;
    @FXML    private AnchorPane dashboardOC;
    @FXML    private AnchorPane orderManagement_scene;
    @FXML    private AnchorPane orderHistory_Scene;
    @FXML    private AnchorPane setAddress_scene;
    //private AnchorPane Tab_loadAddress_scene;
    @FXML    private AnchorPane ratingAndFeedback_scene;
    @FXML    private AnchorPane todaysOffer_scene;
    @FXML    private Label todaysOffer1_scene;
    @FXML    private AnchorPane notification_scene;
    @FXML    private AnchorPane customerAssistance_scene;
    @FXML    private Button backbtn;
    @FXML    private Button homeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sceneSwitch(ActionEvent event) {
        if (event.getSource() == homeBtn) {
            dashboardOC.setVisible(true);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == orderHistory_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(true);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == setaddress_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(true);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == Notification_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(true);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == ratingAndFeedback_btn) {
            dashboardOC.setVisible(true);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(true);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == viewProfile_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);    //ResolvePaymentDispute_btn
        } else if (event.getSource() == todaysOffer_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(true);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        } else if (event.getSource() == customerAssistance_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(false);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
            //Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(true);
        } else if (event.getSource() == OrderManagement_btn) {
            dashboardOC.setVisible(false);
            orderManagement_scene.setVisible(true);
            orderHistory_Scene.setVisible(false);
            setAddress_scene.setVisible(false);
           // Tab_loadAddress_scene.setVisible(false);
            ratingAndFeedback_scene.setVisible(false);
            todaysOffer_scene.setVisible(false);
            notification_scene.setVisible(false);
            customerAssistance_scene.setVisible(false);
        }

    }
}

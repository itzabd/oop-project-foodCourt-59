
package abdullah;

import Shahrier.SupplierItem;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodCourtManagerController implements Initializable {

    @FXML    private Label userNameAfterLogin;
    @FXML    private Button saleReport_btn;
    @FXML    private Button back_btn;
    @FXML    private Button home_btn;
    @FXML    private Button stallDetails_btn;
    @FXML    private Button sendUserNotice_btn;
    @FXML    private Button complaint_btn;
    @FXML    private Button ResolvePaymentDispute_btn;
    @FXML    private Button addNewPolicy_btn;
    @FXML    private Button reviewApplication_Btn;
    @FXML    private Button regStall_btn;
    @FXML    private AnchorPane dashboard;
    @FXML    private AnchorPane stall_managementScene;
    @FXML    private AnchorPane stall_detailsScene;
    @FXML    private AnchorPane reviewApplication_scene;
    @FXML    private AnchorPane salesReportScene;
    @FXML    private AnchorPane sendUserNotice_scene;
    @FXML    private AnchorPane resolvePaymentDisputeScene;
    @FXML    private AnchorPane complaintsScene;
    @FXML    private AnchorPane addNewPolicy_scene;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sceneSwitch(ActionEvent event) {
        if (event.getSource() == home_btn) {
            dashboard.setVisible(true);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);
        }
        else if(event.getSource()==regStall_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(true);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    
        }
        else if(event.getSource()==stallDetails_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(true);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    
        }
        else if(event.getSource()==reviewApplication_Btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(true);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    
        }
        else if(event.getSource()==saleReport_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(true);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    
        }
        else if(event.getSource()==complaint_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(true);
            addNewPolicy_scene.setVisible(false);    //ResolvePaymentDispute_btn
        }
        else if(event.getSource()==addNewPolicy_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(true);    
        }
        else if(event.getSource()==ResolvePaymentDispute_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(false);
            resolvePaymentDisputeScene.setVisible(true);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    
        }
        else if(event.getSource()==sendUserNotice_btn){
            dashboard.setVisible(false);
            stall_managementScene.setVisible(false);
            stall_detailsScene.setVisible(false);
            reviewApplication_scene.setVisible(false);
            salesReportScene.setVisible(false);
            sendUserNotice_scene.setVisible(true);
            resolvePaymentDisputeScene.setVisible(false);
            complaintsScene.setVisible(false);
            addNewPolicy_scene.setVisible(false);    //ResolvePaymentDispute_btn
        }
    }
}
    
        
  

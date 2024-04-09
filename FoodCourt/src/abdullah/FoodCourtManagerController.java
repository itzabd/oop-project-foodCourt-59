
package abdullah;

import Shahrier.SupplierItem;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.Month;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

/**
 * FXML Controller class
 *
 * @author User
 */
public class FoodCourtManagerController implements Initializable {

    @FXML   private Label userNameAfterLogin;
    @FXML    private Button saleReport_btn;
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
    @FXML
    private Button back_btn;
    private ArrayList<Stall> StallArr;
    @FXML
    private TextField stallNameTF;
    @FXML
    private DatePicker RentFromTF;
    @FXML
    private DatePicker RentTToTF;
    @FXML
    private TextField stallManagerNameTF;
    @FXML
    private TextField contactNumberTF;
    @FXML
    private TableView<Stall> tableView;
    @FXML
    private TableColumn<Stall, String> StallName_TC;
    @FXML
    private TableColumn<Stall, Integer> contactNo_TC;
    @FXML
    private TableColumn<Stall, String> stallManagerName_TC;
    @FXML
    private TableColumn<Stall, String> stallType_TC;
    @FXML
    private ComboBox<String> stallTypeCB;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
  
        stallTypeCB.getItems().addAll("Fast Food", "Restaurant",
                "Pizza and Italian Cuisine","Coffee and Tea");
        StallName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallName"));
        contactNo_TC.setCellValueFactory(new PropertyValueFactory<Stall, Integer>("contactNo"));
        stallManagerName_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallManagerName"));
        stallType_TC.setCellValueFactory(new PropertyValueFactory<Stall, String>("StallType"));
        
        ObjectInputStream ois = null;
        {
            ObservableList<Stall> stalllist = FXCollections.observableArrayList();
            try {
                Stall s;

                ois = new ObjectInputStream(new FileInputStream("StallObjects.bin"));

                while (true) {
                    s = (Stall) ois.readObject();
                    stalllist.add(s);
                    tableView.setItems(stalllist);
                }

            } catch (RuntimeException e) {
                e.printStackTrace();

            } catch (Exception ex) {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex1) {
                }
            }

        }
//        tableView.setItems(this.StallList());
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

    @FXML
    private void addButton_regStallOnClick(ActionEvent event) {

        // Check if all data fields are entered or not
        if (stallNameTF.getText().isEmpty() || stallManagerNameTF.getText().isEmpty()
                || stallTypeCB.getValue() == null || RentFromTF.getValue() == null
                || RentTToTF.getValue() == null || contactNumberTF.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all required fields");
            alert.showAndWait();
            return;
        }

        ObservableList<Stall> stalllist = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        {

            try {
                Stall s;

                ois = new ObjectInputStream(new FileInputStream("StallObjects.bin"));

                while (true) {
                    s = (Stall) ois.readObject();
                    stalllist.add(s);
                    tableView.setItems(stalllist);
                }

            } catch (RuntimeException e) {
                e.printStackTrace();

            } catch (Exception ex) {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex1) {
                }
            }

        }
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("StallObjects.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Stall s = new Stall(stallNameTF.getText(),
                    stallManagerNameTF.getText(), stallTypeCB.getValue(),
                    RentFromTF.getValue(), RentTToTF.getValue(),
                    Integer.parseInt(contactNumberTF.getText())
            );

            oos.writeObject(s);
            stalllist.add(s);
            tableView.setItems(stalllist);

            stallNameTF.clear();
            stallManagerNameTF.clear();
            stallTypeCB.setValue(null);
            RentFromTF.setValue(null);
            RentTToTF.setValue(null);
            contactNumberTF.clear();
        } catch (IOException ex) {
            Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FoodCourtManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

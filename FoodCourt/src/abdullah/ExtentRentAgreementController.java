/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullah;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ExtentRentAgreementController implements Initializable {

    @FXML
    private AnchorPane RentDateExtension_fxml;
    @FXML
    private DatePicker newRentToDatepicker;
    private Stall selectedStall;
    public void setSelectedStall(Stall selectedStall) {
        this.selectedStall = selectedStall;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Extend(ActionEvent event) {
         LocalDate newRentToDate = newRentToDatepicker.getValue();

    // Update the RentTo date for the selected stall
    selectedStall.setRentTo(newRentToDate);

    // Save the updated stall object to the file
    updateFile(selectedStall);

    
    Stage stage = (Stage) newRentToDatepicker.getScene().getWindow();
    stage.close();
    }
    private void updateFile(Stall stall) {
        try (FileOutputStream fos = new FileOutputStream("StallObjects.bin", true);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // Write the updated stall object to the file
            oos.writeObject(stall);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        
}


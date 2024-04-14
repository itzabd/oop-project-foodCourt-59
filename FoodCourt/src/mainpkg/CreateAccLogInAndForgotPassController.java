/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ArifulIslam.Chef;
import ArifulIslam.InventoryManager;
import Saif.FoodDeliveryPartner;
import Saif.StallManager;
import Shahrier.FoodSupplier;
import Shahrier.SecurityDepartment;
import abdullah.AllUserData;
import abdullah.FoodCourtManager;
import abdullah.OnlineCustomer;
import abdullah.User;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CreateAccLogInAndForgotPassController implements Initializable {

    @FXML
    private AnchorPane logInPageFrame;
    @FXML
    private ComboBox<String> logInPageUserTypeCombox;
    @FXML
    private TextField loginPageUserName;
    @FXML
    private PasswordField loginPagePswdField;
    @FXML
    private Hyperlink forgotPassHyprLink;
    @FXML
    private Button createAccbtn;
    @FXML
    private AnchorPane forgotPassFrame;
    @FXML
    private Button forgotPassTologinPage;
    @FXML
    private AnchorPane createNewUserFrame;
    @FXML
    private Button createUserPageToLoginPage;
    @FXML
    private Button SignUpButton;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField paasTF;
    @FXML
    private DatePicker DOB_DP;
    @FXML
    private TextField emailTF;
    @FXML
    private RadioButton MaleRadButton;
    @FXML
    private RadioButton FemaleRadButton;
    @FXML
    private TextField contactNoTF;
    @FXML
    private ComboBox<String> userTypeComboBox;
    private ToggleGroup genderToggleGroup;
    @FXML
    private Label UserNameError;
    @FXML
    private Label PassError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        logInPageUserTypeCombox.getItems().addAll("Security Depertment","Food Supplier"
//                                                     ,"Food Court Manager", "Online Customer");
        logInPageUserTypeCombox.getItems().addAll("Security Depertment", "Food Supplier",
                "Food Court Manager", "Online Customer",
                "Inventory Manager", "Chef",
                "Food Delivery Partner", "Stall Manager");

        //----Create Account init --- Start
        genderToggleGroup = new ToggleGroup();
        MaleRadButton.setToggleGroup(genderToggleGroup);
        FemaleRadButton.setToggleGroup(genderToggleGroup);

        userTypeComboBox.getItems().addAll("Security Depertment", "Food Supplier",
                "Food Court Manager", "Online Customer",
                "Inventory Manager", "Chef",
                "Food Delivery Partner", "Stall Manager ");

        //----Create Account init --- Ends
    }

    private int generateUniqueId() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    private void saveUserDataToFile(AllUserData userData) {
        File allUserDataFile = new File("AllUserData.bin");

        try (FileOutputStream fos = new FileOutputStream(allUserDataFile, true); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(userData);
           // Alert alert = new Alert(Alert.AlertType.INFORMATION, "User data saved successfully");
            //alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to save user data");
            alert.showAndWait();
        }
    }

    @FXML
    private void logInPageUserTypeComboxOnClick(ActionEvent event) {

    }

    @FXML
    private void switchToOtherFrame(ActionEvent event) {
        if (event.getSource() == forgotPassHyprLink) {
            logInPageFrame.setVisible(false);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(true);
        } else if (event.getSource() == createAccbtn) {
            logInPageFrame.setVisible(false);
            createNewUserFrame.setVisible(true);
            forgotPassFrame.setVisible(false);
        } else if (event.getSource() == createUserPageToLoginPage) {
            logInPageFrame.setVisible(true);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(false);
        } else if (event.getSource() == forgotPassTologinPage) {
            logInPageFrame.setVisible(true);
            createNewUserFrame.setVisible(false);
            forgotPassFrame.setVisible(false);
        }
    }

    @FXML
    private void logInPageSignInBtn(ActionEvent event) throws Exception {
        /*
        if(logInPageUserTypeCombox.getValue()=="Security Depertment"){
            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/SecurityDeptDashBoard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        
        else if(logInPageUserTypeCombox.getValue()=="Food Supplier"){
            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/FoodSupplierDashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else if(logInPageUserTypeCombox.getValue()=="Food Court Manager"){
            Parent root = FXMLLoader.load(getClass().getResource("/abdullah/FoodCourtManager.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else if(logInPageUserTypeCombox.getValue()=="Online Customer"){
            Parent root = FXMLLoader.load(getClass().getResource("/abdullah/OnlineCustomer.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
         */
        
        String userType = logInPageUserTypeCombox.getValue();
        String username = loginPageUserName.getText();
        String password = loginPagePswdField.getText();

        // Check if a user type is selected
        if (userType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a user.");
            alert.show();
            return;
        }

        // Check if the user type is "Food Court Manager"
        if ("Food Court Manager".equals(userType)) {
            //Load the file
            File employeeFile = new File("FoodCourtManagerList.bin");

            // Check if the file exists
            if (employeeFile.exists()) {
                try (FileInputStream fis = new FileInputStream(employeeFile); 
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    boolean found = false;
                    while (true) {
                        FoodCourtManager manager = (FoodCourtManager) ois.readObject();
                        // Check if username and password match
                        if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                            //if match, load the MaintananceManager.fxml
                            Parent root = FXMLLoader.load(getClass().getResource("/abdullah/FoodCourtManager.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            return;
                        } //check if username matches
                        else if (manager.getUsername().equals(username)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        UserNameError.setText("Invalid username.");

                        return;
                    }
                } catch (EOFException e) {
                    //no match found
                    System.out.println("No matching user found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //if the file does not exist
                System.out.println("Employee file does not exist.");
            }
            UserNameError.setText("Invalid");
            PassError.setText("Invalid");
        }
        // Check if the user type is "Online Customer"
        if ("Online Customer".equals(userType)) {
            //Load the file
            File employeeFile = new File("OnlineCustomerList.bin");

            // Check if the file exists
            if (employeeFile.exists()) {
                try (FileInputStream fis = new FileInputStream(employeeFile);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    boolean found = false;
                    while (true) {
                        OnlineCustomer manager = (OnlineCustomer) ois.readObject();
                        // Check if username and password match
                        if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                            //if match, load the MaintananceManager.fxml
                            Parent root = FXMLLoader.load(getClass().getResource("/abdullah/OnlineCustomer.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            return;
                        } //check if username matches
                        else if (manager.getUsername().equals(username)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        UserNameError.setText("Invalid username.");

                        return;
                    }
                } catch (EOFException e) {
                    //no match found
                    System.out.println("No matching user found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //if the file does not exist
                System.out.println("Employee file does not exist.");
            }
            UserNameError.setText("Invalid");
            PassError.setText("Invalid");
        }
        // Check if the user type is "Security Depertment"
        if ("Security Depertment".equals(userType)) {
            //Load the file
            File employeeFile = new File("SecurityDepertmentList.bin");

            // Check if the file exists
            if (employeeFile.exists()) {
                try (FileInputStream fis = new FileInputStream(employeeFile); 
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    boolean found = false;
                    while (true) {
                        SecurityDepartment manager = (SecurityDepartment) ois.readObject();
                        // Check if username and password match
                        if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                            //if match, load the MaintananceManager.fxml
                            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/SecurityDeptDashBoard.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            return;
                        } //check if username matches
                        else if (manager.getUsername().equals(username)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        UserNameError.setText("Invalid username.");

                        return;
                    }
                } catch (EOFException e) {
                    //no match found
                    System.out.println("No matching user found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //if the file does not exist
                System.out.println("Employee file does not exist.");
            }
            UserNameError.setText("Invalid");
            PassError.setText("Invalid");
        }
        // Check if the user type is "Food Supplier"
        if ("Food Supplier".equals(userType)) {
            //Load the file
            File employeeFile = new File("FoodSupplierList.bin");

            // Check if the file exists
            if (employeeFile.exists()) {
                try (FileInputStream fis = new FileInputStream(employeeFile); 
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    boolean found = false;
                    while (true) {
                        FoodSupplier manager = (FoodSupplier) ois.readObject();
                        // Check if username and password match
                        if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                            //if match, load the MaintananceManager.fxml
                            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/SecurityDeptDashBoard.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            return;
                        } //check if username matches
                        else if (manager.getUsername().equals(username)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        UserNameError.setText("Invalid username.");

                        return;
                    }
                } catch (EOFException e) {
                    //no match found
                    System.out.println("No matching user found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //if the file does not exist
                System.out.println("Employee file does not exist.");
            }
            UserNameError.setText("Invalid");
            PassError.setText("Invalid");
        }
        // Check if the user type is "Inventory Manager"
        if ("Inventory Manager".equals(userType)) {
            //Load the file
            File employeeFile = new File("InventoryManagerList.bin");

            // Check if the file exists
            if (employeeFile.exists()) {
                try (FileInputStream fis = new FileInputStream(employeeFile); 
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    boolean found = false;
                    while (true) {
                        InventoryManager manager = (InventoryManager) ois.readObject();
                        // Check if username and password match
                        if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                            //if match, load the MaintananceManager.fxml
                            Parent root = FXMLLoader.load(getClass().getResource("/Shahrier/FoodSupplierDashboard.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            return;
                        } //check if username matches
                        else if (manager.getUsername().equals(username)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        UserNameError.setText("Invalid username.");

                        return;
                    }
                } catch (EOFException e) {
                    //no match found
                    System.out.println("No matching user found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //if the file does not exist
                System.out.println("Employee file does not exist.");
            }
            UserNameError.setText("Invalid");
            PassError.setText("Invalid");
        }

    }//buttons last bracket

    @FXML
    private void SignInButtonOnClick(ActionEvent event) {
        String userType = userTypeComboBox.getValue();
    
    String gender = "";
    RadioButton selectedRadioButton = (RadioButton) genderToggleGroup.getSelectedToggle();
    if (selectedRadioButton != null) {
        gender = selectedRadioButton.getText();
    }

    if (usernameTF.getText().isEmpty() || paasTF.getText().isEmpty()
            || nameTF.getText().isEmpty() || contactNoTF.getText().isEmpty()
            || emailTF.getText().isEmpty() || DOB_DP.getValue() == null || userTypeComboBox.getValue() == null) {
        System.out.println("Textfield is empty");
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all of the fields");
        alert.show();
        return;
    }

    // Validating username
    if (usernameTF.getText().length() <= 4) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Username needs to be at least 4 characters long");
        alert.showAndWait();
        return;
    }

    //valid password
    String password = paasTF.getText();
    if (password.length() < 8 || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a password that is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, and one special character.");
        alert.showAndWait();
        return;
    }
    //Valid Email
    String email = emailTF.getText();
    if (!isValidEmail(email)) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid email address");
        alert.showAndWait();
        return;
    }

    //Valid Phone number
    String phoneS = contactNoTF.getText();
    if (phoneS.length() != 11 && !phoneS.substring(0, 2).equals("01")) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number");
        alert.showAndWait();
        return;
    }

    // Checking if it's a number
    try {
        Long.parseLong(contactNoTF.getText());
    } catch (NumberFormatException e) {
        System.out.println("Phone num parsing to long failed");
        System.out.println(e);
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number");
        alert.show();
        return;
    }

    // Validating DOB
    if (DOB_DP.getValue().isAfter(LocalDate.now().minusYears(18))) {
        Alert a = new Alert(Alert.AlertType.ERROR, "You must be at least 18 years old to register");
        a.show();
        return;
    }

    //---------------------Main SignUp
    // Specify the correct file path
    
    //------ for food court manager-------
        String filePath;
        if (userTypeComboBox.getValue().equals("Food Court Manager")) {
            filePath = "FoodCourtManagerList.bin";
        } else if (userTypeComboBox.getValue().equals("Online Customer")) {
            filePath = "OnlineCustomerList.bin";
        } else if (userTypeComboBox.getValue().equals("Security Depertment")) {
            filePath = "SecurityDepertmentList.bin";
        } else if (userTypeComboBox.getValue().equals("Food Supplier")) {
            filePath = "FoodSupplierList.bin";
        } else if (userTypeComboBox.getValue().equals("Inventory Manager")) {
            filePath = "InventoryManagerList.bin";
        } else if (userTypeComboBox.getValue().equals("Chef")) {
            filePath = "ChefList.bin";
        } else if (userTypeComboBox.getValue().equals("Food Delivery Partner")) {
            filePath = "FoodDeliveryPartnerList.bin";
        } else if (userTypeComboBox.getValue().equals("Stall Manager")) {
            filePath = "StallManagerList.bin";
        } else {
            // Handle unrecognized user types
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid user type selected");
            alert.show();
            return;
        }

// Create or open the corresponding file
        File employeeFile = new File(filePath);

        try {
            if (!employeeFile.exists()) {
                // Handle the case when the file doesn't exist
                System.out.println("File does not exist. Creating new file.");
                employeeFile.createNewFile();
            }
            // Read all existing objects from the file into a collection
            List<User> userList = new ArrayList<>();
            try (FileInputStream fis = new FileInputStream(employeeFile); ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (true) {
                    User user = (User) ois.readObject();
                    userList.add(user);
                }
            } catch (EOFException e) {
                // End of file reached
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Add the new object to the collection
            if (!userList.stream().anyMatch(u -> u.getUsername().equals(usernameTF.getText()))) {
                User newUser;
                if (userTypeComboBox.getValue().equals("Food Court Manager")) {
                    newUser = new FoodCourtManager(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Online Customer")) {
                    newUser = new OnlineCustomer(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Security Depertment")) {
                    newUser = new SecurityDepartment(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Food Supplier")) {
                    newUser = new FoodSupplier(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Inventory Manager")) {
                    newUser = new InventoryManager(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Chef")) {
                    newUser = new Chef(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Food Delivery Partner")) {
                    newUser = new FoodDeliveryPartner(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else if (userTypeComboBox.getValue().equals("Stall Manager")) {
                    newUser = new StallManager(usernameTF.getText(), emailTF.getText(),
                            nameTF.getText(), paasTF.getText(), contactNoTF.getText(), gender, userTypeComboBox.getValue(), generateUniqueId(),
                            DOB_DP.getValue());
                } else {
                    // Handle unrecognized user types
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid user type selected");
                    alert.show();
                    return;
                }
                userList.add(newUser);
            } else {
                // Username already exists
                Alert a = new Alert(Alert.AlertType.ERROR, "Username already exists");
                a.show();
                return;
            }

            // Write the entire collection back to the file
            try (FileOutputStream fos = new FileOutputStream(employeeFile); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (User user : userList) {
                    oos.writeObject(user);
                }
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "You have been registered successfully");
                successAlert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    //load login scene
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/CreateAccLogInAndForgotPass.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    //Creates an instance of AllUserData
    AllUserData userData = new AllUserData(
            usernameTF.getText(),
            emailTF.getText(),
            nameTF.getText(),
            paasTF.getText(),
            contactNoTF.getText(),
            gender,
            userType,
            generateUniqueId(),
            DOB_DP.getValue()
    );

    // Save user data to file
    saveUserDataToFile(userData);
}

}

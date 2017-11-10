package com.mentCare.controller;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;

public class loginController {


	@FXML private ColorPicker colorTextField;
    @FXML private Button loginButton;
    private String physicianLogin = "Physician";
    private String physicianPassword = "Physician";
    private String patientLogin = "Patient";
    private String patientPassword = "Patient";
    @FXML private TextField usernameBar;
    @FXML private TextField passwordBar;


 public void initialize() {


 }

 public void loginButtonClicked(ActionEvent event) throws IOException
 {
if(usernameBar.getText().equalsIgnoreCase(physicianLogin)&& passwordBar.getText().equalsIgnoreCase(physicianPassword)){
	
	 FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("../../../com/mentCare/view/PhysicianMainView.fxml"));
	    Parent tableViewParent = loader.load();
	    Scene tableViewScene = new Scene(tableViewParent);
	    //access the controller and calls a method
	    //This line gets the Stage information
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

	    window.setScene(tableViewScene);
	    window.show();
	
}
else{
	Alert buttonWasClicked = new Alert(AlertType.CONFIRMATION, "Wrong username or password", ButtonType.OK, ButtonType.CANCEL);
buttonWasClicked.showAndWait();
 }
 }


 

 




}

/*Class Name: Main
 * 
 * The Purpose of this class is to set up the window for the application, as well as be the
 * main controller for the application as a whole
 * 
 * Notes:
 * For testing purposes, there are 3 statements, each that assign root to a different view
 * to test your view, uncomment your view and comment the other two.
 * 
 * To run the application as a whole, uncomment login (the fist root statement)
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent  root = FXMLLoader.load(getClass().getResource("../com/mentCare/view/login.fxml"));
			//Parent  root = FXMLLoader.load(getClass().getResource("../com/mentCare/view/PhysicianMainView.fxml"));
			//Parent  root = FXMLLoader.load(getClass().getResource("../com/mentCare/view/PatientMainView.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

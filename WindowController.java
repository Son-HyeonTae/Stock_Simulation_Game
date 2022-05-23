package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class WindowController implements Initializable {
	
	Stock stock = new Stock();
	String inputValue;
	
	@FXML
	private TextField getnickNameField;
	
	@FXML
	private Button startButton;
	
	// close getnickname window
	public void closeStage() {
		Stage stagewc = (Stage) startButton.getScene().getWindow();
			stagewc.close();
	}
	
	@FXML
	public void getnickName(ActionEvent event) {
		String inputValue = getnickNameField.getText(); 
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("draft.fxml"));
		Parent root1;
		Stage stage;
		try {
			root1 = (Parent)loader.load();
			stage = new Stage();
			stage.setTitle("StockSimulator SSG");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch(IOException ex) {
			Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeStage();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
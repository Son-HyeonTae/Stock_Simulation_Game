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


public class WindowController {
	
	Stock stock = new Stock();
	User user = new User();
	Exchange exchange = new Exchange();
	Getnickname getnickname = new Getnickname();
	
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
		inputValue = getnickNameField.getText();
		getnickname.nickname = inputValue;
		
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
}
package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartWindow {
	
	// create instances
	Stock stock = new Stock();
	Trader trader = new Trader();
	Market exchange = new Market();
	
	// local value
	String inputValue;
	
	// close StartWindow
	public void closeStage() {
		Stage stagewc = (Stage) startButton.getScene().getWindow();
			stagewc.close();
	}
	
	
	@FXML
	public void getnickName(ActionEvent event) {
		inputValue = getnickNameField.getText();
		trader.nickname = inputValue;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		Parent root1;
		Stage stage;
		try {
			root1 = (Parent)loader.load();
			stage = new Stage();
			stage.setTitle("StockSimulator SSG");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch(IOException ex) {
			Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeStage();
	}
	
	// elements
	@FXML
	private TextField getnickNameField;
	@FXML
	private Button startButton;
}
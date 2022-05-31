package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.HomeTradeSystem;

public class ResultWindow implements Initializable {
	
	// create instance
	Stage stage = new Stage();
	Trader trader = new Trader();
	MainWindow mainWindow = new MainWindow();
	HomeTradeSystem hts = new HomeTradeSystem();
	double percent = (HomeTradeSystem.newseed-1000000)/10000;
	
	@FXML
	private Button exit;
	@FXML
	private TextField nickname;
	@FXML
	private TextField seed;
	@FXML
	private TextField lastseed;
	@FXML
	private TextField rate;
	
	@FXML
	public void exit() {
			Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nickname.setText(trader.nickname);
		lastseed.setText(String.valueOf(HomeTradeSystem.newseed));
		rate.setText(String.valueOf((int)(percent)));
	}
}

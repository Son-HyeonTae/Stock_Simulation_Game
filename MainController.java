package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {
	
	// create instance
	User user = new User();
	Exchange exchange = new Exchange();
	Scanner scanner = new Scanner(System.in);
	HTS hts = new HTS();
	Stock stock = new Stock();
	WindowController windowcontroller = new WindowController();
	
	
	// local variable
	String[] strArrayList = exchange.company;
	int seed = hts.seed;
	int wallet[] = hts.wallet;
	int companyIndex = 0;
	String nickname = windowcontroller.inputValue;
	
	
	@FXML 
	public ListView<String> stocklist;
	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private TextField presentValue;
	
	@FXML
	private TextField havemoney;
	
	@FXML
	private TextField showname;
	
	@FXML
	private Button checkname;
	
	@FXML
	private Button gameStartbtn;
	
	@FXML
	public void gameStart(ActionEvent event) {
		stock.setting();
		
		showname.setText(nickname);
		havemoney.setText(Integer.toString(seed)); 
	}
	
	@FXML
	private TextField stockvalue;
	
	@FXML
	private TextField havestock;
	
	@FXML
	private Label trade;
	
	@FXML
	private Label shares;
	
	@FXML
	private Button buy;
	
	@FXML
	public void selectBuyButton(ActionEvent event) {
		int num = Integer.valueOf(stockvalue.getText());	
		
		seed = hts.buy(seed, wallet, companyIndex , stock.stockValue(companyIndex), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[companyIndex]));
		}
		
	@FXML
	private Button sell;
	
	@FXML
	public void selectSellButton(ActionEvent event) {	
		int num = Integer.valueOf(stockvalue.getText());		
		
		seed = hts.sell(seed, wallet, companyIndex, stock.stockValue(companyIndex), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[companyIndex]));
	}
		
	@Override 
	public void initialize(URL location, ResourceBundle resources) {
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
								
				if(event.getClickCount()>=1) {
					companyIndex = stocklist.getSelectionModel().getSelectedIndex();
					stockvalue.setText("");

					presentValue.setText(String.valueOf(stock.value[companyIndex]));
					havestock.setText(String.valueOf(wallet[companyIndex]));
				}
			}
		});
	}
}
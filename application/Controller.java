package application;

import java.net.URL;
import java.util.Random;
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

public class Controller implements Initializable {
	
	User user = new User();
	Exchange exchange = new Exchange();
	Scanner scanner = new Scanner(System.in);
	HTS hts = new HTS();
	Stock stock = new Stock();
	
	String[] strArrayList = exchange.company;
	int seed = hts.seed;
	int wallet[] = hts.wallet;
	int comIndex;
	
	
	@FXML 
	public ListView<String> stocklist;

	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private TextField presentValue;
	
	@FXML
	private TextField havemoney;
	
	@FXML
	private Label getnicknamebox;
	
	@FXML
	private TextField namevalue;
	
	@FXML
	private TextField getnamevalue;
	
	@FXML
	private Button checkname;
	
	@FXML
	public void selectCheckName(ActionEvent event) {
		String inputValue = getnamevalue.getText(); 
		getnamevalue.setText(""); 
		namevalue.setText(inputValue);
		
		String data = Integer.toString(seed);
		havemoney.setText(data); 
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
		String a = stockvalue.getText();
		int num = Integer.valueOf(a);		
		
		seed = hts.buy(seed, wallet, comIndex , stock.stockCall(comIndex), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[comIndex]));
		}
		
	@FXML
	private Button sell;
	
	@FXML
	public void selectSellButton(ActionEvent event) {	
		int num = Integer.valueOf(stockvalue.getText());		
		
		seed = hts.sell(seed, wallet, comIndex, stock.stockCall(comIndex), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[comIndex]));
	}
		
	@Override 
	public void initialize(URL location, ResourceBundle resources) {
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stock.setting();
				
				if(event.getClickCount()>=1) {
					int comIndex = stocklist.getSelectionModel().getSelectedIndex();		
					stockvalue.setText("");

					presentValue.setText(String.valueOf(stock.value[comIndex]));
					havestock.setText(String.valueOf(wallet[comIndex]));
				}
			}
		});
	}
}
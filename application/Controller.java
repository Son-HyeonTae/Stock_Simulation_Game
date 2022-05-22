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
	
	
	int seed = hts.seed;
	int wallet[] = hts.wallet;
	
	int clickValue = 0;
	

	
	@FXML 
	public ListView<String> stocklist;

	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private TextField presentValue; // 현재가
	
	@FXML
	private TextField havemoney; // 보유자금 칸
	
	@FXML
	private Label getnicknamebox;
	
	@FXML
	private TextField namevalue; // 닉네임 출력칸
	
	@FXML
	private TextField getnamevalue; // 닉네임 입력칸
	
	@FXML
	private Button checkname; // 닉네임 확인 버튼
	
	@FXML
	public void selectCheckName(ActionEvent event) {
		
		String inputValue = getnamevalue.getText(); 
		getnamevalue.setText(""); 
		namevalue.setText(inputValue);
		
		String data = Integer.toString(seed);
		havemoney.setText(data); 
	}
	
	// 매수 매도
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
		
		seed = hts.buy(seed, wallet, clickValue , stock.stockCall(clickValue), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[clickValue]));
		}
		
	
	@FXML
	private Button sell;
	
	@FXML
	public void selectSellButton(ActionEvent event) {	
		
		String a = stockvalue.getText();
		int num = Integer.valueOf(a);		
		
		seed = hts.sell(seed, wallet, clickValue , stock.stockCall(clickValue), num); 
		
		havemoney.setText(String.valueOf(seed));
		havestock.setText(String.valueOf(wallet[clickValue]));
		
	}
		


	@Override 
	public void initialize(URL location, ResourceBundle resources) { 

		//보유 주식 / wallet[]의 데이터를 가져오게끔 해야함


		// 종목 표기
		Exchange exchange = new Exchange();
		String[] strArrayList = exchange.company;
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		

		// 종목의 현재가 출력 => 수정해야함(가격이 나오게끔 value[i]의 데이터를 가져와야할듯 / 현재는 배열 정보를 가져오는 방법을 몰라서 일단 종목의 이름으로 출력) / 
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				stock.setting();
				
				if(event.getClickCount()>1) {
					String obj = stocklist.getSelectionModel().getSelectedItem();		
					
					if(obj == "삼성전자") {
						clickValue = 1;
						
						presentValue.setText(String.valueOf(stock.value[1]));
						havestock.setText(String.valueOf(wallet[clickValue]));
						
					}
					else if(obj == "SK하이닉스") {
						clickValue = 2;
						
						presentValue.setText(String.valueOf(stock.value[2]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}
					
					else if(obj == "NAVER") {
						clickValue = 3;
						
						presentValue.setText(String.valueOf(stock.value[3]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}
					else if(obj == "현대차") {
						clickValue = 4;
						
						presentValue.setText(String.valueOf(stock.value[4]));
						havestock.setText(String.valueOf(wallet[clickValue]));
						
						
					}
					else if(obj == "카카오") {
						clickValue = 5;
						
						presentValue.setText(String.valueOf(stock.value[5]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}

				}
			}
		});

		// 종목별 매수 (버튼을 통해 동작하게끔 작성해야함)
		/*buy.setOnAction((AtionEvent)->{
			String obj = stocklist.getSelectionModel().getSelectedItem();
			stocklist.setText("you selected: \"" + obj + "\".");
		});
		*/
	}

}
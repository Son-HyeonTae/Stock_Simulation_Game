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
	private TextField presentValue; // ���簡
	
	@FXML
	private TextField havemoney; // �����ڱ� ĭ
	
	@FXML
	private Label getnicknamebox;
	
	@FXML
	private TextField namevalue; // �г��� ���ĭ
	
	@FXML
	private TextField getnamevalue; // �г��� �Է�ĭ
	
	@FXML
	private Button checkname; // �г��� Ȯ�� ��ư
	
	@FXML
	public void selectCheckName(ActionEvent event) {
		
		String inputValue = getnamevalue.getText(); 
		getnamevalue.setText(""); 
		namevalue.setText(inputValue);
		
		String data = Integer.toString(seed);
		havemoney.setText(data); 
	}
	
	// �ż� �ŵ�
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

		//���� �ֽ� / wallet[]�� �����͸� �������Բ� �ؾ���


		// ���� ǥ��
		Exchange exchange = new Exchange();
		String[] strArrayList = exchange.company;
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		

		// ������ ���簡 ��� => �����ؾ���(������ �����Բ� value[i]�� �����͸� �����;��ҵ� / ����� �迭 ������ �������� ����� ���� �ϴ� ������ �̸����� ���) / 
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				stock.setting();
				
				if(event.getClickCount()>1) {
					String obj = stocklist.getSelectionModel().getSelectedItem();		
					
					if(obj == "�Ｚ����") {
						clickValue = 1;
						
						presentValue.setText(String.valueOf(stock.value[1]));
						havestock.setText(String.valueOf(wallet[clickValue]));
						
					}
					else if(obj == "SK���̴н�") {
						clickValue = 2;
						
						presentValue.setText(String.valueOf(stock.value[2]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}
					
					else if(obj == "NAVER") {
						clickValue = 3;
						
						presentValue.setText(String.valueOf(stock.value[3]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}
					else if(obj == "������") {
						clickValue = 4;
						
						presentValue.setText(String.valueOf(stock.value[4]));
						havestock.setText(String.valueOf(wallet[clickValue]));
						
						
					}
					else if(obj == "īī��") {
						clickValue = 5;
						
						presentValue.setText(String.valueOf(stock.value[5]));
						havestock.setText(String.valueOf(wallet[clickValue]));
					}

				}
			}
		});

		// ���� �ż� (��ư�� ���� �����ϰԲ� �ۼ��ؾ���)
		/*buy.setOnAction((AtionEvent)->{
			String obj = stocklist.getSelectionModel().getSelectedItem();
			stocklist.setText("you selected: \"" + obj + "\".");
		});
		*/
	}

}
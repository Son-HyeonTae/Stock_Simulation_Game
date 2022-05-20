package application;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller implements Initializable {
	
	@FXML 
	private ListView<String> stocklist;

	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private TextField presentValue;
	
	@FXML
	private TextField moneyvalue;
	
	@FXML
	private TextField namevalue;
	
	/*
	@FXML
	private Button buy;
	
	@FXML
	private Button sell;
	 */


	@Override 
	public void initialize(URL location, ResourceBundle resources) { 

		//닉네임 출력 / 닉네임 작성 UI이 작성 후 하면 금방할듯 / 새 textfield 생성 후 입력을 받고 출력하면 됨
		//String name = ;

		//보유 자금 출력
		int seed = HTS.seed;
		String data = Integer.toString(seed);
		moneyvalue.setText(data);

		//보유 주식 / wallet[]의 데이터를 가져오게끔 해야함


		// 종목 표기
		String[] strArrayList = Exchange.company;
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		
		/*
		stocklist.getItems().add("삼성전자");
		stocklist.getItems().add("SK하이닉스");
		stocklist.getItems().add("NAVER");
		stocklist.getItems().add("현대차");
		stocklist.getItems().add("카카오")
		 */


		// 종목의 현재가 출력 => 수정해야함(가격이 나오게끔 value[i]의 데이터를 가져와야할듯 / 현재는 배열 정보를 가져오는 방법을 몰라서 일단 종목의 이름으로 출력) / 
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount()>1) {
					Object obj = stocklist.getSelectionModel().getSelectedItem();
					presentValue.setText(obj.toString());
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
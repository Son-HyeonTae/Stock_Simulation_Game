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

		//�г��� ��� / �г��� �ۼ� UI�� �ۼ� �� �ϸ� �ݹ��ҵ� / �� textfield ���� �� �Է��� �ް� ����ϸ� ��
		//String name = ;

		//���� �ڱ� ���
		int seed = HTS.seed;
		String data = Integer.toString(seed);
		moneyvalue.setText(data);

		//���� �ֽ� / wallet[]�� �����͸� �������Բ� �ؾ���


		// ���� ǥ��
		String[] strArrayList = Exchange.company;
		stocklist.setItems(FXCollections.observableArrayList(strArrayList));
		
		/*
		stocklist.getItems().add("�Ｚ����");
		stocklist.getItems().add("SK���̴н�");
		stocklist.getItems().add("NAVER");
		stocklist.getItems().add("������");
		stocklist.getItems().add("īī��")
		 */


		// ������ ���簡 ��� => �����ؾ���(������ �����Բ� value[i]�� �����͸� �����;��ҵ� / ����� �迭 ������ �������� ����� ���� �ϴ� ������ �̸����� ���) / 
		stocklist.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount()>1) {
					Object obj = stocklist.getSelectionModel().getSelectedItem();
					presentValue.setText(obj.toString());
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
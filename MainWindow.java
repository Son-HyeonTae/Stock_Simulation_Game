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
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainWindow implements Initializable {
   
   // create instance
   Trader user = new Trader();
   Market exchange = new Market();
   Scanner scanner = new Scanner(System.in);
   HomeTradeSystem hts = new HomeTradeSystem();
   Stock stock = new Stock();
   StartWindow windowcontroller = new StartWindow();
   
   // local variable
   String[] strArrayList = exchange.company;
   int seed = hts.seed;
   int wallet[] = hts.wallet;
   int companyIndex = 0;

   
   @FXML 
   public ListView<String> stocklist;
   ObservableList<String> list = FXCollections.observableArrayList();

   
   @FXML
   public void selectBuyButton(ActionEvent event) {
      int num = Integer.valueOf(stockvalue.getText());   
      
      seed = hts.buy(seed, wallet, companyIndex , stock.stockValue(companyIndex), num); 
      
      havemoney.setText(String.valueOf(seed));
      havestock.setText(String.valueOf(wallet[companyIndex]));
      }
   
   @FXML
   public void selectSellButton(ActionEvent event) {   
      int num = Integer.valueOf(stockvalue.getText());      
      
      seed = hts.sell(seed, wallet, companyIndex, stock.stockValue(companyIndex), num); 
      
      havemoney.setText(String.valueOf(seed));
      havestock.setText(String.valueOf(wallet[companyIndex]));
   }
   
   @FXML
   public void turnOver(ActionEvent event) {   
      stock.stockWave();
      }
      
   @FXML
   public void chartOutput() {
      final XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("2003");
      series1.getData().add(new XYChart.Data<>("1", 26000));
      series1.getData().add(new XYChart.Data<>("1", 25000));
      
      final XYChart.Series<String, Number> series2 = new XYChart.Series<>();
      series2.getData().add(new XYChart.Data<>("2", 23000));
      series2.getData().add(new XYChart.Data<>("1", 22000));
      
      chart.getData().addAll(series1, series2);
   }
   
   @Override 
   public void initialize(URL location, ResourceBundle resources) {
      
      stock.setting();
      showname.setText(user.nickname);
      havemoney.setText(Integer.toString(seed));
      
      chartOutput();
      
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

   
   // elements

   @FXML
   private StackedBarChart<String, Number> chart;
   
   @FXML
   private TextField presentValue;
   @FXML
   private TextField havemoney;
   @FXML
   private TextField showname;
   @FXML
   private Button gameStartbtn;
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
   private Button turnoverbtn;
   @FXML
   private Button sell;
}
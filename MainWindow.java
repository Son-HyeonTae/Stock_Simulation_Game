package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainWindow implements Initializable {
   
   // create instances
   Stock stock = new Stock();
   Trader trader = new Trader();
   Market exchange = new Market();
   Scanner scanner = new Scanner(System.in);
   StartWindow windowcontroller = new StartWindow();
   HomeTradeSystem homeTradeSystem = new HomeTradeSystem();
   
   // local variables
   int turnOver = 5;
   int turnCount = 0;
   int companyIndex = 0;
   int seed = homeTradeSystem.seed;
   int wallet[] = homeTradeSystem.wallet;
   String[] strArrayList = exchange.company;

   // local methods
   public void closeStage() {
	   Stage stagewc = (Stage) turnoverbtn.getScene().getWindow();
	   stagewc.close();
   }
   
   
   @Override 
   public void initialize(URL location, ResourceBundle resources) {
      
      showname.setText(trader.nickname);
      havemoney.setText(Integer.toString(seed));
      stock.setting();
      
      stocklist.setItems(FXCollections.observableArrayList(strArrayList));
      stocklist.setOnMouseClicked(new EventHandler<MouseEvent>()
      {
         @Override
         public void handle(MouseEvent event) {
            if(event.getClickCount()>=1) {
               companyIndex = stocklist.getSelectionModel().getSelectedIndex();
               stockvalue.setText("");

               presentValue.setText(String.valueOf(stock.value[companyIndex]));
               havestock.setText(String.valueOf(wallet[companyIndex]));
            }
         }
      }
      );
   }
   
   
   @FXML 
   public ListView<String> stocklist;
   ObservableList<String> list = FXCollections.observableArrayList();
   
   @FXML
   public void selectBuyButton(ActionEvent event) {
      int num = Integer.valueOf(stockvalue.getText());   
      
      seed = homeTradeSystem.buy(seed, wallet, companyIndex , stock.stockValue(companyIndex), num); 
      homeTradeSystem.newseed = seed;
      
      havemoney.setText(String.valueOf(seed));
      havestock.setText(String.valueOf(wallet[companyIndex]));
      }
   
   @FXML
   public void selectSellButton(ActionEvent event) {   
      int num = Integer.valueOf(stockvalue.getText());      
      
      seed = homeTradeSystem.sell(seed, wallet, companyIndex, stock.stockValue(companyIndex), num); 
      homeTradeSystem.newseed = seed;
      
      havemoney.setText(String.valueOf(seed));
      havestock.setText(String.valueOf(wallet[companyIndex]));
   }
   
   @FXML
   public void turnOver() {   
      stock.stockWave();
      turnCount++;
         if (turnCount==turnOver) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultWindow.fxml"));
          Parent root;
          Stage stage;
          try {
             root = (Parent)loader.load();
             stage = new Stage();
             stage.setScene(new Scene(root));
             stage.show();
          } catch(IOException ex) {
          }
          closeStage();
         }
      }

   // elements
   @FXML
   private Label trade;
   @FXML
   private Label shares;
   @FXML
   private Button buy;
   @FXML
   private Button sell;
   @FXML
   private Button turnoverbtn;
   @FXML
   private Button gameStartbtn;
   @FXML
   private TextField showname;
   @FXML
   private TextField havemoney;
   @FXML
   private TextField havestock;
   @FXML
   private TextField stockvalue;
   @FXML
   private TextField presentValue;
   @FXML
   private StackedBarChart<String, Number> chart;
}
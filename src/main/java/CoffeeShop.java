import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeShop extends Application {
	
	BuildingOrder newOrder;
	int nExtra, nSugar, nCream, nVanilla, nSplenda;
	
	public static final String styleCoffe = "CoffeStyle.css";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Coffe Shop");
		
		TextArea infoOrder = new TextArea();
		Button bNewOrder = new Button("New Order");
		Button bDeleteOrder = new Button("Delete Order");
		Button bConfirm = new Button("Confirm");
		Button bExtraShot = new Button ("Add Extra Shot");
		Button bSugar = new Button ("Add Sugar");
		Button bCream = new Button ("Add Cream");
		Button bVanilla = new Button ("Add Vanilla");
		Button bSplenda = new Button ("Add Splenda Sugar");
		infoOrder.setPrefSize(200, 300);
		
		
		
		TextField numExtraShot = new TextField ();
		TextField numSugar = new TextField ();
		TextField numCream  = new TextField ();
		TextField numVanilla = new TextField ();
		TextField numSplenda = new TextField ();
		numExtraShot.setEditable(false);
		numSugar.setEditable(false);
		numCream.setEditable(false);
		numVanilla.setEditable(false);
		numSplenda.setEditable(false);
		
		Text tHeader = new Text("Coffe Shop");
		Text tAddOns = new Text("Add Ons");
		Text tInfoOrder = new Text ("Order Information");
		
		VBox boxCoffeButtons = new VBox (10, bExtraShot, bSugar,bCream,bVanilla,bSplenda); 
		VBox boxCoffeNum = new VBox (10, numExtraShot, numSugar,numCream,numVanilla,numSplenda); 
		HBox boxCoffeUnion = new HBox(10, boxCoffeButtons, boxCoffeNum);
		
		VBox boxCoffe = new VBox (10, bNewOrder, tAddOns, boxCoffeUnion); 
		
		HBox boxBottom = new HBox (40, bDeleteOrder, bConfirm);
		VBox info = new VBox (10, tInfoOrder,infoOrder);
		
		
		
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding( new Insets(20));
		mainPane.setTop(tHeader);
		mainPane.setLeft(boxCoffe);
		mainPane.setRight(info);
		mainPane.setBottom(boxBottom);
		BorderPane.setAlignment(tHeader, Pos.CENTER);
		BorderPane.setAlignment(boxCoffe, Pos.CENTER);
		BorderPane.setAlignment(info, Pos.CENTER);
		BorderPane.setAlignment(boxBottom, Pos.CENTER);
		BorderPane.setMargin(tHeader,  new Insets(10));
		BorderPane.setMargin(boxCoffe,  new Insets(10));
		BorderPane.setMargin(info,  new Insets(10));
		BorderPane.setMargin(boxBottom,  new Insets(10));
		
		bExtraShot.setDisable(true);
		bCream.setDisable(true);
		bSugar.setDisable(true);
		bSplenda.setDisable(true);
		bVanilla.setDisable(true);
		bConfirm.setDisable(true);
		
		bNewOrder.setOnAction(e-> {
			newOrder = new BuildingOrder();
			
			bConfirm.setDisable(false);
			
			nExtra = nSugar = nCream = nVanilla = nSplenda = 0;
			numExtraShot.setText(Integer.toString(nExtra));
			numCream.setText(Integer.toString(nCream));
			numSugar.setText(Integer.toString(nSugar));
			numSplenda.setText(Integer.toString(nSplenda));
			numVanilla.setText(Integer.toString(nVanilla));
			
			
			bExtraShot.setDisable(false);
			bCream.setDisable(false);
			bSugar.setDisable(false);
			bSplenda.setDisable(false);
			bVanilla.setDisable(false);
			
			infoOrder.clear();
			infoOrder.setText(newOrder.info);
		});
		
		bExtraShot.setOnAction(e-> {
			newOrder.addExtraShot();
			nExtra++;
			infoOrder.setText(newOrder.info);
			numExtraShot.setText(Integer.toString(nExtra));
			
		});
		
		bCream.setOnAction(e-> {
			newOrder.addCream();
			nCream++;
			infoOrder.setText(newOrder.info);
			numCream.setText(Integer.toString(nCream));
		});
		
		bSugar.setOnAction(e-> {
			newOrder.addSugar();
			nSugar++;
			infoOrder.setText(newOrder.info);
			numSugar.setText(Integer.toString(nSugar));
		});
		
		bSplenda.setOnAction(e-> {
			newOrder.addSplenda();
			nSplenda++;
			infoOrder.setText(newOrder.info);
			numSplenda.setText(Integer.toString(nSplenda));
		});
		
		bVanilla.setOnAction(e-> {
			newOrder.addVanilla();
			nVanilla++;
			infoOrder.setText(newOrder.info);
			numVanilla.setText(Integer.toString(nVanilla));
		});
		
		bConfirm.setOnAction(e-> {
			newOrder.getTotal();
			infoOrder.setText(newOrder.info);
			bConfirm.setDisable(true);
			bExtraShot.setDisable(true);
			bCream.setDisable(true);
			bSugar.setDisable(true);
			bSplenda.setDisable(true);
			bVanilla.setDisable(true);
		});
		
		bDeleteOrder.setOnAction(e-> {
			nExtra = nSugar = nCream = nVanilla = nSplenda = 0;
			numExtraShot.setText(Integer.toString(nExtra));
			numCream.setText(Integer.toString(nCream));
			numSugar.setText(Integer.toString(nSugar));
			numSplenda.setText(Integer.toString(nSplenda));
			numVanilla.setText(Integer.toString(nVanilla));
			infoOrder.clear();
		});
		

		
		Scene scene = new Scene(mainPane, 600, 400);
		scene.getStylesheets().add("/styles/CoffeStyle.css");
		tHeader.setId("header");
		tAddOns.setId("header");
		tInfoOrder.setId("header");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author nzing
 */
public class SimpleCalc extends Application {

    /**
     * @param args the command line arguments
     */
    private TextField feild = new TextField();
    public void start(Stage primaryStage){
        GridPane numButtons = new GridPane();
        MyHandler myHandler = new MyHandler();
        for (int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                CircleButton numBtn = new CircleButton((i*3)+j+1+"");
                numButtons.add(numBtn, j, i);
                numBtn.setOnMousePressed(myHandler);
                numBtn.setOnMouseReleased(myHandler);
            }
        }
        Button b1= new Button("Sqrt");
        Button b2= new Button("x^2");
        Button b3= new Button("Clr");
        HBox fnButton = new HBox();
        fnButton.getChildren().addAll(b1,b2,b3);
        fnButton.setAlignment(Pos.CENTER);
        
        //TextField feild = new TextField();
        CircleButton circle = new CircleButton();
        circle.setOnMousePressed(new EventHandler<MouseEvent>(){
        
            @Override
            public void handle(MouseEvent event){
                feild.appendText(circle.getValue());
        }
        });
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Double a = Double.parseDouble(feild.getText());
                Double sroot = Math.sqrt(a);
                feild.clear();
                feild.appendText(sroot.toString());
            }
        });
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double a = Double.parseDouble(feild.getText());
                Double Squared = a*a;
                feild.clear();
                feild.appendText(Squared.toString());
            }
        });
        
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                feild.clear();
                feild.appendText("");
            }
        });
        
        BorderPane bPane = new BorderPane();
        bPane.setBottom(fnButton);
        bPane.setTop(feild);
        bPane.setCenter(numButtons);
        Scene scene = new Scene(bPane, 300, 250);
        
        primaryStage.setTitle("Simple Calc");
        primaryStage.setScene(scene);
        primaryStage.show();   
                
    }
    private class MyHandler implements EventHandler<MouseEvent>{
        
        public void handle(MouseEvent event) {
            CircleButton cb = (CircleButton) event.getSource();
            if (cb.getColor().equals(Color.WHITE)){
                feild.setText(feild.getText()+cb.getValue());
                cb.setColor(Color.BLACK);
            }
            else{
                cb.setColor(Color.WHITE);
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}

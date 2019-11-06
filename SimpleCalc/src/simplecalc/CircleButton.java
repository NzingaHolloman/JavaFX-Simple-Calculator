/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

//import javafx.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

/**
 *
 * @author nzing
 */
public class CircleButton extends StackPane{
    private Label lblValue;
    private Circle circle;
    
    
    public CircleButton(){
        lblValue = new Label("");
        circle = new Circle();
        circle.setFill(Color.WHITE);
        circle.setRadius(45);
        this.getChildren().addAll(circle,lblValue);
    }
    public CircleButton(String val){
        circle = new Circle();
        lblValue = new Label(val);
        circle.setFill(Color.WHITE);
        circle.setRadius(45);
        this.getChildren().addAll(circle,lblValue);
    }
    public void setColor(Paint color){
        circle.setFill(color);
    }
    public Paint getColor(){
        return circle.getFill();
    }
    public String getValue(){
        return lblValue.getText();
    }
}

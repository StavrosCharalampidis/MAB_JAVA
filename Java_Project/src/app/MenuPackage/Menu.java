package app.MenuPackage;

import app.css.StyledJava;
import app.Scene.SceneCreator;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;



public class Menu extends SceneCreator implements EventHandler<MouseEvent> {
    FlowPane rootFlowPane;
    Button UserBtn, bt;
    
    public Menu(int width, int height) {
        super(width, height);
        
        rootFlowPane = new FlowPane();
        
        bt = new Button();
        StyledJava style = new StyledJava(bt);
        style.StyledCircle(bt);
        rootFlowPane.getChildren().add(bt);      
       
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == UserBtn) {
            
        }
    }
}

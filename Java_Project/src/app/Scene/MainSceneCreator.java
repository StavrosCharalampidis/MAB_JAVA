package app.Scene;

import app.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import app.css.StyledJava;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    FlowPane rootFlowPane;
    Button UserBtn;
    
    public MainSceneCreator(int width, int height) {
        super(width, height);
        
        rootFlowPane = new FlowPane();


        
        UserBtn = new Button("User");
        UserBtn.setOnMouseClicked(this);
        
 
        StyledJava styles = new StyledJava(UserBtn);
        styles.StyledButton(UserBtn);
        //styles.StyledCircle(UserBtn);
        
        rootFlowPane.setHgap(10);
        rootFlowPane.setAlignment(Pos.CENTER);
        rootFlowPane.getChildren().add(UserBtn);
        
       
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == UserBtn) {
            
            Main.primaryStage.setScene(Main.UserScene);
            Main.primaryStage.setTitle("User Scene");
        }
    }
}

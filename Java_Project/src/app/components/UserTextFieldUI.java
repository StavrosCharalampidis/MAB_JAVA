package app.components;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import app.Scene.SceneCreator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserTextFieldUI extends SceneCreator implements EventHandler<MouseEvent> {
    
    Label nameLbl;
    TextField nameField;
    GridPane rootGridPane, inputFieldsPane;
    
    
    Button nameBtn;
    FlowPane buttonFlowPane;

    public UserTextFieldUI(double width, double height) {
        super(width, height);
        

          
        
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();
        buttonFlowPane = new FlowPane();
        nameLbl = new Label("Name: ");
        nameField = new TextField();
        
        nameBtn = new Button("Sign In");
        
        
        // Ρύθμιση της στοίχισης σε πάνω αριστερά
        inputFieldsPane.setAlignment(Pos.TOP_CENTER);

        // Ρύθμιση του Horizontal και Vertical Gap σε 10 pixels
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        
        inputFieldsPane.add(nameLbl, 0, 0);
        inputFieldsPane.add(nameField, 1, 0);
        
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        
        rootGridPane.setAlignment(Pos.CENTER);
        
        // Ρύθμιση του Horizontal Gap (χώρος ανάμεσα στα κουμπιά) σε 10 pixels
        buttonFlowPane.setHgap(10);
        // Ρύθμιση της στοίχισης
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        
        // Προσθήκη των κουμπιών στο FlowPane
        buttonFlowPane.getChildren().add(nameBtn);
        
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(buttonFlowPane, 1, 1);
        
        nameBtn.setOnMouseClicked(this);
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootGridPane, width, height);
        //return new Scene(UserText.UserTextFieldUI(), width, height);
        
                
    }
    
     @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == nameBtn) {
            System.out.println("this");
        }
    }
    
    
    
}
package app.css;

import javafx.scene.control.Button;


public class StyledJava{
   
    public String MenuIcons = "-fx-background-radius: 15em; " +
                "-fx-min-width: 30px; " +
                "-fx-min-height: 30px; " +
                "-fx-max-width: 30px; " +
                "-fx-max-height: 30px;";
    public Button button;
    public String IDLE_BUTTON_STYLE = "-fx-background-color: blue;";
    public String HOVERED_BUTTON_STYLE = "-fx-background-color: red;";
    
    public StyledJava(Button button) {
        this.button = button;
    };
    
    public Button StyledButton(Button button) {
        
        this.button.setStyle(IDLE_BUTTON_STYLE);
        this.button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
        this.button.setOnMouseExited(e -> button.setStyle(IDLE_BUTTON_STYLE));
        return this.button;
    }
    
    public Button StyledCircle(Button button){
        this.button.setStyle(MenuIcons);
        return this.button;
    }
    
}
 


   
    


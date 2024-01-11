package app;

import app.Scene.UserSceneCreator;
import app.Scene.MainSceneCreator;
import app.MenuPackage.Menu;

import javafx.application.Application;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage primaryStage;
    public static Scene mainScene, UserScene;
    //public static Scene menuScene;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        //primaryStage.initStyle(StageStyle.UNDECORATED);
            
//        Menu menuSceneCreator = new  Menu(650, 300);
//        menuScene = menuSceneCreator.createScene();
        
        MainSceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();
        
        UserSceneCreator UserSceneCreator = new UserSceneCreator(650, 300);
        UserScene = UserSceneCreator.createScene();
            

       
        
        
            
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("JavaFXApplication1");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}

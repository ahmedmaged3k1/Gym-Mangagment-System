package mainClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent group1 = FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/Home.fxml"));
            primaryStage.setTitle("Gym Mangement System");
            primaryStage.setScene(new Scene(group1));
            primaryStage.show();

        }catch(Exception e){
            System.out.println(e);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}

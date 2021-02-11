package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Sample Skeleton for 'Home.fxml' Controller Class
 */

public class mainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_f1_login"
    private Button btn_f1_login;                                                       // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_f1_login != null : "fx:id=\"btn_f1_login\" was not injected: check your FXML file 'GUI/Home/Home.fxml'.";

    }
    @FXML
    private void btnpressed(ActionEvent event) throws IOException {
        try {
            System.out.println("btn login pressed successively ");
            Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/f2.fxml"));
            Scene loginScene = new Scene(loginParent);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(loginScene);
            login_stage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}

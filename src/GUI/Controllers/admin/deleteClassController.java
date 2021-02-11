package GUI.Controllers.admin;
/**
 * Sample Skeleton for 'deleteclass.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import mainClasses.Fitness_class;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class deleteClassController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lbl_classid"
    private Label lbl_classid; // Value injected by FXMLLoader

    @FXML // fx:id="lbl_classname"
    private Label lbl_classname; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_deleteClassid"
    private TextField txtf_deleteClassid; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_deleteClassname"
    private TextField txtf_deleteClassname; // Value injected by FXMLLoader

    @FXML // fx:id="btn_delete_class"
    private Button btn_delete_class; // Value injected by FXMLLoader





    @FXML
    void btn_delete_pressed(ActionEvent x) throws Exception {
        try{
            ButtonType buttonTypeOne=new ButtonType("Confirm");
            ButtonType buttonTypeCancel=new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Delete data");
            alert.setHeaderText("Are you sure you want to delete data , press ok to continue");
            alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeCancel );
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                Fitness_class.class_delete(Integer.parseInt(txtf_deleteClassid.getText()));
            } else if (result.get() == buttonTypeCancel) {
                return;
            }

        }catch (Exception e){

            //Alert  object ;; warning
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Please insert/check Trainee Name and id !");
            alert.showAndWait();
            System.out.println(e);}

    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lbl_classid != null : "fx:id=\"lbl_classid\" was not injected: check your FXML file 'deleteclass.fxml'.";
        assert lbl_classname != null : "fx:id=\"lbl_classname\" was not injected: check your FXML file 'deleteclass.fxml'.";
        assert txtf_deleteClassid != null : "fx:id=\"txtf_deleteClassid\" was not injected: check your FXML file 'deleteclass.fxml'.";
        assert txtf_deleteClassname != null : "fx:id=\"txtf_deleteClassname\" was not injected: check your FXML file 'deleteclass.fxml'.";
        assert btn_delete_class != null : "fx:id=\"btn_delete_class\" was not injected: check your FXML file 'deleteclass.fxml'.";

    }

}

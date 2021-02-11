package GUI.Controllers.admin;

import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import mainClasses.Fitness_class;
import mainClasses.Trainer;
import mainClasses.con1;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Sample Skeleton for 'assignClassToTrainer.fxml' Controller Class
 */
public class assignClassToTrainerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtf_Admin_assignClassToTrainer_className"
    private TextField txtf_Admin_assignClassToTrainer_className; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_Admin_assignClassToTrainer_classId"
    private TextField txtf_Admin_assignClassToTrainer_classId; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_Admin_assignClassToTrainer_TrainerName"
    private TextField txtf_Admin_assignClassToTrainer_TrainerName; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_Admin_assignClassToTrainer_TrainerID"
    private TextField txtf_Admin_assignClassToTrainer_TrainerID; // Value injected by FXMLLoader

    @FXML
    private JFXTimePicker txt_time_class;

    @FXML
    private DatePicker txtf_Admin_assignClassToTrainer_ClassDate;

    @FXML
    private Button btn_assgin;

    @FXML
    protected SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");

    @FXML
    void onAddingText(ActionEvent x) throws SQLException {
        ResultSet rs=Trainer.Display_specific_trainer_basedOn_id(Integer.parseInt(txtf_Admin_assignClassToTrainer_TrainerID.getText()));
        while(rs.next())
        {
            txtf_Admin_assignClassToTrainer_TrainerName.setText(rs.getString("name"));
        }
        con1 connect=new con1();
        ResultSet rs2=connect.displayData_db("Select CLASS_NAME FROM fitness_class where CLASS_ID = "+ Integer.parseInt(txtf_Admin_assignClassToTrainer_classId.getText()) );
        while(rs2.next())
        {
            txtf_Admin_assignClassToTrainer_className.setText(rs2.getString("CLASS_NAME"));
        }
    }

    @FXML
    void btn_assign_pressed(){


        try {
            LocalDate date = txtf_Admin_assignClassToTrainer_ClassDate.getValue();
            Date classDate;
            classDate = java.sql.Date.valueOf(date);
            SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");
            String dateToString = date_format.format(classDate);  //s means start date
            System.out.println(dateToString);
            dateToString.toUpperCase();

            System.out.println(txtf_Admin_assignClassToTrainer_ClassDate.getValue());
            System.out.println(txt_time_class.getValue());

            Fitness_class.Assign_Trainer_to_class(Integer.parseInt(txtf_Admin_assignClassToTrainer_TrainerID.getText()), Integer.parseInt(txtf_Admin_assignClassToTrainer_classId.getText()),
                    txtf_Admin_assignClassToTrainer_TrainerName.getText(), txt_time_class.getValue().toString(), dateToString.toUpperCase());
        }catch(Exception x){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message" );
            alert.setHeaderText("ERROR MESSAGE !");
            alert.showAndWait();
            alert.setContentText(x.getMessage());

        }


    }












    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtf_Admin_assignClassToTrainer_className != null : "fx:id=\"txtf_Admin_assignClassToTrainer_className\" was not injected: check your FXML file 'assignClassToTrainer.fxml'.";
        assert txtf_Admin_assignClassToTrainer_classId != null : "fx:id=\"txtf_Admin_assignClassToTrainer_classId\" was not injected: check your FXML file 'assignClassToTrainer.fxml'.";
        assert txtf_Admin_assignClassToTrainer_TrainerName != null : "fx:id=\"txtf_Admin_assignClassToTrainer_TrainerName\" was not injected: check your FXML file 'assignClassToTrainer.fxml'.";
        assert txtf_Admin_assignClassToTrainer_TrainerID != null : "fx:id=\"txtf_Admin_assignClassToTrainer_TrainerID\" was not injected: check your FXML file 'assignClassToTrainer.fxml'.";

    }
}

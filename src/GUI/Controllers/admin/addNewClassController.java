package GUI.Controllers.admin;
/**
 * Sample Skeleton for 'Addnewclass.fxml' Controller Class
 */
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mainClasses.Fitness_class;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class addNewClassController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtf_n_classid"
    private TextField txtf_n_classid; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_n_classname"
    private TextField txtf_n_classname; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_n_classdesc"
    private TextField txtf_n_classdesc; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_n_classdate"
    private DatePicker txtf_n_classdate; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_n_classcapacity"
    private TextField txtf_n_classcapacity; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_n_classtype"
    private TextField txtf_n_classtype; // Value injected by FXMLLoader

    @FXML // fx:id="btn_add_newClass"
    private Button btn_add_newClass; // Value injected by FXMLLoader

    @FXML
    private JFXTimePicker txtf_n_classtime;
    @FXML
    protected SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");

    @FXML
    void btn_addClass_pressed() throws SQLException {


        LocalDate date = txtf_n_classdate.getValue();
        Date classDate;
        classDate=java.sql.Date.valueOf(date);
        SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");
        String s_dateToString = date_format.format(classDate);  //s means start date
        System.out.println(s_dateToString);
        s_dateToString.toUpperCase();
        System.out.println(txtf_n_classtime.getValue());
        Fitness_class newClass = new Fitness_class(
                txtf_n_classname.getText(), Integer.parseInt(txtf_n_classid.getText()),
                txtf_n_classtime.getValue().toString(), s_dateToString.toUpperCase(),
                Integer.parseInt(txtf_n_classcapacity.getText()), txtf_n_classtype.getText());

        newClass.Add();






    }




    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtf_n_classid != null : "fx:id=\"txtf_n_classid\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classname != null : "fx:id=\"txtf_n_classname\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classdesc != null : "fx:id=\"txtf_n_classdesc\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classdate != null : "fx:id=\"txtf_n_classdate\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classcapacity != null : "fx:id=\"txtf_n_classcapacity\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classtype != null : "fx:id=\"txtf_n_classtype\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert btn_add_newClass != null : "fx:id=\"btn_add_newClass\" was not injected: check your FXML file 'Addnewclass.fxml'.";
        assert txtf_n_classtime != null : "fx:id=\"txtf_n_classtime\" was not injected: check your FXML file 'addNewClass.fxml'.";


    }
}

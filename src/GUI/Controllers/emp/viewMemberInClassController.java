package GUI.Controllers.emp;

import javafx.event.ActionEvent;
import mainClasses.Fitness_class;
import mainClasses.con1;
import mainClasses.Trainee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Sample Skeleton for '5-view members in a specific class.fxml' Controller Class
 */


public class viewMemberInClassController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_display"
    private Button btn_display; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_viewMembers_InClass_classID"
    private TextField txtf_emp_viewMembers_InClass_classID; // Value injected by FXMLLoader

    @FXML // fx:id="xtf_emp_viewMembers_InClass_className"
    private TextField txtf_emp_viewMembers_InClass_className; // Value injected by FXMLLoader

    @FXML // fx:id="tableMembers"
    private TableView<Trainee> tableMembers; // Value injected by FXMLLoader


    @FXML // fx:id="table_viewallmembersinclasses_trainee_id"
    private TableColumn<Trainee, Integer> table_viewallmembersinclasses_trainee_id; // Value injected by FXMLLoader

    @FXML // fx:id="table_viewallmembersinclasses_trainee_name"
    private TableColumn<Trainee, String> table_viewallmembersinclasses_trainee_name; // Value injected by FXMLLoader
    @FXML // fx:id="classTable"

    private TableView<Fitness_class> classTable; // Value injected by FXMLLoader

    @FXML // fx:id="table_viewallmembersinclasses_Class_id"
    private TableColumn<Fitness_class, Integer> table_viewallmembersinclasses_Class_id; // Value injected by FXMLLoader

    @FXML
    ObservableList<Trainee> traineeList = FXCollections.observableArrayList();
    @FXML
    ObservableList<Fitness_class> classList = FXCollections.observableArrayList();


    @FXML
    void btn_display_PRESSED() throws SQLException {

        try {

            con1 connectNow = new con1();
            System.out.println("Functions displays trainees  data in table in a class ");
            String query = "SELECT member_name,member_id  from CLASS_MEMBER " ;
            ResultSet rs = connectNow.displayData_db(query);
            //    execute query to display
            while (rs.next()) {
                traineeList.add(new Trainee(rs.getString("member_name"),rs.getInt("member_id")));
            }
            tableMembers.setItems(traineeList);


            query="SELECT class_id from CLASS_MEMBER  ";
            ResultSet rs2 = connectNow.displayData_db(query);
            while (rs2.next()) {
                classList.add(new Fitness_class(rs2.getInt("class_id")));
            }
            classTable.setItems(classList);

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
        assert btn_display != null : "fx:id=\"btn_display\" was not injected: check your FXML file 'viewMembersInSpecificClass.fxml'.";
        assert tableMembers != null : "fx:id=\"tableMembers\" was not injected: check your FXML file 'viewMembersInSpecificClass.fxml'.";
        assert table_viewallmembersinclasses_Class_id != null : "fx:id=\"table_viewallmembersinclasses_Class_id\" was not injected: check your FXML file 'viewMembersInSpecificClass.fxml'.";
        assert table_viewallmembersinclasses_trainee_id != null : "fx:id=\"table_viewallmembersinclasses_trainee_id\" was not injected: check your FXML file 'viewMembersInSpecificClass.fxml'.";
        assert table_viewallmembersinclasses_trainee_name != null : "fx:id=\"table_viewallmembersinclasses_trainee_name\" was not injected: check your FXML file 'viewMembersInSpecificClass.fxml'.";

        table_viewallmembersinclasses_trainee_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table_viewallmembersinclasses_trainee_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_viewallmembersinclasses_Class_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        btn_display_PRESSED();

    }


}
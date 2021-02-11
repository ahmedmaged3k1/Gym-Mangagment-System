package GUI.Controllers.emp;

/**
 * Sample Skeleton for 'view all members.fxml' Controller Class
 */

import mainClasses.con1;
import mainClasses.Trainee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Trainee;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class viewAllMembersController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private TableView<Trainee> allTraineeTable;
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_Name"
    private TableColumn<Trainee, String> tableColoumn_emp_viewAllMembers_Name; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_ID"
    private TableColumn<Trainee, Integer> tableColoumn_emp_viewAllMembers_ID; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_age"
    private TableColumn<Trainee, Integer> tableColoumn_emp_viewAllMembers_age; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_PhoneNum"
    private TableColumn<Trainee, String> tableColoumn_emp_viewAllMembers_PhoneNum; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_weight"
    private TableColumn<Trainee, Float> tableColoumn_emp_viewAllMembers_weight; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_height"
    private TableColumn<Trainee, Float> tableColoumn_emp_viewAllMembers_height; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_email"
    private TableColumn<Trainee, String> tableColoumn_emp_viewAllMembers_email; // Value injected by FXMLLoader
    @FXML // fx:id="tableColoumn_emp_viewAllMembers_gender"
    private TableColumn<Trainee, String> tableColoumn_emp_viewAllMembers_gender; // Value injected by FXMLLoader
    @FXML
    ObservableList<Trainee> allTraineesView = FXCollections.observableArrayList();


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        assert tableColoumn_emp_viewAllMembers_Name != null : "fx:id=\"tableColoumn_emp_viewAllMembers_Name\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_ID != null : "fx:id=\"tableColoumn_emp_viewAllMembers_ID\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_age != null : "fx:id=\"tableColoumn_emp_viewAllMembers_age\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_PhoneNum != null : "fx:id=\"tableColoumn_emp_viewAllMembers_PhoneNum\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_weight != null : "fx:id=\"tableColoumn_emp_viewAllMembers_weight\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_height != null : "fx:id=\"tableColoumn_emp_viewAllMembers_height\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_email != null : "fx:id=\"tableColoumn_emp_viewAllMembers_email\" was not injected: check your FXML file 'view all members.fxml'.";
        assert tableColoumn_emp_viewAllMembers_gender != null : "fx:id=\"tableColoumn_emp_viewAllMembers_gender\" was not injected: check your FXML file 'view all members.fxml'.";

        tableColoumn_emp_viewAllMembers_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColoumn_emp_viewAllMembers_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColoumn_emp_viewAllMembers_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColoumn_emp_viewAllMembers_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableColoumn_emp_viewAllMembers_height.setCellValueFactory(new PropertyValueFactory<>("height"));
        tableColoumn_emp_viewAllMembers_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableColoumn_emp_viewAllMembers_PhoneNum.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        tableColoumn_emp_viewAllMembers_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        try {
            System.out.println("Functions displays trainees  data in table in a class ");
            ResultSet rs=Trainee.Display_info();

            while (rs.next()) {
                allTraineesView.add(new Trainee(rs.getInt("ID"), rs.getString("NAME"),
                        rs.getString("EMAIL"), rs.getString("GENDER"), rs.getString("PHONE_NUMBER")
                        , rs.getFloat("HEIGHT_CM"), rs.getFloat("WEIGHT_KG"), rs.getInt("AGE")));
            }
            allTraineeTable.setItems(allTraineesView);
        } catch (Exception e) { System.out.println(e); }
    }
}

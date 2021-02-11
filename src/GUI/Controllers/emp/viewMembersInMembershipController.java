package GUI.Controllers.emp;
/**
 * Sample Skeleton for '6-view members in MEMBERSHIP.fxml' Controller Class
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Membership.Open_package;
import mainClasses.Membership.Pay_as_you_go_package;
import mainClasses.Membership.Term_package;
import mainClasses.Trainee;
import mainClasses.con1;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class viewMembersInMembershipController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_emp_viewMembers_InMembership_viewMembers"
    private Button btn_emp_viewMembers_InMembership_viewMembers; // Value injected by FXMLLoader

    @FXML // fx:id="tableMemberData"
    private TableView<Trainee> tableMemberData; // Value injected by FXMLLoader

    @FXML // fx:id="list_viewMembersInMembership_membersID"
    private TableColumn<Trainee, Integer> list_viewMembersInMembership_membersID; // Value injected by FXMLLoader

    @FXML // fx:id="list_viewMembersInMembership_membersnames"
    private TableColumn<Trainee, String> list_viewMembersInMembership_membersnames; // Value injected by FXMLLoader

    @FXML
    ObservableList<Trainee> traineesView = FXCollections.observableArrayList();


    @FXML // fx:id="txtf_emp_viewMembers_InMembership_Name"
    private ChoiceBox<String> txtf_emp_viewMembers_InMembership_Name =new ChoiceBox<>(); // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_viewMembers_InMembership_Type"
    private ChoiceBox<String> txtf_emp_viewMembers_InMembership_Type =new ChoiceBox<>(); // Value injected by FXMLLoader

    @FXML
    ObservableList<String> data = FXCollections.observableArrayList();



    @FXML
    void btn_ViewMembers_PRESSED()   {

        setNull();
        try {

            System.out.println("Functions displays trainees  data in table ");
            con1 connect=new con1();
            String query="SELECT  MEMBER_ID FROM  "+ txtf_emp_viewMembers_InMembership_Type.getSelectionModel().getSelectedItem().toString() ;
            System.out.println(txtf_emp_viewMembers_InMembership_Type.getSelectionModel().getSelectedItem());

            ResultSet rs=connect.displayData_db(query);        //execute query to display

            query= "SELECT  name FROM member WHERE id in ( select member_id from  " + txtf_emp_viewMembers_InMembership_Type.getSelectionModel().getSelectedItem().toString() +")" ;
            ResultSet rs1=connect.displayData_db(query);
            while (rs.next() && rs1.next()) {
                traineesView.add(new Trainee(rs.getInt("member_id"),rs1.getString("name")));
                System.out.println(rs.getInt("member_id"));
            }
            tableMemberData.setItems(traineesView);

        } catch (Exception e) { System.out.println(e); }

    }






    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
        assert txtf_emp_viewMembers_InMembership_Type != null : "fx:id=\"txtf_emp_viewMembers_InMembership_Type\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";
        assert txtf_emp_viewMembers_InMembership_Name != null : "fx:id=\"txtf_emp_viewMembers_InMembership_Name\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";
        assert btn_emp_viewMembers_InMembership_viewMembers != null : "fx:id=\"btn_emp_viewMembers_InMembership_viewMembers\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";
        assert tableMemberData != null : "fx:id=\"tableMemberData\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";
        assert list_viewMembersInMembership_membersID != null : "fx:id=\"list_viewMembersInMembership_membersID\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";
        assert list_viewMembersInMembership_membersnames != null : "fx:id=\"list_viewMembersInMembership_membersnames\" was not injected: check your FXML file 'viewMembersInMembership.fxml'.";

        list_viewMembersInMembership_membersID.setCellValueFactory(new PropertyValueFactory<>("id"));
        list_viewMembersInMembership_membersnames.setCellValueFactory(new PropertyValueFactory<>("name"));

        Open_package c1=new Open_package();
        Term_package c2=new Term_package();
        Pay_as_you_go_package c3=new Pay_as_you_go_package();

        txtf_emp_viewMembers_InMembership_Type.getItems().add(c1.getType());
        txtf_emp_viewMembers_InMembership_Type.getItems().add(c2.getType());
        txtf_emp_viewMembers_InMembership_Type.getItems().add(c3.getType());

        txtf_emp_viewMembers_InMembership_Name.getItems().add(c1.getName());
        txtf_emp_viewMembers_InMembership_Name.getItems().add(c2.getName());
        txtf_emp_viewMembers_InMembership_Name.getItems().add(c2.getName());


    }

    void setNull(){
        tableMemberData.getItems().clear();

    }

}

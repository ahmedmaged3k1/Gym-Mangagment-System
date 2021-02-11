package GUI.Controllers.emp;

import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Fitness_class;
import mainClasses.Trainee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import mainClasses.Trainee;
import mainClasses.con1;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/***         Sample Skeleton for '3-Add.delete Member in class.fxml' Controller Class       */

public class AddDeleteMemberClassController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtf_emp_addMemInClass_classID"
    private TextField txtf_emp_addMemInClass_classID; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMemInClass_className"
    private TextField txtf_emp_addMemInClass_className; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMemInClass_TraineeName"
    private TextField txtf_emp_addMemInClass_TraineeName; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMemInClass_TraineeID"
    private TextField txtf_emp_addMemInClass_TraineeID; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMemInClass_confirm"
    private Button btn_emp_addMemInClass_confirm; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMemInClass_delete"
    private Button btn_emp_addMemInClass_delete; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMemInClass_add"
    private Button btn_emp_addMemInClass_add; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Trainee, String> tableColumn_emp_addMemberInClass_memberName;

    @FXML
    private TableColumn<Trainee, Integer> tableColumn_emp_addMemberInClass_memberID;

    @FXML
    private TableView<Trainee> tableMemberInClass;

    @FXML
    ObservableList<Trainee> tableViewTrainee = FXCollections.observableArrayList();

    @FXML
    private TextField txt_view_class_id;


    @FXML
    void view(){
        int classId=0;

        clearTable();
        try {
            classId=Integer.parseInt(txt_view_class_id.getText());
            if(classId==0)
            {
                classId=Integer.parseInt(txtf_emp_addMemInClass_classID.getText());
            }else {
                System.out.println("This Function displays trainees data  in class whose ID= " + classId + " in table in a class ");
                ResultSet rs = Fitness_class.Display_members_in_class(classId);
                while (rs.next()) {
                    tableViewTrainee.add(new Trainee(rs.getString("member_name"), rs.getInt("member_id")));
                    System.out.println(rs.getString("member_name") + rs.getInt("member_id"));
                }
                tableColumn_emp_addMemberInClass_memberName.setCellValueFactory(new PropertyValueFactory<>("name"));
                tableColumn_emp_addMemberInClass_memberID.setCellValueFactory(new PropertyValueFactory<>("id"));
                tableMemberInClass.setItems(tableViewTrainee);
                initialize();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void btn_add_pressed(){
        try {
            System.out.println("ADD btn is pressed");
            Fitness_class.Add_members_in_class(Integer.parseInt(txtf_emp_addMemInClass_TraineeID.getText().toString()),
                                                Integer.parseInt(txtf_emp_addMemInClass_classID.getText().toString()),txtf_emp_addMemInClass_TraineeName.getText().toString());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Adding member in classid= "+ txtf_emp_addMemInClass_classID.getText()+  " process is successful ");
            alert.showAndWait();

            view();

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter data in all the required text fields ! " );
            alert.showAndWait();
            System.out.println(e + "there is sth that  is empty");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message" );
            alert.setHeaderText(null);
            alert.setContentText("Please Check Entered data ! ");
            alert.showAndWait();
            System.out.println(e);
        }
        view();
    }

    @FXML
    void btn_delete_pressed(){
            try {
                System.out.println("ADD btn is pressed");
                Fitness_class.Remove_members_from_class(Integer.parseInt(txtf_emp_addMemInClass_TraineeID.getText()),
                        Integer.parseInt(txtf_emp_addMemInClass_classID.getText()));


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Deleting member from classid= "+ txtf_emp_addMemInClass_classID.getText()+  "process is successful ");
                alert.showAndWait();

            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Warning Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter data in all the required text fields ! " );
                alert.showAndWait();
                System.out.println(e + "there is sth that  is empty");
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message" );
                alert.setHeaderText(null);
                alert.setContentText("Please Check Entered data ! ");
                alert.showAndWait();
                System.out.println(e);
            }
            view();
    }

    @FXML
    void clearTable(){
        tableMemberInClass.getItems().clear();
    }

    @FXML
    void btn_ConfirmBtn_pressed(ActionEvent x)  {
        try {
            con1.commit_method();

            //Alert  object ;; info
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Information Message");
            alert.setHeaderText("Trainee added successively in class ");
            alert.setContentText(null);
            alert.showAndWait();

        }
        catch (Exception e){

            //Alert  object ;; warning
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText("No data is changed  ");
            alert.setContentText(null);
            alert.showAndWait();

        }



    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        assert txtf_emp_addMemInClass_classID != null : "fx:id=\"txtf_emp_addMemInClass_classID\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert txtf_emp_addMemInClass_className != null : "fx:id=\"txtf_emp_addMemInClass_className\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert txtf_emp_addMemInClass_TraineeName != null : "fx:id=\"txtf_emp_addMemInClass_TraineeName\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert txtf_emp_addMemInClass_TraineeID != null : "fx:id=\"txtf_emp_addMemInClass_TraineeID\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert btn_emp_addMemInClass_confirm != null : "fx:id=\"btn_emp_addMemInClass_confirm\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert btn_emp_addMemInClass_delete != null : "fx:id=\"btn_emp_addMemInClass_delete\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";
        assert btn_emp_addMemInClass_add != null : "fx:id=\"btn_emp_addMemInClass_add\" was not injected: check your FXML file '3-Add.delete Member in class.fxml'.";

    }

}

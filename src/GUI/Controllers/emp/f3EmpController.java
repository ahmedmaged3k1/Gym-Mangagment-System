package GUI.Controllers.emp;
/**
 * Sample Skeleton for 'f3-Emp.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class f3EmpController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_f3_employee_VeiwAllMember"
    private Button btn_f3_employee_VeiwAllMember; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_employee_NewMeber"
    private Button btn_f3_employee_NewMeber; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_employee_addMemberInClass"
    private Button btn_f3_employee_addMemberInClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_employee_RemoveMemberFromClass"
    private Button btn_f3_employee_RemoveMemberFromClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_employee_ViewMemberInClass"
    private Button btn_f3_employee_ViewMemberInClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_employee_ViewAllMemberInMemberShip"
    private Button btn_f3_employee_ViewAllMemberInMemberShip; // Value injected by FXMLLoader

    @FXML
    private Button addDelMem;

    @FXML
    void btn_viewAllMembers_PRESSED(ActionEvent event ) throws IOException {
        try {
            System.out.println("btn View All Members is pressed successively ");
            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/emp/viewAllMembers.fxml"));
            Stage stage = new Stage();
            stage.setTitle("View All Members");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btn_addEditDelMembers_PRESSED(ActionEvent event )  {

        try{
            System.out.println("btn Add/edit/delete Members is pressed successively  ");
            Parent root;
        root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/emp/addDelMem.fxml"));
        Stage stage = new Stage();
            stage.setTitle("Add/edit/delete Members");
            stage.setScene(new Scene(root));
            stage.show();}
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    @FXML
    void btn_AddMemberInClass_PRESSED(ActionEvent event ) throws IOException {
        try {
            System.out.println("btn AddMemberInClass is pressed successively ");
            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/emp/addDeleteMemberInClass.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add/edit/delete Members _ class");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btn_AddDeleteMemberInClass_PRESSED(ActionEvent event ) throws IOException {
        try {
            System.out.println("btn AddDeleteMemberInClass is pressed successively ");
            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/emp/addDeleteMemberInClass.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add/edit/delete Members");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btn_ViewMembersInClass_PRESSED(ActionEvent event ) throws IOException {
        try {
            System.out.println("btn ViewMembersInClass is pressed successively ");
            Parent root;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/fxmlFiles/emp/viewMembersInSpecificClass.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("View Members In a Class");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e)
        {System.out.println(e);
        }

    }

    @FXML
    void btn_ViewMembersInMemberShip_PRESSED(ActionEvent event ) throws IOException {
        try {
            System.out.println("btn ViewMembersInMemberShip is pressed successively ");
            Parent root;
            root =FXMLLoader.load(getClass().getResource("../../fxmlFiles/emp/viewMembersInMembership.fxml"));
            Stage stage = new Stage();
            stage.setTitle("View All Members in a specific MemberShip");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_f3_employee_VeiwAllMember != null : "fx:id=\"btn_f3_employee_VeiwAllMemberInformation\" was not injected: check your FXML file 'f3-Emp.fxml'.";
        assert btn_f3_employee_NewMeber != null : "fx:id=\"btn_f3_employee_NewMeber\" was not injected: check your FXML file 'f3-Emp.fxml'.";
        assert btn_f3_employee_addMemberInClass != null : "fx:id=\"btn_f3_employee_addMemberInClass\" was not injected: check your FXML file 'f3-Emp.fxml'.";
        assert btn_f3_employee_RemoveMemberFromClass != null : "fx:id=\"btn_f3_employee_RemoveMemberFromClass\" was not injected: check your FXML file 'f3-Emp.fxml'.";
        assert btn_f3_employee_ViewMemberInClass != null : "fx:id=\"btn_f3_employee_ViewMemberInClass\" was not injected: check your FXML file 'f3-Emp.fxml'.";
        assert btn_f3_employee_ViewAllMemberInMemberShip != null : "fx:id=\"btn_f3_employee_ViewAllMemberInMemberShip\" was not injected: check your FXML file 'f3-Emp.fxml'.";

    }
}

package GUI.Controllers.admin;

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

/**
 * Sample Skeleton for 'f3emp.fxml' Controller Class
 */
public class f3AdminController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_f3_addEditTrainer"
    private Button btn_f3_addEditTrainer; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_viewClass"
    private Button btn_f3_viewClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_addClass"
    private Button btn_f3_addClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_editClass"
    private Button btn_f3_editClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_deleteClass"
    private Button btn_f3_deleteClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_assignTrainerToClass"
    private Button btn_f3_assignTrainerToClass; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_assignTrainerToMember"
    private Button btn_f3_assignTrainerToMember; // Value injected by FXMLLoader

    @FXML // fx:id="btn_f3_viewMembers"
    private Button btn_f3_viewMembers; // Value injected by FXMLLoader


    @FXML
    void btn_AddTrainer_PRESSED(ActionEvent x) throws IOException {
        try {
            System.out.println("btn AddTrainer is pressed successively ");
            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/addEditDeleteTrainer.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add /edit / delete Trainer");
            stage.setX(680);
            stage.setY(140);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    @FXML
    void btn_AddNewClass_PRESSED(ActionEvent x) throws IOException {

        try {
            System.out.println("btn AddNewClass is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/addNewClass.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add new class");
            stage.setScene(new Scene(root));
            stage.setX(680);
            stage.setY(140);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    @FXML
    void btn_EditClass_PRESSED(ActionEvent x) throws IOException {

        try {
            System.out.println("btn EditClass is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/editClass.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit class");
            stage.setScene(new Scene(root));
            stage.setX(680);
            stage.setY(140);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void btn_deleteClass_PRESSED(ActionEvent x) throws IOException {


            try {
                System.out.println("btn delete class is pressed successively ");

                Parent root;
                root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/deleteclass.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Delete class");
                stage.setScene(new Scene(root));
                stage.setX(680);
                stage.setY(140);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    @FXML
    void btn_AssignTrainerToClass_PRESSED(ActionEvent x) throws IOException {
        try {
            System.out.println("btn AssignTrainerToClass is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/assignClassToTrainer.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Assign Trainer To a Class");
            stage.setScene(new Scene(root));
            stage.setX(680);
            stage.setY(140);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btn_AssignTrainerToMember_PRESSED(ActionEvent x) throws IOException {
        try {
            System.out.println("btn AssignTrainerToMember is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/assignTrainerToMember.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Assign Trainer to Member ");
            stage.setX(680);
            stage.setY(140);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void btn_ViewAllMembersInfo_PRESSED(ActionEvent x) throws IOException {
        try {
            System.out.println("btn ViewAllMembersInfo is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/emp/viewAllMembers.fxml"));
            Stage stage = new Stage();
            stage.setTitle("View all Members class");
            stage.setX(680);
            stage.setY(140);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btn_ViewClass_PRESSED(ActionEvent x) throws IOException {
        try {
            System.out.println("btn ViewClass is pressed successively ");

            Parent root;
            root =FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/admin/viewClasses.fxml"));
            Stage stage = new Stage();
            stage.setTitle("View class");
            stage.setScene(new Scene(root));
            stage.setX(680);
            stage.setY(140);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn_f3_addEditTrainer != null : "fx:id=\"btn_f3_addEditDeleteTrainer\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_viewClass != null : "fx:id=\"btn_f3_viewClass\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_addClass != null : "fx:id=\"btn_f3_addClass\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_editClass != null : "fx:id=\"btn_f3_editClass\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_deleteClass != null : "fx:id=\"btn_f3_deleteClass\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_assignTrainerToClass != null : "fx:id=\"btn_f3_assignTrainerToClass\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_assignTrainerToMember != null : "fx:id=\"btn_f3_assignTrainerToMember\" was not injected: check your FXML file 'f3emp.fxml'.";
            assert btn_f3_viewMembers != null : "fx:id=\"btn_f3_viewMembers\" was not injected: check your FXML file 'f3emp.fxml'.";
        }

}







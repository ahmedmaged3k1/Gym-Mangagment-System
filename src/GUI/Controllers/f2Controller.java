package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainClasses.con1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class f2Controller {

    private Connection connection;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtf_f2_userName;

    @FXML
    private PasswordField txtf_f2_userPassword;

    @FXML
    private Button btn_f2_login;

    @FXML
    void initialize() {
        assert txtf_f2_userName != null : "fx:id=\"txtf_f2_userName\" was not injected: check your FXML file 'f2.fxml'.";
        assert txtf_f2_userPassword != null : "fx:id=\"txtf_f2_userPassword\" was not injected: check your FXML file 'f2.fxml'.";
        assert btn_f2_login != null : "fx:id=\"btn_f2_login\" was not injected: check your FXML file 'f2.fxml'.";

    }
    @FXML
    void btn_login_PRESSED(ActionEvent event) throws IOException {

     //   if( == )     {              // lw admin yft7 screen adimn f3 lw emp yft7 screen f3.emp
       // {

        try {
            con1 connect = new con1();
            String query = "SELECT * FROM admins ";
            ResultSet result=connect.displayData_db(query);
            while (result.next()){
                if (txtf_f2_userName.getText().equalsIgnoreCase(result.getString("name"))){
                    if(txtf_f2_userPassword.getText().equalsIgnoreCase(result.getString("password"))){
                        try {
                            System.out.println("btn LOGIN pressed successively  ");
                            Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/f3-Admin.fxml"));
                            Scene loginScene = new Scene(loginParent);
                            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            login_stage.setScene(loginScene);
                            login_stage.show();
                        }catch (Exception f){
                            System.out.println(f);
                        }
                    }
                    else{
                        System.out.println("password erorr");
                    }
                } }
                    query ="select * from employees";
                    result=connect.displayData_db(query);
                    while (result.next()){
                        if (txtf_f2_userName.getText().equalsIgnoreCase(result.getString("name"))){
                            if(txtf_f2_userPassword.getText().equalsIgnoreCase(result.getString("password"))){
                                try {
                                    System.out.println("btn LOGIN pressed successively  ");
                                    Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/fxmlFiles/f3-Emp.fxml"));
                                    Scene loginScene = new Scene(loginParent);
                                    Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    login_stage.setScene(loginScene);
                                    login_stage.show();
                                }catch (Exception f){
                                    System.out.println(f);
                                }
                            }
                            else{
                                System.out.println("password erorr");
                            }

                        }

                    }



        }
        catch (SQLException e){
            e.getMessage();
        }

     }}
//   /GUI/fxmlFiles/f3-Admin.fxml
//   /GUI/Admin/f3Admin.fxml


//        try {
//            System.out.println("btn LOGIN pressed successively ");
//            Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/emp/f3-Emp.fxml"));
//            Scene loginScene = new Scene(loginParent);
//            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            login_stage.setScene(loginScene);
//            login_stage.show();
//        }catch (Exception f){
//            System.out.println(f);
//        }
//    }


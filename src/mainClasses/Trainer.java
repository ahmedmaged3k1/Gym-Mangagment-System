package mainClasses;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mainClasses.con1.close_connection;

public class Trainer {

    private String name;
    private int age;
    private int id;
    private String phone_number;
    private String email;
    private String gender;

    public Trainer(int id, String name, String email, String gender, String phone_number, int age) {

        this.name = name;
        this.age = age;
        this.id = id;
        this.phone_number = phone_number;
        this.email = email;
        this.gender = gender;

    }

    public Trainer() {
    }



    //                getters and setters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    //                  methods

    public void Add_trainer() {
        try {
            con1 connectNow;
            connectNow = new con1();
            System.out.println("function adds the new trainer data to database IS RUNNING ...... ");

            String query;
            PreparedStatement pre_statement;
            query = "INSERT INTO TRAINER (id, name, age,email,phone_number , gender) " +
                    "VALUES (?,?,?,?,?,?)";

            pre_statement = connectNow.getCon1().prepareStatement(query);
            pre_statement.setInt(1, getId());
            pre_statement.setString(2, getName());
            pre_statement.setInt(3, getAge());
            pre_statement.setString(4, getEmail());
            pre_statement.setString(5, getPhone_number());
            pre_statement.setString(6, getGender());
            int result = pre_statement.executeUpdate();
            System.out.println(result + "records inserted");


        } catch (Exception x) {
            System.out.println(x);
        }


    }

    public void Edit_trainer() {

    }

    public static void Delete_trainer(int trainerId) {
        try {

            con1 connection = new con1();
            int rs = connection.alterData_db("DELETE FROM trainer WHERE id=" + trainerId);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Deleting Trainee from database process is successful ");
            alert.showAndWait();

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText("ERROR MESSAGE !");
            alert.showAndWait();
            alert.setContentText(e.getMessage());
        } finally {
            try {
                close_connection();
            } catch (SQLException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message");
                alert.setHeaderText("Error in closing connection ! ");
                alert.setContentText(e.getMessage());
                alert.showAndWait();

                System.out.println(e);

            }
        }
    }

    public static ResultSet Display_specific_trainer_basedOn_id(int trainerid) throws SQLException {

        con1 connectNow;
        connectNow = new con1();
        System.out.println("function displays  trainer name to database IS RUNNING ...... ");
        String query;
        PreparedStatement pre_statement;
        query = "Select name From TRAINER  ";
        ResultSet rs = connectNow.displayData_db(query);
        return rs;

    }

    public  static void Assign_trainer_member(int trainer_id,int member_id ) throws SQLException {

        try {
            con1 connect=new con1();
            String query="insert into member_trainer(trainer_id,member_id)" +
                    "values("+ trainer_id+","+member_id+")";
            int rs=connect.alterData_db(query);


            System.out.println(rs + "records inserted");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Assigning  member to Trainer  process is successful ! ");
            alert.showAndWait();

        }
        catch (SQLException e ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message" );
            alert.setHeaderText("ERROR MESSAGE !");
            alert.showAndWait();
            alert.setContentText(e.getMessage());

        }
        finally {
            try {
                con1.commit_method();
                con1.close_connection();
            }
            catch (SQLException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message" );
                alert.setHeaderText("ERROR MESSAGE !");
                alert.showAndWait();
                alert.setContentText(e.getMessage());

            }
        }
    };



    public static boolean Check_id(int checkId) throws SQLException {

        boolean isValid = false;
        con1 connect = new con1();
        String query;
        query = "Select count(*) from TRAINER WHERE id='" + checkId + "'";
        ResultSet rs = connect.displayData_db(query);
        while (rs.next()) {
            if (rs.getInt(1) == 1) {
                isValid = true;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }
}



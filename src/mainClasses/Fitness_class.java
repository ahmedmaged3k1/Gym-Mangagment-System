package mainClasses;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Fitness_class {

    private String name;
    private int id;
    private String time;
    private String date;
    private int capacity;
    private String type;

    protected SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");

    public Fitness_class() {
        System.out.println("New Fitness_class is created ");
    }

    //creates new  fitness class
    public Fitness_class(String name, int id, String time, String date, int capacity, String type) throws SQLException {
        this.name = name;
        this.id = id;
        this.time = time;
        this.date = date;
        this.capacity = capacity;
        this.type = type;
    }


    public Fitness_class(int class_id) {
        this.id = class_id;
    }


// getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //methods

    public void Edit() {


    }

    public void Add() {
        try {
            con1 connection = new con1();
            System.out.println("function adds the new fitness class data to database IS RUNNING ...... ");


            String query = "INSERT INTO fitness_class( class_id , class_name , class_capacity , class_type , class_date ,class_time ) "
                    + "VALUES(" + this.id + "," + "'" + this.name + "'" + "," + this.capacity + "," + "'" + this.type + "'" + ","
                    + "'" + this.date + "'" + "," + "'" + this.time + "'  )";

            System.out.println(query);
            int result = connection.alterData_db(query);

            System.out.println(result + "row inserted");
            //alert ,process is successful
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Adding new fitness class process is successful ");
            alert.showAndWait();
        } catch (SQLException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(" Error : " + e);
            alert.showAndWait();

        } finally {
            try {
                con1.close_connection();
            } catch (SQLException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in closing connection ! ");
                alert.showAndWait();
                System.out.println(e);
            }
        }

    }

    public static ResultSet Display_members_in_class(int classId) throws SQLException {
        System.out.println("function displays   trainees   in a specific class  from database data IS RUNNING ...... ");

        con1 connectNow;
        connectNow = new con1();
        String query;
        query = "SELECT member_name , member_id  FROM class_member where class_id=  " + classId;         //execute query to display
        ResultSet result = connectNow.displayData_db(query);
        System.out.println("records shown");
        return result;

    }

    public static ResultSet Display_classes() throws SQLException {
        System.out.println("function displays  all classes  from database data IS RUNNING ...... ");

        con1 connectNow;
        connectNow = new con1();
        String query;
        query = "SELECT * from FITNESS_CLASS ";         //execute query to display
        ResultSet result = connectNow.displayData_db(query);
        System.out.println("records shown");
        return result;

    }

    public static void Add_members_in_class(int traineeId, int classId, String traineeName) {
        try {

            con1 connectNow;
            connectNow = new con1();
            System.out.println("function adds the new trainee   in a specific class  to database data IS RUNNING ...... ");

            String query;
            PreparedStatement pre_statement;
            query = "INSERT INTO class_member (member_id,member_name,class_id) VALUES (?,?,?)";
            pre_statement = connectNow.getCon1().prepareStatement(query);
            pre_statement.setInt(1, traineeId);
            pre_statement.setString(2, traineeName);
            pre_statement.setInt(3, classId);
            int result = pre_statement.executeUpdate();

            System.out.println(result + "records inserted");

        } catch (Exception x) {
            System.out.println(x);
        }


    }

    public static void Assign_Trainer_to_class(int trainerId, int classId, String trainerName, String classTime, String classDay) {
        try {

            con1 connectNow;
            connectNow = new con1();
            System.out.println("function adds (assign trainer to a specific class)  to database data IS RUNNING ...... ");

            String query;

            PreparedStatement pre_statement;
            query = "INSERT INTO trainer_class (trainer_id, trainer_name  , class_id , time , day ) VALUES (?,?,?,?,?)";
            pre_statement = connectNow.getCon1().prepareStatement(query);
            pre_statement.setInt(1, trainerId);
            pre_statement.setString(2, trainerName);
            pre_statement.setInt(3, classId);
            pre_statement.setString(4, classTime);
            pre_statement.setString(5, classDay);
            int result = pre_statement.executeUpdate();

            System.out.println(result + "records inserted");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Assigning  Trainer to class where class id= " + classId + " " + " process is successful ");
            alert.showAndWait();

        } catch (Exception x) {
            System.out.println(x);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText("ERROR MESSAGE !");
            alert.showAndWait();
            alert.setContentText(x.getMessage());
        } finally {
            try {
                con1.close_connection();
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

    public static void Remove_members_from_class(int traineeId, int classId) {
        try {

            con1 connectNow;
            connectNow = new con1();
            System.out.println("function adds the new trainee   in a specific class  to database data IS RUNNING ...... ");

            String query;
            PreparedStatement pre_statement;
            query = "DELETE FROM class_member WHERE member_id = ? AND class_id=?  ";
            pre_statement = connectNow.getCon1().prepareStatement(query);
            pre_statement.setInt(1, traineeId);
            pre_statement.setInt(2, classId);
            int result = pre_statement.executeUpdate();

            System.out.println(result + "records deleted");

        } catch (Exception x) {
            System.out.println(x);
        }

    }

    public static void class_delete(int id) {
        try {

            con1 connection = new con1();
            int rs = connection.alterData_db("DELETE FROM fitness_class WHERE class_id=" + id);
            System.out.println(rs);

            if (rs == 0) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Warning Dialog");
                alert1.setHeaderText("Altering data   process is unsuccessful ");
                alert1.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Deleting fitness class process is successful ");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     finally{
        try {
            con1.close_connection();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error in closing connection ! ");
            alert.showAndWait();
            System.out.println(e);
        }
    }

}

    public static String date_toString(Date d){

        SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");
        String s_dateToString=date_format.format(d);  //s means start date

        return s_dateToString;
    }

}

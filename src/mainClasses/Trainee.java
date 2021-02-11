package mainClasses;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mainClasses.con1.close_connection;

public class Trainee {

        private int id;
        private String name ;
        private String email;
        private String gender;
        private String phone_number ;
        private float height;
        private float weight;
        private int age;


        public Trainee(int id,String name) {

            this.id=id;
            this.name=name;
        }

        public Trainee(int id, String name, String email, String gender, String phone_number,
                       float height, float weight, int age)  {
                this.id = id;
                this.name = name;
                this.email = email;
                this.gender = gender;
                this.phone_number = phone_number;
                this.height = height;
                this.weight = weight;
                this.age = age;
        }

        //constructor
        public Trainee() {
                System.out.println("New Trainee is created ");
        }

    public Trainee(int id) {
            this.id=id;
    }

    public Trainee(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public Trainee(String name) {
        this.name = name;
        }


    //getters and setteres
        public String getName() {
                return name;
        }
        public int getAge() {
                return age;
        }
        public String getPhone_number() {
                return phone_number;
        }
        public float getHeight() {
                return height;
        }
        public float getWeight() {
                return weight;
        }
        public int getId() {
                return id;
        }
        public String getGender() {
                return gender;
        }
        public String getEmail() {
                return email;
        }
        public void setName(String name) {
                this.name = name;
        }
        public void setAge(int age) {
                this.age = age;
        }
        public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
        }
        public void setHeight(float height) {
                this.height = height;
        }
        public void setWeight(float weight) {
                this.weight = weight;
        }
        public void setId(int id) {
                this.id = id;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        public void setGender(String gender) {
                this.gender = gender;
        }



        // class methods
        public static ResultSet Display_info() throws SQLException {
                con1 connectNow=new con1();
                System.out.println("Functions displays trainees  data in table ");
                String query;
                query="SELECT  * FROM MEMBER ";

                ResultSet result=connectNow.displayData_db(query);
                System.out.println(result + "records shown");
                return result;
        }
        public void Edit_trainee(String altered_phone_number , String altered_email){

                if(altered_phone_number!= null) {
                        this.phone_number = altered_phone_number;
                }
                if(altered_email!= null){
                        this.email=altered_email;
                }


        }
//        public void Edit_member(String altered_email){       // cant overload two functions with same name and datatype and same no of parameters
//
//
//        }
        public void Edit_trainee(float altered_weight , float altered_height){
                if(altered_weight != 0 ) {
                        this.weight=altered_weight;
                }
                if(altered_height != 0 ) {
                        this.height = altered_weight;
                }


        }

        public void Add_trainee(){
                try {
                        con1 connectNow;
                        connectNow=new con1();
                        System.out.println("function adds the new trainee data to database IS RUNNING ...... ");


                        String query;
                        PreparedStatement pre_statement ;
                        query="INSERT INTO member(id, name, age,email,phone_number, height_cm, weight_kg, gender) " +
                                "VALUES (?,?,?,?,?,?,?,?)";

                        pre_statement =connectNow.getCon1().prepareStatement(query);

                        pre_statement.setInt(1,getId());
                        pre_statement.setString(2,getName());
                        pre_statement.setInt(3,getAge());
                        pre_statement.setString(4,getEmail());
                        pre_statement.setString(5,getPhone_number());
                        pre_statement.setDouble(6,getHeight());
                        pre_statement.setDouble(7,getWeight());
                        pre_statement.setString(8,getGender());
                        int result=pre_statement.executeUpdate();
                        System.out.println(result + "records inserted");


                } catch (Exception x){
                        System.out.println(x);
                }
        }

        public static void Delete_Trainee(int memberID){
                try {

                        con1 connection=new con1();
                        int rs=connection.alterData_db("DELETE FROM member WHERE id=" + memberID );
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Deleting Trainee from database process is successful ");
                        alert.showAndWait();

                } catch (SQLException e ){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.setTitle("Error Message" );
                        alert.setHeaderText("ERROR MESSAGE !");
                        alert.showAndWait();
                        alert.setContentText(e.getMessage());
                }
                finally {
                        try {
                                close_connection();
                        } catch (SQLException e){

                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.initStyle(StageStyle.UTILITY);
                                alert.setTitle("Error Message" );
                                alert.setHeaderText("Error in closing connection ! ");
                                alert.setContentText(e.getMessage());
                                alert.showAndWait();

                                System.out.println(e);

                        }
                }
        }

        public static boolean Check_id(int checkId) throws SQLException {

                boolean isValid=false;
                con1 connect=new con1();
                String query;
                query="Select count(*) from member WHERE id='" + checkId +  "'" ;
                ResultSet rs=connect.displayData_db(query);
                while(rs.next())
                {
                if(rs.getInt(1)==1){
                        isValid=true;
                }
                else
                { isValid=false; }
                }
                return  isValid;






        }

}




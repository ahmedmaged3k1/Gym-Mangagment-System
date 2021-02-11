
package GUI.Controllers.emp;

import mainClasses.con1;
import mainClasses.Trainee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Sample Skeleton for 'addEditDeleteMembers.fxml' Controller Class
 */


public class addDelMemController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TableView<Trainee> TraineeTable;

    @FXML // fx:id="tableColumn_emp_AddMembers_Name"
    private TableColumn<Trainee, String> tableColumn_emp_AddMembers_Name; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_ID"
    private TableColumn<Trainee, Integer> tableColumn_emp_addMembers_ID; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_age"
    private TableColumn<Trainee, Integer> tableColumn_emp_addMembers_age; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_PhoneNum"
    private TableColumn<Trainee, String> tableColumn_emp_addMembers_PhoneNum; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_weight"
    private TableColumn<Trainee, Float> tableColumn_emp_addMembers_weight; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_height"
    private TableColumn<Trainee, Float> tableColumn_emp_addMembers_height; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_email"
    private TableColumn<Trainee, String> tableColumn_emp_addMembers_email; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_emp_addMembers_gender"
    private TableColumn<Trainee, String> tableColumn_emp_addMembers_gender; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_name"
    private TextField txtf_emp_addMembers_name; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_age"
    private TextField txtf_emp_addMembers_age; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_phoneNo"
    private TextField txtf_emp_addMembers_phoneNo; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_height"
    private TextField txtf_emp_addMembers_height; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_weight"
    private TextField txtf_emp_addMembers_weight; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_id"
    private TextField txtf_emp_addMembers_id; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_emp_addMembers_email"
    private TextField txtf_emp_addMembers_email; // Value injected by FXMLLoader

    @FXML // fx:id="radiobtn_emp_addMembers_male"
    private RadioButton radiobtn_emp_addMembers_male; // Value injected by FXMLLoader

    @FXML // fx:id="radiobtn_emp_addMembers_female"
    private RadioButton radiobtn_emp_addMembers_female; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMembers_add"
    private Button btn_emp_addMembers_add; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMembers_edit"
    private Button btn_emp_addMembers_edit; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMembers_delete"
    private Button btn_emp_addMembers_delete; // Value injected by FXMLLoader

    @FXML // fx:id="btn_emp_addMembers_confirm"
    private Button btn_emp_addMembers_confirm; // Value injected by FXMLLoader
    @FXML
    private ToggleGroup Gender;



    @FXML
    ObservableList<Trainee> listview = FXCollections.observableArrayList();
    @FXML
    ObservableList<String> Gender_list = FXCollections.observableArrayList("Male" , "Female");


    @FXML
    void btn_ADD_isPressed(ActionEvent event) {
        try {
            System.out.println("ADD btn is pressed");

            boolean repeatedId;
            repeatedId=Trainee.Check_id(Integer.parseInt(txtf_emp_addMembers_id.getText()));
            if(repeatedId ){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Warning Message");
                alert.setHeaderText("ID is found in another Trainee");
                alert.setContentText("Cant add the same id to new trainee !" );
                alert.showAndWait();
                txtf_emp_addMembers_id.setText(null);
                return;
            }

            Trainee newTrainee = new Trainee();
            newTrainee.setName(txtf_emp_addMembers_name.getText());
            newTrainee.setPhone_number(txtf_emp_addMembers_phoneNo.getText());
            newTrainee.setId(Integer.parseInt(txtf_emp_addMembers_id.getText()));
            newTrainee.setAge(Integer.parseInt(txtf_emp_addMembers_age.getText()));
            newTrainee.setHeight(Float.valueOf(txtf_emp_addMembers_height.getText()));
            newTrainee.setWeight(Float.valueOf(txtf_emp_addMembers_weight.getText()));
            newTrainee.setEmail(txtf_emp_addMembers_email.getText());
            newTrainee.setGender(((RadioButton) Gender.getSelectedToggle()).getText());
            //   System.out.println(newTrainee.getGender());
            newTrainee.Add_trainee();
            TraineeTable.getItems().clear();
            initialize();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Please insert data in all Text fields ! " );
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

    }


    @FXML
    void btn_ConfirmBtn_pressed(ActionEvent x) throws Exception {

        con1.commit_method();
        setNull();
        Gender.setUserData(null);


    }

    @FXML
    void btn_edit_pressed(ActionEvent y) throws Exception{

        try {
            con1 connect = new con1();
            index = TraineeTable.getSelectionModel().getSelectedIndex();
            while(tableColumn_emp_addMembers_ID.getCellData(index).toString().equals( txtf_emp_addMembers_id.getText()) !=true )
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message" );
                alert.setHeaderText("ERROR MESSAGE ! You arenot obligated to change ID of an existing user .");
                alert.showAndWait();

                txtf_emp_addMembers_id.setText(tableColumn_emp_addMembers_ID.getCellData(index).toString());
            }

            String editedName = txtf_emp_addMembers_name.getText();
            String editedEmail = txtf_emp_addMembers_email.getText();
            String editedGender = ((RadioButton) Gender.getSelectedToggle()).getText();
            String editedPhone_number = txtf_emp_addMembers_phoneNo.getText();
            float editedHeight = Float.valueOf(txtf_emp_addMembers_height.getText());
            float editedWeight = Float.valueOf(txtf_emp_addMembers_weight.getText());
            int editedAge = Integer.parseInt(txtf_emp_addMembers_age.getText());

            String query;
            query = "UPDATE member set name='" + editedName + "',age='" + editedAge
                    + "',email='" + editedEmail + "',phone_number='" + editedPhone_number + "',weight_kg='"
                    + editedWeight + "',height_cm='" + editedHeight + "',gender='" + editedGender + "'"
                    + "WHERE ID=" + (tableColumn_emp_addMembers_ID.getCellData(index).toString());
            connect.alterData_db(query);


            TraineeTable.getItems().clear();
            initialize();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void btn_row_pressed(MouseEvent x) throws Exception {
        try{
            index=TraineeTable.getSelectionModel().getSelectedIndex();

            if(index>-1) {
                txtf_emp_addMembers_name.setText(tableColumn_emp_AddMembers_Name.getCellData(index));
                txtf_emp_addMembers_email.setText(tableColumn_emp_addMembers_email.getCellData(index));
                txtf_emp_addMembers_id.setText(String.valueOf(tableColumn_emp_addMembers_ID.getCellData(index)));
                txtf_emp_addMembers_age.setText(String.valueOf(tableColumn_emp_addMembers_age.getCellData(index)));
                txtf_emp_addMembers_phoneNo.setText(tableColumn_emp_addMembers_PhoneNum.getCellData(index));
                txtf_emp_addMembers_weight.setText(tableColumn_emp_addMembers_weight.getCellData(index).toString());
                txtf_emp_addMembers_height.setText(tableColumn_emp_addMembers_height.getCellData(index).toString());


                String editedGender = toString();
                String getGender = null;

                if (tableColumn_emp_addMembers_gender.getCellData(index).equals("Male")) {
                    radiobtn_emp_addMembers_male.setSelected(true);
                } else if (tableColumn_emp_addMembers_gender.getCellData(index).equals("Female")) {
                    radiobtn_emp_addMembers_female.setSelected(true);
                }

            }
        }catch (Exception e){System.out.println(e);}
    }

    @FXML
    void btn_delete_pressed(ActionEvent x) throws Exception {
        try{
            ButtonType buttonTypeOne=new ButtonType("Confirm");
            ButtonType buttonTypeCancel=new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Delete data");
            alert.setHeaderText("Are you sure you want to delete data , press ok to continue");
            alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeCancel );
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                Trainee.Delete_Trainee(Integer.parseInt(txtf_emp_addMembers_id.getText()));
                index = TraineeTable.getSelectionModel().getSelectedIndex();
                TraineeTable.getItems().remove(index);
                setNull();
            } else if (result.get() == buttonTypeCancel) {
                return;
            }

        }catch (Exception e){


            //Alert  object ;; warning
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Please insert/check Trainee Name and id !");
            alert.showAndWait();
            System.out.println(e);}


    }

    int index=-1;
    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

//        assert tableColumn_emp_AddMembers_Name != null : "fx:id=\"tableColumn_emp_AddMembers_Name\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_ID != null : "fx:id=\"tableColumn_emp_addMembers_ID\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_age != null : "fx:id=\"tableColumn_emp_addMembers_age\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_PhoneNum != null : "fx:id=\"tableColumn_emp_addMembers_PhoneNum\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_weight != null : "fx:id=\"tableColumn_emp_addMembers_weight\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_height != null : "fx:id=\"tableColumn_emp_addMembers_height\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_email != null : "fx:id=\"tableColumn_emp_addMembers_email\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
//        assert tableColumn_emp_addMembers_gender != null : "fx:id=\"tableColumn_emp_addMembers_gender\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_name != null : "fx:id=\"txtf_emp_addMembers_name\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_age != null : "fx:id=\"txtf_emp_addMembers_age\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_phoneNo != null : "fx:id=\"txtf_emp_addMembers_phoneNo\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_height != null : "fx:id=\"txtf_emp_addMembers_height\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_weight != null : "fx:id=\"txtf_emp_addMembers_weight\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_id != null : "fx:id=\"txtf_emp_addMembers_id\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert txtf_emp_addMembers_email != null : "fx:id=\"txtf_emp_addMembers_email\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert radiobtn_emp_addMembers_male != null : "fx:id=\"radiobtn_emp_addMembers_male\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert radiobtn_emp_addMembers_female != null : "fx:id=\"radiobtn_emp_addMembers_female\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert btn_emp_addMembers_add != null : "fx:id=\"btn_emp_addMembers_add\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert btn_emp_addMembers_edit != null : "fx:id=\"btn_emp_addMembers_edit\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert btn_emp_addMembers_delete != null : "fx:id=\"btn_emp_addMembers_delete\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert btn_emp_addMembers_confirm != null : "fx:id=\"btn_emp_addMembers_confirm\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";
        assert Gender_list != null : "fx:id=\"Gender_list\" was not injected: check your FXML file 'addEditDeleteMembers.fxml'.";

        //radiobtn_emp_addMembers_female.setToggleGroup(Gender);
       // radiobtn_emp_addMembers_male.setToggleGroup(Gender);
     //   radiobtn_emp_addMembers_male.setSelected(true);
        TraineeTable.setEditable(true);
        try {

            System.out.println("Functions displays trainees  data in table in a class ");
            con1 connect=new con1();
            String query="SELECT * FROM member ";//execute query to display
            ResultSet rs=connect.displayData_db(query);

            while (rs.next()) {
                listview.add(new Trainee(rs.getInt("ID"), rs.getString("NAME"),
                        rs.getString("EMAIL"), rs.getString("GENDER"), rs.getString("PHONE_NUMBER")
                        , rs.getFloat("HEIGHT_CM"), rs.getFloat("WEIGHT_KG"), rs.getInt("AGE")));
            }
            TraineeTable.setItems(listview);
        } catch (Exception e) {
            System.out.println(e);
        }

        tableColumn_emp_AddMembers_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumn_emp_addMembers_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumn_emp_addMembers_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumn_emp_addMembers_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableColumn_emp_addMembers_height.setCellValueFactory(new PropertyValueFactory<>("height"));
        tableColumn_emp_addMembers_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableColumn_emp_addMembers_PhoneNum.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        tableColumn_emp_addMembers_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }

    @FXML
    void setNull(){

        txtf_emp_addMembers_name.setText(null);
        txtf_emp_addMembers_email.setText (null);
        txtf_emp_addMembers_id.setText(null);
        txtf_emp_addMembers_age.setText(null);
        txtf_emp_addMembers_phoneNo.setText(null);
        txtf_emp_addMembers_weight.setText(null);
        txtf_emp_addMembers_height.setText(null);
        radiobtn_emp_addMembers_male.setSelected(true);
        radiobtn_emp_addMembers_female.setSelected(false);
    }
}




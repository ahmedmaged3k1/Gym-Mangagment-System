package GUI.Controllers.admin; /**
 * Sample Skeleton for 'editClass.fxml' Controller Class
 */

import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import mainClasses.Fitness_class;
import mainClasses.con1;

import java.net.URL;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class editClassController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtf_editClass_classid"
    private TextField txtf_editClass_classid; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_editClass_className"
    private TextField txtf_editClass_className; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_editClass_classDesc"
    private TextField txtf_editClass_classType; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_editClass_classDate"
    private DatePicker txtf_editClass_classDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_editClass_classCapacity"
    private TextField txtf_editClass_classCapacity; // Value injected by FXMLLoader

    @FXML // fx:id="btn_edit_editClass"
    private Button btn_edit_editClass; // Value injected by FXMLLoader

    @FXML // fx:id="txtf_editClass_classTime"
    private JFXTimePicker txtf_editClass_classTime; // Value injected by FXMLLoader

    @FXML // fx:id="btn_editClass_Confirm"
    private Button btn_editClass_Confirm; // Value injected by FXMLLoader

    @FXML // fx:id="btn_editclass_delete"
    private Button btn_editclass_delete; // Value injected by FXMLLoader

    @FXML
    private TableView<Fitness_class> tableView_EditClass;

    @FXML // fx:id="column_editClass_classid"
    private TableColumn<Fitness_class, Integer> column_editClass_classid; // Value injected by FXMLLoader

    @FXML // fx:id="column_editClass_className"
    private TableColumn<Fitness_class, String> column_editClass_className; // Value injected by FXMLLoader

    @FXML // fx:id="column_editClass_classDate"
    private TableColumn<Fitness_class, Date> column_editClass_classDate; // Value injected by FXMLLoader

    @FXML // fx:id="column_editClass_classTime"
    private TableColumn<Fitness_class, String> column_editClass_classTime; // Value injected by FXMLLoader

    @FXML // fx:id="column_editClass_classCapacity"
    private TableColumn<Fitness_class, Integer> column_editClass_classCapacity; // Value injected by FXMLLoader

    @FXML // fx:id="column_editClass_classType"
    private TableColumn<Fitness_class, String> column_editClass_classType; // Value injected by FXMLLoader

    @FXML
    protected DateTimeFormatter date_format =  DateTimeFormatter.ofPattern("dd MMM yy");

    @FXML
    ObservableList<Fitness_class> listview = FXCollections.observableArrayList();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");


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
                Fitness_class.class_delete(Integer.parseInt(txtf_editClass_classid.getText()));
                index = tableView_EditClass.getSelectionModel().getSelectedIndex();
                tableView_EditClass.getItems().remove(index);
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
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            System.out.println(e);
        }
    }

    @FXML
    void btn_edit_pressed(ActionEvent y) throws Exception{

        try {
            con1 connect = new con1();
            index = tableView_EditClass.getSelectionModel().getSelectedIndex();
            while(column_editClass_classid.getCellData(index).toString().equals( txtf_editClass_classid.getText()) !=true )
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error Message" );
                alert.setHeaderText("ERROR MESSAGE ! You arenot obligated to change ID of an existing class .");
                alert.showAndWait();
                txtf_editClass_classid.setText(column_editClass_classid.getCellData(index).toString());
            }

            String editedName = txtf_editClass_className.getText();
            String editedtype = txtf_editClass_classType.getText();
            int editedCapacity = Integer.parseInt(txtf_editClass_classCapacity.getText());
            String editedtime = String.valueOf(txtf_editClass_classTime.getValue());
            System.out.println(txtf_editClass_classDate.getValue());

            System.out.println(txtf_editClass_classTime.getValue());



            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
            String editedDate = (txtf_editClass_classDate.getValue()).format(formatter);

            System.out.println(editedDate);



         //   LocalDate date=txtf_editClass_classDate.getValue();
         //   Date editedDate;
         //    editedDate=new SimpleDateFormat("dd MMM yy").parse(String.valueOf(date));

            String query;
            query = "UPDATE FITNESS_CLASS set CLASS_NAME='" + editedName + "',CLASS_CAPACITY=" + editedCapacity
                    + ",class_type='" + editedtype + "',class_time='" + editedtime  + "',class_date='" + editedDate + "'"
                    + "WHERE CLASS_ID=" + (column_editClass_classid.getCellData(index).toString());
            connect.alterData_db(query);
            tableView_EditClass.getItems().clear();
            initialize();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    int index=-1;
    @FXML
    void btn_row_pressed(MouseEvent x) throws Exception {

        index=tableView_EditClass.getSelectionModel().getSelectedIndex();
        try{
            index=tableView_EditClass.getSelectionModel().getSelectedIndex();
            if(index>-1) {

                txtf_editClass_classid.setText(String.valueOf(column_editClass_classid.getCellData(index)));
                txtf_editClass_className.setText(column_editClass_className.getCellData(index));
                txtf_editClass_classCapacity.setText(column_editClass_classCapacity.getCellData(index).toString());
                txtf_editClass_classType.setText(column_editClass_classType.getCellData(index));
              //  txtf_editClass_classTime.setValue(time);
              //  txtf_editClass_classDate.setValue(date);
                //  txtf_editClass_classDate.setValue(LocalDate.parse(column_editClass_classDate.getCellData(index).toString(),date_format));
                //  txtf_editClass_classTime.setValue(LocalTime.parse(column_editClass_classTime.getCellData(index),dtf));
            }
        }catch (Exception e){System.out.println(e);}
    }


    @FXML
    void view(){
        int classId=0;

        clearTable();
        try {
            classId=Integer.parseInt(txtf_editClass_classid.getText());
            if(classId==0)
            {
                classId=Integer.parseInt(txtf_editClass_classid.getText());
            }else {
                System.out.println("This Function displays class data whose ID= " + classId + " in table in a class ");
                ResultSet rs = Fitness_class.Display_classes();
                while (rs.next()) {

                    listview.add(new Fitness_class(rs.getString("class_name"), rs.getInt("class_id"),
                            rs.getString("class_time"),rs.getString("class_date"),rs.getInt("class_capacity"),
                            rs.getString("class_type")));
                    System.out.println(rs.getString("class_name") + rs.getInt("class_id"));
                }

                tableView_EditClass.setItems(listview);
                initialize();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void btn_ConfirmBtn_pressed(ActionEvent x)  {
        try {
            con1.commit_method();

            //Alert  object ;; info
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Information Message");
            alert.setHeaderText("Classes' changes are commited successively in database ");
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
        assert txtf_editClass_classid != null : "fx:id=\"txtf_editClass_classid\" was not injected: check your FXML file 'editClass.fxml'.";
        assert txtf_editClass_className != null : "fx:id=\"txtf_editClass_className\" was not injected: check your FXML file 'editClass.fxml'.";
        assert txtf_editClass_classDate != null : "fx:id=\"txtf_editClass_classDate\" was not injected: check your FXML file 'editClass.fxml'.";
        assert txtf_editClass_classCapacity != null : "fx:id=\"txtf_editClass_classCapacity\" was not injected: check your FXML file 'editClass.fxml'.";
        assert btn_edit_editClass != null : "fx:id=\"btn_edit_editClass\" was not injected: check your FXML file 'editClass.fxml'.";
        assert txtf_editClass_classTime != null : "fx:id=\"txtf_editClass_classTime\" was not injected: check your FXML file 'editClass.fxml'.";
        assert btn_editClass_Confirm != null : "fx:id=\"btn_editClass_Confirm\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_classid != null : "fx:id=\"column_editClass_classid\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_className != null : "fx:id=\"column_editClass_className\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_classDate != null : "fx:id=\"column_editClass_classDate\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_classTime != null : "fx:id=\"column_editClass_classTime\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_classCapacity != null : "fx:id=\"column_editClass_classCapacity\" was not injected: check your FXML file 'editClass.fxml'.";
        assert column_editClass_classType != null : "fx:id=\"column_editClass_classType\" was not injected: check your FXML file 'editClass.fxml'.";


        try {

            System.out.println("This Function displays classes data  i");
            ResultSet rs = Fitness_class.Display_classes();
            while (rs.next()) {

                listview.add(new Fitness_class(rs.getString("class_name"), rs.getInt("class_id"),
                        rs.getString("class_time"),rs.getString("class_date"),rs.getInt("class_capacity"),
                        rs.getString("class_type")));
                System.out.println(rs.getString("class_name") + rs.getInt("class_id"));
            }
            column_editClass_className.setCellValueFactory(new PropertyValueFactory<>("name"));
            column_editClass_classid.setCellValueFactory(new PropertyValueFactory<>("id"));
            column_editClass_classDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            column_editClass_classTime.setCellValueFactory(new PropertyValueFactory<>("time"));
            column_editClass_classCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
            column_editClass_classType.setCellValueFactory(new PropertyValueFactory<>("type"));
            tableView_EditClass.setItems(listview);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void clearTable(){
        tableView_EditClass.getItems().clear();
    }

    @FXML
    void setNull(){

        txtf_editClass_className.setText(null);
        txtf_editClass_classid.setText (null);
        txtf_editClass_className.setText(null);
        txtf_editClass_classType.setText(null);
        txtf_editClass_classCapacity.setText(null);
        txtf_editClass_classTime.setValue(null);
        txtf_editClass_classDate.setValue(null);

    }
}

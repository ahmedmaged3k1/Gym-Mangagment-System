package GUI.Controllers.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Fitness_class;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 * Sample Skeleton for 'viewClasses.fxml' Controller Class
 */


public class viewClassesController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TableView<Fitness_class> tableView_allClasses;

    @FXML
    private TableColumn<Fitness_class, Integer>  tableColoumn_admin_viewAllClasses_ID;

    @FXML
    private TableColumn<Fitness_class, String>  tableColoumn_admin_viewAllClasses_name;

    @FXML
    private TableColumn<Fitness_class, String> tableColumn_admin_viewAllClasses_date;

    @FXML // fx:id="column_editClass_classTime"
    private TableColumn<Fitness_class, String> tableColumn_admin_viewAllClasses_time;

    @FXML // fx:id="column_editClass_classCapacity"
    private TableColumn<Fitness_class, Integer> tableColumn_admin_viewAllClasses_capacity;

    @FXML // fx:id="column_editClass_classType"
    private TableColumn<Fitness_class, String>  tableColumn_admin_viewAllClasses_type;

    @FXML // fx:id="btn_viewClass_viewAllclasses"
    private Button btn_viewClass_viewAllclasses; // Value injected by FXMLLoader

    @FXML
    ObservableList<Fitness_class> allClassesList = FXCollections.observableArrayList();
//----------------------------------------------------------------------------------------------------------------------


    @FXML
    void btn_viewAllClasses_pressed(){

    }





















    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tableView_allClasses != null : "fx:id=\"tableView_allClasses\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColoumn_admin_viewAllClasses_ID != null : "fx:id=\"tableColoumn_admin_viewAllClasses_ID\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColoumn_admin_viewAllClasses_name != null : "fx:id=\"tableColoumn_admin_viewAllClasses_name\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColumn_admin_viewAllClasses_date != null : "fx:id=\"tableColumn_admin_viewAllClasses_date\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColumn_admin_viewAllClasses_time != null : "fx:id=\"tableColumn_admin_viewAllClasses_time\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColumn_admin_viewAllClasses_capacity != null : "fx:id=\"tableColumn_admin_viewAllClasses_capacity\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert tableColumn_admin_viewAllClasses_type != null : "fx:id=\"tableColumn_admin_viewAllClasses_type\" was not injected: check your FXML file 'viewClasses.fxml'.";
        assert btn_viewClass_viewAllclasses != null : "fx:id=\"btn_viewClass_viewAllclasses\" was not injected: check your FXML file 'viewClasses.fxml'.";



        try {
            System.out.println("Functions displays ALL CLASSES DATA in A table ");
            ResultSet rs= Fitness_class.Display_classes();

// public Fitness_class(String name, int id, String time, String date, int capacity, String type)
            while (rs.next()) {
                allClassesList.add(new Fitness_class(rs.getString("CLASS_NAME"),rs.getInt("CLASS_ID"),
                        rs.getString("CLASS_TIME"), rs.getString("CLASS_DATE"),
                        rs.getInt("CLASS_CAPACITY"),rs.getString("CLASS_type")));
            }


        } catch (Exception e) { System.out.println(e); }

        tableColoumn_admin_viewAllClasses_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColoumn_admin_viewAllClasses_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumn_admin_viewAllClasses_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableColumn_admin_viewAllClasses_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableColumn_admin_viewAllClasses_capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        tableColumn_admin_viewAllClasses_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView_allClasses.setItems(allClassesList);
    }
}

package com.example.crud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button BtnThem;

    @FXML
    private TableColumn<Student, String> EmailColumn;

    @FXML
    private TableColumn<Student, Button> BtnDleColumn;

    @FXML
    private TableColumn<Student, String> DiaChiColumn;

    @FXML
    private TableColumn<Student, Button> BtnEditColumn;



    @FXML
    private TableView<Student> tableView;

    public TableView<Student> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Student> tableView) {
        this.tableView = tableView;
    }



    public TableView getTable(){
        return tableView;
    }

    @FXML
    private TableColumn<Student, String> HoTenColumn;

    @FXML
    private TableColumn<Student, String> MSSVColumn;


    @FXML
    private TableColumn<Student, String> DienThoaiColumn;

    @FXML
    private TableColumn<Student, Button> BtnViewColumn;

    private Map<String,Student> stu = new HashMap<String,Student>();


    private Button BtnDle = new Button("Delete");
    private Button BtnEdit = new Button("Edit");
    private Button BtnView = new Button("View");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //stu.put(1, new Student("B1807644","Linh","Can Tho","linh@gamil.com","3213213","2222","222"));
        //stu.put("2", new Student("B1807644","Linh2","Can Tho","linh@gamil.com","3213213","2222","222"));

        Student student = new Student();

        student.setHoTen("Linh");
        student.setMSSV("B1807644");
        student.setDiaChi("Can Tho");
        student.setEmail("linh@gamil.com");
        student.setDienThoai("3213213");
        student.setDate("2222");
        student.setCMND("2222");
        student.setBtnView(BtnView);
        student.setBtnEdit(BtnEdit);
        student.setBtnDle(BtnDle);

        stu.put("1",student);
        Student stuGet = stu.get("1");
        tableView.getItems().add(stuGet);



        //Xem chi tiet
        BtnView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("s_view.fxml"));
                    Parent sampleParent = loader.load();
                    ViewController controller = loader.getController();
//                    controller.get();
                    controller.viewStudent(stuGet);
                    Scene scene = new Scene(sampleParent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //Xoa
        BtnDle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("TEST ALERT");
                alert.setHeaderText("Bạn có chắc muốn xóa sinh viên: "+student.getHoTen()+" ?");

                ButtonType btT1 = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType btT2 = new ButtonType("No",ButtonBar.ButtonData.NO);

                alert.getButtonTypes().setAll(btT1,btT2);
                Optional<ButtonType> result = alert.showAndWait();

                if(result.get().getButtonData()==ButtonBar.ButtonData.YES){
                    //Student selectedItem = tableView.getSelectionModel().getSelectedItem();
                    tableView.getItems().remove(stuGet);
                }
            }
        });

        BtnDle.setOnMouseClicked((MouseEvent event)->{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("TEST ALERT");
            alert.setHeaderText("Bạn có chắc muốn xóa sinh viên: "+student.getHoTen()+" ?");

            ButtonType btT1 = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType btT2 = new ButtonType("No",ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(btT1,btT2);
            Optional<ButtonType> result = alert.showAndWait();

            if(result.get().getButtonData()==ButtonBar.ButtonData.YES){
                //Student selectedItem = tableView.getSelectionModel().getSelectedItem();
                tableView.getItems().remove(stuGet);
            }
        });




        MSSVColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("MSSV"));
        HoTenColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("HoTen"));
        DiaChiColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("DiaChi"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));
        DienThoaiColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("DienThoai"));
        BtnDleColumn.setCellValueFactory(new PropertyValueFactory<Student,Button>("BtnDle"));
        BtnEditColumn.setCellValueFactory(new PropertyValueFactory<Student,Button>("BtnEdit"));
        BtnViewColumn.setCellValueFactory(new PropertyValueFactory<Student,Button>("BtnView"));


    }







    public void sceneCreate(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("s_create.fxml"));
        Parent sampleParent = loader.load();
        //CreateController controller = loader.getController();
        //Student student = new Student();
        //controller.setStudent(student);

        //Map<Integer,Student> stu = new HashMap<Integer,Student>();
        //tableView.getItems().add( stu.put(1,student));

        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
        stage.show();
    }

    public void addStudent(Student student1){

        stu.put("1", student1);
        Student stuGet = stu.get("1");
        tableView.getItems().add(stuGet);
        //System.out.println(tableView.toString());

    }

    public void xoaCreate(Student student){
        tableView.getItems().remove(student);
        System.out.println(student);
    }




}
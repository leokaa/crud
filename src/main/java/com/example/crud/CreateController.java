package com.example.crud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class CreateController {

    @FXML
    private TextField GetSDT;

    @FXML
    private TextField GetCMND;

    @FXML
    private TextField GetHoTen;

    @FXML
    private TextField GetMSSV;

    @FXML
    private TextField GetNgaySinh;

    @FXML
    private TextField GetEmail;

    @FXML
    private TextField GetDiaChi;


    @FXML
    public void addStudent(ActionEvent event) throws IOException {

        Student student = new Student();
        TableView<Student> tableView = new TableView<>();

        Button BtnDle = new Button("Delete");
        Button BtnEdit = new Button("Edit");
        Button BtnView = new Button("View");

        student.setHoTen(GetHoTen.getText());
        student.setMSSV(GetMSSV.getText());
        student.setDiaChi(GetDiaChi.getText());
        student.setEmail(GetEmail.getText());
        student.setDienThoai(GetSDT.getText());
        student.setDate(GetNgaySinh.getText());
        student.setCMND(GetCMND.getText());


        student.setBtnView(BtnView);
        student.setBtnEdit(BtnEdit);
        student.setBtnDle(BtnDle);

        Map<Integer,Student> stu = new HashMap<Integer,Student>();
        stu.put(1,student);
        Student stuGet = stu.get(1);

        BtnView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("s_view.fxml"));
                    Parent sampleParent = loader.load();
                    ViewController controller = loader.getController();
                    //controller.get();
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
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("tableView.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        });


        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tableView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HelloController controller = loader.getController();

        controller.addStudent(student);
        stage.setScene(scene);
    }


}

package com.example.crud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController {
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
    private Button BtnTroVe;

    @FXML
    private Button BtnAdd;

    public void viewStudent(Student student){
        GetHoTen.setText(String.valueOf(student.getHoTen()));
        GetMSSV.setText(String.valueOf(student.getMSSV()));
        GetDiaChi.setText(String.valueOf(student.getDiaChi()));
        GetEmail.setText(String.valueOf(student.getEmail()));
        GetSDT.setText(String.valueOf(student.getDienThoai()));
        GetNgaySinh.setText(String.valueOf(student.getDate()));
        GetCMND.setText(String.valueOf(student.getCMND()));
    }

    public void editStudent(Student student){


    }

    @FXML
    public void editStudent(ActionEvent event) throws IOException {
        Student student = new Student();

        Button BtnDle = new Button("Delete");
        Button BtnEdit = new Button("Edit");
        Button BtnView = new Button("View");

        student.setBtnView(BtnView);
        student.setBtnEdit(BtnEdit);
        student.setBtnDle(BtnDle);
        student.setHoTen(GetHoTen.getText());
        student.setMSSV(GetMSSV.getText());
        student.setDiaChi(GetDiaChi.getText());
        student.setEmail(GetEmail.getText());
        student.setDienThoai(GetSDT.getText());
        student.setDate(GetNgaySinh.getText());
        student.setCMND(GetCMND.getText());

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tableView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HelloController controller = loader.getController();
        controller.addStudent(student);
        stage.setScene(scene);
    }

    public void TroVe(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tableView.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
        stage.show();
    }
}

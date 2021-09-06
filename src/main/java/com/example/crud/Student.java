package com.example.crud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Student {


    private Student student;

    private String MSSV;
    private String DiaChi;
    private String HoTen;
    private String Email;
    private String DienThoai;

    private String Date;
    private String CMND;

    private Button BtnDle;
    private Button BtnEdit;
    private Button BtnView;


    public Student(String MSSV, String diaChi, String hoTen, String email, String dienThoai, String date, String CMND) {
        this.MSSV = MSSV;
        this.DiaChi = diaChi;
        this.HoTen = hoTen;
        this.Email = email;
        this.DienThoai = dienThoai;
        this.Date = date;
        this.CMND = CMND;
        BtnView = new Button("View");
        BtnEdit = new Button("Edit");
        BtnDle = new Button("Delete");
    }

    public Student() {

    }



    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Button getBtnDle() {
        return BtnDle;
    }

    public void setBtnDle(Button btnDle) {
        BtnDle = btnDle;
    }

    public Button getBtnEdit() {
        return BtnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        BtnEdit = btnEdit;
    }

    public Button getBtnView() {
        return BtnView;
    }

    public void setBtnView(Button btnView) {
        BtnView = btnView;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student=" + student +
                ", MSSV='" + MSSV + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", Email='" + Email + '\'' +
                ", DienThoai='" + DienThoai + '\'' +
                ", Date='" + Date + '\'' +
                ", CMND='" + CMND + '\'' +
                ", BtnDle=" + BtnDle +
                ", BtnEdit=" + BtnEdit +
                ", BtnView=" + BtnView +
                '}';
    }
}


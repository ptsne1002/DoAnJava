/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Nhanvien implements  Serializable{
    private String Manv;
    private String Tennv;
    private String Diachi;
    private String Sodienthoai;
    private Date Ngaysinh;
    private boolean Gioitinh;
    private String CMND;
    private String Quequan;
    private String Dantoc;
    private String Macv;
    private String Mapb;

    public Nhanvien() {
    }

    public Nhanvien(String Manv, String Tennv, String Diachi, String Sodienthoai, Date Ngaysinh, boolean Gioitinh, String CMND, String Quequan, String Dantoc, String Macv, String Mapb) {
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Diachi = Diachi;
        this.Sodienthoai = Sodienthoai;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.CMND = CMND;
        this.Quequan = Quequan;
        this.Dantoc = Dantoc;
        this.Macv = Macv;
        this.Mapb = Mapb;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public String getDantoc() {
        return Dantoc;
    }

    public void setDantoc(String Dantoc) {
        this.Dantoc = Dantoc;
    }

    public String getMacv() {
        return Macv;
    }

    public void setMacv(String Macv) {
        this.Macv = Macv;
    }

    public String getMapb() {
        return Mapb;
    }

    public void setMapb(String Mapb) {
        this.Mapb = Mapb;
    }
}

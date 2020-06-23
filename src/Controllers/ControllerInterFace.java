/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Account;
import Models.Chucvu;
import Models.Nhanvien;
import Models.Phongban;
import Models.QuanlyDBContext;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ControllerInterFace {
    //account
     ArrayList<Account> login (ArrayList<Account>list);
     Account GetAccount(Account ac);
     void AddAccount (ArrayList<Account>list);
     void UpdateAccount (ArrayList<Account>list);
     void DeleteAccount (ArrayList<Account>list);
    
    
    //ChucVu
     ArrayList<Chucvu> GetAllChucVu (ArrayList<Chucvu>list);
     Chucvu GetChucVu (Chucvu cv);
     void AddChucVu (ArrayList<Chucvu>list);
     void UpdateChucVu (ArrayList<Chucvu>list);
     void DeleteChucVu (ArrayList<Chucvu>list);
     
     
     
    //NhanVien
     ArrayList<Nhanvien> GetAllNhanVien (ArrayList<Nhanvien>list);
     Nhanvien GetNhanvien (Nhanvien nv);
     void AddNhanVien (ArrayList<Nhanvien>list);
     void UpdateNhanVien (ArrayList<Nhanvien>list);
     void DeleteNhanVien (ArrayList<Nhanvien>list);
     
     
    //PhongBan
     ArrayList<Phongban> GetAllPhongBan (ArrayList<Phongban>list);
     void AddPhongBan (ArrayList<Phongban>list);
     Phongban GetPhongban (Phongban pb);
     void UpdatePhongBan (ArrayList<Phongban>list);
     void DeletePhongBan (ArrayList<Phongban>list);
    
    
    // XuatFile
     <T> void WriteToFile(ArrayList<T>list,String PathName);
     
     //truy vấn 
    // <T> ArrayList 
}

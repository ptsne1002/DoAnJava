/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Account implements  Serializable {
    private String UserName;

    public Account() {
    }

    public Account(String UserName, String Password, String Permisstion, String Manv) {
        this.UserName = UserName;
        this.Password = Password;
        this.Permisstion = Permisstion;
        this.Manv = Manv;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPermisstion() {
        return Permisstion;
    }

    public void setPermisstion(String Permisstion) {
        this.Permisstion = Permisstion;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }
    private String Password;
    private String Permisstion;
    private String Manv;
}

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
public class Chucvu implements  Serializable{
    private String Macv;

    public String getMacv() {
        return Macv;
    }

    public void setMacv(String Macv) {
        this.Macv = Macv;
    }

    public String getTencv() {
        return Tencv;
    }

    public void setTencv(String Tencv) {
        this.Tencv = Tencv;
    }

    public Chucvu() {
    }

    public Chucvu(String Macv, String Tencv) {
        this.Macv = Macv;
        this.Tencv = Tencv;
    }
    private String Tencv;
}

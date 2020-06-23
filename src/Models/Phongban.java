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
public class Phongban implements  Serializable{
    private String Mapb;

    public Phongban() {
    }

    public Phongban(String Mapb, String Tenpb, String Truongphong) {
        this.Mapb = Mapb;
        this.Tenpb = Tenpb;
        this.Truongphong = Truongphong;
    }
    private String Tenpb;
    private String Truongphong;

    public String getMapb() {
        return Mapb;
    }

    public void setMapb(String Mapb) {
        this.Mapb = Mapb;
    }

    public String getTenpb() {
        return Tenpb;
    }

    public void setTenpb(String Tenpb) {
        this.Tenpb = Tenpb;
    }

    public String getTruongphong() {
        return Truongphong;
    }

    public void setTruongphong(String Truongphong) {
        this.Truongphong = Truongphong;
    }
}

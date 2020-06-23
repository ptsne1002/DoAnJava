/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class ConnnectiontoMySql {
    public static Connection GetConnection() 
    {
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/ctyuit2";
            String Username = "root";
            String Password = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnnectiontoMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = (Connection) DriverManager.getConnection(url,Username,Password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnnectiontoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DELL
 */
public class QuanlyDBContext {
    public static ArrayList<Account> GetAllAccounts(Connection con){
        ArrayList<Account> list = new ArrayList();
        String sqlString = "Select * from Account";
        try {
            Statement stmt = (Statement)con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(sqlString);
            while (rs.next()) {    
                Account ac = new Account();
                ac.setUserName(rs.getString(("UserName")));
                ac.setPassword(rs.getString(("Pass")));
                ac.setPermisstion(rs.getString(("permission")));
                ac.setManv(rs.getString(("Manv")));
                list.add(ac);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        QuanlyDBContext context;
        ArrayList<Account>ls= GetAllAccounts(ConnnectiontoMySql.GetConnection());
        for(var x: ls)
        {
            System.out.println(x.getManv());
        }
    }
}

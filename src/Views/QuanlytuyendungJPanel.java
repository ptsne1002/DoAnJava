/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.TextPrompt;
import Models.CaTruc;
import Models.ConnnectiontoMySql;
import static Views.main.a;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.LayoutManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */


public class QuanlytuyendungJPanel extends javax.swing.JPanel {
    private  TextPrompt p;
    private  ArrayList<CaTruc> dsct = new ArrayList<CaTruc>();
    private Connection con = ConnnectiontoMySql.GetConnection();
    private DefaultTableModel tblModel;
    public static JDialog dialog = new JDialog(a,"Nhập Thông Tin",true);
    public static nhapthongtincatrucJPanel infoJPanel = new nhapthongtincatrucJPanel();
    /**
     * Creates new form NewJPanel6
     * @return 
     */
    
    public ArrayList<CaTruc> GetListCaTruc()
    {
        ArrayList<CaTruc> d = new ArrayList<>();
        String query= "SELECT nv.manv , nv.ten , ct.tencv,ct.nhiemvu , ct.khuvuc , ct.catruc FROM nhanvien nv, catruc ct where ct.manv = nv.manv";
        try {
            Statement st = (Statement) con.createStatement();
            
            ResultSet rs = (ResultSet) st.executeQuery(query);
            while(rs.next())
            {
                CaTruc a = new CaTruc();
               a.setMaNV(rs.getString("manv"));
               a.setTenNV(rs.getString("ten"));
               a.setTenCV(rs.getString("tencv"));
               a.setNhiemVu(rs.getString("nhiemvu"));
               a.setKhuVuc(rs.getString("khuvuc"));
               a.setCaTruc(rs.getString("catruc"));
               d.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlytuyendungJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d;
    }
    
    public void adddatatoTable()
    {
        dsct.clear();
        dsct = GetListCaTruc();
        for(int i = 0 ; i < dsct.size() ; i++)
        {
            String[] Row = new String[6];
            Row[0] = dsct.get(i).getMaNV();
            Row[1] = dsct.get(i).getTenNV();
            Row[2] = dsct.get(i).getTenCV();
            Row[3] = dsct.get(i).getNhiemVu();
            Row[4] = dsct.get(i).getKhuVuc();
            Row[5] = dsct.get(i).getCaTruc();
            //tblCaTruc.addColumn(Row);
            tblModel.addRow(Row);
//           tblCaTruc.isCellEditable(i, 0);
//           tblCaTruc.isCellEditable(i, 1);
        }
//        for(int i = 0 ; i <dsct.size(); i++)
//         {
//            
//         }
    }
    
    public void DeleTeCaTruc()
    {
        int row =0 ;
        int colum = 0;
        int k= 0;
        row = tblCaTruc.getSelectedRow();
        if(row != -1)
        {
        String a = tblCaTruc.getValueAt(row, 0).toString();
        try {
            String sql = "delete from catruc where manv = '"+a+"'";
            Statement st = (Statement) con.createStatement();
             k = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QuanlytuyendungJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(k >0)
        {
            JOptionPane.showMessageDialog(null,"Delete Successful !", "Notifical", JOptionPane.INFORMATION_MESSAGE);
            tblModel.setRowCount(0);
            adddatatoTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Delete Fail !","Notifical", JOptionPane.INFORMATION_MESSAGE);
            tblModel.setRowCount(0);
            adddatatoTable();
            }
        }
    }
    
     public void TaoBang()
     {
         String tieude[] = {"Mã Nhân Viên","Tên Nhân Viên","Tên Công Việc","Nhiệm Vụ","Khu Vực","Ca Trực"};
         tblModel = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int colum) {
                 super.isCellEditable(row, colum); //To change body of generated methods, choose Tools | Templates.
                 if(colum ==0 ||colum == 1)
                 {
                    return false;
                 }
                 return true;
             }
             
         };
         tblModel.setColumnIdentifiers(tieude);
         tblCaTruc.setModel(tblModel);
         tblCaTruc.setVisible(true);
         
         adddatatoTable();
     }

    public QuanlytuyendungJPanel(TextPrompt p, JButton btnLamMoi, JButton btnSuaCaTruc, JButton btnThemCaTruc, JButton btnXoaCaTruc, JLabel jLabel1, JLabel jLabel2, JScrollPane jScrollPane1, JTable tblCaTruc, JTextField txtTimCaTruc, LayoutManager layout) {
        super(layout);
        this.p = p;
        this.btnLamMoi = btnLamMoi;
        this.btnSuaCaTruc = btnSuaCaTruc;
        this.btnThemCaTruc = btnThemCaTruc;
        this.btnXoaCaTruc = btnXoaCaTruc;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jScrollPane1 = jScrollPane1;
        this.tblCaTruc = tblCaTruc;
        this.txtTimCaTruc = txtTimCaTruc;
    }

    public QuanlytuyendungJPanel(TextPrompt p, JButton btnLamMoi, JButton btnSuaCaTruc, JButton btnThemCaTruc, JButton btnXoaCaTruc, JLabel jLabel1, JLabel jLabel2, JScrollPane jScrollPane1, JTable jTable1, JTextField txtTimQLCT) {
        this.p = p;
        this.btnLamMoi = btnLamMoi;
        this.btnSuaCaTruc = btnSuaCaTruc;
        this.btnThemCaTruc = btnThemCaTruc;
        this.btnXoaCaTruc = btnXoaCaTruc;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jScrollPane1 = jScrollPane1;
        this.tblCaTruc = jTable1;
        this.txtTimCaTruc = txtTimQLCT;
    }
    
    public QuanlytuyendungJPanel() {
        initComponents();
        p = new TextPrompt("Tìm Kiếm", txtTimCaTruc);
        TaoBang();
        
        
    }
    
    
    
    public void edit()
    {
        CaTruc a = new CaTruc();
        int k = -1;
        k = tblCaTruc.getSelectedRow();
        if(k > -1)
        {
        a.setMaNV(tblCaTruc.getValueAt(k, 0).toString());
        a.setTenNV(tblCaTruc.getValueAt(k, 1).toString());
        a.setTenCV(tblCaTruc.getValueAt(k, 2).toString());
        a.setNhiemVu(tblCaTruc.getValueAt(k, 3).toString());
        a.setKhuVuc(tblCaTruc.getValueAt(k, 4).toString());
        a.setCaTruc(tblCaTruc.getValueAt(k, 5).toString());
        int z=0;
            try {
                String sql ="update catruc set tencv = '"+a.getTenCV()+"',nhiemvu ='"+a.getNhiemVu()+"',khuvuc = '"+a.getKhuVuc()+"',catruc='"+a.getCaTruc()+"' where manv ='"+a.getMaNV()+"'";
                System.out.println(sql);
                Statement st = (Statement) con.createStatement();
                z = st.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(QuanlytuyendungJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(z >0)
            {
                JOptionPane.showMessageDialog(null,"Update Successful !", "Notifical", JOptionPane.INFORMATION_MESSAGE);
                tblModel.setRowCount(0);
                adddatatoTable();
            }else{
                JOptionPane.showMessageDialog(null,"Update Fail !", "Notifical", JOptionPane.INFORMATION_MESSAGE);
                tblModel.setRowCount(0);
                adddatatoTable();
            }
        }else  
        {
            JOptionPane.showMessageDialog(null,"You must choose some row !", "Notifical", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void openaddCaTruc()
    {
        
        dialog.setSize(420, 350);
        dialog.setLocationRelativeTo(null);
        dialog.add(infoJPanel);
        dialog.setVisible(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTimCaTruc = new javax.swing.JTextField();
        btnSuaCaTruc = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThemCaTruc = new javax.swing.JButton();
        btnXoaCaTruc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaTruc = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1386, 838));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("  Quản Lí Ca Trực  ");

        txtTimCaTruc.setMinimumSize(new java.awt.Dimension(150, 30));
        txtTimCaTruc.setPreferredSize(new java.awt.Dimension(150, 30));

        btnSuaCaTruc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fix1.png"))); // NOI18N
        btnSuaCaTruc.setText("Sửa Ca");
        btnSuaCaTruc.setMaximumSize(new java.awt.Dimension(140, 40));
        btnSuaCaTruc.setPreferredSize(new java.awt.Dimension(140, 30));
        btnSuaCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCaTrucActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/refresh2.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setMaximumSize(new java.awt.Dimension(140, 40));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(120, 40));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThemCaTruc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        btnThemCaTruc.setText("Thêm Ca");
        btnThemCaTruc.setMaximumSize(new java.awt.Dimension(140, 40));
        btnThemCaTruc.setPreferredSize(new java.awt.Dimension(80, 40));
        btnThemCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCaTrucActionPerformed(evt);
            }
        });

        btnXoaCaTruc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete.png"))); // NOI18N
        btnXoaCaTruc.setText("Xoá Ca");
        btnXoaCaTruc.setMinimumSize(new java.awt.Dimension(80, 40));
        btnXoaCaTruc.setPreferredSize(new java.awt.Dimension(80, 40));
        btnXoaCaTruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCaTrucActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search2.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(35, 15));

        tblCaTruc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCaTruc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(519, 519, 519)
                        .addComponent(jLabel1)
                        .addGap(0, 652, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaCaTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimCaTruc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCaTrucActionPerformed
        // TODO add your handling code here:
        DeleTeCaTruc();
    }//GEN-LAST:event_btnXoaCaTrucActionPerformed

    private void btnSuaCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCaTrucActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_btnSuaCaTrucActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        
        tblModel.setRowCount(0);
        adddatatoTable();
        
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemCaTrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCaTrucActionPerformed
        // TODO add your handling code here:
        openaddCaTruc();

    }//GEN-LAST:event_btnThemCaTrucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaCaTruc;
    private javax.swing.JButton btnThemCaTruc;
    private javax.swing.JButton btnXoaCaTruc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCaTruc;
    private javax.swing.JTextField txtTimCaTruc;
    // End of variables declaration//GEN-END:variables
}

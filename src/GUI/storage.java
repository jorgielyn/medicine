/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class storage extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public storage() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Id");
        model.addColumn("name");
        model.addColumn("brand name");
        model.addColumn("generic name");
        model.addColumn("quantity");
        model.addColumn("price");
        model.addColumn("category");
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/iran_medicine";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM medicines");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
               model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2), Rs.getString(3), Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
     public static void main(String[] args) {
        JFrame frame = new storage();
        frame.setTitle("VIEW MEDICINES");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
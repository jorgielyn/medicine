/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.*;
import Model.model;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author iranjo_sd2022
 */
public class controller {

    model mod = new model();

    public boolean delete( String id) {
        boolean success = false;

        try {
            
//            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicines` WHERE ID=" + id);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Successfully removed!", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

            }
//                while(rs.next()){
//                    if(rs.getInt("ID") == id){
//                        String sql = "DELETE FROM `medicines` WHERE ID="+id;
//                        stmt.executeUpdate(sql);
//                        JOptionPane.showMessageDialog(rootPane,"Successfully removed!");
//                        success = true;
//                        break;
//                    }
//                }
//                if(success == true){
//                    this.dispose();
//                    new storage().setVisible(true);
//                }
//                
//                con.close();
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(rootPane,"ID should be a number!");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }

        return success;
    }

    public boolean add(String name, String brandname, String genericname, String quantity, String price, String category) {
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicines` WHERE name='" + name + "'");

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Medicine already exist!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                return success = mod.add(name, brandname, genericname, 0, 0, category);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    public boolean register(String user, String pass, String fname, String lname, String age2) {
        boolean finish = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `accounts` WHERE user='" + user + "'");

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username already exist!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int age = Integer.parseInt(age2);
                    if (age >= 18) {

                        return finish = mod.register(user, pass, fname, lname, age);
                    } else {
                        JOptionPane.showMessageDialog(null, "Age should be a legal!", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Age should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return finish;
    }

    public boolean order(String accnames, String id1, String quantity) {
        boolean success = false;
        boolean exist = false;

        try {

            int qty = Integer.parseInt(quantity);
            try {
                int id = Integer.parseInt(id1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM `medicines` WHERE id=" + id);

                    while (rs.next()) {
                        int stock = rs.getInt("quantity");
                        double price = rs.getDouble("price");
                        System.out.println("Nagbasa siya dito");
                        if (rs.getInt("id") == id) {
                            exist = true;
                            return success = mod.order(accnames, id, qty);
                        }
                        break;
                    }

                    if (exist == false) {
                        JOptionPane.showMessageDialog(null, "Medicine do not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return success;
    }
}

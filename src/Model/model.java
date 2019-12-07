/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import GUI.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author iranjo_sd2022
 */
public class model {

    public boolean delete(int id) {
        boolean success = false;

        try {
            Statement stmt = null;
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicines` WHERE ID=" + id);
            while (rs.next()) {
                if (rs.getInt("ID") == id) {
                    String sql = "DELETE FROM `medicines` WHERE ID=" + id;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Successfully removed!");
                    success = true;
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }

        return success;
    }

    public boolean add(String name, String brandname, String genericname, int quantity, double price, String category) {
        boolean success = false;
        try {
            // create a mysql database connection
            Statement stmt = null;
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            stmt = (Statement) conn.createStatement();
            // the mysql insert statement
            //to encrypt password use MD5 beside the value to be inserted
            String query = " insert into medicines (name,brandname,genericname,quantity,price,category)"
                    + " values (?,?,?,?,?,?)";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data added");
            return success = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            JOptionPane.showMessageDialog(null, "No Data added");
            System.err.println(e.getMessage());
        }

        return success;
    }

    public boolean register(String user, String pass, String fname, String lname, int age) {
        boolean success = false;
        try {
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8081/iran_medicine", "root", "");
            stmt = (Statement) conn.createStatement();
            String val = "'" + user + "','" + pass + "','" + fname + "','" + lname + "'," + age;
            String query = "INSERT INTO `accounts`(`user`, `pass`, `fname`, `lname`,`age`) VALUES (" + val + ")";
            stmt.executeUpdate(query);
            return success = true;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;
    }

    public boolean order(String accnames, int id, int qty) {

        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iran_medicine", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicines` WHERE id=" + id);

            while (rs.next()) {
                int stock = rs.getInt("quantity");
                double price = rs.getDouble("price");
                if (rs.getInt("id") == id) {
                    ResultSet rs1 = stmt.executeQuery("SELECT * FROM `accounts` WHERE user='" + accnames + "'");

                    while (rs1.next()) {
                        int age = rs1.getInt("age");
                        if (rs1.getString("user").equals(accnames) == true) {

                            if (stock < qty) {
                                JOptionPane.showMessageDialog(null, "Insufficient stock!");
                            } else if (stock == qty) {
                                if (age >= 18 && age <= 59) {
                                    System.out.println(age);
                                    System.out.println("Equal then " + (qty * price));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                    String sql = "DELETE FROM `medicines` WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    conn.close();
                                    return success = true;
                                } else {
                                    System.out.println(age);
                                    System.out.println("Equal then senior " + ((qty * price) * .80));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                    String sql = "DELETE FROM `medicines` WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    conn.close();
                                    return success = true;
                                }
                            } else {
                                if (age >= 18 && age <= 59) {
                                    System.out.println(age);
                                    System.out.println(" Equal then " + (qty * price));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                    String sql = "UPDATE `medicines` SET `quantity`=" + (stock - qty) + " WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    conn.close();
                                    return success = true;
                                } else {
                                    System.out.println(age);
                                    System.out.println(" not equal then senior " + ((qty * price) * .80));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                    String sql = "UPDATE `medicines` SET `quantity`=" + (stock - qty) + " WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    conn.close();
                                    return success = true;
                                }

                            }

                        }
                    }
                    break;
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;

    }

}

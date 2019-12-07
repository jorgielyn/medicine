/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;
import medicine.exceptions.ExceptionHandler;

/**
 *
 * @author 2ndyrGroupC
 */
public class Register {

    private String firstname = null;
    private String lastname = null;
    private int age = 0;
    private String accname = null;
    private String password = null;
    private Writers writer = new Writers();

   

    public void register(Scanner write) {
        boolean end = true;

        while (end) {
            try {
                firstname = writer.WriteString(write, "firstname");
                ExceptionHandler.StringCheck(firstname);
                end = false;
                writer.string("firstname");
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        end = true;
        while (end) {
            try {
                lastname = writer.WriteString(write, "lastname");
                ExceptionHandler.StringCheck(lastname);
                end = false;
                writer.string("lastname");
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        end = true;
        while (end) {

            try {

                age = writer.WriteInt(write, "age");
                if (age < 18) {
                    System.out.println("we don't accept minors");
                      
                } else {
                    end = false;
                }

            } catch (InputMismatchException e) {
                write.next();
                System.out.println("we only accept numbers");
            }
        }
        end = true;
        while (end) {
            try {
                accname = writer.WriteString(write, "account");
                ExceptionHandler.StringCheck(accname);
                end = false;
                writer.string("account");
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        end = true;
        while (end) {
            password = writer.WriteString(write, "password");
            String vpassword = writer.WriteString(write, "verification password");
            if (password.equals(vpassword)) {
                end = false;
                writer.string("account");
            } else {
                System.out.println("mismatch password");
            }
        }

    }

    public Register() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Writers getWriter() {
        return writer;
    }

    public void setWriter(Writers writer) {
        this.writer = writer;
    }

}

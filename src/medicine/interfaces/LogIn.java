/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.interfaces;
import java.util.Scanner;
import medicine.exceptions.ExceptionHandler;

/**
 *
 * @author 2ndyrGroupC
 */
public class LogIn {

    private Writers writer = new Writers();
    private String accname;
    private String password;

    public void logIn(Scanner write) {
        boolean end = true;
        while (end) {
            try {
                accname = writer.WriteString(write, "account");
                ExceptionHandler.StringCheck(accname);
                writer.string("account");
            } catch (ArithmeticException e) {
                System.out.println(e);
                continue;
            }
            password = writer.WriteString(write, "password");
            end = false;
        }

    }

    public Writers getWriter() {
        return writer;
    }

    public void setWriter(Writers writer) {
        this.writer = writer;
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

}

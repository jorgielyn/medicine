/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Writers {

    public void string(String string) {
        System.out.println("---" + string + " input success---");
    }

    public String WriteString(Scanner write, String string) {
        System.out.println("enter your " + string);
        String ans = write.next();
        return ans;
    }

    public int WriteInt(Scanner write, String string) {
        int ans = 0;
        System.out.println("enter your " + string);
        ans = write.nextInt();
        return ans;
    }

    public double WriteDouble(Scanner write, String string) {
        double ans = 0;

        System.out.println("enter your " + string);
        ans = write.nextDouble();

        return ans;
    }

}

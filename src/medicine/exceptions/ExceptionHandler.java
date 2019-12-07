/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.exceptions;

import javax.swing.JLabel;

/**
 *
 * @author 2ndyrGroupC
 */
public class ExceptionHandler {

    public static boolean charIsDigit(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isDigit(y)) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public static boolean charIsNotString(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isLetter(y) == false) {
                ans = true;
                break;
            }
        }
        return ans;

    }

    public static void charShouldNotBeNumber(String word) {

        if (charIsNotString(word) || charIsDigit(word)) {
            throw new ArithmeticException("opps!numbers are not allowed");
        }
    }

    public static void StringCheck(String string) {
        charShouldNotBeNumber(string);
    }

    public static void StringCheck(JLabel accname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

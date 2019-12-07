/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.users;

import java.util.ArrayList;
import medicine.medicine.HeadAcheMedicine;
import medicine.medicine.Medicine;

/**
 *
 * @author 2ndyrGroupC
 */
public class UserList {

    private ArrayList<User> accountList = new ArrayList();

    public UserList() {
    }

    public ArrayList<User> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<User> accountList) {
        this.accountList = accountList;
    }

    public void addItem(User acc) {
        accountList.add(acc);
    }

    @Override
    public String toString() {
        return accountList.toString();
    }

    public boolean isInstanceAdmin(User user) {
        return user instanceof Admin;
    }

    public void display() {
        for (User user : accountList) {
            System.out.println(isInstanceAdmin(user) ? user : "");
        }
    }

    public boolean isVerified(String acc, String pass) {
        boolean ans = false;
        for (User user : accountList) {
            if (acc.equals(user.getAccount().getAccName())) {
                if (pass.equals(user.getAccount().getPassword())) {
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    }

    public boolean isInstanceOfAdmin(String acc) {
        boolean ans = false;
        for (User user : accountList) {
            if (acc.equals(user.getAccount().getAccName())) {
                if (isInstanceAdmin(user)) {
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    }

    public void viewAdminAcc() {
       
        System.out.println("***********************************The Admin**********************************\n\n");
       
        for (User med : accountList) {
            if (med instanceof Admin) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void viewCostumerAcc() {
      
        System.out.println("**************************************Our Costumer*****************************\n\n");
       
        for (User med : accountList) {
            if (med instanceof Customer) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void displayAcc() {
       
        System.out.println("********************************The Accounts in the Pharmacy***********************************\n\n");
       
        viewAdminAcc();
        viewCostumerAcc();
        System.out.println("========================================================================================================\n\n\n\n");
    }
    public int getAge(String acc){
        int age=0;
        for (User user : accountList) {
            if (acc.equals(user.getAccount().getAccName())) {
                age=user.getIdentity().getAge();
                break;
            }
        }
        return age;
    }

}

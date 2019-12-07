/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.users;

/**
 *
 * @author 2ndyrGroupC
 */
public class Customer extends User{

    public Customer(String fname, String lname, int age, String acc, String pass) {
        super(fname, lname, age, acc, pass);
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdentity(Identity identity) {
        super.setIdentity(identity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identity getIdentity() {
        return super.getIdentity(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccount(Account account) {
        super.setAccount(account); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccount() {
        return super.getAccount(); //To change body of generated methods, choose Tools | Templates.
    }
    
}


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
public class User {

    private Identity identity;
    private Account account;

    public User(String fname, String lname, int age, String acc, String pass) {
        this.identity = new Identity(fname, lname, age);
        this.account = new Account(acc, pass);
    }

    public User() {

    }
//setters and getters

    
    
    
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return identity+""+account;
    }

}

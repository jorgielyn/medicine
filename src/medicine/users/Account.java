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
public class Account {
    private String accName;
    private String password;

    public Account(String accName, String password) {
        this.accName = accName;
        this.password = password;
    }

    public Account() {
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("account name: %-20s password: %-20s",this.accName,this.password);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import medicine.interfaces.LogIn;
import medicine.interfaces.Register;
import medicine.medicine.*;
import medicine.users.UserList;
import medicine.users.Admin;
import medicine.users.AdminPrivilege;
import medicine.users.Customer;
import medicine.users.CustomerPrivilege;
import medicine.users.User;

/**
 *
 * @author 2ndyrGroupC
 */
public class Interface {

    private Register regis = new Register();
    private Admin admin = new Admin();
    private Customer custom = new Customer();
    private Scanner write = new Scanner(System.in);
    private UserList useList = new UserList();
    private LogIn log = new LogIn();
    private AdminPrivilege adminAccess = new AdminPrivilege();
    private CustomerPrivilege customerAccess = new CustomerPrivilege();
    private MedicineList medList = new MedicineList();

    public void Interface() {
        //instantiates the accountlist for admin and medicinelist
            useList.addItem(new Admin("jorgielyn", "iran", 20,"admin","admin"));
           // useList.addItem(new Customer("gabrielle", "mendez", 20,"cs","cs"));
            medList.addMedicineList(new AllergiesMedicine("semprex-d","acrivastine", "semprex-d", 200, 12));
            medList.addMedicineList(new AllergiesMedicine("zyrtec","cetirizine", "zyrtec", 30, 10));
            medList.addMedicineList(new AllergiesMedicine("tavist","clemastine", "tavist", 100, 11));
            medList.addMedicineList(new HeadAcheMedicine("advil","ibuprofen", "advil", 200, 9));
            medList.addMedicineList(new HeadAcheMedicine("aleve,","naproxen", "aleve,", 310, 8));
            medList.addMedicineList(new HeadAcheMedicine("relpax","eletriptan", "relpax", 2500, 10));
            medList.addMedicineList(new CoughMedicine("vicks","dextromethorphan", "vicks", 100, 10));
            medList.addMedicineList(new CoughMedicine("delsym","extromethorphan", "delsym", 300, 10));
            medList.addMedicineList(new CoughMedicine("tessalon","benzonatate", "tessalon", 300, 10));
            medList.addMedicineList(new BodyPainMedicine("conzip","tramadol", "conzip", 300, 10));
            medList.addMedicineList(new BodyPainMedicine("motrin,","ibuprofen", "motrin,", 300, 10));
            medList.addMedicineList(new BodyPainMedicine("amitriptyline","amitriptyline", "amitriptylines", 300, 10));
        boolean end = true;
//all transaction
        while (end) {
            
            useList.displayAcc();
            //medList.viewList();
            int select = 0;
            System.out.println("press 1 to register\npress 2 to log in\npress 3 quit");
            try {
                select = write.nextInt();
            } catch (InputMismatchException e) {
                write.next();
                System.out.println("WRONG INPUT GIVEN!");
                continue;
            }
            switch (select) {
                //register
                case 1:
                    System.out.println("*REGISTER*");

                    boolean endRegis = true;
                    int selectRegister = 0;
                    while (endRegis) {
                        System.out.println("press 1 to register as admin\tpress 2 for customer");
                        try {
                            selectRegister = write.nextInt();
                            endRegis = false;
                        } catch (InputMismatchException e) {
                            System.out.println("WRONG INPUT GIVEN!");
                            write.next();

                        }
                    }

                    //register as admin or customer
                    regis.register(write);
                    if (selectRegister == 1) {
                        System.out.println("registered as admin");
                        admin = new Admin(regis.getFirstname(), regis.getLastname(), regis.getAge(), regis.getAccname(), regis.getPassword());
                        useList.addItem(admin);

                    } else {
                        System.out.println("registered as cutomer");
                        custom = new Customer(regis.getFirstname(), regis.getLastname(), regis.getAge(), regis.getAccname(), regis.getPassword());
                        useList.addItem(custom);
                    }
                    break;
                case 2:
                    //log In
                    adminAccess.setMedList(medList);
                    customerAccess.setMedList(medList);
                    System.out.println("LOG IN");
                    log.logIn(write);
                    String acc = log.getAccname();
                    String pass = log.getPassword();
                    if (useList.isVerified(acc, pass)) {
                        if (useList.isInstanceOfAdmin(acc)) {
                            
                            System.out.println("PHARMACIST");
                            adminAccess.AdminPrivilege(write);
                            medList.setMedicineList(adminAccess.getMedList().getMedicineList());
                        } else {
                            int age=useList.getAge(acc);
                            System.out.println("CUSTOMER");
                            System.out.println("Welcome to our pharmacy");
                            System.out.println("the customer has the age of "+age);
                            customerAccess.setAge(age);
                            customerAccess.CustomerPrivilege(write);
                            medList.setMedicineList(customerAccess.getMedList().getMedicineList());
                        }
                    } else {
                        System.out.println("INVALID USERNAME OR PASSWORD!");
                    }
                    break;
                case 3:
                    System.out.println("exiting app");
                    end = false;
                    break;
                default:
                    System.out.println("Please check your input!");
                    break;
            }

        }

    }

}

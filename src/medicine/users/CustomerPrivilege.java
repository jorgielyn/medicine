/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import medicine.medicine.Medicine;
import medicine.medicine.MedicineList;

/**
 *
 * @author 2ndyrGroupC
 */
public class CustomerPrivilege {
 private int age;
    private MedicineList medList = new MedicineList();
    private ArrayList<ArrayList> receipt = new ArrayList();

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
 
    
    public MedicineList getMedList() {
        return medList;
    }

    public void setMedList(MedicineList medList) {
        this.medList = medList;
    }

    public ArrayList<ArrayList> getReceipt() {
        return receipt;
    }

    public void setReceipt(ArrayList<ArrayList> receipt) {
        this.receipt = receipt;
    }

    public void viewReceipt() {
        double all = 0;
        System.out.println("====================================================================");
        System.out.println("\t\t\tCUSTOMERS RECEIPT");
        System.out.println("====================================================================");
        for (ArrayList item : receipt) {
//            if (getAge()>=60) {
//                System.out.printf("%-15s\t%-15s\t%-15s\t%s\n", item.get(0), item.get(1), item.get(2), item.get(3));
//                String x = (String) item.get(item.size() - 1);
//
//                all += (Double.parseDouble(x)-(20*100));
//                System.out.println("total price to be paid " + all);
//            }
            System.out.printf("%-15s\t%-15s\t%-15s\t%s\n", item.get(0), item.get(1), item.get(2), item.get(3));
            String x = (String) item.get(item.size() - 1);

            all += Double.parseDouble(x);
        }
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("TOTAL : " + all);
         System.out.println("---------------------------------------------------------------");
    }

    public void cancel(Scanner write) {
        int index = 0;
        String med = null;
        int medQuan = 0;
        boolean end = true;
        while (end) {
            System.out.println("enter the name to be cancelled : ");
            med = write.next();
            if (medList.isMedicinePresent(med)) {
                for (Medicine item : medList.getMedicineList()) {
                    if (med.equals(item.getProduct().getName()) && item.getProduct().getQuantity() > 0) {
                        int quan = item.getProduct().getQuantity();
                        item.getProduct().setQuantity(quan + medQuan);
                        
                        medList.getMedicineList().remove(item);
                        System.out.println("medicine removed");
                        end = false;
                        break;
                    }
                }
            } else{
                System.out.println("medicine not in the list");
            }
        }
    }

    public void purchaseMedicines(Scanner write) {
        ArrayList<String> tempList = new ArrayList();
        int index = 0;
        String med = null;
        int medQuan = 0;
        boolean end = true;
        while (end) {
            medList.viewList();
            System.out.println("enter the name to be purchased : ");
            med = write.next();
            if (medList.isMedicinePresent(med)) {
                for (Medicine item : medList.getMedicineList()) {
                    if (med.equals(item.getProduct().getName()) && item.getProduct().getQuantity() > 0) {
                        index = medList.getMedicineList().indexOf(item);
                        end = false;
                        break;
                    }
                }
            } else {
                System.out.println("medicine not in the list");
            }
        }
        end = true;
        while (end) {

            try {
                System.out.println("enter the quantity to be purchased : ");
                medQuan = write.nextInt();
            } catch (InputMismatchException e) {
                write.next();
                continue;
            }
            if (medList.getMedicineList().get(index).getProduct().getQuantity() > medQuan) {
                end = false;
                int quan = medList.getMedicineList().get(index).getProduct().getQuantity();
                medList.getMedicineList().get(index).getProduct().setQuantity(quan - medQuan);
            } else {
                System.out.println("Out Of Quantity");
            }
        }
        tempList.clear();
        tempList.add(med);
        tempList.add(String.valueOf(medQuan));
        tempList.add(String.valueOf(medList.getMedicineList().get(index).getProduct().getPrice()));
//        for (getAge){
//              if (getAge()>=60){
//                    tempList.add(String.valueOf((medList.getMedicineList().get(index).getProduct().getPrice() * medQuan)-(medList.getMedicineList().get(index).getProduct().getPrice() * medQuan)*0.20));
//                    receipt.add(tempList);
//              }else{
//                    tempList.add(String.valueOf(medList.getMedicineList().get(index).getProduct().getPrice() * medQuan));
//                    receipt.add(tempList);
//        }
        //System.out.println(getAge());
        if (getAge()>=60){
            System.out.println("Age: " +getAge());
            //System.out.println("You can avail a 20% discount!");
            tempList.add(String.valueOf((medList.getMedicineList().get(index).getProduct().getPrice() * medQuan)-(medList.getMedicineList().get(index).getProduct().getPrice() * medQuan)*0.20));
            receipt.add(tempList);
            System.out.println("You can avail a 20% discount!");
        }else{
            System.out.println("Age: " +getAge());
//            System.out.println("Thanks for patronizing us!");
            tempList.add(String.valueOf(medList.getMedicineList().get(index).getProduct().getPrice() * medQuan));
            receipt.add(tempList);
            System.out.println("Thanks for patronizing us!");
        }
//    }
    }
        

    public void CustomerPrivilege(Scanner write) {
        boolean end = true;
        while (end) {
            int select = 0;
            
            System.out.println("\npress:\n1 to purchase\n2 to cancel\n3 to logOut");
            try {
                select = write.nextInt();
            } catch (InputMismatchException e) {
                write.next();
                System.out.println("we only accept numbers");
                continue;

            }
            switch (select) {
                case 1:
                    purchaseMedicines(write);
                    viewReceipt();
                    break;
                case 2:
                    cancel(write);
                    break;
                case 3:
                    end = false;
                    break;
                default:
                    System.out.println("opps something is wrong");
            }

        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.users;

import java.util.InputMismatchException;
import java.util.Scanner;
import medicine.exceptions.ExceptionHandler;
import medicine.interfaces.Writers;
import medicine.medicine.AllergiesMedicine;
import medicine.medicine.BodyPainMedicine;
import medicine.medicine.CoughMedicine;
import medicine.medicine.HeadAcheMedicine;

import medicine.medicine.MedicineList;

/**
 *
 * @author 2ndyrGroupC
 */
public class AdminPrivilege {

    private Writers writers = new Writers();
    private MedicineList medList = new MedicineList();

    public AdminPrivilege() {
    }

    public Writers getWriters() {
        return writers;
    }

    public void setWriters(Writers writers) {
        this.writers = writers;
    }

    public MedicineList getMedList() {
        return medList;
    }

    public void setMedList(MedicineList medList) {
        this.medList = medList;
    }

    public void addMed(Scanner write) {

        System.out.println("you can add now");

        int type = 0;
        boolean end = true;
        while (end) {
            System.out.println("what type of medicine?\n1 for allergy\n2 for body pains\n3 for cough\n4 for headache");
            try {
                type = write.nextInt();
                if (type < 5) {
                    end = false;
                } else {
                    System.out.println("only choose in the given");
                }
            } catch (InputMismatchException e) {
                System.out.println("we only accept numbers");
                write.next();
            }
        }
        String medicine = null;
        end = true;
        while (end) {
            medicine = writers.WriteString(write, "medicine name to be added");
            try {
                ExceptionHandler.charShouldNotBeNumber(medicine);
                end = false;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        if (!medList.isMedicinePresent(medicine)) {
            System.out.println("fill up medicine information");
            //add medicine name

            //add brandname
            String brandname = null;
            end = true;
            while (end) {
                try {
                    brandname = writers.WriteString(write, "medicine brand name to be added");
                    ExceptionHandler.charShouldNotBeNumber(brandname);
                    end = false;
                } catch (ArithmeticException e) {
                    System.out.println(e);
                }
            }
            //add genericname
            String generic = null;
            end = true;
            while (end) {

                try {
                    generic = writers.WriteString(write, "medicine generic name to be added");
                    ExceptionHandler.charShouldNotBeNumber(generic);
                    end = false;
                } catch (ArithmeticException e) {
                    System.out.println(e);
                }
            }
            //add price
            double price = 0;
            end = true;
            while (end) {
                try {
                    price = writers.WriteDouble(write, "medicine price to be added");
                    end = false;
                } catch (InputMismatchException e) {
                    System.out.println("we only accept valid numbers");
                    write.next();
                }
            }
            //quantity
            int quantity = 0;
            end = true;
            while (end) {
                try {
                    quantity = writers.WriteInt(write, "medicine quantity to be added");
                    end = false;
                } catch (InputMismatchException e) {
                    System.out.println("we only accept valid numbers");
                    write.next();
                }
            }
            switch (type) {
                case 1:
                    medList.addMedicineList(new AllergiesMedicine(brandname, generic, medicine, quantity, price));
                    System.out.println("added to AllergiesMedicine");
                    break;
                case 2:
                    medList.addMedicineList(new BodyPainMedicine(brandname, generic, medicine, quantity, price));
                    System.out.println("added to BodyPainMedicine");
                    break;
                case 3:
                    medList.addMedicineList(new CoughMedicine(brandname, generic, medicine, quantity, price));
                    System.out.println("added to CoughMedicine");
                    break;
                case 4:
                    medList.addMedicineList(new HeadAcheMedicine(brandname, generic, medicine, quantity, price));
                    System.out.println("added to HeadAcheMedicine");
                    break;
                default:
                    System.out.println("opps something went wrong while adding medicine!!");
                    break;

            }
        } else {
            System.out.println("medicine already present.suggestion: choose update");
        }

    }

    public void removeMed(Scanner write) {

        String med = null;

        boolean end = true;
        while (end) {
            try {
                med = writers.WriteString(write, "medicine generic name to be deleted");
                ExceptionHandler.charShouldNotBeNumber(med);
                end = false;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            if (medList.isMedicinePresent(med)) {
                medList.removeMed(med);
                System.out.println("medicine removed");
            } else {
                System.out.println("med not in the list");
            }
        }
    }

    public void update(Scanner write) {
        System.out.println("you can update now");
        int type = 0;
        boolean end = true;
        String writeName = null;
        String writes = null;
        String brandname = null;
        String generic = null;
        int quantity = 0;
        double price = 0;
        end = true;
        while (end) {
            try {
                writeName = writers.WriteString(write, "medicine name to be updated");
                ExceptionHandler.charShouldNotBeNumber(writeName);
                end = false;
            } catch (ArithmeticException e) {
                write.next();
                System.out.println(e);
            }
        }
        boolean endAll = true;
        while (endAll) {
            if (medList.isMedicinePresent(writeName)) {
                end = true;
                while (end) {
                    System.out.println("press:\n1 to update name\n2 to update brandname\n3 to update genericname\n4 to update price\n5 to update quantity\n6 to end");
                    try {
                        type = write.nextInt();
                        if (type < 7) {
                            end = false;
                        } else {
                            System.out.println("only choose in the given");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("we only accept numbers");
                        write.next();
                    }
                }
            } else {

                System.out.println("not present opps");
                endAll = false;
                break;

            }
            switch (type) {
                case 1:

                    end = true;
                    while (end) {
                        writes = writers.WriteString(write, "medicine name to be replace");
                        try {
                            ExceptionHandler.charShouldNotBeNumber(writes);
                            end = false;
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                            write.next();
                        }
                    }

                    System.out.println("name updated");
                    break;
                case 2:

                    //add brandname
                    end = true;
                    while (end) {
                        try {
                            brandname = writers.WriteString(write, "new medicine brand name ");
                            ExceptionHandler.charShouldNotBeNumber(brandname);
                            end = false;
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                            write.next();
                        }
                    }

                    System.out.println("new brandname updated");
                    break;
                case 3:

                    end = true;
                    while (end) {

                        try {
                            generic = writers.WriteString(write, "new medicine generic name to replace");
                            ExceptionHandler.charShouldNotBeNumber(generic);
                            end = false;
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                            write.next();
                        }
                    }

                    System.out.println("generic updated");
                    break;
                case 4:

                    end = true;
                    while (end) {
                        try {
                            price = writers.WriteDouble(write, "new medicine price ");
                            end = false;
                        } catch (InputMismatchException e) {
                            System.out.println("we only accept valid numbers");
                            write.next();
                        }
                    }

                    System.out.println("price updated");
                    break;
                case 5:

                    end = true;
                    while (end) {
                        try {
                            quantity = writers.WriteInt(write, "new medicine quantity ");
                            end = false;
                        } catch (InputMismatchException e) {
                            System.out.println("we only accept valid numbers");
                            write.next();
                        }
                    }

                    System.out.println("quantity updated");
                    break;
                case 6:
                    endAll = false;
                    break;
                default:
                    System.out.println("opps something went wrong while adding medicine!!");
                    break;

            }

        }
        if (writes != "NULL") {
            medList.updateName(writeName, writes);

        }
        if (brandname != "NULL") {
            medList.updateName(writeName, brandname);
        }
        if (generic != "NULL") {
            medList.updateName(writeName, generic);
        }
        if (quantity != 0) {
            medList.updateQuantity(writeName, quantity);
        }
        if (price != 0) {
            medList.updatePrice(writeName, price);
        }

    }

    public void AdminPrivilege(Scanner write) {
        int tran = 0;
        
        boolean endAll = true;
        while (endAll) {
            boolean end = true;
            while (end) {
                System.out.println("press:\n1 to add medicine supply\n2 to remove medicine\n3"
                        + " to update medicine\n4 to view medicine list\n5 to log out");
                try {
                    tran = write.nextInt();
                    end = false;
                } catch (InputMismatchException e) {
                    System.out.println("we only accept numbers");
                }
                switch (tran) {
                    case 1:
                        addMed(write);
                        break;
                    case 2:
                        removeMed(write);
                        break;
                    case 3:
                        update(write);
                        break;
                    case 4:
                        System.out.println("view medicines");
                        medList.viewList();
                        break;
                    case 5:
                        System.out.println("logging out");
                        endAll = false;
                        break;
                    default:
                        System.out.println("choose from what is given");
                        break;
                }

            }
        }

    }
}

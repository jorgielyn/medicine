/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine.medicine;

/**
 *
 * @author 2ndyrGroupC
 */
public class Product {
   private String Name; 
   private int quantity;
    private double price;

    public Product() {
    }

    public Product(String Name, int quantity, double price) {
        this.Name = Name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("product name: %-20s quantity: %-20d price:%-20.2f Php",this.Name,this.quantity,this.price);
    }
    
}

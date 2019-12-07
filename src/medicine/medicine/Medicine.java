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
public class Medicine {
    private Product product;
    private String brandName;
    private String genericName;


    public Medicine(String brandName, String genericName,String name, int quantity, double price) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.product=new Product(name,quantity,price);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   

    @Override
    public String toString() {
        return product+String.format("brandName: %-20s GenericName: %-20s",this.brandName,this.genericName);
    }
    
}

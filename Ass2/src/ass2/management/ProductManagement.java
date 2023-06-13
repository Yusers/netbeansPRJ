/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.management;

import ass2.core.Product;
import java.util.ArrayList;
import management.FileManagement;

/**
 *
 * @author overw
 */
public class ProductManagement extends FileManagement {
    ArrayList<Product> listProducts = getListFromFile("products.txt");
    
    
    public void display() {
        System.out.println("=== Product Info ===");
        if(listProducts.isEmpty()) System.out.println("Nothing to output!");
        for(Product p : listProducts) {
            System.out.println(p);
        }
    }
}

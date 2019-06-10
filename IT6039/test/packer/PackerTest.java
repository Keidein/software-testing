/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author dteth
 */
public class PackerTest {
    
    static Coordinates coord[] = {
        // Customer
        new Coordinates(912, 948),
        
        // Depot
        new Coordinates(38, 58)
    };
    
    static Address a[] = {
        // Customer
        new Address("123 Fruitloop Street", "Cereal", "Branch", "9303", coord[0]),
    
        // Depot
        new Address("Town Depot", "Down Town", "Branch", "9300", coord[1])
    };
    
    static Customer c = new Customer("Alex", a[0]);
    static Depot d = new Depot("Main Depot", a[1]);
    static Manifest m = new Manifest();
    
    static Product p[] = {
        new Product("Nail Polish", 1, false, true),
        new Product("Set of Knives", 8, true, false),
        new Product("Playstation Portable", 5, false, true),
        new Product("Back scratcher", 1, true, false),
        new Product("Headphones", 5, false, true)
    };
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer Class...");
    }
    
    @Test
    public void testPackProducts() {
        System.out.println("packProducts");
        
        for (Product item : p) {
            m.addProduct(item);
        }
        
        List<Box> packedItems = Packer.packProducts(c, d, m);
        for (Box items : packedItems) {
            System.out.println(items);
        }
    }
    
}

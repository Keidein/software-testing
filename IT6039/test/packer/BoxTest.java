/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author dteth
 */
public class BoxTest {
    
    public static final double DELTA = 0.001;
    
    //Coordinates coord = new Coordinates(59, 300);
    Coordinates coord[] =
    {
        // Customers Coordinates.
        new Coordinates(59, 300),
        new Coordinates(55, 38),
            
        // Depot
        new Coordinates(35, 99)
    };
    
    Address address[] =
    {
        // Customers Addresses.
        new Address("4981 Fake Street", "Fakerville", "Faking City", "6598",
                coord[0]),
        new Address("9182 Jester Grove", "Clown Place", "Jokes City", "3206",
                coord[1]),
        
        // Depots
        new Address("937 Main Depot", "Main", "Main Place", "6794",
                coord[2])
    };
    
    Customer c[] = {
        new Customer("Bob", address[0]),
        new Customer("Sheeral", address[1])
    };
    
    Depot d = new Depot("Main Depot", address[2]);

    Box box = new Box(c[0], d);
    Product p[] = {
        new Product("Nail", 5, true, false),
        new Product("Wrench", 15, false, false),
        new Product("Glass Cups", 3, false, true)
    };
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box Class");
    }
    
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        box.addProduct(p[0]);
        assertEquals(true, box.remainingCapacity() > 0);
    }
    
    @Test
    public void testToString() {
        System.out.println("toString");
        box.addProduct(p[1]);
        assertTrue(box.toString().contains(c[0].toString()) && box.getLabel().contains(address[0].toString()));
    }
    
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        box.addProduct(p[0]);
        assertEquals(5, box.getWeight(), DELTA);
    }
    
    @Test
    public void testCanFit() {
        System.out.println("canFit");
        box.addProduct(p[0]);
        assertEquals(true, box.canFit(p[1]));
    }
    
    @Test
    public void testRemainingCapacity() {
        System.out.println("remainingCapacity");
        box.addProduct(p[1]);
        assertEquals(5, box.remainingCapacity(), DELTA);
    }
    
    @Test
    public void testIsFragile() {
        System.out.println("isFragile");
        box.addProduct(p[2]);
        assertEquals(true, box.isFragile());
    }
    
    public void testIsHazardous() {
        System.out.println("isHazardous");
        box.addProduct(p[0]);
        assertEquals(false, box.isHazardous());
    }
}

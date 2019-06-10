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
public class ManifestTest {
    
    public static final double DELTA = 0.001;
    
    Product p[] = {
        new Product("Glass Cups", 3, false, true),
        new Product("Mic", 10, false, true),
        new Product("Keyboard", 5, false, false),
        new Product("Mouse", 3, false, false),
        new Product("Desk", 15, false, false),
        new Product("Set of Knives", 7, true, true),
        new Product("Assortment of food", 10, false, true)
    };
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Manifest m = new Manifest();
        
        m.addProduct(p[0]);
        assertEquals(true, m.containsProduct(p[0]));
        assertEquals(false, m.containsProduct(p[3]));
    }
    
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        Manifest m = new Manifest();
        
        assertEquals(false, m.containsProduct(p[1]));
    }
    
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Manifest m = new Manifest();
        
        m.addProduct(p[2]);
        assertEquals(5, m.getTotalWeight(), DELTA);
        
        m.addProduct(p[4]);
        assertEquals(20, m.getTotalWeight(), DELTA);
    }
    
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        Manifest m = new Manifest();
        
        m.addProduct(p[3]);
        assertEquals("Mouse", m.getHeaviestUnder(10).getName());
        
        m.addProduct(p[4]);
        assertEquals("Desk", m.getHeaviestUnder(20).getName());
        
        m.addProduct(p[2]);
        assertEquals("Keyboard", m.getHeaviestUnder(5).getName());
    }
    
    @Test
    public void testToString() {
        System.out.println("toString");
        Manifest m = new Manifest();
        
        m.addProduct(p[4]);
        assertTrue(m.toString().contains(p[4].getName()));
        
        m.addProduct(p[5]);
        assertTrue(m.toString().contains(p[5].getName()));
    }
    
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        Manifest m = new Manifest();
        
        m.addProduct(p[5]);
        assertEquals(true, m.hasFragileItems());
    }
    
    @Test
    public void testHasHazardousItems() {
        System.out.println("hasHazardousItems");
        Manifest m = new Manifest();
        
        m.addProduct(p[6]);
        assertEquals(false, m.hasHazardousItems());
        
        m.addProduct(p[5]);
        assertEquals(true, m.hasHazardousItems());
    }
}

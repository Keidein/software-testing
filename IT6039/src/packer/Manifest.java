package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     * Adds 1 product to the manifest.
     * @param p the product.
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * Adds multiple products to the manifest.
     * @param p the product.
     * @param quantity the amount of the product that you want to add.
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)*quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     * Remove the product from the manifest.
     * @param p the product.
     */
    public void removeProduct(Product p) {
        for (int i = 0; i < quantities.get(p)+1; i++) {
            if (quantities.containsKey(p) && quantities.get(p) > 0) {
                quantities.put(p,quantities.get(p)-1);
            }
            if (quantities.get(p) == null) {
                quantities.remove(p);
            }
            if (quantities.containsKey(p)) {
                byWeight.remove(p);
            }
        }
    }
    
    /**
     * Gets the total weight of the products in the manifest.
     * @return 
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * Returns the products that are under a certain weight.
     * @param weight specified weight as a double.
     * @return 
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Checks if the manifest is empty.
     * @return 
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * Checks if the manifest has a certain product.
     * @param p the product in which to check for.
     * @return 
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * Gets the name and the quantity of the products in the manifest.
     * @return 
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    /**
     * Checks if there is fragile items.
     * @return 
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if there is hazardous items.
     * @return 
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
    
}

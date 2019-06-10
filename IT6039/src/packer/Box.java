package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 
    private int capacity = 20;

    /**
     * Sets the box for the customer and the depot it's coming from.
     * @param customer the customer this box is going to.
     * @param depot the depot this box is coming from.
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * @param product the product to add to the box.
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
        
    /**
     * @param product the product to add to the box.
     * @param quantity the quantity of the product that'll be added.
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
    
    /**
     * @return the label of where it's going, coming from, contents and if
     * fragile, heavy or is hazardous.
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.getWeight() > 15) {
            label.append("HEAVY\n");
        }
        if (this.isHazardous()) {
            label.append("HAZARD\n");
        }
        return label.toString();
    }
    
    /**
     * @return the get label function.
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * @return gets the total weight of the manifest.
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    /**
     * @param p the product
     * @return returns true if the product can fit in the box.
     */
    public boolean canFit(Product p) {
        return p.getWeight() < capacity;
    }
    
    /**
     * @param p the product.
     * @param quantity the quantity of the products.
     * @return returns if the products can fit in the box.
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < capacity;
    }
    
    /**
     * @return the remaining capacity in the box.
     */
    public double remainingCapacity() {
        return capacity - this.getWeight();
    }
    
    /**
     * @return if the box is fragile.
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * @return if the box is hazardous.
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}

package packer;

/**
 *
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * Constructor for the Product class.
     * @param name of the product.
     * @param weight of the product.
     * @param hazardous is this product hazardous?
     * @param fragile is this product fragile?
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * @return the name of the product.
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * @param o is another product.
     * @return if the other product equals this product.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}

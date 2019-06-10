package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    /**
     * Constructor of the depot
     * @param name name of the depot
     * @param address address of the depot
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * @return the name of the depot.
     */
    public String getName() {
        return name.toString();
    }
    
    /**
     * @return the coordinates of the address.
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * @return the name of the depot.
     */
    public String toString() {
        return this.getName();
    }
    
}

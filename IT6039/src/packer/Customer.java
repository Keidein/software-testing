package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * Constructor.
     * @param name the name of the person at the address.
     * @param address the location of the person as an Address.
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * @param address the address to add to the person.
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * @param d the closest address to the depot.
     * @return the bestAddress from the customer.
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().compareDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }

    /**
     * @return the name of the person.
     */
    public String toString() {
        return this.getName();
    }
}

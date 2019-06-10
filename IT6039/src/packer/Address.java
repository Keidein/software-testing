package packer;

/**
 *
 * @author I.M.Bad
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;

    /**
     * Sets the address.
     * @param street the street as a string.
     * @param suburb the suburb as a string.
     * @param city the city as a string.
     * @param postcode the postcode as a string.
     * @param coordinates as X and Y.
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    /**
     * @return the values of the address excluding the coordinates.
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}

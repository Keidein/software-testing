package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
public class Packer {

    /**
     * 
     * @param c Customer the boxes are going to.
     * @param d Depot the boxes are coming from.
     * @param m Manifest of the products.
     * @return the packed boxes contents and label information.
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c, d);
            }
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }  
        }
        if (b != null) {
            packedBoxes.add(b);
            packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}

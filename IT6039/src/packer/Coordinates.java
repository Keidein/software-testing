package packer;

/**
 *
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * Class constructor.
     * @param x the first coordinate as a double.
     * @param y the second coordinate as a double.
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return returns the first coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * @return returns the second coordinate.
     */
    public double getY() {
        return y;
    }
    
    /**
     * Calculates the distances to a different set of coordinates.
     * @param other a second set of coordinates.
     * @return the distance between the 2 coordinates.
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     * Calculates the distance between 2 coordinates.
     * @param other the second set of coordinates.
     * @return the distance between both coordinates.
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    /**
     * Calculates the distance between 2 coordinates.
     * @param other the second set of coordinates.
     * @return the distance between both coordinates +1.
     */
    public double compareDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2)/2 + 1;
    }

}

/**
 * Author: Grigory Shatalin
 */
public class Aggregation {

    private Fraction fractionField;
    private Rectangle[] arrayField;
    private double doubleField;

    /*
     * Non-argument constructor that sets
     * fractionField to 0/1
     * arrayField to size 1 with 1 rectangle in it width 1 and length 1
     * doubleField to 0.0
     */
    public Aggregation() {
        fractionField = new Fraction(0, 1);
        arrayField = new Rectangle[1];
        arrayField[0] = new Rectangle();
        doubleField = 0.0;
    }

    /**
     * Constructor that takes in 3 values to set to our fields
     * 
     * @param a Fraction to copy
     * @param b Rectangle[] to copy
     * @param c double to copy
     */
    public Aggregation(Fraction a, Rectangle[] b, double c) {
        fractionField = new Fraction(a);
        arrayField = new Rectangle[b.length];
        for (int i = 0; i < b.length; i++) {
            arrayField[i] = new Rectangle(b[i]);
        }
        doubleField = new Double(c);
    }

    /**
     * Copy Constructor
     * 
     * @param a Another Aggregation object to copy
     */
    public Aggregation(Aggregation a) {
        fractionField = a.getFraction();
        arrayField = a.getArray();
        doubleField = a.getDouble();
    }

    /**
     * Get the Fraction object stored in this Aggregation.
     * 
     * @return A copy of the Fraction object
     */
    public Fraction getFraction() {
        Fraction a = new Fraction(fractionField);
        return a;
    }

    /**
     * Get the array of Rectangle objects stored in this Aggregation.
     * 
     * @return A deep copy of the array of Rectangle objects
     */
    public Rectangle[] getArray() {
        Rectangle[] a = new Rectangle[arrayField.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Rectangle(arrayField[i]);
        }
        return a;
    }

    /**
     * Get the double value stored in this Aggregation.
     * 
     * @return The double value
     */
    public double getDouble() {
        return new Double(doubleField);
    }

    /**
     * Set the Fraction object in this Aggregation.
     * 
     * @param a The Fraction object to set
     */
    public void setFraction(Fraction a) {
        fractionField = new Fraction(a);
    }

    /**
     * Set the array of Rectangle objects in this Aggregation.
     * 
     * @param a The array of Rectangle objects to set
     */
    public void setArray(Rectangle[] a) {
        arrayField = new Rectangle[a.length];
        for (int i = 0; i < a.length; i++) {
            arrayField[i] = new Rectangle(a[i]);
        }
    }

    /**
     * Set the double value in this Aggregation.
     * 
     * @param a The double value to set
     */
    public void setDouble(double a) {
        doubleField = new Double(a);
    }

    /**
     * Convert this Aggregation object to a string representation.
     * 
     * @return The string representation of the Aggregation object
     */
    public String toString() {
        StringBuilder strB = new StringBuilder("Fraction: " + fractionField.toString());
        strB.append("; Array: [");
        int i;
        for (i = 0; i < arrayField.length - 1; i++) {
            strB.append(arrayField[i] + ",");
        }
        strB.append(arrayField[i] + "]; Double: " + doubleField);

        return strB.toString();
    }

    /**
     * Method needed only to test for a deep copy.
     * 
     * @param a The value to set an element with
     */
    public void forDeepCopyTesting(int a) {
        this.arrayField[0].setLength(a);
    }
}

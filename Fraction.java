/**
 * A class representing fractions.
 * @Author: Grigory Shatalin
 */
public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Default constructor for the Fraction class.
     * Initializes the fraction to 1/1.
     */
    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    /**
     * Constructor for creating a Fraction object with custom numerator and
     * denominator.
     * 
     * @param num The numerator.
     * @param den The denominator.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (num < 0 && den < 0) {
            numerator = -num;
            denominator = -den;
            simplify();
        }
        else if(den<0){
            numerator=-num;
            denominator=-den;
            simplify();
        }
        else{
            numerator = num;
            denominator = den;
            simplify();
        }
    }

    /**
     * Constructor for creating a mixed number (whole number + fraction).
     * 
     * @param val The whole number part.
     * @param num The numerator of the fraction part.
     * @param den The denominator of the fraction part.
     * @throws IllegalArgumentException if the denominator is zero or if either the
     *                                  numerator or denominator is negative.
     */
    public Fraction(int val, int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (den < 0 || num < 0) {
            throw new IllegalArgumentException("Numerator and denominator must be non-negative.");
        }
        if (val < 0) {
            numerator = 0 - (num + (Math.abs(val) * den));
            denominator = den;
            simplify();
        } else {
            numerator = (num + (val * den));
            denominator = den;
            simplify();
        }
    }

    /**
     * Copy Constructor
     * @param a The fraction we're copying
     */
    public Fraction(Fraction a){
        numerator = a.numerator;
        denominator = a.denominator;
    }

    /**
     * Simplifies the fraction by finding and dividing by the greatest common
     * divisor (GCD).
     */
    public void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }
    

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     * 
     * @param x The first integer.
     * @param y The second integer.
     * @return The GCD of x and y.
     */
    public int gcd(int x, int y) {
        do {
            int tmp;
            tmp = y;
            y = x % y;
            x = tmp;
        } while (y > 0);
        return x;
    }

    /**
     * Calculates the least common multiple (LCM) of two integers.
     * 
     * @param x The first integer.
     * @param y The second integer.
     * @return The LCM of x and y.
     */
    public int lcm(int x, int y) {
        int gcd = gcd(x, y);
        return (x * y) / gcd;
    }

    /**
     * Gets the numerator of the fraction.
     * 
     * @return The numerator.
     */
    public int getNum() {
        return numerator;
    }

    /**
     * Gets the denominator of the fraction.
     * 
     * @return The denominator.
     */
    public int getDenom() {
        return denominator;
    }

    /**
     * Sets the numerator and denominator of the fraction.
     * 
     * @param n The new numerator.
     * @param d The new denominator.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public void set(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (n < 0 && d < 0) {
            numerator = -n;
            denominator = -d;
            simplify();
        }
        else if(d<0){
            numerator=-n;
            denominator=-d;
            simplify();
        }
        else{
            numerator = n;
            denominator = d;
            simplify();
        }
    }

    /**
     * Adds the given Fraction 'a' to this Fraction.
     * 
     * @param a The Fraction to be added.
     */
    public Fraction add(Fraction a) {
        int newD = lcm(denominator, a.getDenom());
        int newN;
    
        if (denominator == newD) {
            newN = numerator + (newD / a.getDenom()) * a.getNum();
        } else if (a.getDenom() == newD) {
            newN = (newD / denominator) * numerator + a.getNum();
        } else {
            newN = (newD / denominator) * numerator + (newD / a.getDenom()) * a.getNum();
        }
    
        Fraction result = new Fraction(newN, newD);
        result.simplify(); // Assuming you have a simplify method in your Fraction class
        return result;
    }
    

    /**
     * Subtracts the given Fraction 'a' from this Fraction.
     * 
     * @param a The Fraction to be subtracted.
     */
    public Fraction subtract(Fraction a) {
        int newD = lcm(denominator, a.getDenom());
        int factor1 = newD / denominator;
        int factor2 = newD / a.getDenom();
    
        int newN = numerator * factor1 - a.getNum() * factor2;
    
        Fraction result = new Fraction(newN, newD);
        result.simplify(); // Assuming you have a simplify method in your Fraction class
        return result;
    }
    

    /**
     * Multiplies this Fraction by the given Fraction 'a'.
     * 
     * @param a The Fraction to be multiplied with.
     */
    public Fraction multiply(Fraction a) {
        int numerator = this.numerator * a.getNum();
        int denominator = this.denominator * a.getDenom();
        Fraction result = new Fraction(numerator, denominator);
        return result;
    }

    /**
     * Divides this Fraction by the given Fraction 'a'.
     * 
     * @param a The Fraction to be divided by.
     * @throws IllegalArgumentException if 'a' is a zero Fraction.
     */
    public Fraction divide(Fraction a) {
        // Check for division by zero
        if (a.getNum() != 0) {
            int numerator = this.numerator * a.getDenom();
            int denominator = this.denominator * a.getNum();

            Fraction result = new Fraction(numerator, denominator);
            return result;
        } else {
            // Handle division by zero error
            throw new IllegalArgumentException("can't divide by 0");
        }
    }

    /**
     * Converts this Fraction to a String representation.
     * 
     * @return A String representation of this Fraction.
     */
    public String toString() {
        if(Math.abs(numerator)>denominator){
            int val = numerator/denominator;
            int num = numerator%denominator;
            return numerator + "/" + denominator + " or "+val+" and "+ num + "/"+denominator;
        }
        else if(numerator==0){
            return numerator + "/" + denominator + " or "+0;
        }
        else{
            return numerator + "/" + denominator;
        }
    }

    /**
     * Checks if this Fraction is less than another Fraction 'a'.
     * 
     * @param a The Fraction to compare to.
     * @return true if this Fraction is less than 'a', false otherwise.
     */
    public boolean less(Fraction a) {
        int lcm = lcm(denominator, a.getDenom());
        if ((numerator * (lcm / denominator)) < a.getNum() * (lcm / a.getDenom())) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this Fraction is greater than another Fraction 'a'.
     * 
     * @param a The Fraction to compare to.
     * @return true if this Fraction is greater than 'a', false otherwise.
     */
    public boolean more(Fraction a) {
        int lcm = lcm(denominator, a.getDenom());
        if ((numerator * (lcm / denominator)) > a.getNum() * (lcm / a.getDenom())) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this Fraction is equal to another Fraction 'a'.
     * 
     * @param a The Fraction to compare to.
     * @return true if this Fraction is equal to 'a', false otherwise.
     */
    public boolean equals(Fraction a){
        int lcm = lcm(denominator, a.getDenom());
        if ((numerator * (lcm / denominator)) == a.getNum() * (lcm / a.getDenom())) {
            return true;
        }
        return false;
    }

}

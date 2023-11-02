import javax.management.relation.RelationException;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @author Grigory Shatalin
 *
 */
public class LargeInteger extends HasState implements Relatable, Serializable {
    private int[] num;
    private int digitCount;
    private final int arraySize = 23;

    // No-argument constructor
    public LargeInteger() {
        num = new int[arraySize];
        digitCount = 1;
    }

    // Constructor that takes a string
    public LargeInteger(String numberStr) throws LargeIntegerNumberFormatException {
        if (numberStr == null || numberStr.isEmpty() || numberStr.length() > arraySize) {
            throw new LargeIntegerNumberFormatException("Invalid input string");
        }

        num = new int[arraySize];
        digitCount = numberStr.length();

        // Store the digits in reverse order
        for (int i = 0; i < digitCount; i++) {
            char digitChar = numberStr.charAt(digitCount - i - 1);
            if (!Character.isDigit(digitChar)) {
                throw new LargeIntegerNumberFormatException("Input string contains non-digits");
            }
            num[i] = Character.getNumericValue(digitChar);
        }
    }

    // Constructor that takes a long
    public LargeInteger(long number) throws LargeIntegerNumberFormatException {
        if (number < 0) {
            throw new LargeIntegerNumberFormatException("Negative number is not allowed");
        }

        num = new int[arraySize];
        digitCount = 0;

        // Store the digits in reverse order
        while (number > 0 && digitCount < arraySize) {
            num[digitCount] = (int) (number % 10);
            number /= 10;
            digitCount++;
        }
    }

    // Accessor for digitCount
    public int getDigitCount() {
        return digitCount;
    }

    // Implement toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(digitCount);
        for (int i = digitCount - 1; i >= 0; i--) {
            sb.append(num[i]);
        }
        return sb.toString();
    }

    // Implement add method
    public LargeInteger add(LargeInteger other) throws LargeIntegerOverflowException {
        LargeInteger result = new LargeInteger();
        int carry = 0;

        for (int i = 0; i < arraySize; i++) {
            int sum = num[i] + other.num[i] + carry;
            result.num[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            if (digitCount + 1 > arraySize) {
                throw new LargeIntegerOverflowException("Resulting number is more than 23 digits long");
            }
            result.num[digitCount] = carry;
            result.digitCount = digitCount + 1;
        } else {
            result.digitCount = digitCount;
        }

        return result;
    }

    // Implement clone method
    @Override
    public LargeInteger clone() {
        try {
            LargeInteger copy = (LargeInteger) super.clone();
            copy.num = new int[arraySize]; // Create a new array for the clone
            System.arraycopy(this.num, 0, copy.num, 0, this.num.length); // Copy the elements
            copy.digitCount = this.digitCount;
            return copy;
        } catch (CloneNotSupportedException e) {
            
        }
        return new LargeInteger();
    }

    // Implement methods of the Relatable interface
    @Override
    public boolean isLess(Object other) {
        if (other instanceof LargeInteger) {
            LargeInteger otherInt = (LargeInteger) other;
            // Compare the digit count first
            if (this.digitCount < otherInt.digitCount) {
                return true;
            } else if (this.digitCount > otherInt.digitCount) {
                return false;
            }
            // If digit counts are the same, compare each digit from left to right
            for (int i = this.digitCount - 1; i >= 0; i--) {
                if (this.num[i] < otherInt.num[i]) {
                    return true;
                } else if (this.num[i] > otherInt.num[i]) {
                    return false;
                }
            }
            // The numbers are equal
            return false;
        }
        return false;
    }

    @Override
    public boolean isGreater(Object other) {
        if (other instanceof LargeInteger) {
            LargeInteger otherInt = (LargeInteger) other;
            // Compare the digit count first
            if (this.digitCount > otherInt.digitCount) {
                return true;
            } else if (this.digitCount < otherInt.digitCount) {
                return false;
            }
            // If digit counts are the same, compare each digit from left to right
            for (int i = this.digitCount - 1; i >= 0; i--) {
                if (this.num[i] > otherInt.num[i]) {
                    return true;
                } else if (this.num[i] < otherInt.num[i]) {
                    return false;
                }
            }
            // The numbers are equal
            return false;
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LargeInteger) {
            LargeInteger otherInt = (LargeInteger) other;
            // Compare the digit count first
            if (this.digitCount != otherInt.digitCount) {
                return false;
            }
            // If digit counts are the same, compare each digit from left to right
            for (int i = 0; i < this.digitCount; i++) {
                if (this.num[i] != otherInt.num[i]) {
                    return false;
                }
            }
            // The numbers are equal
            return true;
        }
        return false;
    }
}
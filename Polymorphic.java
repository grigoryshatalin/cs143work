/**
 * 
 * @author Grigory Shatalin
 *
 */

public class Polymorphic {
    
    public static boolean isSorted(Relatable[] objArray) {
        // If the array has 0 or 1 elements, it is considered sorted
        if (objArray.length <= 1) {
            return true;
        }
    
        for (int i = 0; i < objArray.length - 1; i++) {
            // Compare the current object with the next one
            if (objArray[i].isGreater(objArray[i + 1])) {
                return false; // If the current object is greater than the next one, it's not sorted
            }
        }
    
        return true; // All objects have been compared and are in order
    }
    
}

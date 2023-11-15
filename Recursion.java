/**
 * @author Grigory Shatalin
 * Calculates the product of even numbers up to n.
 *
 * @param n The input integer (must be greater than 0).
 * @return The product of even numbers up to n.
 * @throws IllegalArgumentException if n is not greater than 0.
 */
public class Recursion {

  public static int productOfEvens(int n) throws IllegalArgumentException {
    if (n <= 0) {
      throw new IllegalArgumentException("Input must be greater than 0");
    }
    if (n == 1) {
      return 2;
    } else {
      return 2 * n * productOfEvens(n - 1);
    }
  }

  /**
   * Counts the number of matching digits between two non-negative integers.
   *
   * @param n1 The first non-negative integer.
   * @param n2 The second non-negative integer.
   * @return The count of matching digits.
   * @throws IllegalArgumentException if n1 or n2 is negative.
   */
  public static int countDigitMatches(int n1, int n2) throws IllegalArgumentException {
    if (n1 < 0 || n2 < 0) {
      throw new IllegalArgumentException("Inputs must be non-negative");
    }
    if (n1 == 0 || n2 == 0) {
      return 0;
    } else {
      int lastDigitMatch = (n1 % 10 == n2 % 10) ? 1 : 0;
      return lastDigitMatch + countDigitMatches(n1 / 10, n2 / 10);
    }
  }

  /**
   * Generates a pattern based on the input value.
   *
   * @param a The input integer (must be greater than or equal to 1).
   * @return The generated pattern as a string.
   * @throws IllegalArgumentException if a is not greater than or equal to 1.
   */
  public static String generatePattern(int a) {
    if (a < 1) {
      throw new IllegalArgumentException("Passed value is not greater than or equal to 1");
    }

    if (a == 1) {
      return "1";
    } else if (a == 2) {
      return "11";
    } else {
      int b = (a + 1) / 2;
      return b + generatePattern(a - 2) + b;
    }
  }

  /**
   * Recursively finds the index of the minimum element in an array.
   *
   * @param array The input array.
   * @param current The current index during recursion.
   * @param minLocation The index of the current minimum element.
   * @return The index of the minimum element in the array.
   */
  public static int recFindMin(int[] array, int current, int minLocation) {
    if (current == array.length) {
      return minLocation;
    } else {
      if (array[current] < array[minLocation]) {
        return recFindMin(array, current + 1, current);
      } else {
        return recFindMin(array, current + 1, minLocation);
      }
    }
  }

  /**
   * Finds the index of the minimum element in an array.
   *
   * @param array The input array (must not be empty).
   * @return The index of the minimum element in the array.
   * @throws IllegalArgumentException if the array is empty.
   */
  public static int findMin(int[] array) {
    if (array.length == 0) {
      throw new IllegalArgumentException("Array must not be empty");
    }
    return recFindMin(array, 1, 0);
  }

  /**
   * Recursively performs selection sort on an array.
   *
   * @param array The input array.
   * @param startIndex The starting index during recursion.
   */
  public static void recSelectionSort(int[] array, int startIndex) {
    if (startIndex < array.length) {
      int minIndex = recFindMin(array, startIndex, startIndex);
      int temp = array[startIndex];
      array[startIndex] = array[minIndex];
      array[minIndex] = temp;
      recSelectionSort(array, startIndex + 1);
    }
  }

  /**
   * Performs selection sort on an array.
   *
   * @param array The input array.
   */
  public static void selectionSort(int[] array) {
    if (array.length > 0) {
      recSelectionSort(array, 0);
    }
  }
}

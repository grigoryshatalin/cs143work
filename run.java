public class run {
    public static void main(String[] args) {
        String n = generatePattern(2);
        System.out.println(n);
    }

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

}

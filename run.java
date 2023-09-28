public class run {
    public static void main(String[] args){
        Fraction a = new Fraction(12, 8);
        Fraction b = new Fraction(3, 10);
        System.out.println(a.toString());
        a.add(b);
        System.out.println(a.toString());
    }
}

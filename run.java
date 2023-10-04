public class run {
    public static void main(String[] args){
        Fraction f2 = new Fraction(3, 4);   
        Rectangle[] array2 = {new Rectangle(10, 30), new Rectangle(11, 22), new Rectangle(7, 2)};
        Aggregation obj2 = new Aggregation(f2, array2, 3.4);
        array2[1].setWidth(100);// changing the original Rectangle object in array
        System.out.println(obj2.toString());
    }  
}

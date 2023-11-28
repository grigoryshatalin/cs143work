public class run {
    public static void main(String[] args) {
        int count = 0;
        int expectedCount = 2;
            
        List list1 = new List();
        list1.add(6);
        list1.add(5);
        list1.add(3);
        list1.add(4);
        list1.add(2);
        list1.add(1);
        
        List list2 = new List();
        list2.add(102);
        list2.add(101);     
        
        List list3 = new List();
        list3.add(100);
        list3.add(101);
        list3.add(102);
         
        List list4 = new List();
        list4.add(100);
        
        list1.selectionSort();
        list2.selectionSort();
        list3.selectionSort();
        list4.selectionSort();

        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list3.toString());
        System.out.println(list4.toString());

       
}
}
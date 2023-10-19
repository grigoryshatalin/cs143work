public class run{
    public static void main(String[] args){
        int[] color11 = { 22, 33, 44 };
        Circle c11 = new Circle(55, 66, 7, color11);
		Circle c4 = c11.clone();

        int[] tmp = {100, 100, 100};
		c11.setColor(tmp);
        System.out.println(c4.toString());
        System.out.println(c11.toString());


    }
    public static boolean equalArrays(int[] one, int[] two) {
		if (one.length != two.length)
			return false;
		for (int i = 0; i < one.length; i++) {
			if (one[i] != two[i])
				return false;
		}
		return true;
	}
}
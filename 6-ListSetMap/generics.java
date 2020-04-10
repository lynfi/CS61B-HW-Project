public class generics {
	
	public static <T> T test(T... x) {
		return x[1];
	}

    public static void main(String[] args) {
    	int y = test(1, 2);
    	System.out.println(y);
    }
}
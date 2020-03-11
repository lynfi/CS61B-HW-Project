public class TestBody {
    public static void main(String[] args) {
    	Body a = new Body(0., 0., 1., 1., 2., "a");
    	Body b = new Body(1., 1., 1., 1., 2., "b");
    	System.out.println(a.calcForceExertedBy(b));
    	System.out.println(b.calcForceExertedBy(a));
    }
}
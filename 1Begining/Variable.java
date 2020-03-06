public class Variable {
    public static void main(String[] args) {
        int x = 0, t = 0;
        while (x < 10) {
            System.out.print(t + " ");
            x = x + 1;
            t = t + x;
        }
    }
}
public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(15);
		Dog d2 = d;
		d2 = new Dog(111);
		d.makeNoise();
    }
}
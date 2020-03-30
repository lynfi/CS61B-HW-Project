public interface List61B<Item> {
    public void insert(Item x, int position);

    public void addFirst(Item x);

    public void addLast(Item x);

    public Item getFirst();

    public Item getLast();

    public Item get(int i);

    public int size();

    public Item removeLast();

    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
    }

    public static void peek(List61B<String> list) {
        System.out.println(list.getLast());
    }

    public static void peek(SLList<String> list) {
        System.out.println(list.getFirst());
    }

    public static void main(String[] args) {
        SLList<String> SP = new SLList<String>();
        List61B<String> LP = SP;
        SP.addLast("elk");
        SP.addLast("are");
        SP.addLast("cool");
        peek(SP);
        peek(LP);
        SP.print();
        LP.print();
    }
}
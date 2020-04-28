import java.util.Scanner; 

public class WeightedQuickUnionPathCompress {
	int[] size;
	int[] parent;
	int count;

	public WeightedQuickUnionPathCompress(int n) {
		count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			size[i] = 1;
			parent[i] = i;
		}
	}

	// Return the root of the set which contains p, compress the path
	public int find(int p) {
		int root = p;
		while (root != parent[root]) {
			root = parent[root];
		}
		while (p != root) {
			int temp = parent[p];
			parent[p] = root;
			p = temp;
		}
		return root;
	}

	// Connect p and q
	public void connect(int p, int q) {
		int rootp = find(p);
		int rootq = find(q);
		if (rootp == rootq)
			return;
		if (size[rootp] > size[rootq]) {
			parent[rootq] = rootp;
			size[rootp] += size[rootq];
		} else {
			parent[rootp] = rootq;
			size[rootq] += size[rootp];
		}
		count--;
	}

	// Return ture if p and q are in the same set.
	public boolean isConnected(int p, int q) {
		return (find(p) == find(q));
	}

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	WeightedQuickUnionPathCompress t = new WeightedQuickUnionPathCompress(n);
    	int m = in.nextInt();
    	for(int i = 0; i < m; i++) {
    		in.nextLine();
    		String s = in.nextLine();
    		int p = in.nextInt();
    		int q = in.nextInt();
    		System.out.println(p + " " + q);
    		if (s.equals("connect")) {
    			t.connect(p, q);
    		} else {
    			System.out.println(t.isConnected(p, q));
    		}
    	}
    	System.out.println(t.count + " components");
    }
}
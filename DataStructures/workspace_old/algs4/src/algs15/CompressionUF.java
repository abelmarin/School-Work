package algs15;
import java.util.Arrays;
import  stdlib.*;

/* **************************************************************************
 *  Compilation:  javac QuickUnionPathCompressionUF.java
 *  Execution:  java QuickUnionPathCompressionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-union with path compression.
 *
 ****************************************************************************/

public class CompressionUF implements UF {
	private int[] id;    // id[i] = parent of i
	private int count;   // number of components

	// Create an empty union find data structure with N isolated sets.
	public CompressionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	// Return the number of disjoint sets.
	public int count() {
		return count;
	}

	public static boolean DEBUG=false;
	
	// Return component identifier for component containing p
	public int find(int p) {
		int root = p;
		while (root != id[root])
			root = id[root];
		while (p != root) {
			int newp = id[p];
			id[p] = root;
			p = newp;
			if (DEBUG) GraphvizBuilder.ufToFile (id);
		}
		return root;
	}

	// Are objects p and q in the same set?
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}


	// Replace sets containing p and q with their union.
	public void union(int p, int q) {
		int pid = find(p); // loser
		int qid = find(q); // champion
		if (pid == qid) return;
		id[pid] = qid;
		count--;
	}

	public String toString() { return Arrays.toString (id); }

	public static void main(String[] args) {
		StdIn.fromFile ("data/tinyUF.txt");
		//StdIn.fromFile ("data/mediumUF.txt");
		//StdIn.fromFile ("data/largeUF.txt");

		int N = StdIn.readInt();
		CompressionUF uf = new CompressionUF(N);

		// read in a sequence of pairs of integers (each in the range 0 to N-1),
		// calling find() for each pair: If the members of the pair are not already
		// call union() and print the pair.
		Stopwatch sw = new Stopwatch ();
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
			GraphvizBuilder.ufToFile (uf.id);
		}
		StdOut.format("QuickUnionPathCompressionUF # components: %d [%f]\n", uf.count(), sw.elapsedTime ());
	}

}

package algs15.perc;

//import stdlib.*;
import algs15.*;

// Uncomment the import statements above.

// You can test this using InteractivePercolationVisualizer and PercolationVisualizer
// All methods should make at most a constant number of calls to the UF data structure,
// except percolates(), which may make up to N calls to the UF data structure.
public class Percolation {
	int N;
	boolean[] open;
	UF full;
	UF perc;
	public Percolation(int N) {
		this.N = N;
		this.open = new boolean[N*N];
		this.full = new WeightedUF(N*N);
		this.perc = new WeightedUF(N*N);
		for (int i = 0; i < N-1; i++) {
            full.union(i, i+1);
            perc.union(i, i+1);
            perc.union(i+N*(N-1), i+N*(N-1)+1);
        }
	}
	public void open(int i, int j) {
	    int pos = i*N+j;
	    open[pos] = true;
	    if (i+1 < N) {
	        if (isOpen(i+1,j)) {
	        	perc.union(pos, (i+1)*N+j);
	        	full.union(pos, (i+1)*N+j);
	        }
	    }
	    if (i-1 >= 0) {
		    if (isOpen(i-1,j)) {
	        	perc.union(pos, (i-1)*N+j);
	        	full.union(pos, (i-1)*N+j);
	        }
	    }
	    if (j+1 < N) {
	        if (isOpen(i,j+1)) {
	        	perc.union(pos, pos+1);
	        	full.union(pos, pos+1);
	        }
	    }
	    if (j-1 >= 0) {
	        if (isOpen(i,j-1)) {
	        	perc.union(pos, pos-1);
	        	full.union(pos, pos-1);
	        }
	    }
	}
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		return open[i*N+j];
	}
	// is site (row i, column j) full?  BLUE
	public boolean isFull(int i, int j) {
		return isOpen(i,j) && full.connected(0, i*N+j);
	}
	// does the system percolate?
	public boolean percolates() {
		return perc.connected(0, N*N-1);
	}
}
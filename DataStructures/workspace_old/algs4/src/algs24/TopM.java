package algs24;
import stdlib.*;
import algs12.Transaction;
import algs13.Stack;

public class TopM {

	// Print the top M lines in the input stream.
	public static void main(String[] args) {
		args = new String[] { "5" };
		StdIn.fromFile ("data/tinyBatch.txt");

		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<>(M+1);

		while (StdIn.hasNextLine()) {
			// Create an entry from the next line and put on the PQ.
			String line = StdIn.readLine();
			Transaction transaction = new Transaction(line);
			pq.insert(transaction);

			// remove minimum if M+1 entries on the PQ
			if (pq.size() > M)
				pq.delMin();
		}   // top M entries are on the PQ

		// print entries on PQ in reverse order
		Stack<Transaction> stack = new Stack<>();
		for (Transaction transaction : pq)
			stack.push(transaction);
		for (Transaction transaction : stack)
			StdOut.println(transaction);
	}
}


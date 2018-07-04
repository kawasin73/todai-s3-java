public class NQueenMain {

	 public static void abort(String msg) {
        System.err.println("Usage: java NQueenMain <queens>");
        System.err.println(msg);
        System.exit(1);
    }

	 public static void main(String[] args) {
	 	if (args.length != 1){
	 		abort("Invalid length of args");
	 		return;
	 	}
	 	int n = 0;
	 	try {
	 		n = Integer.parseInt(args[0]);
	 	} catch(NumberFormatException e) {
	 		abort("Invalid # of queens: " + args[0]);
	    }
	 	if (n<=0) {
	 		abort("Invalid # of queens: " + args[0]);
	 	}

	 	NQueen nq = new NQueen(n);

	 	if (nq.tryQueen(0)) {
	 		nq.print();
	 	} else {
	 		System.out.println("No solution.");
	 	}
	}
}
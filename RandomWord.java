import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Scanner;

public class RandomWord {

	public static void main(String[] args) {
		String Champion ="";
		new Scanner(System.in);
		
		while(!StdIn.isEmpty()) {
			String Challenger = StdIn.readString();
			
			if (Champion == "") {
				Champion = Challenger;
			}
			
			else {
			if (StdRandom.bernoulli() == true) {
				Champion = Challenger;
			}
		}
		}
		
		System.out.println(Champion);

	}

}

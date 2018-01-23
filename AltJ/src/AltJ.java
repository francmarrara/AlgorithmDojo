import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AltJ {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// Liste di numeri
		ArrayList<Integer> positivi = new ArrayList<Integer>();
		ArrayList<Integer> negativi = new ArrayList<Integer>();
		// inizio a leggere e memorizzare

		String s = scanner.next();

		while (!s.equals("<END>")) {
			int n = Integer.parseInt(s);

			if (n < 0) {
				negativi.add(n);
			} else {
				positivi.add(n);
			}
			s = scanner.next();
		}

		/*
		 * Collections.sort use Mergesort and Not QuickSort! QuickSort has two major
		 * deficiencies when compared to mergesort:
		 * 
		 * 1) It's not stable (as parsifal noted). 2) It doesn't guarantee n log n
		 * performance; it can degrade to quadratic performance on pathological inputs.
		 * 
		 */
		Collections.sort(positivi);
		Collections.sort(negativi);

		int MaxDim = Math.max(positivi.size(), negativi.size());

		for (int i = 0; i < MaxDim; i++) {

			if (i < negativi.size())
				System.out.println(negativi.get(i));

			if (i < positivi.size())
				System.out.println(positivi.get(i));

		}

	}
}
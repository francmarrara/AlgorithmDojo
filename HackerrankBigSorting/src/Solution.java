import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Solution {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		ArrayList<String> numbers = new ArrayList<String>();

		int size = in.nextInt();

		for (int i = 0; i < size; i++) {
			numbers.add(in.next());
		}
		CompareStringsAsBigIntegers s = new CompareStringsAsBigIntegers();
		Collections.sort(numbers, s);

		for (String s2 : numbers) {
			System.out.println(s2);

		}
		// your code goes here
	}

}
import java.util.Comparator;

public class CompareStringsAsBigIntegers implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) < s2.charAt(i))
				return -1;
			if (s1.charAt(i) > s2.charAt(i))
				return 1;
		}

		return 0;

	}

}
import java.util.Arrays;
import java.util.Scanner;

// goo.gl/JfoL2J
public class Pr10739 {
	static char[] str;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int j = 1; j <= tc; j++) {
			str = in.next().toCharArray();
			int u = str.length;
			cache = new int[u][u];
			for (int i = 0; i < u; i++)
				Arrays.fill(cache[i], -1);
			System.out.println("Case " + j + ": " + solve(0, u - 1));
		}
	in.close();
	}

	private static int solve(int i, int j) {
		// TODO Auto-generated method stub
		if (i >= j)
			return 0;
		if (cache[i][j] != -1)
			return cache[i][j];
		int u = (str[i] == str[j]) ? 0 : 1;//boolean statement ? true result : false result;

		return cache[i][j] = Math.min(solve(i + 1, j - 1) + u, Math.min(solve(i + 1, j), solve(i, j - 1)) + 1);
	}
}
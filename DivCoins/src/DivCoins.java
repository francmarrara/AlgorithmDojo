import java.util.Arrays;
import java.util.Scanner;

/**
 * UVa Online Judge Problem #562 - Dividing coins
 *
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class DivCoins {
  private static Scanner scn = new Scanner(System.in);

  public static void main(String [] args) {
    int n = scn.nextInt();
    for (int i = 0; i < n; i++) {
      testCase();
    }
  }

  public static void testCase() {
    int m = scn.nextInt();

    // Special case when there are 0 coins
    if (m == 0) {
      System.out.println("0");
      return;
    }

    int [] coins = new int[m];

    int sum = 0;
    for (int i = 0; i < m; i++) {
      coins[i] = scn.nextInt();
      sum += coins[i];
    }

    boolean [][] table = new boolean[m][sum+1];
    table[0][0] = true; // Zero is possible!
    table[0][coins[0]] = true; // The first coin is possible

    for (int i = 1; i < m; i++) {
      for (int s = 0; s <= sum - coins[i]; s++) {
        if (table[i-1][s]) {
          table[i][s] = true; // Still possible
          table[i][s+coins[i]] = true; // New possible sum
        }
      }
    }

    int k = sum / 2; // Middle point of the table
    while (!table[m-1][k]) {
      k--;
    }

    System.out.println(sum - 2*k);
  }
}
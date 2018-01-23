import java.util.ArrayList;
import java.util.Scanner;

class Grade {
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Grade(int _score) {
		this.score = _score;
	}

	public boolean islessthan3() {
		if (((score + 1) % 5 == 0) && score > 37) {
			score += 1;
			return true;
		} else if (((score + 2) % 5 == 0) && score > 37) {
			score += 2;
			return true;
		}

		return false;

	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		ArrayList<Grade> scores = new ArrayList<Grade>();

		for (int i = 0; i < size; i++) {
			scores.add(new Grade(scanner.nextInt()));
		}

		for (Grade g : scores) {
			g.islessthan3();
			System.out.println(g.getScore());

		}

	}

}

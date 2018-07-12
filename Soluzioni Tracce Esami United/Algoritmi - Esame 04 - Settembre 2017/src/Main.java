

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Esame exam = new Esame();
		exam.readInput();
		System.out.println(exam.testIsLegalInput());

	}
}
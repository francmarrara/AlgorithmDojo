
public class StringaPalindroma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ADAM";
		if(s.equals(new StringBuilder(s).reverse().toString()))
			System.out.println("palindroma");
	}

}

/*
 * boolean isPalindrome(String s) {
 
int n = s.length();
for (int i = 0; i < (n/2); ++i) {
   if (s.charAt(i) != s.charAt(n - i - 1)) {
       return false;
   }
}

return true;
}
*/
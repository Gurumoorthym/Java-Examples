package javaUtilities;

public class Palindrome {
	public static boolean isPalindrome(String word) {
		if(null != word) {
		return new StringBuilder(word).reverse().toString().equalsIgnoreCase(word);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("December"));
		System.out.println(isPalindrome("Madam"));
	}
	
}

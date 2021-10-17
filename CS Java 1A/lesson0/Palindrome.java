import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		String word;

		// initialize Scanner
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\n");

		System.out.println("Enter a word: ");
		word = input.next();

		System.out.println(reverseString(word));


	}
	public static void checkPalindrome(String checkWord) {
		int wordLength;
		int leftValue;
		int rightValue;
		wordLength = checkWord.length();

		if ((wordLength) % 2 == 0) {
			int center = ((wordLength) / 2) - 1;
			leftValue = center;
			rightValue = center + 1;
		}

		else{
			int center = ((wordLength) / 2);
			leftValue = center - 1;
			rightValue = center + 1;
		}

		while (leftValue >= 0 && rightValue <= wordLength) {
			char l = checkWord.charAt(leftValue);
			char r = checkWord.charAt(rightValue);

			if (l == r) {
				leftValue--;
				rightValue++;
			}

			else {
				System.out.println("The word is not a Palindrome.");
				return;
			}
		}
		System.out.println("The word is a Palindrome.");
		return;
	}

	public static String reverseString(String checkWord){
		String reverseWord = "";
		int wordLength = checkWord.length();
		int charSpot = wordLength-1;
		char c;

		while (charSpot>=0){
			c = checkWord.charAt(charSpot);
			reverseWord += c;
			charSpot--;
			}
		return reverseWord;
		}
	}
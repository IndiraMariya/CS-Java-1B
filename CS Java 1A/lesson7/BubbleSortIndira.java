import java.util.Scanner;
/*
This program takes an input from the user, or from a text file.
Then, it returns an array that has the numbers from the input listed in order.
 */

public class BubbleSortIndira {
	public static void main(String[] args) {
		//declare variables
		int arrayCount;
		int tempValue;

		// initialize Scanner
		Scanner input = new Scanner(System.in);

		// check args to see if it should be interactive mode
		if (args.length > 0){
			if (args[0].equals("-interactive")) System.out.print("Enter count: ");
		}

		// take count input to create a new array
		arrayCount = input.nextInt();
		int[] inputArray = new int[arrayCount];

		// check args to see if it should be interactive mode
		if (args.length > 0){
			if (args[0].equals("-interactive")) System.out.print("Enter Number List: ");
		}

		// check to make sure input is valid
		if (input.hasNextInt()) {
			for (int i = 0; i < arrayCount; i++)
				inputArray[i] = input.nextInt();
		}
		else System.out.println("Bad Input");

		// use Bubble Sort to sort the array from smallest to biggest
		for (int x = 0; x < inputArray.length; x++) {
			for (int i = 1; i < inputArray.length; i++) {
				if (inputArray[i - 1] > inputArray[i]) {

					tempValue = inputArray[i - 1];
					inputArray[i - 1] = inputArray[i];
					inputArray[i] = tempValue;
				}
			}
		}

		// check args to see if it should be interactive mode
		if (args.length > 0){
			if (args[0].equals("-interactive")) System.out.print("Sorted Number List: ");
		}

		// print the sorted array
		for (int i = 0; i < inputArray.length; i++) System.out.print(inputArray[i]+ " ");
		System.out.println("");

	}
}

/*
Output:
Indiras-MacBook-Pro:src indiram$ java BubbleSortIndira -interactive
Enter count: 10
Enter Number List: 45 34 2 45 56 2 67 3 55 99
Sorted Number List: 2 2 3 34 45 45 55 56 67 99

Indiras-MacBook-Pro:src indiram$ java BubbleSortIndira < 20nums.txt
-865 -824 -820 -803 -678 -631 -540 -536 -436 -297 -103 -57 160 322 363 494 494 638 688 746

Indiras-MacBook-Pro:src indiram$ java BubbleSortIndira < 50nums.txt
195 208 623 1206 1560 1594 1645 1697 1763 1868 1994 2181 2946 3018 3061 3074 3179 3316 3343 3841 3853 3926 4203 4714 4724 4867 4985 5101 5253 5260 5606 5706 5844 6681 6687 6925 7181 7192 7355 7396 7481 7968 8216 8418 8838 9001 9076 9204 9703 9963

Indiras-MacBook-Pro:src indiram$ java BubbleSortIndira < 100nums.txt
1 1 3 3 5 9 10 11 17 17 17 19 19 20 21 25 26 27 27 27 27 29 30 33 35 36 37 38 39 42 42 42 42 42 43 44 44 44 44 45 45 46 47 48 50 51 51 52 52 52 53 55 55 55 57 57 58 58 60 61 61 62 62 63 63 63 64 66 67 68 69 69 70 70 72 72 74 74 78 81 81 81 81 82 82 83 84 86 87 88 88 92 92 93 93 94 95 95 100 100
 */
import java.util.Scanner;
/*
The program gets information stored in a file and converts it into a organized receipt.
 */

public class FinalReceiptIndira {
	public static void main(String[] args) {

		// declare variables
		int itemNumber = 0;
		double finalTotal = 0;
		final double CLUBCARD = 0.05;
		final double TAX = 0.0875;
		double taxPrice;
		double clubcardPrice;

		// initialize scanner
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\n");

		// check if the number of items is a valid input
		if (input.hasNextInt()) {
			itemNumber = input.nextInt();
			if (itemNumber < 0) {
				System.out.println("Sorry, invalid data. Goodbye!");
				System.exit(0);
			}
		}
      else {
			System.out.println("Sorry, invalid data. Goodbye!");
			System.exit(0);
		}

		// declare arrays to store product info
      String[] nameArray = new String[itemNumber];
		double[] priceArray = new double[itemNumber];
		double[] amountArray = new double[itemNumber];

		getProdInfo(input, itemNumber, nameArray, priceArray, amountArray);

		// Print Overall Info
		System.out.println("------------------------------------");
		System.out.println("SaveMart Receipt");
		System.out.println("123 Main Street");
		System.out.println("San Jose CA 95135");
		System.out.println("");

		// Print product info and calculate subtotal
		for (int i = 0; i < itemNumber; i++)
			finalTotal += outputProdInfo(nameArray[i],priceArray[i],amountArray[i]);

		// Print the tax and clubcard info and final total
		System.out.println("");
		System.out.printf("%-30s%6.2f\n", "SUBTOTAL", finalTotal);

		clubcardPrice = finalTotal * CLUBCARD;
		finalTotal -= clubcardPrice;
		System.out.printf("%-30s%6.2f\n","CLUBCARD Saving 5%", clubcardPrice);

		taxPrice = finalTotal * TAX;
		finalTotal += taxPrice;
		System.out.printf("%-30s%6.2f\n", "TAX 8.75%", taxPrice);

		System.out.printf("%-30s%6.2f\n", "TOTAL", finalTotal);
		System.out.println("------------------------------------");
	}

	// Gathers product info based on the number of items and puts the values into an array
	public static void getProdInfo(Scanner input, int items, String[] prodName,double[] prodPrice, double[] prodAmount ) {
		for (int i  = 0; i < items; i++) {
			prodName[i] = input.next();

			// Checks if the input for product price is valid
			if (input.hasNextDouble()) {
				prodPrice[i] = input.nextDouble();
				if (prodPrice[i] < 0) {
					System.out.println("Sorry, invalid data. Goodbye!");
					System.exit(0);
				}
			} else {
				System.out.println("Sorry, invalid data. Goodbye!");
				System.exit(0);
			}

         // Checks if the input for product price is valid
			if (input.hasNextDouble()) {
				prodAmount[i] = input.nextDouble();
				if (prodAmount[i] < 0) {
					System.out.println("Sorry, invalid data. Goodbye!");
					System.exit(0);
				}
			} else {
				System.out.println("Sorry, invalid data. Goodbye!");
				System.exit(0);
			}
		}
		return;
	}
	// Prints product info (price, name, weight/amount)
	public static double outputProdInfo(String prodName, double prodPrice, double prodWeight) {
		double prodTotal = prodWeight * prodPrice;
		System.out.printf("%-30s%6.2f\n", prodName, prodTotal);
		System.out.printf("%6.2f at %6.2f\n", prodWeight, prodPrice);
		return prodTotal;
	}
}

/*
Output
Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-good1.txt
------------------------------------
SaveMart Receipt
123 Main Street
San Jose CA 95135

Honey Crisp Apples              2.60
  2.00 at   1.30
Captain Crunch                  8.25
  2.50 at   3.30
Wonder Bread                    4.50
  3.00 at   1.50

SUBTOTAL                       15.35
CLUBCARD Saving 5%              0.77
TAX 8.75%                       1.28
TOTAL                          15.86
------------------------------------


Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-good2.txt
------------------------------------
SaveMart Receipt
123 Main Street
San Jose CA 95135

Oven Joy Bread                  1.98
  2.00 at   0.99
Lucerne Milk                    2.29
  1.00 at   2.29
Hormel Chili with Beans         3.87
  3.00 at   1.29
12-pack Blue Moon              12.99
  1.00 at  12.99
Organic Navel Oranges           3.73
  2.50 at   1.49
Granny Smith Apples             1.74
  1.60 at   1.09
Tillamook Greek Yogurt          6.00
  6.00 at   1.00

SUBTOTAL                       32.60
CLUBCARD Saving 5%              1.63
TAX 8.75%                       2.71
TOTAL                          33.68
------------------------------------



Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-good3.txt
------------------------------------
SaveMart Receipt
123 Main Street
San Jose CA 95135

CEPES                           5.69
  1.00 at   5.69
CHAMPIGNON GEANT                4.03
  3.70 at   1.09
RISOTTO AU FROMAGE             13.34
  2.00 at   6.67
CHATAIGNES                      7.20
  6.00 at   1.20
CHOU FRISE                      5.67
  3.00 at   1.89

SUBTOTAL                       35.93
CLUBCARD Saving 5%              1.80
TAX 8.75%                       2.99
TOTAL                          37.12
------------------------------------

Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-bad1.txt
Sorry, invalid data. Goodbye!

Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-bad2.txt
Sorry, invalid data. Goodbye!

Indiras-MacBook-Pro:src indiram$ java FinalReceiptIndira < input-bad3.txt
Sorry, invalid data. Goodbye!

 */
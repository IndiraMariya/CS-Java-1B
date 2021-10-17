import java.util.Scanner;
/*
 This program is a more efficient version of the Robust Receipt.
 The program takes the product information provided by the input and puts it into a receipt format using methods.
 */

public class ConciseReceiptIndira {
	public static void main(String[] args) {
      // Declare variables
		double prodPrice1;
		double prodWeight1;
		String prodName1;

		double prodPrice2;
		double prodWeight2;
		String prodName2;

		double prodPrice3;
		double prodWeight3;
		String prodName3;

		double prodTotal1;
		double prodTotal2;
		double prodTotal3;

		final double CLUBCARD = 0.05;
		final double TAX = 0.0875;
		double totalPrice;

		double taxPrice;
		double clubcardPrice;

		String subtotalText = "SUBTOTAL";
		String clubcardText = "CLUBCARD Saving 5%";
		String taxText = "TAX 8.75%";
		String totalText = "TOTAL";

		// Initialize Scanner
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\n");

		// Get First product Information
		System.out.print("Enter Product Name: ");
		prodName1 = input.next();
		prodPrice1 = getProdInfo(input,prodName1, "price");
		prodWeight1 = getProdInfo(input, prodName1, "weight/quantity");

		// Get Second Product Information
		System.out.print("Enter Product Name: ");
		prodName2 = input.next();
		prodPrice2 = getProdInfo(input,prodName2, "price");
		prodWeight2 = getProdInfo(input, prodName2, "weight/quantity");

		// Get Third Product Information
		System.out.print("Enter Product Name: ");
		prodName3 = input.next();
		prodPrice3 = getProdInfo(input,prodName3, "price");
		prodWeight3 = getProdInfo(input, prodName3, "weight/quantity");

		// Print Overall Info
		System.out.println("------------------------------------");
		System.out.println("SaveMart Receipt");
		System.out.println("123 Main Street");
		System.out.println("San Jose CA 95135");
		System.out.println("");

		// Print Specific Product info
		outputProdInfo(prodName1, prodPrice1, prodWeight1);
		outputProdInfo(prodName2, prodPrice2, prodWeight2);
		outputProdInfo(prodName3, prodPrice3, prodWeight3);

		// Calculate and Print the Totals
		prodTotal1 = prodPrice1 * prodWeight1;
		prodTotal2 = prodPrice2 * prodWeight2;
		prodTotal3 = prodPrice3 * prodWeight3;

		totalPrice = prodTotal1 + prodTotal2 + prodTotal3;   // calculating the subtotal
		System.out.println("");
		System.out.printf("%-30s%6.2f\n", subtotalText, totalPrice);

		clubcardPrice = totalPrice * CLUBCARD; // calculating the amount decreased from the subtotal
		totalPrice -= clubcardPrice;  // decreasing clubcard offer from subtotal
		System.out.printf("%-30s%6.2f\n", clubcardText, clubcardPrice);

		taxPrice = totalPrice * TAX;  // calculating amount added to subtotal
		totalPrice += taxPrice;      // adding tax to subtototal
		System.out.printf("%-30s%6.2f\n", taxText, taxPrice);

		System.out.printf("%-30s%6.2f\n", totalText, totalPrice);
		System.out.println("------------------------------------");
	}

	// Prompt for, read, and return a double
	public static double getProdInfo(Scanner input, String prodName, String valType) {
		double prodInfo = 0;
		System.out.println("Enter "+ prodName + " " + valType + ": ");

		// Checks if the inout is valid
		if (input.hasNextDouble()) {
			prodInfo = input.nextDouble();
			if (prodInfo < 0) {
				System.out.println("Sorry, invalid data. Goodbye!");
				System.exit(0);
			}
		}
		else {
			System.out.println("Sorry, invalid data. Goodbye!");
			System.exit(0);
		}
		return prodInfo;
	}

	// Shows line item for a product
	public static void outputProdInfo(String prodName, double prodPrice, double prodWeight) {
		double prodTotal = prodWeight * prodPrice;
		System.out.printf("%-30s%6.2f\n", prodName, prodTotal);
		System.out.printf("%6.2f at %6.2f\n", prodWeight, prodPrice);
		return;
	}
}

/*
Output:

ras-MacBook-Pro:src indiram$ java ConciseReceiptIndira < input-good1.txt
Enter Product Name: Enter Oven Joy Bread price:
Enter Oven Joy Bread weight/quantity:
Enter Product Name: Enter Lucerne Milk price:
Enter Lucerne Milk weight/quantity:
Enter Product Name: Enter Hormel Chili with Beans price:
Enter Hormel Chili with Beans weight/quantity:
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

SUBTOTAL                        8.14
CLUBCARD Saving 5%              0.41
TAX 8.75%                       0.68
TOTAL                           8.41
------------------------------------


Indiras-MacBook-Pro:src indiram$ java ConciseReceiptIndira < input-good2.txt
Enter Product Name: Enter CEPES price:
Enter CEPES weight/quantity:
Enter Product Name: Enter CHAMPIGNON GEANT price:
Enter CHAMPIGNON GEANT weight/quantity:
Enter Product Name: Enter RISOTTO AU FROMAGE price:
Enter RISOTTO AU FROMAGE weight/quantity:
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

SUBTOTAL                       23.06
CLUBCARD Saving 5%              1.15
TAX 8.75%                       1.92
TOTAL                          23.83
------------------------------------


Indiras-MacBook-Pro:src indiram$ java ConciseReceiptIndira < input-bad1.txt
Enter Product Name: Enter Oven Joy Bread price:
Enter Oven Joy Bread weight/quantity:
Enter Product Name: Enter Lucerne Milk price:
Sorry, invalid data. Goodbye!


Indiras-MacBook-Pro:src indiram$ java ConciseReceiptIndira < input-bad2.txt
Enter Product Name: Enter CEPES price:
Enter CEPES weight/quantity:
Sorry, invalid data. Goodbye!
Indiras-MacBook-Pro:src indiram$
 */
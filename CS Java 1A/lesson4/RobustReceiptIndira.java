import java.util.Scanner;

/*
The Robust Reciept gathers product information from the input and prints the info into a formatted receipt.
 */

public class RobustReceiptIndira {
    public static void main(String[] args) {

        // declare variables
        String prodName1;
        double prodPrice1 = 0;
        double prodWeight1 = 0;
        double prodTotal1 = 0;

        String prodName2;
        double prodPrice2 = 0;
        double prodWeight2 = 0;
        double prodTotal2 = 0;

        String prodName3;
        double prodPrice3 = 0;
        double prodWeight3 = 0;
        double prodTotal3 = 0;

        final double CLUBCARD = 0.05;
        final double TAX = 0.0875;
        double totalPrice;

        double taxPrice;
        double clubcardPrice;

        String subtotalText = "SUBTOTAL";
        String clubcardText = "CLUBCARD Saving 5%";
        String taxText = "TAX 8.75%";
        String totalText = "TOTAL";

        // initialize Scanner
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");

        // First Product Information
        // get first product name
        System.out.print("Enter Product Name: ");
        prodName1 = input.next();

        // get first product price
        System.out.print("Enter "+ prodName1+ " price: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodPrice1 = input.nextDouble();
            if (prodPrice1 < 0) {            // check if the input is a positive value
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }

        //get first product weight
        System.out.print("Enter "+ prodName1+ " weight/quantity: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodWeight1 = input.nextDouble();
            if (prodWeight1 < 0) {            // check if the input is a positive value
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }
        System.out.println("");


        // Second Product Information
        // get second product Name
        System.out.print("Enter Product Name: ");
        prodName2 = input.next();

        // get second product price
        System.out.print("Enter "+ prodName2+ " price: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodPrice2 = input.nextDouble();
            if (prodPrice2 < 0) {            // check if the input is a positive value
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }

        // get second product quantity
        System.out.print("Enter "+ prodName2+ " weight/quantity: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodWeight2 = input.nextDouble();
            if (prodWeight2 < 0) {            // check if the input is a positive value
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }
        System.out.println("");


        // Third Product Information
        // get third product name
        System.out.print("Enter Product Name: ");
        prodName3 = input.next();

        // get third product price
        System.out.print("Enter "+ prodName3+ " price: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodPrice3 = input.nextDouble();
            if (prodPrice3 < 0) {            // check if the input is a positive value
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }

        // get third product quantity
        System.out.print("Enter "+ prodName3+ " weight/quantity: ");
        if (input.hasNextDouble()) {            // check if the input is a number
            prodWeight3 = input.nextDouble();            // check if the input is a positive value
            if (prodWeight3 < 0) {
                System.out.println("Sorry, invalid data. Goodbye!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, invalid data. Goodbye!");
            System.exit(0);
        }
        System.out.println("");

        // Calculating product totals
        prodTotal1 = prodPrice1 * prodWeight1;
        prodTotal2 = prodPrice2 * prodWeight2;
        prodTotal3 = prodPrice3 * prodWeight3;


        // printing information in receipt format
        System.out.println("------------------------------------");
        System.out.println("SaveMart Receipt");
        System.out.println("123 Main Street");
        System.out.println("San Jose CA 95135");
        System.out.println("");

        System.out.printf("%-30s%6.2f\n", prodName1, prodTotal1);
        System.out.printf("%6.2f at %6.2f\n", prodWeight1, prodPrice1);

        System.out.printf("%-30s%6.2f\n", prodName2, prodTotal2);
        System.out.printf("%6.2f at %6.2f\n", prodWeight2, prodPrice2);

        System.out.printf("%-30s%6.2f\n", prodName3, prodTotal3);
        System.out.printf("%6.2f at %6.2f\n", prodWeight3, prodPrice3);
        System.out.println("");

        totalPrice = prodTotal1 + prodTotal2 + prodTotal3;   // calculating the subtotal
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
}

/*
Output:
Indiras-MacBook-Pro:src indiram$ java RobustReceiptIndira < input-good.txt
Enter Product Name: Enter Honey Crisp Apples price: Enter Honey Crisp Apples weight/quantity:
Enter Product Name: Enter Captain Crunch price: Enter Captain Crunch weight/quantity:
Enter Product Name: Enter Wonder Bread price: Enter Wonder Bread weight/quantity:
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
Indiras-MacBook-Pro:src indiram$


Indiras-MacBook-Pro:src indiram$ java RobustReceiptIndira < input-bad1.txt
Enter Product Name: Enter Honey Crisp Apples price: Enter Honey Crisp Apples weight/quantity:
Enter Product Name: Enter Captain Crunch price: Sorry, invalid data. Goodbye!
Indiras-MacBook-Pro:src indiram$


Enter Product Name: Enter Honey Crisp Apples price: Enter Honey Crisp Apples weight/quantity:
Enter Product Name: Enter Captain Crunch price: Enter Captain Crunch weight/quantity:
Enter Product Name: Enter Wonder Bread price: Sorry, invalid data. Goodbye!
Indiras-MacBook-Pro:src indiram$


 */
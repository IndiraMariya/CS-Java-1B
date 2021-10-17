import java.util.Scanner;

public class ReceiptIndira {
    public static void main(String[] args) {
        // Delclare variables
        double applePrice;
        double appleWeight;
        double appleTotal;

        double cerealPrice;
        int cerealQuantity;
        double cerealTotal;

        double breadPrice;
        int breadQuantity;
        double breadTotal;

        double subtotal; // price of all the items
        final double CLUBCARD = 0.05;
        final double TAX = 0.0875;
        double clubcardPrice; // %5 of subtotal
        double taxPrice; // total tax

        // initialize Scanner
        Scanner input = new Scanner(System.in);

        // Prompt for input and read amounts
        // apples
        System.out.print("Enter price (Apple per lbs): ");
        applePrice = input.nextDouble();
        System.out.print("Enter weight: ");
        appleWeight = input.nextDouble();

        appleTotal = applePrice * appleWeight;

        // Cereal
        System.out.print("Enter price(Cereal): ");
        cerealPrice = input.nextDouble();
        System.out.print("Enter quantity: ");
        cerealQuantity = input.nextInt();

        cerealTotal = cerealPrice * cerealQuantity;

        // Bread
        System.out.print("Enter price(Bread): ");
        breadPrice = input.nextDouble();
        System.out.print("Enter quantity: ");
        breadQuantity = input.nextInt();

        breadTotal = breadPrice * breadQuantity;

        // calcuating final prices

        // Print general information
        System.out.println("------------------------------------");
        System.out.println("SaveMart Receipt");
        System.out.println("123 Main Street");
        System.out.println("San Jose CA 95135");
        System.out.println("");

        // Print Items
        System.out.println("Honey Crisp Apples            "+ appleTotal);
        System.out.println("  "  + appleWeight + " lbs at " + applePrice + " per lb");

        System.out.println("Cinnamon Toast Crunch         "+ cerealTotal);
        System.out.println("  " + "Quantity "  + cerealQuantity);

        System.out.println("Wonder Bread                  "+ breadTotal);
        System.out.println("  " + "Quantity "  + breadQuantity);

        // Print Prices

        System.out.println("");

        subtotal = appleTotal + cerealTotal + breadTotal;
        System.out.println("SUBTOTAL                      "+ subtotal);

        clubcardPrice = subtotal * CLUBCARD;
        clubcardPrice = Math.round(clubcardPrice*100.0)/100.0;
        System.out.println("CLUBCARD Saving 5%            "+ clubcardPrice);

        subtotal -= clubcardPrice;
        taxPrice = subtotal * TAX;
        taxPrice = Math.round(taxPrice*100.0)/100.0;
        System.out.println("TAX 8.75%                     "+ taxPrice);

        subtotal += taxPrice;
        subtotal = Math.round(subtotal*100.0)/100.0;

        System.out.println("TOTAL                         "+ subtotal);
        System.out.println("------------------------------------");
    }
}

/*
Indiras-MacBook-Pro:lesson2 indiram$ java ReceiptIndira
Enter price (Apple per lbs): 1.30
Enter weight: 2.0
Enter price(Cereal): 3.45
Enter quantity: 2
Enter price(Bread): 1.50
Enter quantity: 3
------------------------------------
SaveMart Receipt
123 Main Street
San Jose CA 95135

Honey Crisp Apples            2.6
  2.0 lbs at 1.3 per lb
Cinnamon Toast Crunch         6.9
  Quantity 2
Wonder Bread                  4.5
  Quantity 3

SUBTOTAL                      14.0
CLUBCARD Saving 5%            0.7
TAX 8.75%                     1.16
TOTAL                         14.46
------------------------------------
Indiras-MacBook-Pro:lesson2 indiram$

 */
import java.util.Scanner;

public class MathTesterIndira {
    public static void main(String[] args) {
        // declare variables
        int mathChoice;
        int num1 = (int)(Math.random()*10)+1;
        int num2 = (int)(Math.random()*10)+1;
        int numS = 0;
        int answer = 0;
        int response = 0;
        boolean isCorrect = false;

        // initialize scanner
        Scanner input = new Scanner(System.in);

        // Shows different math options
        System.out.println("Welcome to Math Tester");
        System.out.println("What are we practicing?");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division (quotient)");
        System.out.println("[5] Division (remainder)");

        // get choice input
        System.out.print("Choice: ");
        mathChoice = input.nextInt();

        // what each of the different choice options do
        switch (mathChoice) {
            case 1:
                System.out.print("What is "+ num1 +" + "+num2+ " ");
                response = input.nextInt();
                answer = num1 +num2;
                break;
            case 2:
                System.out.print("What is "+ num1 +" - "+num2+ " ");
                response = input.nextInt();
                answer = num1 - num2;
                break;
            case 3:
                System.out.print("What is "+ num1 +" * "+num2+" ");
                response = input.nextInt();
                answer = num1 * num2;
                break;
            case 4:
                // to make sure that the number being divided is bigger than the divisor
                if (num2 >num1){
                    numS = num2;
                    num2 = num1;
                    num1 = numS;
                }
                System.out.print("What is "+ num1 +" / "+num2+" ");
                response = input.nextInt();
                answer = num1 / num2;
                break;
            case 5:
                // to make sure that the number being divided is bigger than the divisor
                if (num2 >num1){
                    numS = num2;
                    num2 = num1;
                    num1 = numS;
                }
                System.out.print("What is the remainder of "+ num1 +" / "+num2+" ");
                response = input.nextInt();
                answer = num1 % num2;
                break;
            default: // if none of the given options are chosen
                System.out.println("Not a Valid Choice.");

        }

        // check if the given answer is correct
        isCorrect = (answer == response);

        if (isCorrect){
            System.out.println("That is exactly right!");
        }
        else{
            System.out.println("Nope, it is "+ answer+ ".");
        }


    }
}

/*
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 1
What is 2 + 8 10
That is exactly right!
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 2
What is 1 - 1 3
Nope, it is 0.
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 3
What is 2 * 1 2
That is exactly right!
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 4
What is 9 / 4 5
Nope, it is 2.
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 5
What is the remainder of 4 / 4 0
That is exactly right!
Indiras-MacBook-Pro:lesson3 indiram$ java MathTesterIndira
Welcome to Math Tester
What are we practicing?
[1] Addition
[2] Subtraction
[3] Multiplication
[4] Division (quotient)
[5] Division (remainder)
Choice: 6
Not a Valid Choice.
Indiras-MacBook-Pro:lesson3 indiram$

 */
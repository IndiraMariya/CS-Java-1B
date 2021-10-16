import java.util.Scanner;

// Implements the Tic Tac Toe Game
public class TicTacToeGame
{

   // Implements a 3x3 Grid
   public class Grid
   {
      // Member variable to store the grid
      char grid[][] = new char [3][3];

      // constructor
      public Grid() {
         for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++) {
               grid[r][c] = ' ';
            }
         }
      }

      // Checks if the spot on grid is available
      // Returns true is the spot on the grid is not taken,
      // otherwise returns false
      public boolean isFree(int row, int col)
      {
         // shifts the number back by one, so the rows and columns start from zero
         row -= 1;
         col -= 1;
         if (grid[row][col] == ' ') return true;

         return false;
      }

      // Prints a tic tac toe grid
      public void print()
      {
         for(int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c++)
               System.out.print("+---");
            System.out.println("+");

            for (int c = 0; c < grid[0].length; c++) {
               System.out.print("| " + grid[r][c] + " ");
            }
            System.out.println("|");
         }
         System.out.println("+---+---+---+");
      }

      // Set a grid value at position row, column to player
      // Checks to make sure player is 'X' or 'Y', else prints (eg. if A entered)
      //    Value (A) is not X or O. Exiting.
      // and exits the program.
      public void setGridValue(int row, int col, char player)
      {
         // shifts the number back by one, so the rows and columns start from zero
         row -= 1;
         col -= 1;

         // validates players
         if (player == 'X'|| player == 'O')
            grid[row][col] = player;
         else {
            System.out.println("Value " + player + " is not X or O. Exiting.");
            System.exit(0);
         }
      }

      // Checks if player supplied ('X' or 'O') won the game
      // If so, returns true, otherwise returns false
      public boolean isWinner(char player)
      {
         //checks if there are three if the same char in a row or column
         int winRow = 0;
         int winCol = 0;
         for (int r = 0; r < grid.length; r++){
            winRow = 0;
            winCol = 0;
            for (int c = 0; c < grid[0].length; c++) {
               if (player == grid[r][c]) winRow += 1;
               if (player == grid[c][r]) winCol += 1;
            }
            if (winRow == 3 || winCol == 3) return true;
         }

         //checks if there are three of the same char in a diagonal
         if (player == grid[0][0] && grid[1][1] == grid[0][0])
            if (grid[1][1] == grid[2][2])
               return true;

         if (player == grid[0][2] && grid[0][2] == grid[1][1])
            if (grid[1][1] == grid[2][0])
               return true;

         //returns false when there are winning combinations
         return false;
      }
   }

   // Helper function to read and return a valid row or col number
   // Checks if the value read is a number, else prints
   //    Not a number. Exiting.
   // and exits the program.
   // Also checks if the number read is 1, 2, or 3, else prints (eg. if 5 entered)
   //    Value (5) is not 1, 2, or 3. Exiting.
   // and exits the program.
   public static int readNumber(Scanner input)
   {
      int value = -1;
      if (input.hasNextInt()) {
         value = input.nextInt();
         if (value != 1 && value !=2){
            if (value != 3) {
               System.out.println("Value (" + value + ") is not 1, 2, or 3. Exiting.");
               System.exit(0);
            }
         }
      }
      else{
         System.out.println("Not a number. Exiting.");
         System.exit(0);
      }
      return value;

   }

   // Main method
   // Do Not Modify.
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      // initialize myGrid to use to play
      TicTacToeGame myGame = new TicTacToeGame();
      Grid myGrid = myGame.new Grid();

      // Current player is X
      char player = 'X';
      // current row and column
      int row = 0, col = 0;
      // how many turns have been taken
      int turnCount = 0;

      // show initial grid
      myGrid.print();

      // repeat till someone wins or there is a draw
      while (turnCount < 9)
      {
         // read position
         System.out.printf("Player %c, enter row: ", player);
         row = readNumber(input);
         System.out.printf("Player %c, enter col: ", player);
         col = readNumber(input);
         System.out.printf("\nYou entered (%d, %d)\n", row, col);

         // check if position is free
         if (!myGrid.isFree(row, col))
         {
            System.out.println("Position taken. Try again.");
            continue;
         }

         // mark the position
         myGrid.setGridValue(row, col, player);

         // show the updated grid
         myGrid.print();

         // check if there is a winner
         if (myGrid.isWinner(player))
         {
            System.out.printf("Player %c wins!!!\n", player);
            System.exit(0);
         }

         // switch player
         if (player == 'X')
            player = 'O';
         else
            player = 'X';
            
         turnCount++;
      }
      System.out.printf("It's a draw!!!\n", player);
   }
}


/*
Indiras-MacBook-Pro:src indiram$ java TicTacToeGame < game1.txt
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (2, 2)
+---+---+---+
|   |   |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (1, 1)
+---+---+---+
| O |   |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 3)
+---+---+---+
| O |   |   |
+---+---+---+
|   | X |   |
+---+---+---+
|   |   | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 3)
+---+---+---+
| O |   |   |
+---+---+---+
|   | X | O |
+---+---+---+
|   |   | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 2)
+---+---+---+
| O |   |   |
+---+---+---+
|   | X | O |
+---+---+---+
|   | X | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (1, 2)
+---+---+---+
| O | O |   |
+---+---+---+
|   | X | O |
+---+---+---+
|   | X | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 1)
+---+---+---+
| O | O |   |
+---+---+---+
|   | X | O |
+---+---+---+
| X | X | X |
+---+---+---+
Player X wins!!!



Indiras-MacBook-Pro:src indiram$ java TicTacToeGame < game2.txt
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (1, 1)
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 2)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 3)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (1, 2)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 2)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   | X | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (3, 1)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
| O | X | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (1, 3)
+---+---+---+
| X | O | X |
+---+---+---+
|   | O |   |
+---+---+---+
| O | X | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 3)
+---+---+---+
| X | O | X |
+---+---+---+
|   | O | O |
+---+---+---+
| O | X | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (2, 1)
+---+---+---+
| X | O | X |
+---+---+---+
| X | O | O |
+---+---+---+
| O | X | X |
+---+---+---+
It's a draw!!!




Indiras-MacBook-Pro:src indiram$ java TicTacToeGame < game3.txt
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (1, 1)
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 2)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 3)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (1, 1)
Position taken. Try again.
Player O, enter row: Player O, enter col:
You entered (1, 2)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   | X |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (3, 1)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
| X |   | X |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (3, 2)
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
| X | O | X |
+---+---+---+
Player O wins!!!



Indiras-MacBook-Pro:src indiram$ java TicTacToeGame < bad-input1.txt
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (1, 1)
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 2)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Value (-3) is not 1, 2, or 3. Exiting.



Indiras-MacBook-Pro:src indiram$ java TicTacToeGame < bad-input2.txt
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Player X, enter col:
You entered (1, 1)
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player O, enter row: Player O, enter col:
You entered (2, 2)
+---+---+---+
| X |   |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
Player X, enter row: Not a number. Exiting.
Indiras-MacBook-Pro:src indiram$

 */
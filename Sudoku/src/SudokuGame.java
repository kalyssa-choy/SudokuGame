/**
 * Runs a game of sudoku.
 * @author kchoy
 */
import java.util.Scanner;
public class SudokuGame {
    public static void main(String[] args)
    {
        int[][] thePuzzle = new int[][]
                {
                        {0, 7, 1, 0, 0, 0, 0, 0, 6},
                        {0, 0, 9, 0, 0, 0, 8, 0, 0},
                        {5, 0, 4, 9, 0, 0, 0, 7, 1},
                        {0, 0, 0, 0, 0, 0, 9, 0, 0},
                        {0, 0, 0, 4, 3, 0, 0, 0, 0},
                        {7, 0, 0, 0, 0, 0, 0, 0, 0},
                        {8, 0, 0, 0, 6, 0, 4, 3, 5},
                        {0, 0, 3, 1, 4, 0, 0, 0, 8},
                        {6, 0, 0, 0, 0, 7, 0, 0, 0}
                };

        // TODO 1: Write the code below this line.
        SudokuBoard puzzle = new SudokuBoard(thePuzzle);
        puzzle.printBoard();
        Scanner in = new Scanner(System.in);

        while (puzzle.isGameOver() == false)
        {
            int myGuess = collectInput(in, "guess");
            int myRow = collectInput(in, "row");
            int myColumn = collectInput(in, "column");
            puzzle.makeGuess(myGuess, myRow, myColumn);
            puzzle.printBoard();
        }

        System.out.println("Good game!");
        in.close();
    }

    public static int collectInput(Scanner input, String inputType)
    {
        // TODO 2: Write the code below this line.
        inputType.toLowerCase();

        if (inputType.equals("row"))
        {
            System.out.println("Enter row: ");
            if (input.hasNextInt())
            {
                int myRow = input.nextInt();
                if (myRow > 0 && myRow < 10)
                {
                    return myRow;
                }
                else
                {

                    System.out.println("Invalid row! Must be between 1 and 9.");
                    System.out.println();
                    myRow = -1;
                    return myRow;
                }
            }
            else
            {
                System.out.println("Input must be a number!");
                return -1;
            }
        }
        else if (inputType.equals("column"))
        {
            System.out.println("Enter column: ");
            if (input.hasNextInt())
            {
                int myCol = input.nextInt();
                if (myCol > 0 && myCol < 10)
                {
                    return myCol;
                }
                else
                {

                    System.out.println("Invalid column! Must be between 1 and 9.");
                    System.out.println();
                    myCol = -1;
                    return myCol;
                }
            }
            else
            {
                System.out.println("Input must be a number!");
                return -1;
            }

        }
        else if (inputType.equals("guess"))
        {
            System.out.println("Enter guess: ");
            if (input.hasNextInt())
            {
                int myGuess = input.nextInt();
                if (myGuess > 0 && myGuess < 10)
                {
                    return myGuess;
                }
                else
                {

                    System.out.println("Invalid guess! Must be between 1 and 9.");
                    System.out.println();
                    myGuess = -1;
                    return myGuess;
                }
            }
            else
            {
                System.out.println("Input must be a number!");
                return -1;
            }
        }
        else
        {
            System.out.println("Please enter \"guess\", \"row\", or \"column\".");
            return -1;
        }
    }
}
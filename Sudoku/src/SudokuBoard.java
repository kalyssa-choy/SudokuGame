public class SudokuBoard
{
    private int[][] board;


    public SudokuBoard(int[][] myBoard)
    {
        board = myBoard;
    }

    public void makeGuess(int guess, int row, int column)
    {
        row--;
        column--;
        board[row][column] = guess;
    }

    public boolean isValidRow(int row)
    {
        // TODO 1: Write the code below this line.
        for(int i = 0; i < board[row].length; i++)
        {

            for (int k = 0; k < board[row].length; k++)
            {
                if (i != k)
                {
                    if (board[row][i] == board[row][k])
                    {
                        return false;
                    }
                }
                else
                {
                    continue;
                }
            }
        }
        return true;
    }

    public boolean isValidColumn(int column)
    {
        for(int i = 0; i < board.length; i++)
        {

            for (int k = 0; k < board.length; k++)
            {
                if (i != k)
                {
                    if (board[i][column] == board[k][column])
                    {
                        return false;
                    }
                }
                else
                {
                    continue;
                }
            }
        }
        return true;
    }

    // TODO 2: Write the code below this line.

    public boolean isValidBox(int boxNum)
    {


        int rowNum = 0;
        int colNum = 0;
        if (boxNum == 3 || boxNum == 4 || boxNum == 5)
        {
            rowNum = 3;
        }
        else if(boxNum == 0 || boxNum == 1 || boxNum == 2)
        {
            rowNum = 0;
        }
        else if(boxNum == 6 || boxNum == 7 || boxNum == 8)
        {
            rowNum = 6;
        }

        if (boxNum == 0 || boxNum == 3 || boxNum == 6)
        {
            colNum = 0;
        }
        else if(boxNum == 1 || boxNum == 4 || boxNum == 7)
        {
            colNum = 3;
        }
        else if (boxNum == 2 || boxNum == 5 || boxNum == 8)
        {
            colNum = 6;
        }



        int count = 0;
        for(int k = 0; k < 10; k++)
        {
            count = 0;
            for(int i = rowNum; i < rowNum + 3 && i < board.length; i++)
            {
                for(int j = colNum; j < colNum + 3 && j < board[0].length; j++)
                {
                    if (board[i][j] == k)
                    {
                        count++;
                        if (count > 1)
                        {
                            return false;
                        }

                    }
                }
            }

        }
        return true;

    }

    public boolean isGameOver()
    {
        // TODO 2: Write the code below this line.


        for (int i = 0; i <board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] > 9 || board[i][j] < 1)
                {
                    return false;
                }
                else if(board [i][j] == 0)
                {
                    return false;
                }
                else if (!isValidRow(i))
                {
                    return false;
                }
                else if (!isValidColumn(j))
                {
                    return false;
                }
                else if(!isValidBox(j))
                {
                    return false;
                }

            }
        }
        return true;
    }

    /**
     * Prints the current board state.
     */
    public void printBoard() {
        System.out.println("-------------------------");
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(c == 0){
                    System.out.print("|");
                }
                if (c % 3 == 0) {
                    if(board[r][c] == 0){
                        System.out.print(" _ ");
                    }
                    else{
                        System.out.print(" " + board[r][c] + " ");
                    }
                }
                else{
                    if(board[r][c] == 0){
                        System.out.print("_ ");
                    }
                    else{
                        System.out.print(board[r][c] + " ");
                    }
                }
                if(c == 8){
                    System.out.println("|");
                }
                else if (c % 3 == 2) {
                    System.out.print("|");
                }
            }
            if(r % 3 == 2){
                System.out.println("-------------------------");
            }
        }
        System.out.println();
    }
}
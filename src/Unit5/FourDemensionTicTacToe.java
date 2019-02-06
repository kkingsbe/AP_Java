package Unit5;

import java.util.Scanner;

public class FourDemensionTicTacToe {
    /*
     * Not truely 4D as you aren't traveling through time (yet) but its close enough
     */
    static String[][][][] gameBoard = new String[3][3][3][3]; //A blank 4D gameboard with X, Y, Z, and Time Slice (1, 2, 3)
    //gameBoard[X][Y][Z][T]
    static String turn = "X"; //Tracks the current turn
    public static void main(String[] args)
    {
        //Initialize one T/Z slice of the gameboard with test values
        gameBoard[0][0][0][0] = "O";
        gameBoard[0][1][0][0] = "X";
        gameBoard[0][2][0][0] = "O";
        gameBoard[1][0][0][0] = "O";
        gameBoard[1][1][0][0] = "X";
        gameBoard[1][2][0][0] = "O";
        gameBoard[2][0][0][1] = "X";
        gameBoard[2][1][0][0] = "X";
        gameBoard[2][2][0][0] = "O";
        while(true)
            getTurn(gameBoard);
    }
    public static void printGameBoard(String[][][][] gameBoard, int timeSlice, int zSlice)
    {
        System.out.println("*-----*");
        for(int colIndex = 0; colIndex < gameBoard.length; colIndex ++) //Iterates over each space in the 2D slice of the 3D slice of the 4D gameboard
        {
            System.out.print("|");
            for(int rowIndex = 0; rowIndex < gameBoard[colIndex].length; rowIndex++) //Iterates over each column & row to print either X or O depending on the value
            {
                if(gameBoard[colIndex][rowIndex][zSlice][timeSlice] == "X")
                    System.out.print("X");
                else if(gameBoard[colIndex][rowIndex][zSlice][timeSlice] == "O")
                    System.out.print("O");
                else
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("*-----*");
    }
    public static void getTurn(String gameBoard[][][][])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Would you like to print the gameboard(1), or take your turn(2)?: ");
        String choice = sc.nextLine();

        if(choice.equals("1"))
        {
            System.out.print("Time Slice: ");
            int timeSlice = sc.nextInt();
            System.out.print("Z Slice: ");
            int zSlice = sc.nextInt();
            printGameBoard(gameBoard, timeSlice-1, zSlice-1);
        }
        else if(choice.equals("2"))
        {
            System.out.print("Time Slice: ");
            int timeSlice = sc.nextInt();
            System.out.print("Z Slice: ");
            int zSlice = sc.nextInt();
            System.out.print("Column: ");
            int col = sc.nextInt();
            System.out.print("Row: ");
            int row = sc.nextInt();
            gameBoard[col-1][row-1][zSlice-1][timeSlice-1] = turn;
        }
    }
}

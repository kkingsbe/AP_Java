package Unit5;

import java.io.IOException;
import java.util.Arrays;
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
        System.out.println(turn + "'s turn!");
        /*
        //Initialize one T/Z slice of the gameboard with test values
        gameBoard[0][0][0][0] = "O";
        gameBoard[0][1][0][0] = "X";
        gameBoard[0][2][0][0] = "O";
        gameBoard[1][0][0][0] = "O";
        gameBoard[1][1][0][0] = "X";
        gameBoard[1][2][0][0] = "O";
        gameBoard[2][0][0][0] = "X";
        gameBoard[2][1][0][0] = "X";
        gameBoard[2][2][0][0] = "O";
        */
        while(true) //Main game loop
        {
            getTurn(gameBoard); //Lets the player take their turn
            boolean xWin = checkForWin(gameBoard, "X"); //Checks to see if X won
            boolean oWin = checkForWin(gameBoard, "O"); //Checks to see if O won
            if(xWin)
            {
                //printGameBoard(gameBoard, 0, 0); //Prints the gameboard for dev purposes
                System.out.println("X wins!");
            }
            if(oWin)
            {
                //printGameBoard(gameBoard, 0, 0); //Prints the gameboard for dev purposes
                System.out.println("O wins!");
            }
        }
    }
    public static void printGameBoard(String[][][][] gameBoard, int timeSlice, int zSlice) //Prints the gameboard
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
    public static void getTurn(String gameBoard[][][][]) //Lets the player take their turn
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Would you like to print the gameboard(1), or take your turn(2)?: ");
        String choice = sc.nextLine();
        clearScreen();
        boolean alreadOccupied = false;

        if(choice.equals("1")) //Print the gameboard
        {
            System.out.print("Time Slice: ");
            int timeSlice = sc.nextInt();
            System.out.print("Z Slice: ");
            int zSlice = sc.nextInt();
            printGameBoard(gameBoard, timeSlice-1, zSlice-1); //Prints the gameboard with values corrected to be indexed at zero
        }
        else if(choice.equals("2"))
        {
            System.out.print("Time Slice: ");
            int timeSlice = sc.nextInt();
            System.out.print("Z Slice: ");
            int zSlice = sc.nextInt();
            printGameBoard(gameBoard, timeSlice-1, zSlice-1);
            System.out.print("Column: ");
            int col = sc.nextInt();
            System.out.print("Row: ");
            int row = sc.nextInt();
            if(gameBoard[row-1][col-1][zSlice-1][timeSlice-1] == null) //Updates the gameboard if the indicated space is not occupied
            {
                gameBoard[row-1][col-1][zSlice-1][timeSlice-1] = turn; //Updates the gameboard with values corrected to be indexed at zero
                clearScreen();
                printGameBoard(gameBoard, timeSlice-1, zSlice-1);
            }
            else
            {
                System.out.println("Space Already Occupied!");
                alreadOccupied = true; //If the space is already occupied, it sets a flag to be true so the player can go again
            }
            if(!alreadOccupied)
            {
                if(turn.equals("O"))
                    turn = "X";
                else
                    turn = "O";
                System.out.println(turn + "'s turn!");
            }
        }
    }
    public static boolean checkForWin(String[][][][] gameBoard, String player) //Checks to see if X wins
    {
        boolean win = false;
        if(checkFor2DWins(gameBoard, player))
            win = true;
        if(checkFor3DWins(gameBoard, player))
            win = true;
        return win;
    }
    public static boolean checkFor2DWins(String[][][][] gameBoard, String player)
    {
        boolean xWin = false;
        for(int timeIndex = 0; timeIndex < gameBoard[0][0][0].length; timeIndex++)
        {
            for(int zIndex = 0; zIndex < gameBoard[0][0].length; zIndex++)
            {
                for(int col = 0; col < gameBoard[0].length; col ++)
                {
                    try{ //Try Catch to get around NullPointerException
                        //Check to see if X won by playing three in a row horizontally within the same Z and Time dimensions
                        if(gameBoard[col][0][zIndex][timeIndex].equals(player) && gameBoard[col][1][zIndex][timeIndex].equals(player) && gameBoard[col][2][zIndex][timeIndex].equals(player))
                        {
                            xWin = true;
                            break;
                        }
                    } catch (NullPointerException e){}
                }
                for (int row = 0; row < gameBoard.length; row++) {
                    try {
                        //Check to see if X won by playing three in a row vertically within the same Z and Time dimensions
                        if (gameBoard[0][row][zIndex][timeIndex].equals(player) && gameBoard[1][row][zIndex][timeIndex].equals(player) && gameBoard[2][row][zIndex][timeIndex].equals(player)) {
                            xWin = true;
                            break;
                        }
                    } catch (NullPointerException e){}
                }
                try {
                    //Check to see if X won by playing three in a row diagonally from the top left within the same Z and Time dimensions
                    if (gameBoard[0][0][zIndex][timeIndex].equals(player) && gameBoard[1][1][zIndex][timeIndex].equals(player) && gameBoard[2][2][zIndex][timeIndex].equals(player)) {
                        xWin = true;
                        break;
                    }
                } catch (NullPointerException e) {}
                try {
                    //Check to see if X won by playing three in a row diagonally from the top right in the same Time and Z dimensions
                    if (gameBoard[2][2][zIndex][timeIndex].equals(player) && gameBoard[1][1][zIndex][timeIndex].equals(player) && gameBoard[0][0][zIndex][timeIndex].equals(player)) {
                        xWin = true;
                        break;
                    }
                } catch (NullPointerException e) {}
            }
        }
        return xWin;
    }
    public static boolean checkFor3DWins(String[][][][] gameBoard, String player)
    {
        boolean win = false;
        for(int timeCubeIndex = 0; timeCubeIndex < 3; timeCubeIndex ++) //Iterates over each 3D cross section of the gameboard
        {
            for(int x = 0; x < 3; x ++) //Iterates over each x value in the bottom of the cube
            {
                for(int y = 0; y < 3; y ++) //Iterates over each y value in the bottom of the cube
                {
                    try {
                        //Checks to see if the player got 3 in a row vertically
                        if (gameBoard[x][y][0][timeCubeIndex].equals(player) && gameBoard[x][y][1][timeCubeIndex].equals(player) && gameBoard[x][y][2][timeCubeIndex].equals(player))
                        {
                            win = true;
                        }
                    } catch (NullPointerException e){}
                    try {
                        //Checks to see if the player got 3 in a row diagonally all with the same x value starting from the bottom
                        if (gameBoard[0][y][0][timeCubeIndex].equals(player) && gameBoard[1][y][1][timeCubeIndex].equals(player) && gameBoard[2][y][2][timeCubeIndex].equals(player))
                        {
                            win = true;
                        }
                    } catch (NullPointerException e){}
                    try {
                        //Checks to see if the player got 3 in a row diagonally all with the same y value starting from the top
                        if (gameBoard[2][y][2][timeCubeIndex].equals(player) && gameBoard[1][y][1][timeCubeIndex].equals(player) && gameBoard[0][y][0][timeCubeIndex].equals(player))
                        {
                            win = true;
                        }
                    } catch (NullPointerException e){}
                }
                try {
                    //Checks to see if the player got 3 in a row diagonally all with the same y value starting from the bottom left
                    if (gameBoard[x][0][0][timeCubeIndex].equals(player) && gameBoard[x][1][1][timeCubeIndex].equals(player) && gameBoard[x][2][2][timeCubeIndex].equals(player))
                    {
                        win = true;
                    }
                } catch (NullPointerException e){}
                try {
                    //Checks to see if the player got 3 in a row diagonally all with the same y value starting from the top left
                    if (gameBoard[x][0][2][timeCubeIndex].equals(player) && gameBoard[x][1][1][timeCubeIndex].equals(player) && gameBoard[x][2][0][timeCubeIndex].equals(player))
                    {
                        win = true;
                    }
                } catch (NullPointerException e){}
            }
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[0][0][0][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[2][2][2][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[2][0][0][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[0][2][2][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[0][2][0][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[2][0][2][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[2][2][0][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[0][0][2][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            //DECENDING-------------------------------------
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[0][0][2][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[2][2][0][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[2][0][2][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[0][2][0][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[0][2][2][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[2][0][0][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
            try {
                //Checks to see if the player got 3 in a row diagonally on all three axes
                if (gameBoard[2][2][0][timeCubeIndex].equals(player) && gameBoard[1][1][1][timeCubeIndex].equals(player) && gameBoard[0][0][2][timeCubeIndex].equals(player))
                {
                    win = true;
                }
            } catch (NullPointerException e){}
        }
        return win;
    }
    public static void clearScreen() { //Not the best way, but simple and gets the job done
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}

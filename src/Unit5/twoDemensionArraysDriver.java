package Unit5;

import java.util.Random;

public class twoDemensionArraysDriver {
    public static void main(String[] args)
    {
        int[][] array = initialize2DArray(5, 10);
        System.out.println("Test Array:");
        ArrayPrintMethods.printArray(array);
        System.out.println();
        System.out.println("--------max--------");
        System.out.println(twoDemensionArrays.max(array));
    }
    public static int[][] initialize2DArray(int cols, int rows)
    {
        int[][] output = new int[cols][rows];
        Random rng = new Random();
        for(int col = 0; col < cols; col++)
        {
            for(int row = 0; row < rows; row ++)
            {
                output[col][row] = rng.nextInt(100);
            }
        }
        return output;
    }
}

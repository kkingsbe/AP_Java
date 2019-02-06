package Unit5;

import java.util.Random;

public class twoDemensionArraysDriver {
    public static void main(String[] args)
    {
        int[][] array = initialize2DArray(5, 5);
        System.out.println("Test Array:");
        ArrayPrintMethods.printArray(array);
        System.out.println();
        System.out.println("--------max--------");
        System.out.println(twoDemensionArrays.max(array));
        System.out.println("--------rowSum--------");
        System.out.println(twoDemensionArrays.rowSum(array, 1));
        System.out.println("--------colSum--------");
        System.out.println(twoDemensionArrays.colSum(array,2 ));
        System.out.println("--------allRowSums--------");
        ArrayPrintMethods.printArray(twoDemensionArrays.allRowSums(array));
        System.out.println("--------isRowMagic--------");
        System.out.println(twoDemensionArrays.isRowMagic(array));
        System.out.println("--------isColMagic--------");
        System.out.println(twoDemensionArrays.isColMagic(array));
        System.out.println("--------isSquare--------");
        System.out.println(twoDemensionArrays.isSquare(array));
        System.out.println("--------isMagicSquare--------");
        System.out.println(twoDemensionArrays.isMagicSquare(array));
        System.out.println("--------isLatinSquare--------");
        System.out.println(twoDemensionArrays.isLatinSquare(array));
    }
    public static int[][] initialize2DArray(int rows, int cols)
    {
        int[][] output = new int[rows][cols];
        Random rng = new Random();
        for(int col = 0; col < rows; col++)
        {
            for(int row = 0; row < cols; row ++)
            {
                output[col][row] = rng.nextInt(100);
            }
        }
        return output;
    }
}

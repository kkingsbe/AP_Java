package Unit5;
/*
 * Author: Kyle Kingsberry
 * Date: 2/5/2o19
 */
public class ArrayPrintMethods {
    public static void printArray(int[] array)
    {
        System.out.print("[");
        for(int item = 0; item < array.length - 1; item ++)
        {
            System.out.print(array[item] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }
    public static void printArray(String[] array)
    {
        System.out.print("[");
        for(int item = 0; item < array.length - 1; item ++)
        {
            System.out.print(array[item] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.print("]");
    }
    public static void printArray(int[][] array)
    {
        System.out.println("[ \n");
        for(int[] subArray : array)
        {
            printArray(subArray);
            System.out.println();
        }

        System.out.println("]");
    }
    public static void printArray(String[][] array)
    {
        System.out.println("[");
        for(String[] subArray : array)
        {
            printArray(subArray);
            System.out.println();
        }

        System.out.println("]");
    }
}

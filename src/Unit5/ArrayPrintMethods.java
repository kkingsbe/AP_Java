package Unit5;

public class ArrayPrintMethods {
    public static void printArray(int[] array)
    {
        System.out.print("[");
        for(int item = 0; item < array.length - 1; item ++)
        {
            System.out.print(array[item] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.print("]");
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
        System.out.print("[");
        for(int[] subArray : array)
        {
            printArray(subArray);
        }

        System.out.print("]");
    }
    public static void printArray(String[][] array)
    {
        System.out.print("[");
        for(String[] subArray : array)
        {
            printArray(subArray);
        }

        System.out.print("]");
    }
}

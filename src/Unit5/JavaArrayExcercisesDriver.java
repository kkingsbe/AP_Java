package Unit5;
/*
 * Author: Kyle Kingsberry
 * Date: 2/5/2o19
 */
public class JavaArrayExcercisesDriver {
    public static void main(String[] args) {
        int[] array = {20, 20, 30, 40, 50, 50, 50};
        String[] strArray = {"My", "name", "is", "Kyle"};
        System.out.println("Test int Array: ");
        ArrayPrintMethods.printArray(array);
        System.out.println();
        System.out.println("Test String array:");
        ArrayPrintMethods.printArray(strArray);
        System.out.println();
        System.out.println("-------removeDupes--------");
        System.out.println(JavaArrayExcercises.removeDupes(array));
        System.out.println("-------contains--------");
        System.out.println(JavaArrayExcercises.contains(20, array));
        System.out.println("-------remove--------");
        ArrayPrintMethods.printArray(JavaArrayExcercises.remove(array, 3));
        System.out.println();
        System.out.println("-------average--------");
        System.out.println(JavaArrayExcercises.average(array));
        System.out.println("-------getPairs--------");
        ArrayPrintMethods.printArray(JavaArrayExcercises.getPairs(40, array));
        System.out.println();
        System.out.println("-------findDupe--------");
        System.out.println(JavaArrayExcercises.findDupe("Kyle", strArray));
        System.out.println("-------minMax--------");
        ArrayPrintMethods.printArray(JavaArrayExcercises.minMax(array));
        System.out.println();
    }
}

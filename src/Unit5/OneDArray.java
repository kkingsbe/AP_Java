/*
 * Creator: Kyle Kingsberry
 * Date: 1/30/2018
 */

package Unit5;

import java.util.Arrays;
import java.util.Random;

public class OneDArray {
    public static void run()
    {
        double[] array = new double[99];
        array = populate(array);
        double sum = sum(array);
        double average = average(array, sum);
        System.out.println("Mean: " + average);
        Arrays.sort(array);
        System.out.println("Median: " + array[49]);
        printInterval(array, 9);
    }

    public static double[] populate(double[] array)
    {
        Random rng = new Random();
        for(int index = 0; index < array.length; index ++)
        {
            array[index] = rng.nextDouble() * 100;
        }
        return array;
    }

    public static double sum(double[] array)
    {
        double sum = 0.0;
        for(double item : array)
        {
            sum += item;
        }
        return sum;
    }

    public static double average(double[] array, double sum)
    {
        return sum / array.length;
    }

    public static void printInterval(double[] array, int interval)
    {
        System.out.println("Printing every " + interval + "th elemnt:");
        System.out.println("--------------------------");
        for(int index = 0; index < array.length; index ++)
        {
            if(index % interval == 0)
            {
                System.out.println(array[index]);
            }
        }
    }
}

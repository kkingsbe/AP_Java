package Unit5;
/*
 * Author: Kyle Kingsberry
 * Date: 2/5/2o19
 */
public class JavaArrayExcercises
{
    public static int removeDupes(int[] input)
    {
        int len = input.length;
        for(int x = 0; x < input.length; x++) //Iterate over each int in the array
        {
            for(int y = 0; y < input.length; y++) //Compare it against each other int in the array
            {
                if(input[x] == input[y] && x != y) //If they are the same and have different indexes, they are duplicates
                {
                    len --;
                    break;
                }
            }
        }
        len ++; //Off by 1 error?
        return len;
    }
    public static boolean contains(int target, int[] input)
    {
        boolean isIn = false;
        for(int item : input)
        {
            if(item == target)
                isIn = true;
        }
        return isIn;
    }
    public static int[] remove(int[] input, int targetIndex)
    {
        int[] output = new int[input.length-1];
        int activeIndex = 0;
        for(int index = 0; index < input.length; index++)
        {
            if(index != targetIndex)
            {
                output[activeIndex] = input[index];
                activeIndex ++;
            }
        }
        return output;
    }
    public static int average(int[] input) //Self explanatory
    {
        int total = 0;
        int average = 0;
        for(int index = 1; index < input.length - 1; index ++)
        {
            total += input[index];
        }
        average = total / input.length - 2;
        return average;
    }
    public static int[][] getPairs(int targetSum, int[] input)
    { //<Spaghetti>
        int trueCount = 0;
        for(int x : input)
        {
            for(int y : input)
            {
                if(x + y == targetSum)
                    trueCount ++;
            }
        }
        int[][] pairs = new int[trueCount][2];
        int index = 0;
        trueCount = 0;
        for(int x : input)
        {
            int index2 = 0;
            for(int y : input)
            {
                if(x + y == targetSum)
                {
                    pairs[trueCount][0] = input[index];
                    pairs[trueCount][1] = input[index2];
                    trueCount ++;
                }

                index2 ++;
            }
            index ++;
        }
        return pairs;
    } //</Spaghetti>
    public static int findDupe(String target, String[] input)
    {
        int dupes = 0;
        for(String item : input)
        {
            if(item == target)
                dupes ++;
        }
        return dupes;
    }
    public static int[] minMax (int[] input)
    {
        int[] output = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int item : input)
        {
            if(item > max)
                max = item;
            if(item < min)
                min = item;
        }
        output[0] = min;
        output[1] = max;
        return output;
    }
}

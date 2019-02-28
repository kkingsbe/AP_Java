package Unit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordSort {
    public static void main(String[] args)
    {
        String inputRaw = getInput();
        String inputClean = cleanInput(inputRaw);
        ArrayList<String> unsortedArr = toArr(inputClean);
        ArrayList<String> sortedArr = selectionSort(unsortedArr);
        for(String string : sortedArr)
            System.out.println(string);
    }
    private static String getInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Paragraph:  ");
        String input = sc.nextLine();
        return input;
    }
    private static String cleanInput(String input)
    {
        return input.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
    }
    private static ArrayList<String> toArr(String input)
    {
        ArrayList<String> unsorted = new ArrayList<>(Arrays.asList(input.split(" ")));
        return unsorted;
    }
    private static ArrayList<String> selectionSort(ArrayList<String> input)
    {
        for(int index = 0; index < input.size(); index ++)
        {
            String primaryItem = input.get(index);
            String secondaryItem = primaryItem;
            int secondIndex = 0;
            for(int x = index; x < input.size(); x ++)
            {
                if(input.get(x).compareTo(secondaryItem) < 0)
                {
                    secondaryItem = input.get(x);
                    secondIndex = x;
                }
            }
            if(secondIndex > 0)
            {
                input.set(secondIndex, primaryItem);
                input.set(index, secondaryItem);
            }
        }
        return input;
    }
    private static ArrayList<String> insertionSort(ArrayList<String> input)
    {
        String temp;
        for(int primaryIndex = 1; primaryIndex < input.size(); primaryIndex ++)
        {
            String word = input.get(primaryIndex);
            String word2;
            for(int secondaryIndex = primaryIndex - 1; secondaryIndex < input.size(); secondaryIndex --)
            {
                word2 = input.get(secondaryIndex);
                if(word.compareTo(word2) < 0) //If word comes before word2
                {
                    temp = input.get(secondaryIndex);
                    input.set(secondaryIndex, word);
                    for(int x = secondaryIndex; x < input.size(); x++)
                    {
                        temp = input.get(x);

                    }
                }
            }
        }
        return input;
    }
}

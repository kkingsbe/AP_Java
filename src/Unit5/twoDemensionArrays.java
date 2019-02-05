package Unit5;

public class twoDemensionArrays {
    public static int max(int[][] a)
    {
        int max = Integer.MIN_VALUE;
        for(int[] col : a)
        {
            for(int item : col)
            {
                if(item > max)
                    max = item;
            }
        }
        return max;
    }
}

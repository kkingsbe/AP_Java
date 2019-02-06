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
    public static int rowSum(int[][] a, int x)
    {
        int sum = 0;
        for(int item : a[x])
            sum += item;
        return sum;
    }
    public static int colSum(int[][] a, int x)
    {
        int sum = 0;
        for(int index = 0; index < a.length; index ++)
            sum += a[index][x];
        return sum;
    }
    public static int[] allRowSums(int[][] a)
    {
        int[] rowSums = new int[10];
        int rowIndex = 0;
        for(int[] row : a)
        {
            int colIndex = 0;
            for(int col : row)
            {
                rowSums[rowIndex] += a[rowIndex][colIndex];
                colIndex ++;
            }
            rowIndex++;
        }
        return rowSums;
    }
    public static boolean isRowMagic(int[][] a)
    {
        boolean isMagic = true;
        int[] rowSums = new int[a.length];
        for(int row = 0; row < a.length; row++)
        {
            int rowSum = 0;
            for(int col = 0; col < a[row].length; col ++)
            {
                rowSum += a[row][col];
            }
            rowSums[row] += rowSum;
        }
        int prevRow = rowSums[0];
        for(int rowSum : rowSums)
        {
            if(rowSum != prevRow)
                isMagic = false;
        }
        return isMagic;
    }
    public static boolean isColMagic(int[][] a)
    {
        boolean isMagic = true;
        int[] colSums = new int[a[0].length];
        for(int col = 0; col < a[0].length; col++)
        {
            int rowSum = 0;
            for(int row = 0; row < a.length; row ++)
            {
                rowSum += a[row][col];
            }
            colSums[col] += rowSum;
        }
        int prevCol = colSums[0];
        for(int colSum : colSums)
        {
            if(colSum != prevCol)
                isMagic = false;
        }
        return isMagic;
    }
    public static boolean isSquare(int[][] a)
    {
        boolean isSquare = true;
        int rows = a.length;
        int cols = a[0].length;
        if(rows != cols)
            isSquare = false;
        return isSquare;
    }
    public static boolean isMagicSquare(int[][] a)
    {
        boolean rowMagic = isRowMagic(a);
        boolean colMagic = isColMagic(a);
        boolean square = isSquare(a);
        if(rowMagic && colMagic && square)
            return true;
        else
            return false;
    }
    public static boolean isLatinSquare(int[][] a)
    {
        boolean square = isSquare(a);
        boolean latinRows = true;
        boolean latinCols = true;
        for(int row = 0; row < a.length; row++)
        {
            int lastItem = 0;
            for(int item : a[row])
            {
                if(item != lastItem + 1)
                    latinRows = false;
            }
        }
        for(int col = 0; col < a[0].length; col++)
        {
            int lastItem = 0;
            for(int row = 0; row < a.length; row++)
            {
                int item = a[row][col];
                if(item != lastItem + 1)
                    latinCols = false;
            }
        }
        return square && latinRows && latinCols;
    }
}

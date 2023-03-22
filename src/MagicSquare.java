public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i = 0; i<array2d[0].length; i++){
            sum = sum + array2d[0][i];
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        boolean equal = true;
        for (int r = 1; r < array2d.length; r++){
            int rowSum = 0;
            for (int c = 0; c < array2d[r].length; c++){
                rowSum = rowSum + array2d[r][c];
            }
            if (!(rowSum == checkSum)){
                equal = false;
                break;
            }
        }
        return equal;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        boolean equal = true;
        for (int c = 0; c < array2d[0].length; c++){
            int colSum = 0;
            for (int r = 0; r < array2d.length; r++){
                colSum = colSum + array2d[r][c];
            }
            if (!(colSum == checkSum)){
                equal = false;
                break;
            }
        }
        return equal;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        boolean equal = false;

        int diagonal1Sum = 0;
        int r1 = 0;
        int c1 = 0;
        while (r1 < array2d.length){
            diagonal1Sum = diagonal1Sum + array2d[r1][c1];
            c1++;
            r1++;
        }

        int diagonal2Sum = 0;
        int r2 = 0;
        int c2 = array2d.length-1;
        while (r2 < array2d.length){
            diagonal2Sum = diagonal2Sum + array2d[r2][c2];
            r2++;
            c2--;
        }
        if ((diagonal2Sum == checkSum) && (diagonal1Sum == checkSum)){
            equal = true;
        }
        return equal;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int sum = calculateCheckSum(array2d);
        boolean row = magicRows(array2d, sum);
        boolean col = magicColumns(array2d, sum);
        boolean diagonal = magicDiagonals(array2d, sum);
        if (row && col && diagonal){
            return true;
        }
        else {
            return false;
        }
    }

}

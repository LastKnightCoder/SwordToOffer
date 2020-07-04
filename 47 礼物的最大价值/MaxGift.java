public class MaxGift {
    public static int getMaxGift(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] maxMatrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int left = 0;
                int up = 0;
                if (row > 0) {
                    left = maxMatrix[row - 1][column];
                }
                if (column > 0) {
                    up = maxMatrix[row][column - 1];
                }
                maxMatrix[row][column] = Math.max(left, up) + matrix[row][column];

            }
        }

        return maxMatrix[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int maxSum = getMaxGift(matrix);
        System.out.println(maxSum);
    }
}
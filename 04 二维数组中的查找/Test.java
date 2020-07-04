public class Test {

    public static boolean findInMatrix(int[][] matrix, int number) {
        boolean found = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && columns >= 0) {
                if (matrix[row][column] == number) {
                    found = true;
                    break;
                } else if (matrix[row][column] > number) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};

        boolean found = findInMatrix(matrix, 2);
        System.out.println(found);
    }
}
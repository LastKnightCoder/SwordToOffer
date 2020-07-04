public class PrintMatrixClockwisely {
    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        if (matrix.length != 0) {
            if (matrix[0].length == 0) {
                return;
            }
        }

        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while (rows > start * 2 && columns > start * 2) {
            printCircle(matrix, start);
            start++;
        }
    }

    private static void printCircle(int[][] matrix, int start) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i]);
        }

        
        for (int i = start + 1; i <= endY; i++) {
            System.out.print(matrix[i][endX]);
        }
        

        if (endY > start) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(matrix[endY][i]);
            }
        }
        
        if (endX > start) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.print(matrix[i][start]);
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}};
        printMatrixClockwisely(matrix);
    }
}
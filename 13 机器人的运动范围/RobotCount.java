public class RobotCount {
    public static int movingCount(int threshold, int rows, int columns) {
        if (threshold <= 0 || rows <= 0 || columns <= 0) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                visited[row][column] = false;
            }
        }

        return movingCountCore(threshold, rows, columns, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int columns, int row, int column, boolean[][] visited) {
        int count = 0;

        if (check(threshold, rows, columns, row, column, visited)) {
            visited[row][column] = true;
            count = 1 + movingCountCore(threshold, rows, columns, row - 1, column, visited)
                    + movingCountCore(threshold, rows, columns, row, column - 1, visited)
                    + movingCountCore(threshold, rows, columns, row + 1, column, visited)
                    + movingCountCore(threshold, rows, columns, row, column + 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int columns, int row, int column, boolean[][] visited) {
        if (row >= 0 && row < rows
                && column >= 0 && column < columns
                && (getDigitalNumber(row) + getDigitalNumber(column)) <= threshold
                && !visited[row][column]) {
            return true;
        }
        return false;
    }

    private static int getDigitalNumber(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(10, 100, 100));
    }
}
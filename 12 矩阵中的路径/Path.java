public class Path {
    public static boolean hasPath(char[][] matrix, char[] str) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] vistied = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                vistied[row][column] = false;
            }
        }

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (hasPathCore(matrix, row, column, str, pathLength, vistied)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathCore(char[][] martix, int row, int column, char[] str, int pathLength, boolean[][] visited) {
        if (pathLength >= str.length) {
            return true;
        }

        boolean hasPath = false;

        if (row >= 0 && row < martix.length && column >= 0 && column < martix[0].length && martix[row][column] == str[pathLength] && !visited[row][column]) {
            pathLength++;
            visited[row][column] = true;
            hasPath = hasPathCore(martix, row, column - 1, str, pathLength, visited)
                    || hasPathCore(martix, row - 1, column, str, pathLength, visited)
                    || hasPathCore(martix, row + 1, column, str, pathLength, visited)
                    || hasPathCore(martix, row, column + 1, str, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        char[] str = {'t', 'c', 'f', 'd', 'j'};

        System.out.println(hasPath(matrix, str)); // true
    }
}
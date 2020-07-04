public class Cut {

    public static int cut(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] results = new int[n + 1];

        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int result = results[j] * results[i - j];
                if (max < result) {
                    max = result;
                }
            }
            results[i] = max;
        }

        return results[n];
    }

    public static void main(String[] args) {
        System.out.println(cut(9));
    }
}
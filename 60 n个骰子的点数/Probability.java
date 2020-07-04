public class Probability {
    public static double[] probability(int n) {
        if (n < 1) {
            return new double[]{0};
        }

        int[][] numbers = new int[n + 1][6*n + 1];

        for (int i = 1; i <= 6; i++) {
            numbers[1][i] = 1;
        }

        // i 表示骰子数
        for (int i = 2; i <= n; i++) {
            // s 表示 i 个骰子投出的点数
            for (int s = i; s <= 6 * i; s++) {
                for (int cur = 1; cur <= 6; cur++) {
                    // s - cur 表示前 i - 1 个骰子应该投出的点数
                    // 前 i - 1 个骰子投出的点数最小值为 i - 1
                    // 如果 s - cur 小于 i - 1 说明不可能
                    if (s - cur < i - 1) {
                        break;
                    }
                    numbers[i][s] += numbers[i - 1][s - cur];
                }
            }
        }

        double total = Math.pow(6, n);

        // 最小点数为 n，最大点数为 6n，总共有 6n - n + 1 = 5n + 1种可能
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = numbers[n][i] / total;
        }

        return ans;
    }

    public static void main(String[] args) {
        double[] ans = probability(2);
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            if (i == ans.length - 1) {
                System.out.println(ans[i] + "]");
            } else {
                System.out.print(ans[i] + ",");
            }
        }
    }
}
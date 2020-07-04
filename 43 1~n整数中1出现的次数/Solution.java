class Solution {
    public static int numberOfOneToN(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numberOfOne(i);
        }

        return count;
    }

    private static int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
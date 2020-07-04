public class MaxDiff {
    public static int maxDiff(int[] data) {
        if (data == null || data.length <= 1) {
            return 0;
        }

        int maxDiff = 0;
        int min = data[0];

        for (int i = 2; i < data.length; i++) {
            if (data[i] > min) {
                int diff = data[i] - min;
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            } else {
                min = data[i];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] data = {9, 11, 8, 5, 7, 12, 16, 14};
        int maxDiff = maxDiff(data);
        System.out.println(maxDiff);
    }
}
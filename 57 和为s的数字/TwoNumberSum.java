public class TwoNumberSum {
    public static  int[] towNumberSum(int[] data, int sum) {
        if (data == null || data.length == 0) {
            return null;
        }

        int start = 0;
        int end = data.length - 1;

        while (start < end) {
            int curSum = data[start] + data[end];
            if (curSum == sum) {
                return new int[]{data[start], data[end]};
            } else if (curSum < sum) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 4, 5, 11, 15};
        int[] results = towNumberSum(data, 15);
        System.out.println(results[0] + " " + results[1]);
    }
}
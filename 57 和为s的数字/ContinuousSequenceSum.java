public class ContinuousSequenceSum {
    public static void continuousSequenceSum(int sum) {
        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = small + big;

        while (small < middle) {

            if (curSum == sum) {
                printContinuousSequence(small, big, sum);
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printContinuousSequence(small, big, sum);
                }
            }

            big++;
            curSum += big;
        }
    }

    private static void printContinuousSequence(int small, int big, int sum) {
        for (int i = small; i <= big; i++) {
            if (i == big) {
                System.out.println(i + " = " + sum);
            } else {
                System.out.print(i + " + ");
            }
        }
    }

    public static void main(String[] args) {
        continuousSequenceSum(18);
    }
}
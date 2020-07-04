import java.util.Arrays;

public class Continuous {
    public static boolean isContinuous(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        Arrays.sort(data);

        int numberOfZero = 0;
        int numberOfGap = 0;

        for (int i = 0; i < data.length && data[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero;
        int big = small + 1;
        while (big < data.length) {
            if (data[small] == data[big]) {
                return false;
            }

            numberOfGap += (data[big] - data[small] - 1);
            small++;
            big++;
        }

        return numberOfZero >= numberOfGap;
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 3, 4, 5};
        boolean res = isContinuous(data);
        System.out.println(res);
    }
}
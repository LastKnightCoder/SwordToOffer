public class InversePairs {
    public static int inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        return inversePairs(data, 0, data.length - 1);
    }

    public static int inversePairs(int[] data, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        int left = inversePairs(data, start, mid);
        int right = inversePairs(data, mid + 1, end);

        int p1 = mid;
        int p2 = end;

        int count = 0;

        int[] help = new int[end - start + 1];
        int helpIndex = help.length - 1;

        while (p1 >= start && p2 >= mid + 1) {
            if (data[p1] > data[p2]) {
                count += (p2 - mid);
                help[helpIndex--] = data[p1];
                p1--;
            } else {
                help[helpIndex--] = data[p2];
                p2--;
            }
        }

        while (p1 >= start) {
            help[helpIndex--] = data[p1--];
        } 
        while (p2 >= mid + 1) {
            help[helpIndex--] = data[p2--];
        }

        for (int i = start; i <= end; i++) {
            data[i] = help[i - start];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 4};
        int count = inversePairs(data);
        System.out.println(count);
    }
}
public class MoreThanHalfNumber {
    private static int partition(int[] data, int start, int end) {
        if (end < start) {
            throw new RuntimeException("参数错误");
        }

        int num = data[end];
        int more = end + 1;
        int cur = start;
        while (cur < more) {
            if (data[cur] <= num) {
                cur++;
            } else {
                int number = data[cur];
                data[cur] = data[--more];
                data[more] = number;
            }
        }

        return cur - 1;
    }

    public static int moreThanHalfNumber(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("参数操作");
        }

        int count = 1;
        int result = data[0];
        for (int i = 1; i < data.length; i++) {
            if (result != data[i]) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                result = data[i];
                count = 1;
            }
        }

        return result;
    }

    public static int findMoreThanHalfNumber(int[] data) {
        int start = 0;
        int end = data.length - 1;
        int index = partition(data, start, end);
        int middle = start + (end - start) / 2;
        while (index != middle) {
            if (index < middle) {
                start = index + 1;
                index = partition(data, start, end);
            } else {
                end = index - 1;
                index = partition(data, start, end);
            }
        }

        return data[index];
    }

    

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 2, 4, 2, 5, 2, 6, 2, 2};
        int result = findMoreThanHalfNumber(data);
        System.out.println(result);
    }
}
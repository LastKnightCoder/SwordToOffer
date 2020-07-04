public class GetNumber {
    private static int firstKNumber(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (data[mid] == k) {
                if (mid > 0 && data[mid - 1] == k) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else if (data[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int lastKNumber(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;

        while (start <= end) {
            int mid = start + (end -start) / 2;
            if (data[mid] == k) {
                if (mid < data.length - 1 && data[mid + 1] == k) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (data[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int getNumberOfK(int[] data, int k) {
        if (data == null || data.length == 0) {
            return 0;
        }

        int first = firstKNumber(data, k);
        int last = lastKNumber(data, k);

        if (first == -1 || last == -1) {
            return 0;
        }
        return (last - first) + 1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 3, 3, 4, 5};
        // int first = firstKNumber(data, 3);
        // int last = lastKNumber(data, 3);
        // System.out.println(first);
        // System.out.println(last);
        int number = getNumberOfK(data, 3);
        System.out.println(number);
    }
}
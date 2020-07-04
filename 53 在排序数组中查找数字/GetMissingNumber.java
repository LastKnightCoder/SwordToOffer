public class GetMissingNumber {
    public static int getMissingNumber(int[] data) {

        if (data == null || data.length  == 0) {
            return -1;
        }

        int start = 0;
        int end = data.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (data[mid] != mid) {
                if (mid > 0 && data[mid - 1] != (mid -1 )) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 2, 3, 5, 6, 7};
        int missingNumber = getMissingNumber(data);
        System.out.println(missingNumber);
    }
}
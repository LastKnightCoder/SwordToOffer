public class GetSameIndex {
    public static int getSameIndex(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int start = 0;
        int end = data.length - 1;

        while (start <= end) {
            int mid = start + (end - start);
            if (data[mid] == mid) {
                return mid;
            } else if (data[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {-3, -1, 1, 3, 5};
        int sameIndex = getSameIndex(data);
        System.out.println(sameIndex);
    }
}
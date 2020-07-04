public class Test03 {
    public static int duplicate(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        
        while (end >= start) {
            int middle = start + (end - start) / 2;
            // 获得数字范围在[start, middle]范围内的数目
            int countNum = count(arr, start, middle);
            if (start == end) {
                if(countNum > 1) {
                    return start;
                } else {
                    // 如果范围只剩最后一个元素，但是数目不大于1，说明没有重复的
                    break;
                }
            }

            if (countNum > (middle - start + 1)) {
                // 在[start, middle]中继续找
                end = middle;
            } else {
                // 在[middle + 1, end]中继续找
                start = middle + 1;
            }
        }

        return -1;
    }

    // 统计数组中数字范围在[start, end]范围内的数目
    private static int count(int[] arr, int start, int end) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if (start <= arr[i] && arr[i] <= end) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        int num = duplicate(arr);
        System.out.println(num); // 3
    }
}
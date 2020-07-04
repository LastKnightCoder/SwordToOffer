public class Min {
    public static int min(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        // 如果 start 的值小于 end，说明数组没有进行旋转，则返回数组的第一个值，这就是 mid = 0 的原因
        while (arr[start] >= arr[end]) {
            // 如果两个指针相差 1 个距离，则返回第二个指针指向的值
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            // 如何中间的值和两个指针的值相等，则进行顺序查找
            if (arr[start] == arr[end] && arr[start] == arr[mid]) {
                return minInOrder(arr, start, end);
            }

            // 如果中间的值比 start 的值大，则将 start 移至中间
            if (arr[mid] >= arr[start]) {
                start = mid;
            } else if (arr[mid] < arr[end]) {
                // 否则中间的值比 end 小，则将 end 移至中间
                end = mid;
            }
        }

        return arr[mid];
    }

    // 顺序查找的代码
    public static int minInOrder(int[] arr, int start, int end) {
        int minResult = arr[start];
        for (int i = start; i <= end; i++) {
            if (minResult > arr[i]) {
                minResult = arr[i];
            }
        }
        return minResult;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(min(arr)); // 1
    }
}
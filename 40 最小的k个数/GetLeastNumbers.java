import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
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

    public static int[] getLeastNumbers(int[] data, int k) {

        if (data.length < k) {
            throw new RuntimeException("数组的长度小于k");
        }

        int start = 0;
        int end = data.length - 1;
        int index = partition(data, start, end);

        while (index != (k - 1)) {
            if (index < (k - 1)) {
                start = index + 1;
                index = partition(data, start, end);
            } else {
                end = index - 1;
                index = partition(data, start, end);
            }
        }

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = data[i];
        }

        return results;
    }

    public static int[] getLeastKNumber(int[] data, int k) {
        if (data.length < k) {
            throw new RuntimeException("数组的长度小于k");
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());

        for (int i =0; i < k; i++) {
            maxHeap.add(data[i]);
        }

        for (int i = k; i < data.length; i++) {
            if (data[k] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(data[i]);
            }
        }

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = maxHeap.poll();
        }

        return results;
    }

    private static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            return num2 - num1;
        }
    }

    public static void printArray(int[] data) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i != data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] results = getLeastNumbers(data, 3);
        printArray(results);
    }
}
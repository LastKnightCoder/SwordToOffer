import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MiddleNumber {
    public static double getMiddleNumber(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("数组为空或null");
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());
        Queue<Integer> minHeap = new PriorityQueue<>(new MinComparator());
        
        maxHeap.add(data[0]);
        for (int i = 1; i < data.length; i++) {
            if (data[i] < maxHeap.peek()) {
                maxHeap.add(data[i]);
            } else {
                minHeap.add(data[i]);
            }

            if (maxHeap.size() - minHeap.size() >= 2) {
                int res = maxHeap.remove();
                minHeap.add(res);
            } else if (minHeap.size() - maxHeap.size() >= 2) {
                int res = minHeap.remove();
                maxHeap.add(res);
            }
        }

        double result;
        if (maxHeap.size() - minHeap.size() > 0) {
            result = maxHeap.peek();
        } else if (maxHeap.size() - minHeap.size() < 0) {
            result = minHeap.peek();
        } else {
            result = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
        }

        return result;
    }

    private static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            return num2 - num1;
        }
    }

    private static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            return num1 - num2;
        }
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 5, 2, 3, 8, 4, 8, 9, 5, 10};
        double result = getMiddleNumber(data);
        System.out.println(result);
    }
}
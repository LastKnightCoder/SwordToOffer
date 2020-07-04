import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueWithMax {
    private static Deque<Integer> queue = new LinkedList<>();
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());

    public static void offer(int value) {
        queue.offer(value);
        priorityQueue.offer(value);
    }

    public static void poll() {
        Integer i = queue.poll();
        priorityQueue.remove(i);
    }

    public static Integer max() {
        return priorityQueue.peek();
    }

    public static int[] maxSliderWindow(int[] data, int size) {
        if (data == null || data.length == 0) {
            return data;
        }

        if (data.length < size) {
            return null;
        }

        int[] results = new int[data.length - size + 1];

        for (int i = 0; i < size; i++) {
            offer(data[i]);
        }

        for (int i = size; i < data.length; i++) {
            results[i - size] = max();
            poll();
            offer(data[i]);
        }

        results[results.length - 1] = max();

        return results;
    }

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] results = maxSliderWindow(data, 3);
        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i != results.length - 1) {
                System.out.print(results[i] + ",");
            } else {
                System.out.println(results[i] + "]");
            }

        }
    }
}
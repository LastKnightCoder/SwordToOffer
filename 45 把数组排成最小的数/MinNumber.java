import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {
    public static void minNumber(Integer[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        Arrays.sort(numbers, new MyComparator());
    }

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer m, Integer n) {
            return ("" + m + n).compareTo("" + n + m);
        }
    }

    private static void printArray(Integer[] data) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            str.append(data[i]);
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Integer[] numbers = {34, 31, 321};
        minNumber(numbers);
        printArray(numbers);
    }
}
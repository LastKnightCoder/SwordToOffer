public class ReorderOddEven {
    public static void reorderOddEven(final int[] data, final Group group) {
        if (data == null) {
            return;
        }

        int after = data.length;
        int cur = 0;
        while (cur < after) {
            if (group.group(data[cur])) {
                cur++;
            } else {
                swap(data, cur, --after);
            }
        }
    }

    public static void swap(final int[] data, final int i, final int j) {
        final int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void printArray(final int[] data) {
        System.out.print("[ ");
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                System.out.println(data[i] + " ]");
            } else {
                System.out.print(data[i] + ", ");
            }
        }
    }

    public static void main(final String[] args) {
        final int[] data = { 1, 2, -3, 4, -5, 9, 6, 3 };
        reorderOddEven(data, number -> number % 3 == 0);
        printArray(data);

        reorderOddEven(data, number -> number < 0);
        printArray(data);

        reorderOddEven(data, number -> (number & 1) == 1);
        printArray(data);
    }
}
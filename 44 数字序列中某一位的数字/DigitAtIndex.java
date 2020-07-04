public class DigitAtIndex {
    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;

        while (true) {
            int numbers = countInteger(digit);
            if (index < numbers * digit) {
                return digitAtIndex(index, digit);
            }
            index -= numbers * digit;
            digit++;
        }
    }

    private static int countInteger(int digit) {
        if (digit == 1) {
            return 10;
        }

        return (int)Math.pow(10, digit - 1) * 9;
    }

    private static int digitAtIndex(int index, int digit) {
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;

        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private static int beginNumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (int)Math.pow(10, digit - 1);
    }

    public static void main(String[] args) {
        int number = digitAtIndex(1001);
        System.out.println(number); // 7
    }
}
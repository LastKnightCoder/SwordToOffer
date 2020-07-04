public class TranslateNumberToChar {
    public static int translateNumberToChar(int number) {
        char[] numberStr = Integer.toString(number).toCharArray();
        return translateNumberToChar(numberStr, 0);
    }

    private static int translateNumberToChar(char[] numberStr, int start) {
        if (start == numberStr.length) {
            return 0;
        }

        if (start == numberStr.length - 1) {
            return 1;
        }

        char[] num = {numberStr[start], numberStr[start+1]};
        int number = Integer.parseInt(new String(num));

        if (number < 26) {
            return 2 + translateNumberToChar(numberStr, start + 2);
        } else {
            return 1 + translateNumberToChar(numberStr, start + 1);
        }
    }

    public static void main(String[] args) {
        int count = translateNumberToChar(12258);
        System.out.println(count);
    }
}
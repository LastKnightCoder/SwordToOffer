public class NumberOf1Between1AndN {
    public static int numberOf1Between1AndN(int number) {
        char[] str = Integer.toString(number).toCharArray();

        return numberOfOne(str, 0);
    }

    private static int numberOfOne(char[] str, int start) {
        if (start == str.length) {
            return 0;
        }

        // 最高位
        int first = str[start] - '0';

        int restLength = str.length - start;

        if (restLength == 1 && first == 0) {
            return 0;
        }
        if (restLength == 1 && first > 0) {
            return 1;
        }

        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = (int)Math.pow(10, restLength - 1);
        } else if (first == 1) {
            String s = new String(str);
            s = s.substring(start + 1) ;
            numFirstDigit = Integer.parseInt(s) + 1;
        }
        int numOtherDigit = (int)(first * (restLength - 1) * Math.pow(10, restLength - 2));

        int numRecursive = numberOfOne(str, start + 1);

        return numFirstDigit + numOtherDigit + numRecursive;
    }

    public static void main(String[] args) {
        int result = numberOf1Between1AndN(12345);
        System.out.println(result);
    }
}
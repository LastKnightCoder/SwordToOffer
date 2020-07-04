public class Print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n) {
        if (n < 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        while(!increment(number)) {
            printNumber(number);
        }
    }

    private static boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        for(int i = number.length  - 1; i >= 0; i--) {
            int nNumber = number[i] - '0' + takeOver;
            if (i == number.length - 1) {
                nNumber++;
            }

            if (nNumber >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    takeOver = 1;
                    nNumber -= 10;
                    number[i] = (char)(nNumber + '0');
                }
            } else {
                number[i] = (char)(nNumber + '0');
                break;
            }
        }

        return isOverflow;
    }

    private static void printNumber(char[] number) {
        StringBuilder str = new StringBuilder();
        boolean beginZero= true;
        for(int i = 0; i < number.length; i++) {
            if (beginZero && number[i] != '0') {
                beginZero = false;
            }
            if (!beginZero) {
                str.append(number[i]);
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }


}
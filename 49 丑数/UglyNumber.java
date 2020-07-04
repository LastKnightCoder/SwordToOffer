public class UglyNumber {
    public static int getUglyNumber(int n) {
        int count = 0;
        int number = 0;
        while (count < n) {
            number++;
            if (isUglyNumber(number)) {
                count++;
            }
        }

        return number;
    }

    private static boolean isUglyNumber(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;

        int uglyNumberMultiply2Index = 0;
        int uglyNumberMultiply3Index = 0;
        int uglyNumberMultiply5Index = 0;

        for (int i = 1; i < uglyNumbers.length; i++) {
            int min = Math.min(uglyNumbers[uglyNumberMultiply2Index] * 2, 
            Math.min(uglyNumbers[uglyNumberMultiply3Index] * 3, uglyNumbers[uglyNumberMultiply5Index] * 5));
            
            uglyNumbers[i] = min;

            if (uglyNumbers[uglyNumberMultiply2Index] * 2 == min) {
                uglyNumberMultiply2Index++;
            }

            if (uglyNumbers[uglyNumberMultiply3Index] * 3 == min) {
                uglyNumberMultiply3Index++;
            }

            if (uglyNumbers[uglyNumberMultiply5Index] * 5 == min) {
                uglyNumberMultiply5Index++;
            }
        }

        return uglyNumbers[index - 1];
    }

    public static void main(String[] args) {
        int uglyNumberAtIndex = getUglyNumber(1500);
        System.out.println(uglyNumberAtIndex);
    }
}
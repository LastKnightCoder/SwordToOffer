public class FindNumAppearOnce {
    private static int findFirstBitIs1(int number) {
        int flag = 1;
        int index = 0;
        while ((number & flag) != 0 && index < 32) {
            flag = flag << 1;
            index++;
        }

        return index;
    }

    private static boolean isBit1(int number, int index) {
        int flag = 1 << index;
        return (number & flag) != 0;
    }

    public static int[] findNumAppearOnce(int[] data) {
        if (data == null || data.length < 2) {
            throw new RuntimeException("传入的数字错误");
        }

        int resultOR = 0;
        for (int i = 0; i < data.length; i++) {
            resultOR ^= data[i];
        }

        int firstBit1 = findFirstBitIs1(resultOR);
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < data.length; i++) {
            if (isBit1(data[i], firstBit1)) {
                num1 ^= data[i];
            } else {
                num2 ^= data[i];
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] twoNum = findNumAppearOnce(data);
        System.out.println(twoNum[0] + " " + twoNum[1]);
    }
}
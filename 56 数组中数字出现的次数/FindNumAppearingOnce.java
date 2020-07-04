public class FindNumAppearingOnce {
    public static int findAppearOnceWithBit(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("wrong input");
        }

        int[] bitSum = new int[32];

        for (int i = 0; i < data.length; i++) {
            int mask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit =  (data[i] & mask);
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                mask = mask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 1, 2, 3, 3, 3};
        int once = findAppearOnceWithBit(data);
        System.out.println(once);
    }
}
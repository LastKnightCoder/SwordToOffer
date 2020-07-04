public class FindGreatestSumOfSubArray {
    public static int findGreastSumOfSubArray(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("数组为空或null");
        }
        int sum = 0;
        int greastSum = sum;
        for (int i = 0; i < data.length; i++) {
            if (sum <= 0) {
                sum = data[i];
            } else {
                sum += data[i];
            }

            if (sum > greastSum) {
                greastSum = sum;
            }
        }
        return greastSum;
    }

    public static void main(String[] args) {
        int[] data = {2, -1, 3, -4, 5, -2, 4, 7};
        int result = findGreastSumOfSubArray(data);
        System.out.println(result);
    }
    
}
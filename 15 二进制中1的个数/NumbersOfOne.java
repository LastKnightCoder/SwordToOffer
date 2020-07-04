public class NumbersOfOne {
    public static int numbersOfOne(int n) {
        int count = 0;

        while(n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

    // public static int numbersOfOne(int n) {
    //     int count = 0;
    //     int flag = 1;

    //     while (flag != 0) {
    //         if ((n & flag) != 0) {
    //             count++;
    //         }
    //         flag = flag << 1;
    //     }

    //     return count;
    // }

    public static void main(String[] args) {
        System.out.println(numbersOfOne(-7)); // 30
    }
}
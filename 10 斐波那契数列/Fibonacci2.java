public class Fibonacci2 {
    public static int fibonacci(int n) {
        int firstNumber = 1;
        int secondNumber = 1;

        if (n <= 0) {
            return 0;
        } if (n == 1 || n == 2) {
            return 1;
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            result =  firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = result;
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(fibonacci(45));
        long end = System.nanoTime();

        System.out.println((end -  start) / 1000000 + " ms");
    }
}
public class Fibonacci1 {
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacci(n -1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(fibonacci(45));
        long end = System.nanoTime();

        System.out.println((end -  start) / 1000000 + " ms");
    }
}
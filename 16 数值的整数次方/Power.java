public class Power {
    public static double power(double base, int exponent) {

        // base = 0
        if (Math.abs(base) < 0.00000001 && exponent < 0) {
            throw new RuntimeException("不能出现0的负次幂");
        }

        int absExponent = Math.abs(exponent);

        double result = anotherPowerWithPositiveExponent(base, absExponent);

        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    // private static double powerWithPositiveExponent(double base, int exponent) {
    //     double result = 1.0;

    //     for (int i = 0; i < exponent; i++) {
    //         result *= base;
    //     }

    //     return result;
    // }

    private static double anotherPowerWithPositiveExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            return base;
        }

        double result = anotherPowerWithPositiveExponent(base, exponent >> 1);
        result *= result;

        // use bit operation not % operator
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 7)); // 0.25
    }
}
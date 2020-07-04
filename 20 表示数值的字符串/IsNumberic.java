public class IsNumberic {
    private static int index;
    public static boolean isNumberic(char[] str) {
        if (str == null) {
            return false;
        }

        boolean numberic = scanInteger(str, 0);

        if (index < str.length) {
            if (str[index] == '.') {
                index++;
                numberic = scanUnsignedInteger(str, index) || numberic;
            }
        }
        
        if (index < str.length) {
            if (str[index] == 'e' || str[index] == 'E') {
                index++;
                numberic = numberic && scanInteger(str, index);
            }
        }
        
        return numberic && index == str.length;
    }

    private static boolean scanInteger(char[] str, int start) {
        if (start >= str.length) {
            return false;
        }
        if (str[start] == '+' || str[start] == '-') {
            return scanUnsignedInteger(str, start + 1);
        }
        return scanUnsignedInteger(str, start);
    }

    private static boolean scanUnsignedInteger(char[] str, int start) {
        index = start;
        if (index < str.length) {
            while(str[index] >= '0' && str[index] <= '9') {
                index++;
                if (index == str.length) {
                    break;
                }
            }
        }
        return index > start;
    }

    public static void main(String[] args) {
        System.out.println(isNumberic(".123".toCharArray())); // true
        System.out.println(isNumberic("123.".toCharArray())); // true
        System.out.println(isNumberic("+.123".toCharArray())); // true
        System.out.println(isNumberic("-.123".toCharArray())); // true
        System.out.println(isNumberic(".123e-2".toCharArray())); // true
        System.out.println(isNumberic("1.2.2".toCharArray())); // false
        System.out.println(isNumberic("1.2e+2".toCharArray())); // true
    }
}
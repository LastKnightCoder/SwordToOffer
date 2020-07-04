public class Test {
    public static char[] replaceBlank(char[] str) {

        if (str == null) {
            throw new IllegalArgumentException("字符数组为null");
        }

        int length = str.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                count++;
            }
        }
        char[] newStr = new char[length + count * 2];

        int p1 = length - 1;
        int p2 = length + count * 2 - 1;

        while(p1 != p2) {
            if (str[p1] != ' ') {
                newStr[p2] = str[p1];
                p1--;
                p2--;
            } else {
                p1--;
                newStr[p2--] = '0';
                newStr[p2--] = '2';
                newStr[p2--] = '%';
            }
        }

        while(p1 >= 0) {
            newStr[p1] = str[p1];
            p1--;
        }

        return newStr;
    }

    private static void printCharArray(char[] str) {
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] str = {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        // char[] str = {' ', ' ', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        printCharArray(str);
        char[] newStr = replaceBlank(str);
        printCharArray(newStr);
    }
}
public class LeftRotateString {
    public static String leftRotateString(String string, int n) {
        String string1 = string.substring(0, n);
        String string2 = string.substring(n);

        string1 = reverse(string1);
        string2 = reverse(string2);
        string = string1 + string2;
        string = reverse(string);
        return string;
    }

    public static String reverse(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        char[] str = string.toCharArray();
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String string = "abcdefg";
        string = leftRotateString(string, 2);
        System.out.println(string);
    }
}
public class Permutation {
    public static void permutation(String string) {
        char[] str = string.toCharArray();
        permutation(str, 0);
    }

    private static void permutation(char[] str, int index) {
        if (index == str.length) {
            System.out.println(new String(str));
        }

        for (int i = index; i < str.length; i++) {
            char temp = str[i];
            str[i] = str[index];
            str[index] = temp;

            permutation(str, index + 1);

            temp = str[i];
            str[i] =  str[index];
            str[index] = temp;
        }
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}
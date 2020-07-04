import java.util.HashMap;

public class FindFirstNotRepeating {
    public static char findFirstNotRepeating(char[] str) {
        if (str == null || str.length == 0) {
            return '\0';
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                map.put(str[i], map.get(str[i]) + 1);
            } else {
                map.put(str[i], 1);
            }
        }

        for (int i = 0; i < str.length; i++) {
            if (map.get(str[i]) == 1) {
                return str[i];
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        char c = findFirstNotRepeating("abaccdeff".toCharArray());
        System.out.println(c);
    }
}
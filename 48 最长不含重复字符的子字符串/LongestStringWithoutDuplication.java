public class LongestStringWithoutDuplication {
    public static int getLongestStringWithoutDuplication(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        char[] str = string.toCharArray();
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        int curLength = 0;
        int maxLength = 0;

        for (int i = 0; i < str.length; i++) {
            int prevIndex = position[str[i] - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - prevIndex;
            }
            position[str[i] - 'a'] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int maxLength = getLongestStringWithoutDuplication("arabcacfr");
        System.out.println(maxLength);
    }
}
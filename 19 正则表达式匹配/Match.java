public class Match {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length  && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        if (strIndex == str.length && patternIndex != pattern.length) {
            return false;
        }

        if ((patternIndex + 1) < pattern.length && pattern[patternIndex + 1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.') {
                boolean result = matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                || matchCore(str, strIndex + 1, pattern, patternIndex)
                || matchCore(str, strIndex, pattern, patternIndex + 2);
                return result;
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();

        char[] pattern1 = "a.a".toCharArray();
        System.out.println(match(str, pattern1)); // true
        
        char[] pattern2 = "ab*ac*a".toCharArray();
        System.out.println(match(str, pattern2)); // true
        
        char[] pattern3 = "aa.a".toCharArray();
        System.out.println(match(str, pattern3)); // false

        char[] pattern4 = "ab*a".toCharArray();
        System.out.println(match(str, pattern4)); // false

    }
}
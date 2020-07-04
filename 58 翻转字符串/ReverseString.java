public class ReverseString {
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
            start++;a
            end--;
        }

        return new String(str);
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }

        sentence = reverse(sentence);
        String[] strings = sentence.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reverse(strings[i]);
            if (i != strings.length - 1) { 
                stringBuilder.append(strings[i] + " ");
            } else {
                stringBuilder.append(strings[i]);
            }
        }

        return stringBuilder.toString();
        
    }

    public static void main(String[] args) {
        String sentence = "I am a Student.";
        sentence = reverseSentence(sentence);
        System.out.println(sentence);
    }
}
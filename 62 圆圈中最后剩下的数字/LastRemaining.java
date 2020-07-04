import java.util.LinkedList;
import java.util.List;

public class LastRemaining {
//    public static int lastRemaining(int n, int m) {
////        List<Integer> list = new LinkedList<>();
////
////        for (int i = 0; i < n; i++) {
////            list.add(i);
////        }
////
////        int currentIndex = (m - 1) % list.size();
////        while (list.size() > 1) {
////            list.remove(currentIndex);
////            currentIndex = (currentIndex + m - 1) % list.size();
////        }
////
////        return list.get(currentIndex );
////    }

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }

        int last = 0;
        for (int i = 2; i<= n; i++) {
            last = (last + m) % n;
        }

        return last;
    }

    public static void main(String[] args) {
        int result = lastRemaining(5, 5);
        System.out.println(result);
    }
}
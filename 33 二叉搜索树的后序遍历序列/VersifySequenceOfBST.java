public class VersifySequenceOfBST {
    public static boolean versifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return versifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean versifySequenceOfBST(int[] sequence, int start, int end) {
        int root = sequence[end];
        int index = start;
        for (; index < end; index++) {
            if (sequence[index] > root) {
                break;
            }
        }
        int mid = index;
        for (; index < end; index++) {
            if (sequence[index] < root) {
                return false;
            }
        }

        boolean left = true;
        if (mid > 0) {
            left = versifySequenceOfBST(sequence, 0, mid - 1);
        }

        boolean right = true;
        if (mid < end) {
            right = versifySequenceOfBST(sequence, mid, end - 1);;
        }
        
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(versifySequenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8})); // true
        System.out.println(versifySequenceOfBST(new int[]{7, 4, 6, 5})); // false
    }
}
public class Test02 {
    public static int duplicate(int[] arr) {
        int N = arr.length;
        int[] helpArr = new int[N];

        for(int i = 0; i < N; i++) {
            if (arr[i] == helpArr[arr[i]]) {
                return arr[i];
            } else {
                helpArr[arr[i]] = arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        int num = duplicate(arr);
        System.out.println(num); // 3
    }
}
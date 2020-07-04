public class Test01 {
    public static boolean duplicate(int[] arr) {

        if (arr.length <= 0 || arr == null) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if (arr[arr[i]] == arr[i]) {
                    return true;
                }

                swap(arr, i, arr[i]);
                printArr(arr);
            }
        }

        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1) {
                System.out.print(", "); 
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 3, 5};
        // int[] arr = {7, 5, 6, 3, 4, 1, 0, 2};
        boolean duplicated = duplicate(arr);
        System.out.println(duplicated);
    }
}
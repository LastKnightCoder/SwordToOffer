import java.util.Stack;

public class IsPopOrder {
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null) {
            return false;
        }

        if (pushOrder.length != popOrder.length) {
            return false;
        }
        boolean possible = false;
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        while (popIndex < popOrder.length) {
            while(stack.isEmpty() || stack.peek() != popOrder[popIndex]) {
                if (pushIndex == pushOrder.length) {
                    break;
                }
                stack.push(pushOrder[pushIndex++]);
            }
            if (stack.peek() != popOrder[popIndex]) {
                break;
            }
            stack.pop();
            popIndex++;
        }

        if (stack.isEmpty() && popIndex == popOrder.length) {
            possible = true;
        }

        return possible;
    }

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder1 = {4, 5, 3, 2, 1};
        int[] popOrder2 = {4, 3, 5, 1, 2};

        System.out.println(isPopOrder(pushOrder, popOrder1));
        System.out.println(isPopOrder(pushOrder, popOrder2));
    }
}
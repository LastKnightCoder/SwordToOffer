import java.util.Stack;

public class StackWithMin {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public StackWithMin() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop() {
        if (stack.empty()) {
            throw new RuntimeException("stack is empty");
        } 

        minStack.pop();
        return stack.pop();
    }

    public Integer min() {
        if(minStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(1);
        stackWithMin.push(2);
        stackWithMin.push(3);
        stackWithMin.push(0);

        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
}
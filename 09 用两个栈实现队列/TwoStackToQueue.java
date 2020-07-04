import java.util.Stack;

public class TwoStackToQueue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void appendTail(Integer value) {
        // 添加数据从 stack1 添加
        stack1.push(value);
    }

    public static Integer deleteHead() {
        // stack2 不为空时 从stack2 弹出数据
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            // stack2 为空时 且stack1 不为空时，将stack1的数据弹出压入到stack2中
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                // stack1 和 stack2 都为空，说明队列为空 抛出异常
                throw new RuntimeException("Queue is Empty");
            }
        }
    }

    public static void main(String[] args) {
        TwoStackToQueue.appendTail(1); // 1
        TwoStackToQueue.appendTail(2); // 1 2
        TwoStackToQueue.appendTail(3); // 2 3
        TwoStackToQueue.appendTail(4); // 1 2 3 4
        System.out.println(TwoStackToQueue.deleteHead()); // 1
        TwoStackToQueue.appendTail(5); // 2 3 4 5
        System.out.println(TwoStackToQueue.deleteHead()); // 2
    }
}
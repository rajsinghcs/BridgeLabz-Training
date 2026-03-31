import java.util.*;

public class ImplementQueueUsingStacks {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public ImplementQueueUsingStacks() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println(queue.pop());  
        System.out.println(queue.pop());  
    }
}

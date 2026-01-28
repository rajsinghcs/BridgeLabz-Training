import java.util.*;
public class ImplementStackUsingQueues {
    static Queue<Integer> queue;
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i=0; i<queue.size()-1; i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
       return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    public static void main(String[] args){
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top());   // 30
        System.out.println(stack.pop());   // 30
        System.out.println(stack.top());   // 20
        System.out.println(stack.empty()); // false
    }
}

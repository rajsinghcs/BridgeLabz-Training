import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> res = new Stack<>();
        ListNode temp = head;
        if (head == null || head.next == null){
            return true;
        }
        while(temp!=null){
            res.push(temp.val);
            temp = temp.next;
        }
        while(!res.isEmpty()){
            int stackVal = res.pop();
            if(head.val != stackVal){
                return false;
            }
            else{
                head=head.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pll.isPalindrome(head)); // Output: true
    }
}
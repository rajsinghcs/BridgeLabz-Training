import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}
 
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        while( head!=null && head.val==val){
            head=head.next;
        }
        if(head==null){
            return head;
        }
        while(temp !=null){
            if(temp.next!=null && temp.next.val==val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(6);
        temp.next.next.next = new ListNode(3);
        temp.next.next.next.next = new ListNode(4);
        temp.next.next.next.next.next = new ListNode(5);
        temp.next.next.next.next.next.next = new ListNode(6);

        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        int valToRemove = 3;    
        ListNode updatedHead = solution.removeElements(head, valToRemove);
        System.out.print("Updated linked list after removing " + valToRemove + ": ");
        temp = updatedHead; 
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
} 

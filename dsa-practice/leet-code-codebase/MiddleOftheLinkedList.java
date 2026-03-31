public class MiddleOftheLinkedList {
static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == null || fast.next == null){
                return slow;
            }
        }
    return slow;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(3);
        temp.next.next.next = new ListNode(4);
        temp.next.next.next.next = new ListNode(5);

        MiddleOftheLinkedList solution = new MiddleOftheLinkedList();
        ListNode middle = solution.middleNode(head);
        System.out.println("Middle node value: " + middle.val);
       
    }
}
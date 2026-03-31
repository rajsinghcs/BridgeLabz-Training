public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode nextPair = current.next.next;
            ListNode second = current.next;

            // Swap the pair
            second.next = current;
            current.next = nextPair;

            if (prev != null) {
                prev.next = second;
            }

            // Update pointers for next iteration
            prev = current;
            current = nextPair;
        }
        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        // Create a test list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);

        ListNode swapped = solution.swapPairs(head);

        System.out.println("Swapped list:");
        printList(swapped);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

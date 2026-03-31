public class TextEditorUndoRedo {

    static final int MAX_HISTORY = 10;

    static Node head = null;
    static Node tail = null;
    static Node current = null;
    static int size = 0;

    // Doubly Linked List Node
    static class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    // Add new text state
    public static void addState(String text) {

        Node newNode = new Node(text);

        // If first state
        if (head == null) {
            head = tail = current = newNode;
            size++;
            return;
        }

        // Remove redo history
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        // Add at end
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        // Maintain history limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available");
        }
    }

    // Redo operation
    public static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available");
        }
    }

    // Display current text
    public static void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("Editor is empty");
        }
    }

    // Main method 
    public static void main(String[] args) {

        addState("Hello");
        addState("Hello World");
        addState("Hello World!");
        addState("Hello World!!");

        displayCurrentState();

        undo();
        displayCurrentState();

        undo();
        displayCurrentState();

        redo();
        displayCurrentState();

        addState("Hello Java World");
        displayCurrentState();

        redo();   // Should not redo
    }
}

import java.util.Stack;

class HistoryNode {
    String url;
    HistoryNode prev, next;

    HistoryNode(String url) {
        this.url = url;
    }
}

class BrowserBuddy {

    private HistoryNode current;
    private Stack<String> closedTabs = new Stack<>();

    // Visit new page
    public void visit(String url) {
        HistoryNode node = new HistoryNode(url);

        if (current != null) {
            current.next = node;
            node.prev = current;
        }
        current = node;
        System.out.println("Visited: " + url);
    }

    // Go back
    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No previous page");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    // Go forward
    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No next page");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    // Close current tab
    public void closeTab() {
        if (current == null) {
            System.out.println("No tab to close");
            return;
        }

        closedTabs.push(current.url);
        System.out.println("Closed tab: " + current.url);

        if (current.prev != null)
            current = current.prev;
        else
            current = current.next;
    }

    // Restore closed tab
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore");
            return;
        }

        String url = closedTabs.pop();
        visit(url);
        System.out.println("Restored tab: " + url);
    }

    public static void main(String[] args) {

        BrowserBuddy browser = new BrowserBuddy();

        browser.visit("google.com");
        browser.visit("github.com");
        browser.visit("stackoverflow.com");

        browser.back();
        browser.forward();

        browser.closeTab();
        browser.restoreTab();
    }
}

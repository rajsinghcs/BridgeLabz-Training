class ParcelStage {

    String stage;
    ParcelStage next;

    ParcelStage(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

class ParcelTracker {

    private ParcelStage head;

    // Add stage at end
    public void addStage(String stage) {
        ParcelStage newNode = new ParcelStage(stage);

        if (head == null) {
            head = newNode;
            return;
        }

        ParcelStage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add checkpoint after a stage
    public void addCheckpoint(String afterStage, String newStage) {
        ParcelStage temp = head;

        while (temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found. Parcel may be lost.");
            return;
        }

        ParcelStage node = new ParcelStage(newStage);
        node.next = temp.next;
        temp.next = node;
    }

    // Track parcel
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel lost (no tracking data)");
            return;
        }

        ParcelStage temp = head;
        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpoint("Shipped", "Custom Checkpoint");

        tracker.trackParcel();
    }
}

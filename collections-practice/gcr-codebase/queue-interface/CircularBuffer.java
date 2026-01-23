class CircularBuffer {
    int[] buffer;
    int size, front = 0, count = 0;

    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    void insert(int x) {
        int index = (front + count) % size;
        buffer[index] = x;

        if (count == size) {
            front = (front + 1) % size; 
        } else {
            count++;
        }
    }

    void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);

        cb.display(); 
    }
}

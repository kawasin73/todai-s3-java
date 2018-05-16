public class Queue {
    private int capacity;
    private int size;
    private int front;
    private int rear;
    private String[] dataSet;

    public Queue(int initSize) {
        capacity = initSize;
        size = 0;
        front = 0;
        rear = 0;
        dataSet = new String[capacity];
    }

    public boolean isEmpty() {
        // ここにisEmptyの処理を書いてください
        return size == 0;
    }

    public void insert(String s) {
        // ここにinsertの処理を書いてください
        if (size >= capacity) {
            doubleCapacity();
        }
        if (size == 0) {
            front = rear = 0;
        } else {
            rear = next(rear);
        }
        dataSet[rear] = s;
        size++;
    }

    public String remove() {
        // ここにremoveの処理を書いてください
        if (isEmpty()) {
            return "";
        }
        String data = dataSet[front];
        size--;
        front = next(front);
        return data;
    }

    public String peek() {
        // ここにpeekの処理を書いてください
        if (isEmpty()) {
            return "";
        }
        return dataSet[front];
    }

    private int next(int v) {
        if (v == capacity - 1) {
            return 0;
        }
        return v + 1;
    }

    private void doubleCapacity() {
        // ここにdoubleCapacityの処理を書いてください
        int newCap = capacity * 2;
        String[] newDataSet = new String[newCap];
        for (int i = 0; i < size; i++) {
            newDataSet[i] = dataSet[front];
            front = next(front);
        }
        front = 0;
        rear = capacity - 1;
        dataSet = newDataSet;
        System.out.printf("Capacity: %d -> %d\n", this.capacity, newCap);
        capacity = newCap;
    }
}
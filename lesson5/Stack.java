public class Stack {
    private static final int DEFAULT_INIT_SIZE = 16;

    private int capacity;
    private int size;
    private String[] dataSet;

    public Stack() {
        this(DEFAULT_INIT_SIZE);
    }

    public Stack(int initSize) {
        capacity = initSize;
        size = 0;
        dataSet = new String[capacity];
    }

    public boolean isEmpty() {
        // ここにisEmptyの処理を書いてください
        return size == 0;
    }

    public void push(String s) {
        // ここにpushの処理を書いてください
        if (size >= capacity) {
            doubleCapacity();
        }
        dataSet[size] = s;
        size++;
    }

    public String pop() {
        // ここにpopの処理を書いてください
        if (isEmpty()) {
            return "";
        }
        size--;
        return dataSet[size];
    }

    public String peek() {
        // ここにpeekの処理を書いてください
        if (isEmpty()) {
            return "";
        }
        return dataSet[size - 1];
    }

    private void doubleCapacity() {
        // ここにdoubleCapacityの処理を書いてください
        int newCap = capacity * 2;
        String[] newDataSet = new String[newCap];
        for (int i = 0; i < capacity; i++) {
            newDataSet[i] = dataSet[i];
        }
        dataSet = newDataSet;
        System.out.printf("Capacity: %d -> %d\n", this.capacity, newCap);
        capacity = newCap;
    }
}

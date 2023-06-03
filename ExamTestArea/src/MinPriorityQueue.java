public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] data;
    private int size;

    public MinPriorityQueue(int capacity) {
        data = (T[]) new Comparable[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void shiftUp(int index) {
        while (index > 0 && data[parent(index)].compareTo(data[index]) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void insert(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Heap is full");
        }
        data[size] = element;
        shiftUp(size);
        size++;
    }

    private void shiftDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        if (left < size && data[left].compareTo(data[minIndex]) < 0) {
            minIndex = left;
        }
        int right = rightChild(index);
        if (right < size && data[right].compareTo(data[minIndex]) < 0) {
            minIndex = right;
        }
        if (index != minIndex) {
            swap(index, minIndex);
            shiftDown(minIndex);
        }
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = data[0];
        data[0] = data[size - 1];
        size--;
        shiftDown(0);
        return min;
    }
}

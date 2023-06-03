class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Node class for storing the elements of the linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    // Constructor to create an empty linked list
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to insert elements in ascending order
    public void insertInOrder(T data) {
        // Create a new node with the given data
        Node<T> newNode = new Node<>(data);

        // Check if the linked list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        // Find the correct position to insert the new node
        Node<T> current = head;
        while (current.next != null && current.data.compareTo(data) < 0) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        } else {
            newNode.next.prev = newNode;
        }
        size++;
    }

    // Method to print the elements of the linked list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Getters for the size and head of the linked list
    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }
}

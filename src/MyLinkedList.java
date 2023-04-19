public class MyLinkedList<T> implements MyList {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList(){
        this.head=null;
        this.tail=null;
        size=0;
    }
    @Override
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void printList(){
        if(size == 0){
            System.out.println("Linked list is empty.");
            return;
        }
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.item);
            if (currentNode.next != null) {
                System.out.print(" ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    @Override
    public boolean contains(Object o) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.item.equals(head.item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public void add(Object item) {
        Node<T> newNode = new Node<T>((Node<T>) item, null, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    @Override
    public boolean remove(Object item) {
        if (head == null) {
            return false;
        }
        if (head.item.equals(item)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return true;
        }
        Node<T> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.item.equals(item)) {
                currentNode.prev.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    @Override
    public Object remove(int index) {
        checkIndex(index);

        if (index == 0) {
            Object removed = head.item;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return removed;
        }

        if (index == size - 1) {
            Object removed = tail.item;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }

        Node<T> ptr = getNodeAtIndex(index);
        Node<T> prev = ptr.prev;
        Node<T> next = ptr.next;
        Object removed = ptr.item;

        prev.next = next;
        next.prev = prev;
        size--;
        return removed;
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> ptr = head.next;
        for (int i = 1; i < size - 1; i++) {
            if (i == index) {
                return ptr;
            }
            ptr = ptr.next;
        }
        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }
    }
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> node = getNode(index);
        return node.item;
    }

    private Node<T> getNode(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}

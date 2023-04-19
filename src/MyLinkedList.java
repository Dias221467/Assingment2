public class MyLinkedList<T> implements MyList {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //Creating List with without values
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    //Show the size of List
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //Show the List
    public void printList() {
        if (size == 0) {
            System.out.println("Linked list is empty.");
            return;
        }
        //CurrentNode - method which states for specific object
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

    //contains - method that checking whether array contains a given element
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

    // Create a new node with the given item
    @Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        // If the list is empty, set the new node as the head and tail
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //add object in specific place
    @Override
    public void add(Object item, int index) {
        // Check that the index is within bounds
        checkIndex(index);
        // Create a new node with the given item
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        // Traverse the list until the specified index is reached
        Node<T> ptr = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                // Insert the new node into the list
                newNode.prev = ptr;
                newNode.next = ptr.next;
                ptr.next.prev = newNode;
                ptr.next = newNode;
                size++;
                return;
            }
            ptr = ptr.next;
        }
    }
    //Removes the first occurrence of the specified element from this list.
    @Override
    public boolean remove(Object item) {
        // If the list is empty, return false
        if (head == null) {
            return false;
        }
        //If the head contains the item to be removed
        if (head.item.equals(item)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return true;
        }
        // Iterate through the list starting from the second node
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

    // Removes the element at the specified index in this linked list.
    @Override
    public Object remove(int index) {
        checkIndex(index);
        // Removing the first node
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
        // Removing the last node
        if (index == size - 1) {
            Object removed = tail.item;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        // Removing a node in the middle
        Node<T> ptr = getNodeAtIndex(index);
        Node<T> prev = ptr.prev;
        Node<T> next = ptr.next;
        Object removed = ptr.item;

        prev.next = next;
        next.prev = prev;
        size--;
        return removed;
    }
    // returns the Node object at the specified index in the linked list.
    private Node<T> getNodeAtIndex(int index) {
        Node<T> ptr = head.next; // Start at the second node
        for (int i = 1; i < size - 1; i++) { // Loop through the nodes
            if (i == index) { // If the current index matches the specified index
                return ptr;
            }
            ptr = ptr.next;
        }
        return null; // If the specified index is out of bounds, return null
    }
    //Checking if the null under the index exist
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }
    }
    //Delete all List
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    //
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

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            Node<T> ptr = head;
            for (int i = 0; i < size; i++) {
                if (ptr.item == null) {
                    return i;
                }
                ptr = ptr.next;
            }
        } else {
            Node<T> ptr = head;
            for (int i = 0; i < size; i++) {
                if (o.equals(ptr.item)) {
                    return i;
                }
                ptr = ptr.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        T element = (T) o;
        if (tail.item == element) {
            return size - 1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size - 2; i >= 0; i--) {
            if (ptr.item == element) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        // check if the list is sortable (i.e., if it contains only integers)
        if (isSortable()) {
            Node<T> front = head;
            Node<T> back = null;
            // loop through the list using the front pointer
            while (front != null) {
                // loop backwards from back to front
                back = front.next;
                while (back != null && back.prev != null && (Integer) back.item < (Integer) back.prev.item) {
                    // if the value at back is less than the value at the previous node, swap their values
                    swapValue(back, back.prev);
                    // move back one node backwards
                    back = back.prev;
                }
                // move front one node forwards
                front = front.next;
            }
        }
    }
    //checks whether the list contains elements that are only integers and doubles
    public boolean isSortable() {
        Node<T> ptr = head;
        boolean containsIntegers = false;
        boolean containsDoubles = false;
        // iterate through the list to check the types of its elements
        for (int i = 0; i < size; i++) {
            if (ptr.item instanceof Integer) {
                containsIntegers = true;
            } else if (ptr.item instanceof Double) {
                containsDoubles = true;
            } else {
                return false;
            }
            ptr = ptr.next;
        }
        // if the list contains both integers and doubles, it is sortable
        return containsIntegers && containsDoubles;
    }
    public void swapValue(Node<T> first, Node<T> second) {
        Object value = first.item;
        first.item = second.item;
        second.item = (T) value;
    }
}

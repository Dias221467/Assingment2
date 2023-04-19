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

}

public class MyLinkedList<T> implements MyList {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
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
}

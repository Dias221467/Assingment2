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
    @Override
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void printList(){
        if(size == 0){
            System.out.println("Linked List is empty\n");
            return;
        }
        if(head.next == null){
            System.out.println(head.item);
            return;
        }
        System.out.println(head.item + "<->");
        Node<T> ptr = head.next;
        while (ptr.next != null){
            System.out.println(ptr.item + "<->");
            ptr = ptr.next;
        }
        System.out.println(ptr.item + "\n");
    }
}

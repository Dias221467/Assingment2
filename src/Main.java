public class Main {
    public static void main(String[] args) {
        /*
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(25);
        System.out.println(arrayList.getElement(3));
        arrayList.deleteElement(3);
        System.out.println(arrayList.getElement(3));

        arrayList.clear();
        if(arrayList.isEmpty()){
            System.out.println("empty");
            }
        else{
            System.out.println("not");
            }
              */
        MyLinkedList lists = new MyLinkedList();
        lists.add(667);
        lists.add(228);
        lists.add(1337);
        lists.add(1488, 2);
        lists.printList();
        System.out.println(lists.size());
        System.out.println(lists.isSortable());
        lists.sort();
        lists.printList();
    }
}

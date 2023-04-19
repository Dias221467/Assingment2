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
        lists.add(15);
        lists.add(575);
        lists.add(398);
        lists.add(8524);
        lists.add(1381, 3);
        lists.printList();
        System.out.println(lists.size());
        System.out.println(lists.isSortable());
        lists.sort();
        lists.printList();
    }
}

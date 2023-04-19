public class Main {
    public static void main(String[] args){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(25);

        System.out.println(arrayList.get(3));
        arrayList.remove(3);
        System.out.println(arrayList.get(3));

        arrayList.clear();
        if(arrayList.isEmpty())
            System.out.println("empty");
        else
            System.out.println("not");
    }
}

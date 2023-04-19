public class MyArrayList<T> implements MyList{
    private T[] arr;
    private int size;

    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    public void add(T value){
        if(size==arr.length){
            increaseLenght();
        }
        this.arr[size++] = value;
    }
    public void increaseLenght(){
        T[] newArr =(T[]) new Object[arr.length*2];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}

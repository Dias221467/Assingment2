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
    public T getElement(int index){
        if(index<0 ||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    public void deleteElement(int index){
        checkIndex(index);
        for(int i = index - 1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}

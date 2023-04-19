public class MyArrayList<T> implements MyList{
    private T[] arr;
    private int size;

    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean contains(Object o){
        boolean bool = false;
        for(int i = 0; i < size; i++){
            if(arr[i] == o){
                bool = true;
            }
        }
        return bool;
    }
    @Override
    public void add(Object item){
        if(size==arr.length){
            increaseLenght();
        }
        this.arr[size++] = (T) item;
    }
    @Override
    public void add(Object item, int index){
        if(size == arr.length){
            increaseLenght();
        }
        T[] newArr = (T[]) new Object[arr.length];
        for (int i = 0; i< index; i++){
            newArr[i] = arr[i];
        }
        for(int i = index; i<size; i++){
            newArr[i+1] = arr[i];
        }
        newArr[index] = (T) item;
        arr = newArr;
        size++;
    }
    public void increaseLenght(){
        T[] newArr =(T[]) new Object[arr.length*2];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public T get(int index){
        if(index<0 ||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    public Object remove(int index){
        checkIndex(index);
        for(int i = index - 1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        size--;
        return null;
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
    public void printList(){
        for (int i = 0; i<size; i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }
    public void sort(){

    }
}

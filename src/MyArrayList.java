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
    //contains - method that checking whether array contains a given element
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
    //add - add new object in array
    //if() - if the max length is reached it's gonna increase it
    @Override
    public void add(Object item){
        if(size==arr.length){
            increaseLenght();
        }
        this.arr[size++] = (T) item;
    }
    //add(obj, index) - add new object in specific place, by giving him the index
    //
    @Override
    public void add(Object item, int index){
        if(size == arr.length){
            increaseLenght();
        }
        // Create a new array to hold the elements
        T[] newArr = (T[]) new Object[arr.length];
        // Copy the elements before the index into the new array
        for (int i = 0; i< index; i++){
            newArr[i] = arr[i];
        }
        // Copy the elements after the index into the new array, shifted one position to the right
        for(int i = index; i<size; i++){
            newArr[i+1] = arr[i];
        }
        // Insert the new element into the new array
        newArr[index] = (T) item;
        // Update the reference to the underlying array and increase the size
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
    //Define the index of chosen element
    @Override
    public T get(int index){
        //catch the error
        if(index<0 ||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    //delete the object in specific place
    @Override
    public Object remove(int index){
        checkIndex(index);
        for(int i = index - 1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        //decrease size
        size--;
        return null;
    }
    //delete the specific object
    @Override
    public boolean remove(Object item){
        boolean removed = false;
        for(int i = 0; i < size; i++){
            if (arr[i] == item){
                remove(i);
                removed = true;
            }
        }
        return removed;
    }
    //Checks if there anything on this index
    public void checkIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    //Find the index of the object
    @Override
    public int indexOf(Object o){
        for(int i =0; i < size; i++){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    //Returns the index of the last occurrence of the specified element in this array,
    @Override
    public int lastIndexOf(Object o){
        for(int i = size - 1; i >=0; i--){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    //Clear all array
    @Override
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 5;
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
    //Determines the type of elements in the array, either "int", "double", or "0" if the array contains other types.
    public String sorting(){
        int intSize = 0;
        int doubleSize = 0;
        for (int i = 0; i < size; i++){
            try {
                // attempt to cast the current element to an integer
                int value = (Integer) arr[i];
                intSize++; // increment integer counter if successful
            } catch (ClassCastException e) {
            }
            try {
                // attempt to cast the current element to a double
                double tempD = (Double) arr[i];
                doubleSize++;
            } catch (ClassCastException e) {
            }
        }
        if (intSize == size){
            return "int";
        }
        if (doubleSize == size){
            return "double";
        }
        return "0";
    }
    //Sorts the elements of the array in ascending order.
    @Override
    public void sort() {
        // Check the type of the array elements
        if (sorting().equals("int")) {
            int n = size;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if ((int) arr[j] > (int) arr[j + 1]) {
                        T temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        }
        if (sorting().equals("double")) {
            // Sort the elements as doubles
            int n = size;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if ((Double) arr[j] > (Double) arr[j + 1]) {
                        T temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        }
    }
}

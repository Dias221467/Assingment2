# Assingment2
## Ibragimov Dias
### MyArrayList
#### Size

__Description:__ _Creating method for descripting the size of array_

__Solution:__
````Java
@Override
    public int size(){
        return size;
    }
````
#### Contains
__Description:__ _Method that checking whether array contains a given element_

__Solution:__
````Java
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
````

__Description:__ _This is the method that we will you to add new objects in our array_

__Solution:__
````Java
@Override
    public void add(Object item){
        if(size==arr.length){
            increaseLenght();
        }
        this.arr[size++] = (T) item;
    }
````

#### add(Object item, int index)
__Description:__ _Method where we can add object in the specific place, by defining its index_

__Explanation:__ _This code adds an element to a dynamic array at a specific index. If the array is full, it first calls the increaseLength() method to increase the capacity of the array. It then creates a new array with the same length as the original one, copies all the elements before the specified index into the new array, copies all the elements after the specified index into the new array, shifted one position to the right, inserts the new element into the new array, and finally updates the reference to the underlying array and increases the size._

__Solution:__
````Java
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
````

#### IncreaseLenght
__Description:__ _Method used for increasing the limit or the length of array_

__Solution:__
````Java
public void increaseLenght(){
        T[] newArr =(T[]) new Object[arr.length*2];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
````

#### Get
__Description:__ _Define the index of chosen element_

__Solution:__
````Java
@Override
    public T get(int index){
        //catch the error
        if(index<0 ||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
````

#### Remove(int index)
__Description:__ _delete the object in specific place_

__Solution:__
````Java
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
````

#### Remove(Object item)

__Description:__ _delete the specific object_

__Solution:__
````Java
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
````

#### checkIndex(int index)
__Description:__ _Checks if there anything on this index_

__Solution:__ 
````Java
public void checkIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
````

#### indexOf(Object o)
__Description:__ _Find the index of the object_

__Solution:__
````Java
 @Override
    public int indexOf(Object o){
        for(int i =0; i < size; i++){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }
````

#### lastIndexOf(Object o)
__Description:__ _Returns the index of the last occurrence of the specified element in this array,_

__Solution:__ 
````Java
@Override
    public int lastIndexOf(Object o){
        for(int i = size - 1; i >=0; i--){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }
````

#### Clear

__Description:__ _Clear all array_

__Solution:__ 
````Java
@Override
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }
````

#### sorting
__Description:__ _Determines the type of elements in the array, either "int", "double", or "0" if the array contains other types._

__Explanation:__ _The method iterates through the array using a for loop, attempting to cast each element to an integer and a double. If the casting is successful, the integer and double counters are incremented. If the casting fails, the catch block does nothing and the loop continues to the next element._

__Solution__
````Java
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
````

#### Sort

__Description:__ _Sorts the elements of the array in ascending order._

__Explanation:__ _First, it calls the sorting() method to determine whether the elements are all of type int or double. If the elements are all of type int, the method uses a classic bubble sort algorithm to sort the elements in ascending order. If the elements are all of type double, the same algorithm is used, but the comparison of elements is done based on their double value._

__Solution:__
````Java
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
````

### MyLinkedList
### Size

__Description:__ _Determine the size of List_

__Solution:__
````Java
@Override
    public int size() {
        return size;
    }
````

### PrintList
__Description:__ _Show the List_

__Solution:__
````Java
public void printList() {
        if (size == 0) {
            System.out.println("Linked list is empty.");
            return;
        }
        //CurrentNode - method which states for specific object
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
````

### Contains
__Description:__ _method that checking whether array contains a given element_

__Solution:__
````Java
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
````

### add(Object item)
__Description:__ _Create a new node with the given item_

__Solution:__
````Java
@Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        // If the list is empty, set the new node as the head and tail
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
````

### add(Object item, int index)
__Description:__ _add object in specific place_

__Solution:__
````Java
@Override
    public void add(Object item, int index) {
        // Check that the index is within bounds
        checkIndex(index);
        // Create a new node with the given item
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        // Traverse the list until the specified index is reached
        Node<T> ptr = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                // Insert the new node into the list
                newNode.prev = ptr;
                newNode.next = ptr.next;
                ptr.next.prev = newNode;
                ptr.next = newNode;
                size++;
                return;
            }
            ptr = ptr.next;
        }
    }
````

### remove(Object item)
__Description:__ _Removes the first occurrence of the specified element from this list._

__Explanation:__ _The method starts by checking if the list is empty, and if it is, it returns false indicating that the item was not found in the list. If the head of the list contains the item to be removed, it updates the head to point to the second node and sets the previous node of the new head to null. It then decrements the size of the list and returns true indicating that the item was found and removed._

__Solution:__ 
````Java
@Override
    public boolean remove(Object item) {
        // If the list is empty, return false
        if (head == null) {
            return false;
        }
        //If the head contains the item to be removed
        if (head.item.equals(item)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return true;
        }
        // Iterate through the list starting from the second node
        Node<T> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.item.equals(item)) {
                currentNode.prev.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
````

### remove(int index)

__Description:__ _Removes the element at the specified index in this linked list._

__Explanation:__ _The code first checks if the given index is within the valid range of the list, throwing an IndexOutOfBoundsException if the index is invalid.

If the index is 0, indicating the first node, the code removes the head node, updates the head reference to the next node, and returns the removed item. If the size of the list is 1, the tail reference is also set to null.

If the index is size - 1, indicating the last node, the code removes the tail node, updates the tail reference to the previous node, and returns the removed item.

If the index is neither the first nor last node, the code finds the node at the given index, retrieves references to the previous and next nodes, removes the current node, and returns the removed item. The prev node's next reference is updated to the next node, and the next node's prev reference is updated to the prev node. The size variable is then decremented._

__Solution:__
````Java
 @Override
    public Object remove(int index) {
        checkIndex(index);
        // Removing the first node
        if (index == 0) {
            Object removed = head.item;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return removed;
        }
        // Removing the last node
        if (index == size - 1) {
            Object removed = tail.item;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        // Removing a node in the middle
        Node<T> ptr = getNodeAtIndex(index);
        Node<T> prev = ptr.prev;
        Node<T> next = ptr.next;
        Object removed = ptr.item;

        prev.next = next;
        next.prev = prev;
        size--;
        return removed;
    }
````

### getNodeAtIndex(int index)

__Description:__ _returns the Node object at the specified index in the linked list._

__Solution:__
````Java
private Node<T> getNodeAtIndex(int index) {
        Node<T> ptr = head.next; // Start at the second node
        for (int i = 1; i < size - 1; i++) { // Loop through the nodes
            if (i == index) { // If the current index matches the specified index
                return ptr;
            }
            ptr = ptr.next;
        }
        return null; // If the specified index is out of bounds, return null
    }
````

### checkIndex(int index)

__Description:__ _Checking if the null under the index exist_

__Solution:__
````Java
private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }
    }
````

### clear
__Description:__ _Delete all of the List_

__Solution:__
````Java
@Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
````

### indexOf

__Description:__ _Define the index of object_

__Explanation:__ _The method starts by checking if the element to search for is null, in which case it iterates through the list checking for null items until it finds a match. If the element to search for is not null, it iterates through the list checking for items that are equal to the specified element using the equals() method.

Once a match is found, the method returns the index of the node that contains the element. If no match is found, the method returns -1._

__Solution:__ 
````Java
 @Override
    public int indexOf(Object o) {
        if (o == null) {
            Node<T> ptr = head;
            for (int i = 0; i < size; i++) {
                if (ptr.item == null) {
                    return i;
                }
                ptr = ptr.next;
            }
        } else {
            Node<T> ptr = head;
            for (int i = 0; i < size; i++) {
                if (o.equals(ptr.item)) {
                    return i;
                }
                ptr = ptr.next;
            }
        }
        return -1;
    }
````

### lastIndexOf(Object o)
__Description:__ _This method, lastIndexOf, returns the last occurrence index of the specified element in the doubly linked list, or -1 if the element is not found._

__Explanation:__ _The method takes an Object as a parameter and casts it to the generic type T. It first checks if the tail node contains the element. If it does, it returns the index of the tail node._

_If the element is not found in the tail node, the method iterates through the list starting from the second last node (tail.prev) to the head of the list. It checks if each node's item is equal to the specified element and returns the index of the first node that matches. If the element is not found in any of the nodes, it returns -1._

__Solution:__
````Java
@Override
    public int lastIndexOf(Object o) {
        T element = (T) o;
        if (tail.item == element) {
            return size - 1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size - 2; i >= 0; i--) {
            if (ptr.item == element) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }
````

### sort()
__Description:__ _Sorts the elements of the array in ascending order._

__Explanation:__ _The code first checks if the list is sortable (i.e., if it contains only integers) using the isSortable() method. Then, it loops through the list using a front pointer and a back pointer. The front pointer starts at the head of the list, and the back pointer starts at the node after the front pointer. The code loops backwards from back to front, checking if the value at the back node is less than the value at the previous node. If it is, the values are swapped. The back pointer is then moved one node backwards, and the loop continues until the back pointer is at the front node or the value at the back node is greater than or equal to the value at the previous node. The front pointer is then moved one node forwards, and the process repeats until the entire list is sorted._

__Solution:__
````Java
 @Override
    public void sort() {
        // check if the list is sortable (i.e., if it contains only integers)
        if (isSortable()) {
            Node<T> front = head;
            Node<T> back = null;
            // loop through the list using the front pointer
            while (front != null) {
                // loop backwards from back to front
                back = front.next;
                while (back != null && back.prev != null && (Integer) back.item < (Integer) back.prev.item) {
                    // if the value at back is less than the value at the previous node, swap their values
                    swapValue(back, back.prev);
                    // move back one node backwards
                    back = back.prev;
                }
                // move front one node forwards
                front = front.next;
            }
        }
    }
````

### isSortable()
__Description:__ _checks whether the list contains elements that are only integers and doubles_

__Explanation:__ _This isSortable method checks if the linked list contains only integers or doubles, and returns true if it is the case. Otherwise, it returns false. This is necessary to ensure that the sort method can only be called if the list is sortable (i.e., if it contains only one type of element)._

_The method iterates through the list and checks the type of each element using the instanceof operator. If an element is not an integer or a double, the method returns false. If the list contains both integers and doubles, it also returns false. Finally, if the list contains only integers or only doubles, it returns true._

__Solution:__
````Java
public boolean isSortable() {
        Node<T> ptr = head;
        boolean containsIntegers = false;
        boolean containsDoubles = false;
        // iterate through the list to check the types of its elements
        for (int i = 0; i < size; i++) {
            if (ptr.item instanceof Integer) {
                containsIntegers = true;
            } else if (ptr.item instanceof Double) {
                containsDoubles = true;
            } else {
                return false;
            }
            ptr = ptr.next;
        }
        // if the list contains both integers and doubles, it is sortable
        return containsIntegers && containsDoubles;
    }
````

### SwapValue
__Description:__ _Changing placement of values, by replacement them with each other_

__Solution:__ 
````Java
public void swapValue(Node<T> first, Node<T> second) {
        Object value = first.item;
        first.item = second.item;
        second.item = (T) value;
    }
````
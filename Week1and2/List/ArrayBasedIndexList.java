import java.io.*;
import java.util.*;

public class ArrayBasedIndexList<E> implements IndexList<E> {

    private E[] list;
    private int count;
    private int length;

    public ArrayBasedIndexList() {
      this.count = 0;
      length = 5; // the first array will have an initial length of 5
      list = (E[]) (new Object[length]);
    }

    /**
     * Insert method
     * @param index index of where the element has to be inserted in the array
     * @param e     the element that has to be inserted
     */
    public void insert(int index,E e){
      if(index < 0) //If the index is not valid, throw exception
        throw new IllegalArgumentException();

      /**
       * Once the count reaches the length it means that the array is full and a new Array
       * is created. The length of the new array doubles. This is to avoid creating a new
       * array mulitple times.
       */
      if(length == count){ //if the array is full
        length = length * 2;
      }

      //create new Array
        E[] newList = (E[]) (new Object[length]);
        //Copy all exisiting items
        for(int i = 0; i < count; i++){
          newList[i] = list[i];
        }
        //change the name
        list = newList;

      //insert element
      for(int i = length-1; i > index; i--){
        list[i] = list[i-1];
      }
      list[index] = e;

      count++;  //Count increasing
    }

    public void remove(int index){
      //Validate the Index
      if(index < 0 || index >= length)
        throw new IllegalArgumentException();
      //Remove the element
      for(int i = index; i < length-1; i++){
        list[i] = list[i+1];
      }
      //Decrease the count;
      count--;
    }

    public E get(int index) {
      if(index < 0 || index >=length)
        throw new IllegalArgumentException();
      return list[index];
    }
    public int getSize() {
      return count;
    }

    public int getLength(){
      return length;
    }

    /*public static void main(String[] args){
        ArrayBasedIndexList<Integer> array = new ArrayBasedIndexList<Integer>();
        array.insert(0,1);
        array.insert(1,2);
        array.insert(2,3);
        array.insert(3,4);

        System.out.println(array.getSize());
        System.out.println(array.getLength());
        array.insert(2, 10);
        System.out.println(array.get(0));

        System.out.println(array.getSize());
        array.insert(2, 10);

        System.out.println(array.getSize());



    }*/

}

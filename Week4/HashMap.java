import java.util.*;
public class HashMap<E>{

    private final static int TABLE_SIZE = 128;

    //HashEntry<E>[] table; //instead of an array use a linked list
    LinkedList<HashEntry<E>>[] hashTable;

    public HashMap() {
        //table = new HashEntry[TABLE_SIZE];
        hashTable = (LinkedList<HashEntry<E>>[]) new LinkedList[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++)
            hashTable[i] = null;
    }

    public E get(int key) {
        int hash = (key % TABLE_SIZE);

        if (hashTable[hash] == null)
            return null;
        else {
          //return table[hash].getValue();
          for(HashEntry<E> e : hashTable[hash]){
            if(key == e.getKey()){
              return e.getValue();
            }
          }
          return null;
        }
    }

    public void put(int key, E value) {
        int hash = (key % TABLE_SIZE);

        HashEntry<E> e = new HashEntry<>(key, value);

        if(hashTable[hash] == null){
          //create a new LinkedList
          LinkedList<HashEntry<E>> list = new LinkedList<>();
          list.add(e);
          hashTable[hash] = list;
        }
        else
          hashTable[hash].add(e);
    }
}

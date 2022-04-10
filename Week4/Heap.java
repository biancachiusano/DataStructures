import java.util.*;

class Heap { //MAXHeap
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public Heap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d; //this is the opposite of the rank formula
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) throws Exception {
        if (isFull())
          throw new Exception("Heap is full");
        heap[heapSize++] = x;
        upHeap(heapSize - 1);
    }

    public int delete(int x) throws Exception {
        if (isEmpty())
          throw new Exception("Heap is empty");
        if(x > heapSize-1)
          throw new Exception("Index does not exist");

        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        downHeap(x);
        return key;
    }

    // maintain heap property during insertion
    private void upHeap(int i) {
        // TODO Implement this method

        while(heap[i] > heap[parent(i)] && i != 0){
          int temp = heap[i];
          heap[i] = heap[parent(i)];
          heap[parent(i)] = temp;
          upHeap(parent(i));
        }
    }

    // maintain heap property during deletion
    private void downHeap(int i) {
        // TODO Implement this method
        //That situation should be covered and resolved in the downHeap method
        //instead (and does not need to be explicitly solved by its own individual if statement,
        //instead it should be resolved by the overall behaviour of the downheap method if you follow
        //the algorithm correctly).

        //Make the array smaller
        //System.out.println("DEBUG1");
        int[] tempHeap = new int[heapSize];
        for(int j = 0; j < tempHeap.length; j++){
          tempHeap[j] = heap[j];
        }
        heap = tempHeap;

        //check if the new node is greater than its parent
        //to do this first check if it is the root
        if(i != 0){
          if(heap[i] > heap[parent(i)]){
            upHeap(i);
          }
        }
          try{
            int max = maxChild(i);
            if(heap[i] < heap[max]){
              int temp = heap[i];
              heap[i] = heap[max];
              heap[max] = temp;
              downHeap(max);
            }
          } catch(Exception e){
            return;
          }
      }


    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    // return max from the heap
    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public int[] getHeap() {
        // This method is used for autotesting
        return heap;
    }


}

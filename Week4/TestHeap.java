public class TestHeap{

  public static void main(String[] args){

    Heap h = new Heap(6);
    try{
      h.insert(1);
      h.insert(5);
      h.insert(8);
      h.insert(7);
      h.insert(3);
      h.insert(6);
      int[] sorted = h.getHeap();
      printHeap(sorted);
      h.delete(0);
      sorted = h.getHeap();
      printHeap(sorted);
      h.delete(0);
      sorted = h.getHeap();
      printHeap(sorted);
      h.delete(1);
      sorted = h.getHeap();
      printHeap(sorted);
    } catch(Exception e){
      System.out.println(e);
    }
  }

  public static void printHeap(int[] sorted){
    for(int i = 0; i < sorted.length; i++){
      System.out.print(sorted[i] + " ");
    }
    System.out.println();
  }
}

/*[57, 56, 57, 52, 50, 42, 33, 52, 18, 50, 47, 28, 45, 26, 40, 25,
51, 8, 9, 26, 46, 38, 45, 21, 36, 20, 29, 8, 34, 20, 24, 5, 9, 7, 30,
8, 15, 1, 6, 6, 11, 24, 33, 22, 32, 45, 9, 20, 21, 3, 10, 3, 20, 16]
is not a heap. Meaning that you did not properly restore the heap after
delete / insert. Run some tests and check whether the heap order is
maintained, then re-upload your code.*/

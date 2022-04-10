public class TestMerge{

  public static void main(String[] args){

    MergeSort m = new MergeSort();
    int[] list = {3,10,5,6,4,2,7,11};
    int[] sorted = m.sort(list);

    System.out.println("initial: ");
    print(list);

    System.out.println("sorted: ");
    print(sorted);

  }

  public static void print(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
}

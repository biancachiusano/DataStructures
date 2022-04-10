import java.util.Arrays;

class MergeSort {


    public static int[] merge(int[] left, int[] right) {

      // Initial indexes of first and second subarrays
      int[] arr = new int[left.length + right.length];
      // TODO Complete the method
      int count = 0;
      while(left.length > 0 && right.length > 0){
        if(left[0] <= right[0]){
          arr[count] = left[0];
          left = remove(left);
        } else {
          arr[count] = right[0];
          right = remove(right);
        }
        count++;
      }

      while(left.length > 0){
        arr[count] = left[0];
        left = remove(left);
        count++;
      }

      while(right.length > 0){
        arr[count] = right[0];
        right = remove(right);
        count++;
      }


      return arr;
    }

    public static int[] remove(int[] array){
      int[] newArray = new int[array.length-1];
      for(int i = 1; i < newArray.length; i++){
        newArray[i-1] = array[i];
      }
      return newArray;
    }

    public static void print(int[] arr){
      for(int i = 0; i < arr.length; i++){
        System.out.print(arr[i] + ", ");
      }
      System.out.println();
    }



    public static int[] sort(int arr[]) {
        // Find the middle point
        if (arr.length > 1) {
            int m = arr.length / 2;
            int[] l1 = Arrays.copyOfRange(arr, 0, m);
            int[] l2 = Arrays.copyOfRange(arr, m, arr.length);

            l1 = sort(l1);
            l2 = sort(l2);

            return merge(l1, l2);
        } else {
            return arr;
        }
    }
}

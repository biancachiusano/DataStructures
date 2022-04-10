import java.util.Arrays;
import java.util.Stack;

public class Reverse {

/**
 * Reverse method
 * @param  list integer array passed
 * @return      a reversed array
 */
	public static int[] reverse(int[] list) {
		//Initializing a new stack with size of the array passed
		Stack<Integer> stack = new Stack<Integer>();
		stack.setSize(list.length);

		//Pushing all of the elements of the array in the stack
		for(int i = 0; i < list.length; i++) {
			stack.push(list[i]);
		}

		//initializing a new array that will contain the elements in reversed order
		int[] solution = new int[list.length];

		//popping all of the elements of the stack into the new array
		for(int i = 0; i < list.length; i++) {
			int temp = stack.pop();
			solution[i] = temp;
		}

		return solution;
	}

	public static void main(String[] args) {
		// Every value in the argument array is a single element in the list
		int[] arr = new int[args.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}

		int[] result = reverse(arr);
		System.out.println(Arrays.toString(result));

	}
}

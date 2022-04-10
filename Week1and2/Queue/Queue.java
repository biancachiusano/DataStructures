import java.util.Stack;

//Class for queue
public class Queue<E> implements IQueue<E> {
//Creating two stacks: one for enqueuing and one for dequeuing
 private Stack<E> stackEnqueue;
 private Stack<E> stackDequeue;
 private int front; // front points to front element in the queue
 private int rear; // rear points to last element in the queue
 private int capacity; // maximum capacity of the queue
 private int count; // current size of the queue

 /**
  * Class constructor
  * @param size of the queue, thus also for the two stacks
  */
 public Queue(int size) {

	 stackEnqueue = new Stack<E>();
	 stackEnqueue.setSize(size);

	 stackDequeue = new Stack<E>();
	 stackDequeue.setSize(size);

	 capacity = size;
     front = 0;
     rear = -1;
     count = 0;
 }

/**
 * Dequeue method
 * If the enqueue stacks is not empty, pop all of the
 * elements from the enqueue stack and push them in the dequeue stack
 * in order to reverse the order of the elements.
 * Then, pop the first element from the dequeue stack and store it
 * in the generic variable solution (count also decreases). The rest of the elements are also popped
 * back into the enqueue stack, reversing the order once again.
 * @return the variable solution
 */
 public E dequeue() {
     if (isEmpty())
         throw new RuntimeException("Queue empty exception");

     for(int i = 0; i < count; i++){
        E element = stackEnqueue.pop();
        stackDequeue.push(element);
     }

     count--;
     E solution = stackDequeue.pop();

     for(int i = 0; i < count; i++){
        E element = stackDequeue.pop();
        stackEnqueue.push(element);
     }

     return solution;

 }

/**
 * Enqueue method
 * Count increases
 * If the enqueue stack is not full, push the passed item
 * into the enqueue stack
 * @param item element to push into the enqueue stack
 */
 public void enqueue(E item) {
     if (isFull())
         throw new RuntimeException("Queue is full exception");

     count++;

     stackEnqueue.push(item);
 }

 /**
  * peek method:
  * @return the last element pushed into the enqueue stack
  */
 public E peek() {
     if (isEmpty())
         throw new RuntimeException("Queue empty exception");

    E element = stackEnqueue.pop();
    stackEnqueue.push(element);
    return element;
 }

 public int size() {
     return count;
 }

 public boolean isEmpty() {
     return (size() == 0);
 }

 public boolean isFull() {
     return (size() == capacity);
 }

//SOME TESTS
 /*public static void main(String[] args) {

	 Queue<Integer> intQueue = new Queue<Integer>(5);
	 intQueue.enqueue(1);
	 intQueue.enqueue(2);
	 intQueue.enqueue(3);
	 intQueue.enqueue(4);

   System.out.println("peek : " + intQueue.peek());

	 System.out.println("Dequeue: " + intQueue.dequeue());
	 System.out.println("Dequeue: " + intQueue.dequeue());
   intQueue.enqueue(7);
	 intQueue.enqueue(8);
   System.out.println("Dequeue: " + intQueue.dequeue());
	 System.out.println("Dequeue: " + intQueue.dequeue());
   System.out.println("Dequeue: " + intQueue.dequeue());
	 System.out.println("Dequeue: " + intQueue.dequeue());

 }*/

}

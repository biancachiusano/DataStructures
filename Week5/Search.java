import java.util.*;

public class Search<E> extends GraphAdjacencyList<E>{

  //DO not use a boolean array to store the visited nodes
  //remove void if you use the constructor

    public void Search() {

    }

    public List<E> BFS(Graph<E> g, E startnode) {

      //GraphAdjacencyList<E> graph = (GraphAdjacencyList<E>) g;
      LinkedList<E> queue = new LinkedList<E>();
      LinkedList<E> n =  new LinkedList<E>();
      LinkedList<E> ordered = new LinkedList<E>();

      queue.add(startnode);

      while(!queue.isEmpty()){ //is this the base case

        n = (LinkedList<E>) g.neighbors(queue.getFirst());

        //is x has not been visited
        for(E node : n){
          boolean flag = true;
          for(E check : queue){
            if(check == node)
              flag = false;
          }
          for(E last : ordered){
            if(last == node)
              flag = false;
          }
          if(flag)
            queue.add(node);
          }

        ordered.add(queue.getFirst());
        queue.remove(0);
        //System.out.println(queue.toString());
      }
      return ordered;
    }

    /*public static void main(String[] args){

    GraphAdjacencyList<String> mit = new GraphAdjacencyList<String>();

		/*mit.addVertex(1);
		mit.addVertex(2);
		mit.addVertex(3);
		mit.addVertex(4);
		mit.addVertex(5);
		mit.addVertex(6);
		mit.addVertex(7);
		mit.addVertex(8);
		mit.addVertex(9);
		mit.addVertex(10);
		mit.addVertex(11);
		mit.addVertex(12);

		mit.addEdge(1,2);
		mit.addEdge(1,3);
		mit.addEdge(1,4);

		mit.addEdge(2,5);
		mit.addEdge(2,6);

		mit.addEdge(4, 7);
		mit.addEdge(4, 8);


		mit.addEdge(5,9);
		mit.addEdge(5,10);


		mit.addEdge(7,11);
		mit.addEdge(7,12);

    mit.addVertex("X");
    mit.addVertex("W");
    mit.addVertex("Y");
    mit.addVertex("Z");
    mit.addVertex("A");

    mit.addEdge("X", "W");
    mit.addEdge("W", "Y");
    mit.addEdge("W", "Z");
    mit.addEdge("Z", "A");


		Search<String> search = new Search<String>();


		System.out.println(search.BFS(mit, "X"));

  }*/



  /*The neighbours method in graphs returns a list of neighbours.
And you can loop until you've explored all neighbours.*/
}

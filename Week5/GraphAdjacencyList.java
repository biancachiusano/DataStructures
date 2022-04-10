import java.util.*;
public class GraphAdjacencyList<T> implements Graph<T>{

//For simplification, there will never be twice
//the same element in the graph.

  private ArrayList<LinkedList<T>> graph;
//The graph should store elements of type T --> in a linkedlist
  public GraphAdjacencyList(){
    graph = new ArrayList<LinkedList<T>>();
  }

  // whether there’s an edge from x to y
  public boolean adjacent(T x, T y){
    //adjacent not only from x to y but also from y to x
    //USE RECURSION
    LinkedList<T> trial = (LinkedList<T>) neighbors(x);
    if(trial != null){
      for(int i = 0; i < trial.size(); i++){
        if(trial.get(i) == y)
          return true;
      }
    }
    trial = (LinkedList<T>) neighbors(y);
    if(trial != null){
      for(int i = 0; i < trial.size(); i++){
        if(trial.get(i) == x)
          return true;
      }
    }
    return false;
  }

  //all vertices y s.t. there’s an edge from x to y
  public List<T> neighbors(T x){
    boolean flag = false;
    //Check if the vertex exists
    for(LinkedList<T> L : graph){
      if(L.getFirst() == x){
        flag = true;
      }
    }
    if(flag){
      //Return all vertices of the graph which are connected to x by an edge
      for(int i = 0; i < graph.size(); i++){
        if(graph.get(i).getFirst() == x){
          return graph.get(i);
        }
      }
    }
    return null;
  }

  //adds the vertex x
  public void addVertex(T x){
    boolean flag = false;
    //CHECK IF VETEX HAS ALREADY BEEN ADDED //CHECK FOR VERTICES UNDER 0?
    for(LinkedList<T> L : graph){
      if(L.getFirst() == x)
        flag = true;
    }

    if(!flag){
      LinkedList<T> newV = new LinkedList<T>();
      newV.addFirst(x);
      graph.add(newV);
    }
  }

  //removes the vertex x
  public void removeVertex(T x){

    boolean flag = false;
    //check if vertex exists
    for(int i = 0; i < graph.size(); i++){
      if(graph.get(i).getFirst() == x){
        flag = true;
        graph.remove(i);
      }
    }
    if(flag){ //if the vertex exists
      for(LinkedList<T> L : graph){
        removeEdge(L.getFirst(), x);
      }
    }
  }

  public boolean checkExis(T x, T y){

    for(LinkedList<T> L : graph){
      if(L.getFirst() == x)
        return true;
    }
    return false;
  }

  //adds edge from the vertices x to y
  public void addEdge(T x, T y){

    //YOU CAN'T ADD AN EDGE IF A VERTEX DOES NOT EXIST
    if(checkExis(x, y) && checkExis(y, x)){
      //CHECK IF EDGE ALREADY EXISTS
      boolean flag = false;
      for(int i = 0; i < graph.size(); i++){
        if(graph.get(i).getFirst() == x){
          for(T node : graph.get(i)){
            if(node == y)
              flag = true;
          }
        }
      }

      if(!flag){
        //ADD to X linked list
        for(int i = 0; i < graph.size(); i++){
          if(graph.get(i).getFirst() == x)
            graph.get(i).add(y);
        }

        //ADD to Y linked list
        for(int i = 0; i < graph.size(); i++){
          if(graph.get(i).getFirst() == y)
            graph.get(i).add(x);
        }
      }
    }
  }
   //removes edge from the vertices x to y
  public void removeEdge(T x, T y){

    if(adjacent(x, y)){
      LinkedList<T> update = (LinkedList<T>) neighbors(x);
      for(int i = 0; i < update.size(); i++){
        if(update.get(i) == y)
          update.remove(i);
      }

      for(LinkedList<T> L : graph){
        if(L.getFirst() == x)
          L = update;
      }

      removeEdge(y, x);
    }
  }

  public void printArr(){
    for(int i = 0; i < graph.size(); i++){
      System.out.println(graph.get(i));
    }
    System.out.println();
  }

  public static void main(String[] args){
    GraphAdjacencyList<Integer> g = new GraphAdjacencyList<Integer>();
    g.addVertex(1);
    g.addVertex(2);
    g.addVertex(3);
    g.addVertex(4);
    g.addVertex(5);
    g.printArr();
    g.addEdge(1, 3);
    g.addEdge(1, 2);
    g.addEdge(4, 5);
    g.addEdge(4, 2);
    g.printArr();
    g.removeVertex(1);
    //System.out.println(g.adjacent(2,1));
    g.printArr();

  }

  /*Are we supposed to check if the graph contains one element before doing an operation with this element? */
  /*You need to remove all edges pointing to the vertex as well as away from the vertex.
When you remove a vertex*/

}

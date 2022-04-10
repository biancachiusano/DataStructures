public class BinarySearchTree {



      BinaryTree<Integer> tree = new LinkedBinaryTree<>();
      private int count;

      public BinarySearchTree() {
        count = 0;
      }

      public void insert(Integer e) {
        if(count == 0) //this works
        {
          tree.addRoot(e);
          count++;
        }
        else { //Check if element exists
          if(!find(e))
            insertInSubTree(tree.getRoot(), e);
        }

      }

        public void insertInSubTree(BinaryTreeNode<Integer> node, Integer elem){
            //insert element in a subtree
            //Find a leaf node
              if(!node.hasLeftChild() && !node.hasRightChild()){
                if(elem > node.getElement())
                  node.addRightChild(elem);
                else
                  node.addLeftChild(elem);

                count++;
              }
              else{
                if(elem < node.getElement()){
                  try{
                    insertInSubTree(node.getLeftChild(), elem);
                  } catch(NullPointerException e){
                    node.addLeftChild(elem);
                  }
                }
                else
                  try {
                    insertInSubTree(node.getRightChild(), elem);
                  } catch(NullPointerException e){
                    node.addRightChild(elem);
                  }
              }
        }

      public boolean delete(Integer e) {
        if(find(e)){
          deleteNode(tree.getRoot(), e);
          count--;
          return true;
        }
        else return false; //works
      }

      public void deleteNode(BinaryTreeNode<Integer> node, Integer e){
        //search + recursion
        if(e < node.getElement()) //no
          deleteNode(node.getLeftChild(), e);
        else if(e > node.getElement()) //yes //no
          deleteNode(node.getRightChild(), e);
        else { //node found
          if(!node.hasLeftChild() && !node.hasRightChild()){ //leaf
            node.setElement(null); //no
          }
          //left node is empty --> only right node --> swap
          else if(!node.hasLeftChild()){ //getElement()? //no
            try{
              if(node.getParent().getRightChild().getElement().equals(node.getElement())){
                node.getParent().addRightChild(node.getRightChild().getElement());
              }
              else{
                node.getParent().addLeftChild(node.getRightChild().getElement());
              }
            } catch(NullPointerException ex){
              tree.addRoot(node.getRightChild().getElement());
            }

          } //right node is empty --> only left node --> swap
          else if(!node.hasRightChild()){ //YES
            try{
              if(node.getParent().getRightChild().getElement().equals(node.getElement())){
                node.getParent().addRightChild(node.getLeftChild().getElement());
              }
              else{
                node.getParent().addLeftChild(node.getLeftChild().getElement());
              }
            } catch(NullPointerException ex){
              tree.addRoot(node.getLeftChild().getElement());
            }
          }
          else{ //two links
            //next in order
            node.setElement(inOrderNext(node.getRightChild()));
          }
        }
      }

      public Integer inOrderNext(BinaryTreeNode<Integer> node){
        if(!node.hasLeftChild() && !node.hasRightChild()){
          Integer temp = node.getElement();
          node.setElement(null);
          return temp;
        }
        else if(node.hasLeftChild())
          return inOrderNext(node.getLeftChild());
        else return inOrderNext(node.getRightChild());
      }

      public boolean find(Integer e) {
        if(count == 0)
          return false;
        else if(found(tree.getRoot(), e))
          return true;
        else return false;
      }

      public boolean found(BinaryTreeNode<Integer> node, Integer elem){

        if(node==null)
          return false;

        if(elem < node.getElement()){
          if(node.hasLeftChild())
            return found(node.getLeftChild(), elem);
          node = null;
          return found(node, elem);
        }
        else if(elem > node.getElement()){
          if(node.hasRightChild())
            return found(node.getRightChild(), elem);
          node = null;
          return found(node, elem);
        }
        else return true;
      }

      
      public BinaryTree<Integer> returnTree(){
        return tree;
      }
}

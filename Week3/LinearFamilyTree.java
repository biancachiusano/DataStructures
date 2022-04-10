public class LinearFamilyTree {

    String str;

    public LinearFamilyTree() {
    }

    public String linearize(BinaryTree<String> tree) {
      return print(tree.getRoot());
    }
    private String print(BinaryTreeNode<String> n) { //recursion
         str = "( " + n.getElement() + " ";

         if(n.hasLeftChild()){
           str = str + print(n.getLeftChild());
         }
         if(n.hasRightChild()){
           str = str + print(n.getRightChild());
         }

         str = str + ") ";

         return str;
    }
    //( I ( Father )( Mother ( Grandma )( Grandpa )))
}


public class LinkedBinaryTree<E> implements BinaryTree<E>{

    private E data;

    private LinkedBinaryTreeNode<E> root = new LinkedBinaryTreeNode<>(null,null);

    public LinkedBinaryTree (){

    }
    public BinaryTreeNode<E> getRoot() {
      return root;
    }
    public void addRoot(E e) {
      root.data = e;
      root = new LinkedBinaryTreeNode<>(e, null);
    }

    public boolean hasRoot() {
      if((root.data).equals(null))
        return false;
      return true;
    }
}

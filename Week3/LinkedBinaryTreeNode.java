public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

    E data;
    LinkedBinaryTreeNode<E> right;
    LinkedBinaryTreeNode<E> left;
    LinkedBinaryTreeNode<E> parent;

    //CREATE A ROOT TO THE root

    public LinkedBinaryTreeNode(E e,LinkedBinaryTreeNode<E> p) {
      this.data = e;
      this.parent = p;
    }

    public E getElement() {
      return data;
    }

    public void setElement(E e) {
      this.data = e;
    }

    public BinaryTreeNode<E> getParent() {
      return this.parent;
    }

    public BinaryTreeNode<E> getLeftChild() {
      if(!this.hasLeftChild())
        return null;
      return this.left;
    }

    public BinaryTreeNode<E> getRightChild(){
      if(!this.hasRightChild())
        return null;
      return this.right;
    }

    public void addLeftChild(E element) {
      this.left = new LinkedBinaryTreeNode(element, this);
    }

    public void addRightChild(E element) {
      this.right = new LinkedBinaryTreeNode(element, this);
    }

    public boolean hasLeftChild() {
      if(left != null)
        return true;
      return false;
    }

    public boolean hasRightChild() {
      if(right != null)
        return true;
      return false;
    }

    public void delete() {
      if(!(this.hasLeftChild()) && !(this.hasRightChild())){ //leaf
        this.data = null;
      }
      //if it is a root
      if(parent.equals("null")){ //ROOT

          //pseudonode
          LinkedBinaryTreeNode<E> newRoot = new LinkedBinaryTreeNode<E>(null,null);

          if(hasLeftChild() && hasRightChild()){ //Can I just use this assuming that null node doesn't give problems
            newRoot.addLeftChild(getLeftChild().getElement());
            newRoot.addRightChild(getRightChild().getElement());
          }
          else if(hasLeftChild()){
            newRoot.addLeftChild(getLeftChild().getElement());
          }
          else if(hasRightChild()){
            newRoot.addRightChild(getRightChild().getElement());
          }
          parent.addLeftChild(null);
          parent.addRightChild(null);
          
      } else {

        if(hasLeftChild() && hasRightChild()){
          throw new RuntimeException("This is not direcly possible");
        }
        else if(hasLeftChild()){

            if((parent.getLeftChild()).equals(getElement())){ //left child of parent
              parent.addLeftChild(getLeftChild().getElement());
            }
            else { //Right child of parent
              parent.addRightChild(getLeftChild().getElement());
            }

        }
        else if(hasRightChild()){

            if((parent.getLeftChild()).equals(getElement())){ //left child of parent
              parent.addLeftChild(getRightChild().getElement());
            }
            else { //Right child of parent
              parent.addRightChild(getRightChild().getElement());
            }
        }

      }

    }
}

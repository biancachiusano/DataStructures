public class Test {
    public static void main(String[] args)
    {

        /*LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.addRoot("a");
        tree.getRoot().addLeftChild("b");
        tree.getRoot().addRightChild("c");
        tree.getRoot().getRightChild().addRightChild("d");
        //tree.getRoot().getRightChild().delete();
        //tree.getRoot().getLeftChild().delete();

        System.out.println(tree.getRoot().getElement());
        //  System.out.println(tree.getRoot().getLeftChild().getElement());
        System.out.println(tree.getRoot().getRightChild().getElement());

        BinaryTree<String> tree2 = (BinaryTree<String>) tree;
        LinearFamilyTree lin = new LinearFamilyTree();
        System.out.println(lin.linearize(tree2));*/


        /*LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.addRoot("I");
        tree.getRoot().addLeftChild("Father");
        tree.getRoot().addRightChild("Mother");
        tree.getRoot().getRightChild().addLeftChild("Grandma");
        tree.getRoot().getRightChild().addRightChild("Grandpa");
        //tree.getRoot().getRightChild().delete();
        //tree.getRoot().getLeftChild().delete();

        BinaryTree<String> tree2 = (BinaryTree<String>) tree;
        LinearFamilyTree lin = new LinearFamilyTree();
        lin.linearize(tree2);*/

        /*LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.addRoot("I");
        tree.getRoot().addLeftChild("Father");
        tree.getRoot().addRightChild("Mother");
        tree.getRoot().getRightChild().addLeftChild("Grandma");
        tree.getRoot().getRightChild().addRightChild("Grandpa");
        //tree.getRoot().getRightChild().delete();
        //tree.getRoot().getLeftChild().delete();

        BinaryTree<String> tree2 = (BinaryTree<String>) tree;
        LinearFamilyTree lin = new LinearFamilyTree();
        System.out.println(lin.linearize(tree2));*/

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(80);
        System.out.println(tree.find(80));
        BinaryTree<Integer> printTree = tree.returnTree();
        System.out.println(printTree.getRoot().getElement());
        //System.out.println(printTree.getRoot().getLeftChild().getElement());
        System.out.println(printTree.getRoot().getRightChild().getElement());
        //System.out.println(printTree.getRoot().getRightChild().getLeftChild().getElement());




    }
}

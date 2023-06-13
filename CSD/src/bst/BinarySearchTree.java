package fptu.demo.binarysearchtree;

/**
 * Java program to demonstrate basic operations in a Binary Search Tree (BST)
 *
 * @author vinhvo
 */
import java.io.*;
import java.util.*;

class BinarySearchTree<E extends Comparable<E>> {

    //------------------- nested Node class -----------------------
    protected static class Node<E> {

        private E element;          // an element stored at this node
        //private Node<E> parent;   // a reference to the parent node (if any)
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Constructors build a node with the given element and its children.
         *
         * @param e the real data that each node stores
         * @param leftChild left child of the current node
         * @param rightChild right child of the current node
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            //parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
            //parent = above;
            this.left = null;
            this.right = null;
        }

        // getter, setter methods
        public E getElement() {
            return element;
        }

        /*This method will be used later
        public Node<E> getParent() {
            return this.parent;
        }
         */
        @Override
        public String toString() {
            return "Node{" + "element=" + element + ", left=" + left + ", right=" + right + '}';
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // update methods
        public void setElement(E e) {
            this.element = e;
        }

        /*This method will be used later
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
         */
        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    } // --------------- end of nested Node class -----------------

    // Root of BST
    /**
     * Each object belongs to BST has one root node
     */
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    // Constructor
    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(E e) {
        this.root = new Node<E>(e);
    }

    // Equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinarySearchTree<?> otherTree = (BinarySearchTree<?>) obj;
        return countNodes(root) == countNodes((Node<E>) otherTree.getRoot()) && getHeight(root) == getHeight((Node<E>) otherTree.getRoot());
    }

    private int countNodes(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    // Clone
    @Override
    public BinarySearchTree<E> clone() {
        try {
            BinarySearchTree<E> clone = (BinarySearchTree<E>) super.clone();
            if (root != null) {
                clone.root = clone(root);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    private Node<E> clone(Node<E> root) {
        if (root == null) {
            return null;
        }
        Node<E> cloneNode = new Node<>(root.getElement());
        cloneNode.setLeft(clone(root.getLeft()));
        cloneNode.setRight(clone(root.getRight()));
        return cloneNode;
    }

    /**
     * Insert a node into the binary search tree
     *
     * @param data data of type E that implements the Comparable interface
     * @return void
     */
    public void insert(E data) {
        this.root = insertRec(this.root, data);
    }

    /**
     * A recursive function to insert a new node with data (e) into BST
     *
     * @param root : the root of the current sub-tree
     * @param e: data field
     * @return root node of the tree after insertion
     */
    private Node<E> insertRec(Node<E> root, E data) {
        /* If the tree is empty, then return a new node */
        if (root == null) {
            return new Node<E>(data);
        } /**
         * If the value of the data being inserted is less than the value of the
         * current root node, then traverse to the left node of the current
         * root, and set the current left node to whatever gets returned from
         * the insert method
         */
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: root.left = insertRec(...,
             * ...);
             */
            root.left = insertRec(root.left, data);
        } /**
         * If the value of the data being inserted is less than the value of the
         * current root node,, then traverse to the right node of the current
         * root,, and set the current right node to whatever gets returned from
         * the insert method
         */
        else if (data.compareTo(root.getElement()) > 0) {
            /**
             * Write your code here, it should be: root.right = insertRec(...,
             * ...);
             */
            root.right = insertRec(root.right, data);
        } else {
            // This is emply to explicitly state that we do NOT 
            // allow insert duplicate values into the tree.
            ;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    /**
     * This method finds the maximum value in the tree
     *
     * @param root root node of the current subtree
     * @return maximum value in the tree
     */
    public E findMax(Node<E> root) {
        // We simply continue traversing to the right until we can't go any more, 
        // That means we have reached the largest element 
        if (root == null) {
            return null;
        }

        while (root.getRight() != null) {
            //Write your code here
            root = root.getRight();
        }

        return root.getElement();
    }

    public E findMin(Node<E> root) {
        if (root == null) {
            return null;
        } else if (root.getLeft() == null) {
            return root.getElement();
        } else {
            return findMin(root.getLeft());
        }
    }

    public int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.getLeft());
            int rightHeight = getHeight(root.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int getTotalNodes(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int leftNodes = getTotalNodes(root.getLeft());
            int rightNodes = getTotalNodes(root.getRight());
            return leftNodes + rightNodes + 1;
        }
    }

    public int getTotalLeaf(Node<E> root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else {
            int leftLeaves = getTotalLeaf(root.getLeft());
            int rightLeaves = getTotalLeaf(root.getRight());
            return leftLeaves + rightLeaves;
        }
    }

    public boolean isBST(Node<E> root) {
        return isBSTRec(root, null, null);
    }

    private boolean isBSTRec(Node<E> root, E min, E max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.getElement().compareTo(min) <= 0) || (max != null && root.getElement().compareTo(max) >= 0)) {
            return false;
        }
        return isBSTRec(root.getLeft(), min, root.getElement()) && isBSTRec(root.getRight(), root.getElement(), max);
    }

    /**
     * Returns true if the value is contained in the binary search tree, false
     * otherwise
     *
     * @param data: the value that's being searched for
     * @return boolean evaluation
     * @see boolean
     */
    public Node<E> contains(E data) {
        return containsRec(this.root, data);
    }

    private Node<E> containsRec(Node<E> root, E data) {
        // if the root is null, then either the BST is empty or 
        // the value has not been found and traversal cannot continue
        if (root == null) {
            return null;
        } // if the data being searched for is less than the value of the current root's data, 
        // then we check if the data exists in the current root's left sub-tree
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: contains(..., ...)
             */
            return containsRec(root.left, data);
        } // if the data being searched for is greater than the value of the current root's data, 
        // then we check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.getElement()) > 0) {
            /**
             * Write your code here, it should be: contains(abc,xyz)
             */
            return containsRec(root.right, data);
        } // if the data being searched for is equal to the value of the current root's data, then 
        // the search was successful and the method should return true
        else {
            return root;
        }
    }

    /**
     * DFS to print the values stored in the BST via in-Order traversal
     *
     * @param void
     * @return void
     */
    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Node, Right
    // Traverses left as far as possible until a null node is reached, 
    // then prints the root node and 
    // then goes as far right as possible until a null node is reached. 
    private void inorder(Node<E> root) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft());
        System.out.print(" " + root.getElement().toString());
        inorder(root.getRight());
    }

    /**
     * DFS to print the values stored in the BST via pre-Order traversal
     *
     * @param void
     * @return void
     */
    public void preorder() {
        //Write your code here
        System.out.print("Preorder traversal: ");
        preorderRec(root);
        System.out.println();
    }

    // Sequence to be printed: Node, Left, Right
    // Prints the root node, then traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached.
    private void preorderRec(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }
        System.out.print(" " + root.getElement().toString());
        preorderRec(root.getLeft());
        preorderRec(root.getRight());
    }

    /**
     * DFS to print the values stored in the BST via post-Order traversal
     *
     * @param void
     * @return void
     */
    public void postorder() {
        //Write your code here
        System.out.println("Postorder traversal: ");
        postorderRec(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Right, Node
    // Traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached,
    // and finally prints the root node.
    private void postorderRec(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }
        postorderRec(root.getLeft());
        postorderRec(root.getRight());
        System.out.print(" " + root.getElement().toString());
    }

    // Test the class's methods
//    public static void main(String[] args) {
//        /**
//         * NOTE that these code is just example feel free to modify for testing
//         * other methods
//         */
//        BinarySearchTree<Integer> i_tree = new BinarySearchTree<Integer>();
//
//        /* Let us build the BST as below
//                  5
//                /   \
//              3       9
//             /  \    /  \
//            2    4  6    10 
//           /         \
//          1           7
//         */
//        i_tree.insert(5);
//        i_tree.insert(3);
//        i_tree.insert(2);
//        i_tree.insert(4);
//        i_tree.insert(9);
//        i_tree.insert(6);
//        i_tree.insert(10);
//        i_tree.insert(1);
//        i_tree.insert(7);
//
//        System.out.println(i_tree.contains(10).toString());
//        // print inorder traversal of the BST
//        i_tree.inorder();
//
//        // print preorder traversal of the BST
////        i_tree.preorder();
//        // print postorder traversal of the BST
////        i_tree.postorder();
//        System.out.println("Maximum values in BST = " + i_tree.findMax(i_tree.getRoot()));
//
//        BinarySearchTree<String> s_tree = new BinarySearchTree<String>();
//
//        /* 
//        Let us build the BST as below
//                  m
//                /   \
//              d       r
//             /  \    /  \
//            c    g  o    t 
//           /         \
//          b           q
//          
//         */
//        s_tree.insert("m");
//        s_tree.insert("d");
//        s_tree.insert("c");
//        s_tree.insert("b");
//        s_tree.insert("g");
//        s_tree.insert("r");
//        s_tree.insert("o");
//        s_tree.insert("t");
//        s_tree.insert("q");
//
//        // print inorder traversal of the BST
////        s_tree.inorder();
//        // print preorder traversal of the BST
////        s_tree.preorder();
//        // print postorder traversal of the BST
////        s_tree.postorder();
//        System.out.println("Maximum values in BST = " + s_tree.findMax(s_tree.getRoot()));
//    }
}

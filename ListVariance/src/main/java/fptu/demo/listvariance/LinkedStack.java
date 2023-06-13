package fptu.demo.listvariance;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vinhvo
 */
public class LinkedStack<E extends Comparable<E>> implements Stack<E> {

    /**
     * The primary storage for elements of the stack
     */
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty list
    // private Node<E> top; // equivalent to list's head

    /**
     * Constructs an initially empty stack.
     */
    public LinkedStack() {
    }   // new stack relies on the initially empty list

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        // write your code here
        return list.size();
    }

    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        // write your code here
        return list.isEmpty();
    }

    /**
     * Inserts an element at the top of the stack.
     *
     * @param element the element to be inserted
     */
    @Override
    public void push(E element) {
        // write your code here
        list.addFirst(element);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     *
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        // write your code here
        if (isEmpty()) {
            return list.getFirst();
        }
        return null;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public void reverse() {
        // write your code here
        LinkedStack<E> tempStack = new LinkedStack<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            E element = list.removeFirst();
            tempStack.push(element);
        }
        this.list = tempStack.list;
    }

    /**
     * Produces a string representation of the contents of the stack. (ordered
     * from top to bottom)
     * <p>
     * This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    public String toString() {
        // write your code here
        list.display();
        return "Vinh";
    }
}

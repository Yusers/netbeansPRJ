/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fptu.demo.listvariance;

/**
 * Stack interface
 * A collection of objects that are inserted and removed according to the last-in-first-out principle.
 * Although similar in purpose, this interface differs from java.util.Stack.
 *
 * @author vinhvo
 */
public interface Stack<E> {

    /**
     * Returns the numbers of elements in the stack.
     * @return number of elements in the stack.
     */
    int size();

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Inserts an element into the top of the stack.
     * @param e the element to be inserted.
     */
    void push(E e);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty).
     */
    E top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty).
     */
    E pop();
    
    /**
     * Reverse all elements in the stack
     * 
     */
    void reverse();
}


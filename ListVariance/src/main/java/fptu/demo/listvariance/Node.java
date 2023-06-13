/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptu.demo.listvariance;

/**
 *
 * @author vinhvo
 */
public class Node<E extends Comparable<E>> implements Comparable<E>{
    // Each node has two attributes
    private E element;      // 1. Data fields
    private Node<E> next;   // 2. Link to the next node

    // Constructors with two parameters
    public Node(E e, Node<E> n) {
        this.element = e;
        this.next = n;
    }

    public E getElement() {
        return this.element;
    }

    public void setElement(E e) {
        this.element = e;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> n) {
        this.next = n;
    }

    @Override
    public int compareTo(E that) {

        return this.getElement().compareTo(that);
    }
}// End of the class Node<E>
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptu.demo.listvariance;

/**
 *
 * @author vinhvo
 */
/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 */
public class LinkedQueue2<E extends Comparable<E>> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    private Node<E> rear, front;

    @Override
    public int size() {
        // write your code here
        int count = 0;
        Node<E> current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        // write your code here
        return front == null;
    }

    @Override
    public void enqueue(E e) {
        // write your code here
        Node<E> newNode = new Node<>(e, null);
        if (rear != null) {
            rear.setNext(newNode);
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    @Override
    public E first() {
        // write your code here
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    @Override
    public E dequeue() {
        // write your code here
        if (isEmpty()) {
            return null;
        }
        E element = front.getElement();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return element;
    }
    
    @Override
    public void reverse() {
        // write your code here
        Node<E> current = front;
        Node<E> previous = null;
        Node<E> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        rear = front;
        front = previous;
    }
}

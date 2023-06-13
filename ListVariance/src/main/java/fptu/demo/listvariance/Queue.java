package fptu.demo.listvariance;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author vinhvo
 */
public interface Queue<E> {
    
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();
    
    E first(); // returns the front element of the queue
    
    /**
     * Reverse all elements in the queue
     * 
     */
    void reverse();
}


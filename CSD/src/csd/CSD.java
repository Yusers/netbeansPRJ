/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd;

/**
 *
 * @author overw
 */
public class CSD {
    public static void main(String[] args) {
        int[] a = new int[10];
        System.out.println(a[0]);
    }

    /**
     * @param args the command line arguments
     */
    class ArrayStack {

        protected Object[] a;
        int top, max;

        public ArrayStack() {
            this(50);
        }

        public ArrayStack(int max1) {
            max = max1;
            a = new Object[max];
            top = -1;
        }

        protected boolean grow() {
            int max1 = max + max / 2;
            Object[] a1 = new Object[max1];
            if (a1 == null) {
                return (false);
            }
            for (int i = 0; i <= top; i++) {
                a1[i] = a[i];
            }
            a = a1;
            return (true);
        }

        public boolean isEmpty() {
            return (top == -1);
        }

    }
}

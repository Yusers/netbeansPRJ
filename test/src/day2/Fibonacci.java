/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

import java.util.Scanner;

/**
 *
 * @author overw
 */
public class Fibonacci {
    public static int fibonacciRecursion(int n) {
        if(n < 0) {
            return -1;
        } else if(n == 0 || n == 1) {
            return n;
        } else {
            return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range: ");
        int range = sc.nextInt();
        for(int i = 0; i < range; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
    }
}

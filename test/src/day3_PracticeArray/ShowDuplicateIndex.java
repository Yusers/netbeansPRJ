/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_PracticeArray;

import java.util.Scanner;

/**
 *
 * @author overw
 */
public class ShowDuplicateIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte n;
        do {
            System.out.print("Enter n: ");
            n = sc.nextByte();
        } while(!(n >= 1 && n <= 100));
        int a[] = new int[n];

        
        for(int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }   
        
        
//        Print out elements
        byte count = 0;
        System.out.println("Enter x: ");
        int x = sc.nextInt();
        for(byte i = 0; i < a.length; i++) {
            if(a[i] == x) {
                count++;
            }
        }
        System.out.println("x appear: " + count + " times");
    }
}

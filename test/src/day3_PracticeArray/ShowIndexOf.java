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
public class ShowIndexOf {
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
        System.out.println("show index can divibe by 3 and 5: ");
        for(byte i = 0; i < a.length; i++) {
            if(a[i] % 3 == 0 || a[i] % 5 == 0) {
                System.out.print("a[" + i + "]\n");
            }
        }
    }
}

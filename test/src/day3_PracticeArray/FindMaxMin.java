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
public class FindMaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte n;
        do {
            System.out.print("Enter n: ");
            n = sc.nextByte();
        } while(!(n >= 1 && n <= 100));
        int a[] = new int[n];
//       input array
        for(byte i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]");
            a[i] = sc.nextInt();
        }
//      Max
        int max = a[0];
        byte index = 0;
        for(byte i = 0; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        System.out.println("Max: " + max + " at index: a[" + index + "]");
//      Min 
        int min = a[0];
        for(byte i = 0; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        System.out.println("Min: " + min + " at index a[" + index + "]");
    }
}

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
public class ShowIndexIsPrimeNumbers {
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
        for(byte i = 0; i < a.length; i++) {
            boolean isPrime = true;
            if(a[i] < 2) {
                isPrime = false;
            }
            for(byte j = 2; j < a[i]; j++) {
                if(a[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.println("Index have Prime Number is: ");
            if(isPrime) {
                System.out.println("a[" + i + "]");
            }
        }
    }
}

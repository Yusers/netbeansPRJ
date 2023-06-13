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
public class TotalOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter n1: ");
        short n1 = sc.nextShort();
        System.out.print("Enter n2: ");
        short n2 = sc.nextShort();
        for(short i = n1; i <= n2; i++) {
            if(i%2 != 0) {
                sum+=i;
            }
        }
        System.out.print("Sum of odd numbers: " + sum);
    }
}

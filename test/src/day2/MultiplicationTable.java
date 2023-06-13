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
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        byte n = sc.nextByte();
        for(byte i = 1; i <= 9; i++) {
            System.out.println(n + " x " + i + " = " + (n*i));
        }
    }
}

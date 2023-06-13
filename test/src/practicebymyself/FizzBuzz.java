/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicebymyself;

import java.util.Scanner;

/**
 *
 * @author overw
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        short n = sc.nextShort();
        
        for(byte i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 == 0) {
                System.out.print("Fizz Buzz, ");
            } else if(i % 3 == 0) {
                System.out.print("Fizz, ");
            } else if(i % 5 == 0) {
                System.out.print("Buzz, ");
            } else {
                System.out.print(i + ", ");
            }
        }
        
//        Another way to do FizzBuzz more optimized
        String s = "";
        byte c3 = 0, c5 = 0;
        for(byte i = 1; i <= n; i++) {
            c3++;
            c5++;
            if(c3 == 3) {
                s += "Fizz";
                c3=0;
            } 
            if(c5 == 5) {
                s += "Buzz";
                c5=0;
            }
            if(s.length() == 0) {
                System.out.println(i);
            } else {
                System.out.println(s);
            }
            s = "";
        }
    }
}

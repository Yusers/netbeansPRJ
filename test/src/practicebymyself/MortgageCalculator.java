/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicebymyself;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author overw
 */
public class MortgageCalculator {
    public static void main(String[] args) {
//        Constant 
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        boolean cond = false;
        float annualInterest;
        float monthlyInterest;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextInt();
            if(principal >= 1 && principal <= 1000000) {
                System.out.print("Annual Interest Rate: ");
                annualInterest = sc.nextFloat();
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            }
        } while(!cond);
            
            System.out.print("Period (Years): ");
            byte years = sc.nextByte();
            int numberOfPayments = years * MONTHS_IN_YEAR;
        
        
        double mortgage = principal * (monthlyInterest*Math.pow(1 + monthlyInterest, numberOfPayments))
                /(Math.pow(1 + monthlyInterest, numberOfPayments)-1);
        } while(principal > 1 && principal < 1000000);
        
        
        
        String mortageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortageFormated);
        
    }
}

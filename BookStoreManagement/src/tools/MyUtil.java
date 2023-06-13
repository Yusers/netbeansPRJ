/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author Minh Khang
 */
public class MyUtil {
    public static final Scanner SC = new Scanner(System.in);
    
    public static boolean validStr(String str, String regEx){
        return str.matches(regEx);
    }
    
    public static String readString(String message, int minL, int maxL){
        if(minL > maxL){
            int t = minL;
            minL = maxL;
            maxL = t;
        }
        String input ="";
        boolean OK = true;
        do{
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            int L = input.length();
            if(L < minL || L > maxL){
                OK =false;
            }
        }while (!OK);
        return input;
    }
    
    public static String readPattern(String message, String pattern){
        String input ="";
        boolean OK;
        do{
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            OK = validStr(input, pattern);
        }while (!OK);
        return input;
    }
    
        public static double readDouble(String message, double min){
        String input ="";
        boolean OK = true;
        double result;
        do{
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            result = Double.parseDouble(input);
            if(result < min){
                OK = false;
            }
        }while (!OK);
        return result;
    }
        
        public static int readInt(String message, int min){
        String input ="";
        boolean OK = true;
        int result;
        do{
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            result = Integer.parseInt(input);
            if(result < min){
                OK = false;
            }
        }while (!OK);
        return result;
    }
        
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsr;

import java.util.Scanner;

/**
 *
 * @author overw
 */
public class HMSR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
        int arr[] = new int[n];
        int a;
        boolean cont = true;
        boolean flag = true;

        for (byte i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        // switch case:
        int choice = 0;
        do {
            System.out.println("1. Find index of elements");
            System.out.println("2. Delete elements");
            System.out.println("3. Display");
            System.out.println("4. Insert an element (specific position) into an array");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    flag = true;
                    do {
                        try {
                            System.out.print("Enter element value to find index: ");
                            a = Integer.parseInt(sc.nextLine());
                            for (byte i = 0; i < n; i++) {
                                if (a == arr[i]) {
                                    System.out.println("index is: " + i);
                                    flag = false;
                                }
                            }
                            if (flag) {
                                System.out.println("Can't find");
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Try again!!");
                        }
                    } while (flag);
                    break;
                case 2:
                    flag = true;
                    do {
                        try {
                            System.out.print("Enter index to remove: ");
                            a = Integer.parseInt(sc.nextLine());
                            if (a >= n) {
                                System.out.println("Input wrong!!");
                                throw new Exception();
                            }
                            for (int i = a; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            n--;
                            System.out.println("After removed: ");
                            for (byte i = 0; i < n; i++) {
                                System.out.print("a[" + i + "]: " + arr[i] + "\n");
                            }
                            flag = false;
                        } catch (Exception e) {
                            System.out.println("Try again!!");
                        }
                    } while (flag);
                    break;
                case 3:
                    for (byte i = 0; i < n; i++) {
                        System.out.println("arr[" + i + "]" + arr[i]);
                    }
                    break;
                case 4:
                    System.out.print("Enter position to insert: ");
                    a = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter value to insert: ");
                    int e = Integer.parseInt(sc.nextLine());
                    for(byte i = 0; i < n+1; i++) {
                        if(i == a) {
                            arr[i] = e;
                            arr[i+1] = arr[i];
                        }
                    }
                    n++;
                    break;
                case 5:
                    break;
                case 6:
                    cont = false;
                    break;
            }
        } while (cont);

    }

}

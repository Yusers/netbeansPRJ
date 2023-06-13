package test;

/**
 *
 * @author overw
 */
import java.uti;
import java.lang.Integer;
import java.util.Scanner;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long result = 0;
        Scanner sc = new Scanner(System.in);
        
//        System.out.print("n1: ");
//        n1 = sc.nextInt();
//        
//        System.out.print("n2: ");
//        n2 = sc.nextInt();
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        
        
    }
    public static int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int fn = 1;
 
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }
        return fn;
    }
        
}

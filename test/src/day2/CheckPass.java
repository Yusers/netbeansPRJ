/*
 This class including checkPassword with String

 */
package day2;
import java.text.NumberFormat;
import static java.lang.Math.*;
import java.util.Scanner;
/**
 *
 * @author overw
 */
public class CheckPass {
    public static void main(String[] args) {
//    Constant
        final String PASSWORD = "12345";
        Scanner sc = new Scanner(System.in);
        String pass = null;
        byte count = 0;
//      Execute
        do {
            System.out.print("\nEnter password: ");
            pass = sc.nextLine();
            count++;
            if(pass.equals(PASSWORD)) {
                System.out.println("Right password");
                break;
            } else {
                System.out.print("Wrong input 3 times will lock\nYou entered wrong "+ count + " times");
                System.out.println("\nWrong password! try again");
            }
        } while(count < 3 && !pass.equals(PASSWORD));
    }
}

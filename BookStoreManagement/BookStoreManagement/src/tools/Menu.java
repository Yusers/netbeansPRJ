/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import java.util.ArrayList;
/**
 *
 * @author Minh Khang
 */
public class Menu extends ArrayList<String> {
    public Menu(){
        super();
    }
    public int getUserChoice(){
        int choice;
        int n = this.size();
        for(int i = 1; i <= n; i++)
            System.out.println(i + "-" + this.get(i-1));
        System.out.println((n+1) + ": Quit");
        System.out.println("_______________");
        System.out.print("Choose (1 to " + (n+1) +"): ");
        choice = Integer.parseInt(MyUtil.SC.nextLine());
        return choice;
    }
}

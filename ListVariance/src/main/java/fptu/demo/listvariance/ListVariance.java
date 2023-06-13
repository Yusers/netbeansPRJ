*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fptu.demo.listvariance;

/**
 *
 * @author vinhvo
 */
public class ListVariance {

    public static void testStack(){
        // write your code here to test methods of stack
        LinkedStack s = new LinkedStack();
        
        s.push(5);
        s.push(6);
        s.push("Vo Vinh");
        s.toString();
    }
    
    public static void testQueue(){
        // write your code here to test methods of queue
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("Test methods of stack");
        testStack();

        System.out.println("Test methods of queue");
        testQueue();
    }
}

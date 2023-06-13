/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList.singlyLinkedList;

/**
 *
 * @author vinhvo
 */
public class TestSLL_Solution {
    public static void main(String[] args) {
        
        SinglyLinkedList_Student myList1 = new SinglyLinkedList_Student();
        myList1.addFirst(4); // head -> 4 -> null (tail -> 4)
        myList1.addFirst(6); // head -> 6 -> 4 -> null 
        myList1.addFirst(8); // head -> 8 - > 6 -> 4 -> null (tail -> 4)
        
        myList1.display();
        
        myList1.addLast(2); // head -> 8 - > 6 -> 4 -> 2 -> null (tail -> 2)
        myList1.addAfter(myList1.getNode(6), 5); // middle
        myList1.display(); // 8 -> 6 -> 5 -> 4 -> 2
        
//        
        myList1.addAfter(myList1.getNode(2), 1); // end
        myList1.display(); // 8 -> 6 -> 5 -> 4 -> 2 --> 1
        
        myList1.addAfter(null, 10); // start
        myList1.display(); // 10 -> 8 -> 6 -> 5 -> 4 -> 2 -> null
        
        myList1.removeFirst();
        myList1.display(); // 8 -> 6 -> 5 -> 4 -> 2 -> null

   
        myList1.removeLast(); 
        
        System.out.println("List after remove the last node (key = 2)");
        myList1.display(); // 8 -> 6 -> 5 -> 4
        
        myList1.removeLast(); 
        System.out.println("List after remove the last node (key = 4)");
        myList1.display(); // 8 -> 6 -> 5
        
        myList1.removeLast(); 
        System.out.println("List after remove the last node (key = 5)");
        myList1.display(); // 8 -> 6

        myList1.removeLast(); 
        System.out.println("List after remove the last node (key = 6)");
        myList1.display(); // 8
        
        myList1.removeLast(); 
        System.out.println("List after remove the last node (key = 8)");
        myList1.display(); // Empty list
        

        
        
        
        
        SinglyLinkedList_Student myList2 = new SinglyLinkedList_Student();
        myList2.addFirst("Vinh");
        myList2.addFirst("Duc");
        myList2.addFirst("Vo");
        myList2.addFirst("Mr.");

        myList2.display();
        
        myList2.removeFirst(); // Vo --> Duc --> Vinh --> null
        myList2.removeAfter(myList2.getNode("Duc")); // Vo --> Duc --> null
        myList2.display();
        
        myList2.addFirst("Naruto"); // Naruto --> Vo --> Duc -> null
        System.out.println("List after remove Duc");
        myList2.remove("Duc");
        myList2.display();
        
   
        
        
        
        
        
        
        SinglyLinkedList_Student myList3 = null;
        
        try {
           myList3 = (SinglyLinkedList_Student) myList2.clone();
           myList3.display();
           
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        }
        
        if (myList3.equals(myList2)){
            System.out.println("Two lists are equal");
        }
        else
            System.out.println("Two lists NOT equal");

        
        SinglyLinkedList_Student myList4 = new SinglyLinkedList_Student();
        myList4.addFirst("Vinh");
        myList4.addFirst("Vo");    
        
        if (myList3.equals(myList4)){
            System.out.println("Two lists are equal");
        }
        else
            System.out.println("Two lists NOT equal");
        
        SinglyLinkedList_Student myList5 = new SinglyLinkedList_Student();
        myList5.addFirst(7); // head -> 7 -> null (tail -> 7)
        myList5.addFirst(6); // head -> 6 -> 7 -> null 
        myList5.addFirst(8); // head -> 8 - > 6 -> 7 -> null (tail -> 7)
        
        myList5.display();
        myList5.sortList();
        myList5.display();
        
        
        myList5.remove(7);
        myList5.display();
        
        myList5.remove(6);
        myList5.display();
        
        myList5.remove(8);
        myList5.display();
        
    } // End main
    
    
        
    
}

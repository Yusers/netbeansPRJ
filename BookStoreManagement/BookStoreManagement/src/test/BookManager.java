/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import core.*;
import tools.*;
/**
 *
 * @author Minh Khang
 */
public class BookManager {
    public static void main(String[] args) throws Exception{
        Menu mnu = new Menu();
        mnu.add("Publisher: Add");
        mnu.add("Publisher: Search");
        mnu.add("Publisher: Remove");
        mnu.add("Publisher: Update");
        mnu.add("Publisher: Print");
        mnu.add("Publisher: Save to file");
        mnu.add("Book: Add");
        mnu.add("Book: Search");
        mnu.add("Book: Remove");
        mnu.add("Book: Update");
        mnu.add("Book: Print");
        mnu.add("Book: Save to file");
        int nChoice = mnu.size();
        
        PublisherList pList = new PublisherList();
        pList.readFromFile();
        BookList bList = new BookList(pList);
        bList.readFromFile();
        int choice;
        boolean pChange= false;
        boolean bChange= false;
        
        do{
            System.out.println("\n -----BOOK MANAGER-----");
            choice = mnu.getUserChoice();
            switch(choice){
                case 1:
                    pList.addPublisher();
                    pChange = true;
                    break;
                case 2:
                    pList.search();
                    break;
                case 3:
                    System.out.println("This function is not supported");
                    break;
                case 4:
                    pList.updatePublisher();
                    pChange = true;
                    break;
                    
                case 5:
                    pList.print();
                    break;
                
                case 6:
                    pList.writeToFile();
                    pChange = false;
                    break;
                    
                case 7:
                    bList.addBook();
                    bChange = true;
                    break;
                    
                case 8:
                    bList.search();
                    break;
                    
                case 9:
                    bList.removeBook();
                    bChange = true;
                    break;
                    
                case 10:
                    bList.updateBook();
                    bChange = true;
                    break;
                    
                case 11:
                    bList.print();
                    break;
                    
                case 12:
                    bList.writeToFile();
                    bChange = false;
                    break;
            }
        }while(choice > 0 && choice <= nChoice);
        String response;
        if(pChange == true || bChange == true){
            System.out.println("Data changed, sace file? (Y/N): ");
            response= MyUtil.SC.nextLine().trim().toUpperCase();
            if(response.startsWith("Y")){
                if(pChange) 
                    pList.writeToFile();
                if(bChange)
                    bList.writeToFile();
            }
        }
        System.out.println("Thank you!");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Scanner;

/**
 *
 * @author overw
 */
public class Main {

    public static int getUsersChoice(int firstChoice, int lastChoice) {
        boolean flag = true;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter choice between " + firstChoice + ", " + lastChoice + ": ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < firstChoice || choice > lastChoice) {
                    throw new Error();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Exception!! try again");
            } catch (Error e) {
                System.out.println("Please enter between " + firstChoice + ", " + lastChoice);
            }
        } while (flag);

        return choice;
    }

    // UI Publishers Management
    public static void publishersManagementUI() {
        PublishersManagement publishersManagement = new PublishersManagement();
        boolean flag = true;
        do {
            try {
                System.out.println("==== Publisher Management ====");
                System.out.println("1. Create a Publisher");
                System.out.println("2. Delete the Publisher");
                System.out.println("3. Save the Publishers list to file");
                System.out.println("4. Print the Publisher list from the file");
                System.out.println("5. Back to the main menu");
                System.out.print("Enter choice: ");
                switch (getUsersChoice(1, 5)) {
                    case 1:
                        publishersManagement.input();
                        break;
                    case 2:
                        publishersManagement.delete();
                        break;
                    case 3:
                        publishersManagement.writeFile();
                        break;
                    case 4:
                        publishersManagement.display();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Try again!" + e);
            }
        } while (flag);
    }

    // UI Books Management
    public static void booksManagementUI() {
        BooksManagement booksManagement = new BooksManagement();
        boolean flag = true;
        do {
            try {
                System.out.println("==== Publisher Management ====");
                System.out.println("1. Create a Book");
                System.out.println("2. Search the Book");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book information");
                System.out.println("5. Save the Book list to file");
                System.out.println("6. Print the Books list from the file");
                System.out.println("7. Back to the main menu");
                System.out.print("Enter choice: ");
                switch (getUsersChoice(1, 7)) {
                    case 1:
                        booksManagement.input();
                        break;
                    case 2:
                        booksManagement.searchBook();
                        break;
                    case 3:
                        booksManagement.updateBook();
                        break;
                    case 4:
                        break;
                    case 5:
                        booksManagement.writeFile();
                        break;
                    case 6:
                        booksManagement.display();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Try again!" + e);
            }
        } while (flag);
    }

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        // Menu display
        do {
            try {
                System.out.println("==== Management Program ====");
                System.out.println("1. Publishers management");
                System.out.println("2. Books management");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                switch (getUsersChoice(1, 3)) {
                    case 1:
                        publishersManagementUI();
                        break;
                    case 2:
                        booksManagementUI();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong!, Try again!!" + "\n" + e);
            }
        } while (flag);

    }
}

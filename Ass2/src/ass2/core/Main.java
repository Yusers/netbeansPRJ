/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.core;

import ass2.management.CustomerManagement;
import ass2.management.OrderManagement;
import ass2.management.ProductManagement;
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

    public static void updateOrderMenu(OrderManagement ordMng) {
        boolean flag = true;
        do {
            try {
                System.out.println("10.1. Update an Order based on its ID");
                System.out.println("10.2. Delete an Order based on its ID");
                System.out.println("Orthers - Quit");
                switch (getUsersChoice(1, 3)) {
                    case 1:
                        ordMng.update();
                        break;
                    case 2:
                        ordMng.delete();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (flag);
    }

    public static void main(String[] args) {
        boolean flag = true;
        ProductManagement productManagement = new ProductManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        OrderManagement orderManagement = new OrderManagement();
        do {
            try {
                System.out.println("--- Order Management ---");
                System.out.println("1. List all Prodcuts");
                System.out.println("2. List all Customers");
                System.out.println("3. Search a Customer based on his/her ID");
                System.out.println("4. Add a Customer");
                System.out.println("5. Update a Customer");
                System.out.println("6. Save Customers to the file, named customers.txt");
                System.out.println("7. List all Orders in ascending order of Customer name");
                System.out.println("8. List all pending Orders");
                System.out.println("9. Add an Order");
                System.out.println("10. Update an Order");
                System.out.println("11. Save Orders to file, named orders.txt");
                System.out.println("Others - Quit");
                switch (getUsersChoice(1, 12)) {
                    case 1:
                        productManagement.display();
                        break;
                    case 2:
                        customerManagement.display();
                        break;
                    case 3:
                        customerManagement.search();
                        break;
                    case 4:
                        customerManagement.add();
                        break;
                    case 5:
                        customerManagement.update();
                        break;
                    case 6:
                        customerManagement.save();
                        break;
                    case 7:
                        orderManagement.display("");
                        break;
                    case 8:
                        orderManagement.display("pending");
                        break;
                    case 9:
                        orderManagement.add();
                        break;
                    case 10:
                        updateOrderMenu(orderManagement);
                        break;
                    case 11:
                        orderManagement.save();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Try again! " + e);
            }
        } while (flag);
    }
}

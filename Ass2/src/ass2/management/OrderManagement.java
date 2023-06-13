/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.management;

import ass2.core.Customer;
import ass2.core.Order;
import ass2.core.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import management.FileManagement;

/**
 *
 * @author overw
 */
public class OrderManagement extends FileManagement {

    Scanner sc = new Scanner(System.in);
    ArrayList<Order> listOrders = getListFromFile("orders.txt");

    // Add orders
    public void add() {
        CustomerManagement cm = new CustomerManagement();
        ProductManagement pm = new ProductManagement();
        boolean flag = true;
        String id = null;
        // input OrderID
        do {
            System.out.print("Enter order ID(Dxxx): ");
            try {
                id = sc.nextLine();
                if (!id.matches("D[0-9]{3}")) {
                    throw new Exception();
                }
                for (Order o : listOrders) {
                    if (o.getId().equals(id)) {
                        throw new Error();
                    }
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with O and ends with 3 digits");
            } catch (Error e) {
                System.out.println("ID is duplicated");
            }
        } while (flag);

        // Submenu to choose Customer
        String customerID = null;
        flag = true;
        do {
            try {
                cm.display();
                System.out.println("=== Choose one ===");
                System.out.print("Enter id customer: ");
                customerID = sc.nextLine();
                for (Customer c : cm.listCustomers) {
                    if (c.getId().equals(customerID)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("please choose right ID");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (flag);

        // Submenu to choose Product
        String productID = null;
        flag = true;
        do {
            try {
                pm.display();
                System.out.println("=== Choose one ===");
                System.out.print("Enter id product: ");
                productID = sc.nextLine();
                for (Product p : pm.listProducts) {
                    if (p.getId().equals(productID)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("please choose right ID");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (flag);

        // Input orderQuantity
        int quantity = -1;
        flag = true;
        do {
            try {
                System.out.print("Enter quantity: ");
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 1) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ");
            }
        } while (flag);

        // Input orderDate
        String date = "";
        flag = true;
        do {
            try {
                System.out.print("Enter date: ");
                date = sc.nextLine();
                if (!date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! right format (mm/dd/yyyy)");
            }
        } while (flag);

        // Input status
        boolean status = false;
        flag = true;
        do {
            try {
                System.out.print("Enter status: ");
                status = Boolean.parseBoolean(sc.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again!");
            }
        } while (flag);
        Order order = new Order();
        order.setId(id);
        order.setCustomerID(customerID);
        order.setProductID(productID);
        order.setQuantity(quantity);
        order.setDate(date);
        order.setStatus(status);
        listOrders.add(order);
        System.out.println("=> add success");
    }

    // Save
    public void save() {
        boolean flag = true;
        do {
            System.out.print("Save? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.toUpperCase().equals("N")) {
                System.out.println("=> Save failed!");
                break;
            }
            flag = false;
            updateFile(listOrders);
            System.out.println("=> Save succesfully!");
        } while (flag);
    }

    // update
    public void update() {
        boolean flag = true;
        String id = null;
        // input OrderID
        do {
            System.out.print("Enter order ID(Dxxx): ");
            try {
                id = sc.nextLine();
                if (!id.matches("D[0-9]{3}")) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with D and ends with 3 digits");
            }
        } while (flag);
        // Check order in a list
        flag = true;
        int index = -1;
        for (Order o : listOrders) {
            if (o.getId().equals(id)) {
                index = listOrders.indexOf(o);
            }
        }
        if (index >= 0) {
            CustomerManagement cm = new CustomerManagement();
            ProductManagement pm = new ProductManagement();
            // Submenu to choose Customer
            String customerID = null;
            flag = true;
            do {
                try {
                    cm.display();
                    System.out.println("=== Choose one ===");
                    System.out.print("Enter id customer: ");
                    customerID = sc.nextLine();
                    if (customerID.isEmpty()) {
                        break;
                    }
                    for (Customer c : cm.listCustomers) {
                        if (c.getId().equals(customerID)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("please choose right ID");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (flag);

            // Submenu to choose Product
            String productID = null;
            flag = true;
            do {
                try {
                    pm.display();
                    System.out.println("=== Choose one ===");
                    System.out.print("Enter id product: ");
                    productID = sc.nextLine();
                    if (productID.isEmpty()) {
                        break;
                    }
                    for (Product p : pm.listProducts) {
                        if (p.getId().equals(productID)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("please choose right ID");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (flag);

            // Input orderQuantity
            int quantity = -1;
            flag = true;
            do {
                try {
                    System.out.print("Enter quantity: ");
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity < 0) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (NumberFormatException n) {
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! ");
                }
            } while (flag);

            // Input orderDate
            String date = "";
            flag = true;
            do {
                try {
                    System.out.print("Enter date: ");
                    date = sc.nextLine();
                    if (date.isEmpty()) {
                        break;
                    }
                    if (!date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! right format (mm/dd/yyyy)");
                }
            } while (flag);

            // Input status
            Boolean status = null;
            flag = true;
            do {
                try {
                    System.out.print("Enter status: ");
                    String value = sc.nextLine();
                    if (value.isEmpty()) {
                        break;
                    } else {
                        status = Boolean.parseBoolean(value);
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again!");
                }
            } while (flag);
            Order order = new Order();
            order.setId(id);
            order.setCustomerID(customerID.isEmpty() ? listOrders.get(index).getCustomerID() : customerID);
            order.setProductID(productID.isEmpty() ? listOrders.get(index).getProductID() : productID);
            order.setQuantity(quantity == -1 ? listOrders.get(index).getQuantity() : quantity);
            order.setDate(date.isEmpty() ? listOrders.get(index).getDate() : date);
            order.setStatus(status == null ? listOrders.get(index).isStatus() : status);
            listOrders.set(index, order);
            updateFile(listOrders);
            System.out.println("=> Update successfully");
        } else {
            flag = false;
            System.out.println("=> OrderID does not exist");
            System.out.println("=> Update failed");
        }
    }

    // delete
    public void delete() {
        boolean flag = true;
        String orderID;
        Iterator<Order> iterator = listOrders.iterator();
        if (listOrders.isEmpty()) {
            System.out.println("=> Nothing to delete");
        } else {
            try {
                System.out.print("Enter orderID to delete: ");
                orderID = sc.nextLine();
                // If use for each and remove a obj will return exception ConcurrentModificationException
                while (iterator.hasNext()) {
                    Order o = iterator.next();
                    if (o.getId().equals(orderID)) {
                        iterator.remove();
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("*OrderID does not exist");
                    System.out.println("=> *Deleted failed");
                } else {
                    System.out.println("=> *Deleted successfully");
                    updateFile(listOrders);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // Display
    public void display(String status) {
        if (status == "pending") {
            System.out.println("=== Order Pending ===");
            if (listOrders.isEmpty()) {
                System.out.println("Nothing to ouput!");
            }
            for (Order o : listOrders) {
                if (o.isStatus()) {
                    System.out.println(o);
                }
            }
        } else {
            System.out.println("=== Order Info ===");
            if (listOrders.isEmpty()) {
                System.out.println("Nothing to ouput!");
            }
            ArrayList<Customer> listCustomer = getListFromFile("customers.txt");
            Collections.sort(listCustomer, (Customer c1, Customer c2) -> {
                return c1.getName().compareTo(c2.getName());
            });

            for (Customer c : listCustomer) {
//            System.out.println(c);
                for (Order o : listOrders) {
                    if (c.getId().equals(o.getCustomerID())) {
                        System.out.println(o);
                    }
                }
            }
        }
    }
}

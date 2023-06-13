/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.management;

import ass2.core.Customer;
import java.util.ArrayList;
import java.util.Scanner;
import management.FileManagement;

/**
 *
 * @author overw
 */
public class CustomerManagement extends FileManagement {

    ArrayList<Customer> listCustomers = getListFromFile("customers.txt");
    Scanner sc = new Scanner(System.in);

    // Display
    public void display() {
        System.out.println("=== Customer Info ===");
        if (listCustomers.isEmpty()) {
            System.out.println("=> Nothing to output!");
        }
        for (Customer c : listCustomers) {
            System.out.println(c.toString().trim());
        }
    }

    // Update Customer
    public void update() {
        boolean flag = true;
        String cusId = null;
        do {
            try {
                System.out.print("Enter customer id to update: ");
                cusId = sc.nextLine();
                if (!cusId.matches("C[0-9]{3}")) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Please enter right format (Cxxx)!");
            }
        } while (flag);
        flag = true;
        int index = -1;
        for (Customer c : listCustomers) {
            if (c.getId().equals(cusId)) {
                index = listCustomers.indexOf(c);
            }
        }
        if (index >= 0) {
            String name = null;
            String address = null;
            String phone = null;
            // update customer Name
            flag = true;
            do {
                System.out.print("Enter customer name: ");
                try {
                    name = sc.nextLine();
                    if (name.isEmpty()) {
                        break;
                    }
                    if (name == null) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! name cant be null");
                }
            } while (flag);

            // update address 
            flag = true;
            do {
                System.out.print("Enter customer address: ");
                try {
                    address = sc.nextLine();
                    if (address.isEmpty()) {
                        break;
                    }
                    if (address == null) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! name cant be null");
                }
            } while (flag);

            // update phone 
            flag = true;
            do {
                System.out.print("Enter customer phone: ");
                try {
                    phone = sc.nextLine();
                    if (phone.isEmpty()) {
                        break;
                    }
                    if (phone == null) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Try again! name cant be null");
                }
            } while (flag);
            Customer customer = new Customer();
            customer.setId(cusId);
            customer.setName(name.isEmpty() ? listCustomers.get(index).getName() : name.toUpperCase());
            customer.setAddress(address.isEmpty() ? listCustomers.get(index).getAddress(): address.toUpperCase());
            customer.setPhone(phone.isEmpty() ? listCustomers.get(index).getPhone() : phone);
            // update in position of list
            listCustomers.set(index, customer);
            updateFile(listCustomers);
            System.out.println("=> Updated successfully");
        } else {
            flag = false;
            System.out.println("=> *Customer does not exist");
            System.out.println("=> Updated failed");
        }
    }

    // Validate and Input
    // Add function
    public void add() {
        boolean flag = true;
        String id = null;
        String name = null;
        String address = null;
        String phone = null;
        // input Name
        do {
            System.out.print("Enter customer ID(Cxxx): ");
            try {
                id = sc.nextLine();
                if (!id.matches("C[0-9]{3}")) {
                    throw new Exception();
                }
                for (Customer c : listCustomers) {
                    if (c.getId().equals(id)) {
                        throw new Error();
                    }
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! ID must start with C and ends with 3 digits");
            } catch (Error e) {
                System.out.println("ID is duplicated");
            }
        } while (flag);

        // input Name
        flag = true;
        do {
            System.out.print("Enter customer name: ");
            try {
                name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! name is null");
            }
        } while (flag);

        // input Address
        flag = true;
        do {
            System.out.print("Enter customer address: ");
            try {
                address = sc.nextLine();
                if (address.isEmpty()) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Try again! address is null");
            }
        } while (flag);

        // input Phone
        flag = true;
        do {
            System.out.print("Enter customer phone: ");
            try {
                phone = sc.nextLine();
                if(phone.isEmpty()) {
                    throw new Error();
                }
                if (!(phone.length() >= 10 && phone.length() <= 12)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Error e) {
                System.out.println("Try again! phone is null");
            } catch (Exception e) {
                System.out.println("Try again! phone need greater than 9 and below 12");
            }
        } while (flag);
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name.toUpperCase());
        customer.setAddress(address.toUpperCase());
        customer.setPhone(phone);
        listCustomers.add(customer);
        System.out.println("=> Add success!");
    }

    // Write File & Save
    public void save() throws Exception {
        boolean flag = true;
        do {
            System.out.print("Save? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.toUpperCase().equals("N")) {
                System.out.println("=> Save failed!");
                break;
            }
            flag = false;
            updateFile(listCustomers);
            System.out.println("=> Save succesfully!");
        } while (flag);
    }

    // Search
    public void search() {
        boolean flag = true;
        do {
            try {
                System.out.print("Enter customer code: ");
                String id = sc.nextLine();
                boolean cont = false;
                for (Customer customer : listCustomers) {
                    if (customer.getId().equals(id)) {
                        System.out.println("=> " + customer);
                        cont = true;
                    }
                }
                if (!cont) {
                    System.out.println("=> This customer does not exist");
                }
                flag = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (flag);
    }
}

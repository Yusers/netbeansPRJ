package hrs.main;

import hrs.entities.*;
import hrs.services.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeManagement {

    public static int getUserChoice(int firstChoice, int lastChoice) {
        boolean cont = true;
        int userChoice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                userChoice = Byte.parseByte(sc.nextLine());
                if (userChoice < firstChoice || userChoice > lastChoice) {
                    throw new UnknownError();
                }

                cont = false;
            } catch (Exception e) {
                System.out.print("Exception: " + e + ". Enter again: ");
            } catch (UnknownError u) {
                System.out.print("Please choose the correct option above: ");
            }
        } while (cont == true);

        return userChoice;
    }

    public static void saveToFile(HashMap department, ArrayList<String> list) {
        if (list.isEmpty()) {
            return;
        }
        
        File f = new File("employee.txt");
        boolean append = false;
        
        try (FileWriter fw = new FileWriter(f, append);
                PrintWriter pw = new PrintWriter(fw)) {
            for (String x : list) {
                Department listOfEmployee = (Department) department.get(x);
                ArrayList tmplist = listOfEmployee.getListOfEmployee();
                pw.println("======" + x + "======");
                pw.println("_____Salaried Employee_____");
                for (Object e : tmplist) {
                    if (e instanceof SalariedEmployee) {
                        pw.println("\n" + e);
                    }
                }
                
                pw.println("______Hourly Employee______");
                for (Object e : tmplist) {
                    if (e instanceof HourlyEmployee) {
                        pw.println("\n" + e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Variables
        boolean flag = true;
        int userChoice = 0;
        int choice = 0;
        String name;
        String ssn;
        int index;
        String departmentName;
        // Object instance
        SalariedEmployeeService salariedService = new SalariedEmployeeService();
        SalariedEmployee salariedEmployee;
        HourlyEmployeeService hourlyService = new HourlyEmployeeService();
        HourlyEmployee hourlyEmployee;
        Department listOfEmployee;
        SortByName sortName = new SortByName();
        SortBySSN sortSSN = new SortBySSN();
        EmployeeService eservice = new EmployeeService();
        // ArrayList
        ArrayList tmplist;
        ArrayList<String> listOfDepartment = new ArrayList<>();
        HashMap<String, Department> department = new HashMap<>();
        HashSet<String> setOfSsn = new HashSet<>();

        do {
            System.out.println("\n====== EMPLOYEE MANAGEMENT SYSTEM ======");
            System.out.println("1. Add an employee");
            System.out.println("2. Display employees");
            System.out.println("3. Classify employees");
            System.out.println("4. Search employee by (department, emp’s name)");
            System.out.println("5. Update an employee");
            System.out.println("6. Delete an employee");
            System.out.println("7. Report");
            System.out.println("8. Exit");
            System.out.print("\nPlease choose function you'd like to do: ");
            userChoice = getUserChoice(1, 8);

            switch (userChoice) {
                case 1:
                    choice = 0;
                    if (!listOfDepartment.isEmpty()) {
                        System.out.println("======Choose exist deparment======");
                        for (int i = 0; i < listOfDepartment.size(); i++) {
                            System.out.println((i + 1) + ". "
                                    + listOfDepartment.get(i));
                        }
                        System.out.print("Your choice (0 to enter a new department): ");
                        choice = getUserChoice(0, listOfDepartment.size());
                    }
                    if (choice == 0) {
                        System.out.print("Enter department name: ");
                        departmentName = sc.nextLine();
                        listOfDepartment.add(departmentName);
                        listOfEmployee = new Department(departmentName);
                        department.put(departmentName, listOfEmployee);
                    } else {
                        departmentName = listOfDepartment.get(choice - 1);
                    }

                    System.out.print("Choose 1. Salaried, 2. Hourly: ");
                    choice = getUserChoice(1, 2);
                    if (choice == 1) {
                        salariedEmployee = salariedService.addEmployee(setOfSsn);
                        setOfSsn.add(salariedEmployee.getSsn());
                        listOfEmployee = department.get(departmentName);
                        tmplist = listOfEmployee.getListOfEmployee();
                        tmplist.add(salariedEmployee);
                    } else {
                        hourlyEmployee = hourlyService.addEmployee(setOfSsn);
                        setOfSsn.add(hourlyEmployee.getSsn());
                        listOfEmployee = department.get(departmentName);
                        tmplist = listOfEmployee.getListOfEmployee();
                        tmplist.add(hourlyEmployee);
                    }

                    break;
                case 2:
                    // Display employee
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Empty!!");
                    }
                    System.out.print("Choose 1. Order by SSN, 2. Order by Name, 3. Exit: ");
                    choice = Byte.parseByte(sc.nextLine());
                    if (choice == 1) {
                        for (String x : listOfDepartment) {
                            listOfEmployee = department.get(x);
                            tmplist = listOfEmployee.getListOfEmployee();
                            sortSSN.orderBySSN(tmplist);
                            listOfEmployee.display();
                        }
                    } else if (choice == 2) {
                        for (String x : listOfDepartment) {
                            listOfEmployee = department.get(x);
                            tmplist = listOfEmployee.getListOfEmployee();
                            sortName.orderByName(tmplist);
                            listOfEmployee.display();
                        }
                    } else {
                        break;
                    }
                    break;
                case 3:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    }
                    
                    salariedService.classifyEmployee(department, listOfDepartment);
                    break;
                case 4:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    }
                    
                    System.out.print("Choose 1.Search by department name, "
                            + "2.Search by name: ");
                    choice = getUserChoice(1, 2);
                    if (choice == 1) {
                        System.out.print("Enter department name: ");
                        departmentName = sc.nextLine();
                        index = listOfDepartment.indexOf(departmentName);
                        if (index >= 0) {
                            listOfEmployee = (Department) department.get(departmentName);
                            System.out.println("======" + departmentName + "======");
                            listOfEmployee.display();
                        } else {
                            System.out.println("Department does not exist");
                        }
                    } else {
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                        for (String x : listOfDepartment) {
                            System.out.println("======" + x + "======");
                            listOfEmployee = (Department) department.get(x);
                            tmplist = listOfEmployee.getListOfEmployee();
                            salariedService.searchByName(tmplist, name);
                        }
                    }
                    
                    break;
                case 5:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    }
                    
                    System.out.print("Enter SSN: ");
                    ssn = sc.nextLine();
                    if (setOfSsn.add(ssn)) {
                        setOfSsn.remove(ssn);
                        System.out.println("SSN does not exist");
                    } else {
                        for (String x : listOfDepartment) {
                            listOfEmployee = (Department) department.get(x);
                            tmplist = listOfEmployee.getListOfEmployee();
                            index = eservice.searchBySsn(tmplist, ssn);
                            if (index >= 0) {
                                if (tmplist.get(index) instanceof SalariedEmployee) {
                                    salariedEmployee = salariedService.updateBySSN(setOfSsn, ssn);
                                    tmplist.remove(index);
                                    tmplist.add(index, salariedEmployee);
                                } else {
                                    hourlyEmployee = hourlyService.updateBySSN(setOfSsn, ssn);
                                    tmplist.remove(index);
                                    tmplist.add(index, hourlyEmployee);
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    }
                    
                    System.out.print("Enter SSN: ");
                    ssn = sc.nextLine();
                    if (setOfSsn.add(ssn)) {
                        setOfSsn.remove(ssn);
                        System.out.println("SSN does not exist");
                    } else {
                        setOfSsn.remove(ssn);
                        for (String x : listOfDepartment) {
                            listOfEmployee = (Department) department.get(x);
                            tmplist = listOfEmployee.getListOfEmployee();
                            index = eservice.searchBySsn(tmplist, ssn);
                            if (index >= 0) {
                                tmplist.remove(index);
                                System.out.println("Delete successfully");
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    }
                    
                    for (String x : listOfDepartment) {
                        listOfEmployee = (Department) department.get(x);
                        System.out.println("======" + x + "======");
                        System.out.println("Number of employees: "
                                + listOfEmployee.getListOfEmployee().size());
                    }
                    
                    break;
                case 8:
                    if (listOfDepartment.isEmpty()) {
                        System.out.println("Nothing has inputed");
                        break;
                    } else {
                        saveToFile(department, listOfDepartment);
                        System.out.println("File stored at: C:\\FPT\\Java\\HRS");
                        break;
                    }
            }

        } while (userChoice >= 1 && userChoice <= 7);
    }
}

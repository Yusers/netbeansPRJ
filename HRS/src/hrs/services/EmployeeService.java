package hrs.services;

import hrs.entities.Department;
import hrs.entities.Employee;
import hrs.entities.HourlyEmployee;
import hrs.entities.SalariedEmployee;
import hrs.utils.ValidationRules;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {

    String SSN;
    String firstName;
    String lastName;
    String birthDay;
    String phone;
    String email;
    boolean updateBySSN;
    
    // Methods add
    public void add(HashSet set) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        ValidationRules isValid = new ValidationRules();
        // check SSN
        do {
            try {
                if(!updateBySSN) {
                    System.out.println("SSN (unique): ");
                    SSN = sc.nextLine();
                    if(!isValid.checkSSN(SSN, set)) {
                        throw new Exception();
                    }
                } 
                flag = false;
            } catch(Exception e) {
                System.out.println("Duplicated. Enter again!");
            }
        } while(flag);

        // Input FirstName and LastName
        System.out.println("First name: ");
        firstName = sc.nextLine();
        System.out.println("Last name: ");
        lastName = sc.nextLine();
        
        // Check Birth day
        flag = true;
        do {
            try {
                System.out.println("Birth Day e.g: dd/mm/yyyy");
                birthDay = sc.nextLine();
                isValid.checkBirthDay(birthDay);
                flag = false;
            } catch(Exception e) {
                System.out.println("Wrong format try again!!");
            }
        } while(flag);

        // Check Phone
        flag = true;
        do {
            try {
                System.out.println("Phone e.g: more than 7 digits");
                phone = sc.nextLine();
                if(!isValid.checkPhone(phone)) throw new Exception();
                flag = false;
            } catch(Exception e) {
                System.out.println("Wrong format try again!!");
            }
        } while(flag);

        // Check Email
        flag = true;
        do {
            try {
                System.out.println("Email e.g: abc@email.com");
                email = sc.nextLine();
                if(!isValid.checkEmail(email)) throw new Exception();
                flag = false;
            } catch(Exception e) {
                System.out.println("Wrong format try again!!");
            }
        } while(flag);
    }

    public void classifyEmployee(HashMap department, ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (String x : list) {
                Department listOfEmployee = (Department) department.get(x);
                ArrayList tmplist = listOfEmployee.getListOfEmployee();

                System.out.println("======" + x + "======");
                System.out.println("_____Salaried Employee_____");
                for (Object e : tmplist) {
                    if (e instanceof SalariedEmployee) {
                        System.out.println("\n" + e);
                    }
                }

                System.out.println("______Hourly Employee______");
                for (Object e : tmplist) {
                    if (e instanceof HourlyEmployee) {
                        System.out.println("\n" + e);
                    }
                }
            }
        }
        
    }

    public void searchByName(ArrayList<Employee> list, String name) {
        for (Employee x : list) {
            if (x.getFirstName().equals(name)) {
                System.out.println(x);
            }
        }
    }

    public int searchBySsn(ArrayList<Employee> list, String ssn) {
        for (Employee x : list) {
            if (x.getSsn().equals(ssn)) {
                return list.indexOf(x);
            }
        }

        return -1;
    }
}

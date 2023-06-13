package hrs.services;

import hrs.entities.HourlyEmployee;
import hrs.utils.ValidationRules;
import java.util.HashSet;
import java.util.Scanner;

public class HourlyEmployeeService extends EmployeeService {

    public HourlyEmployee addEmployee(HashSet set) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        ValidationRules rule = new ValidationRules();
        HourlyEmployee hourlyEmployee = new HourlyEmployee();

        super.updateBySSN = false;
        super.add(set);
        do {
            try {
                System.out.print("Wage: ");
                double wage = Double.parseDouble(sc.nextLine());
                if (wage < 0) {
                    throw new UnknownError();
                }

                System.out.print("Working hours: ");
                double workingHours = Double.parseDouble(sc.nextLine());
                if (workingHours < 0) {
                    throw new UnknownError();
                }

                flag = false;
                hourlyEmployee.setBirthDay(birthDay);
                hourlyEmployee.setEmail(email);
                hourlyEmployee.setFirstName(firstName);
                hourlyEmployee.setLastName(lastName);
                hourlyEmployee.setPhone(phone);
                hourlyEmployee.setSsn(SSN);
                hourlyEmployee.setWage(wage);
                hourlyEmployee.setWorkingHours(workingHours);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } catch (UnknownError u) {
                System.out.println("Number less than 0 has been entered");
            }
        } while (flag);

        return hourlyEmployee;
    }

    public HourlyEmployee updateBySSN(HashSet set, String ssn) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        ValidationRules isValid = new ValidationRules();
        HourlyEmployee hourlyEmployee = new HourlyEmployee();

        super.SSN = SSN;
        super.updateBySSN = true;
        super.add(set);
        do {
            try {
                System.out.print("Wage: ");
                double wage = Double.parseDouble(sc.nextLine());
                if (wage < 0) {
                    throw new UnknownError();
                }

                System.out.print("Working hours: ");
                double workingHours = Double.parseDouble(sc.nextLine());
                if (workingHours < 0) {
                    throw new UnknownError();
                }

                flag = false;
                hourlyEmployee.setBirthDay(birthDay);
                hourlyEmployee.setEmail(email);
                hourlyEmployee.setFirstName(firstName);
                hourlyEmployee.setLastName(lastName);
                hourlyEmployee.setPhone(phone);
                hourlyEmployee.setSsn(ssn);
                hourlyEmployee.setWage(wage);
                hourlyEmployee.setWorkingHours(workingHours);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } catch (UnknownError u) {
                System.out.println("Number less than 0 has been entered");
            }
        } while (flag);

        return hourlyEmployee;
    }
}

package hrs.services;

import hrs.entities.SalariedEmployee;
import hrs.utils.ValidationRules;
import java.util.HashSet;
import java.util.Scanner;

public class SalariedEmployeeService extends EmployeeService {
    public SalariedEmployee addEmployee(HashSet set) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        ValidationRules isValid = new ValidationRules();
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        super.updateBySSN = false;
        super.add(set);
        do {
            try {
                System.out.print("Commission rate: ");
                double commissionRate = Double.parseDouble(sc.nextLine());
                if (commissionRate < 0) {
                    throw new UnknownError();
                }

                System.out.print("Gross sales: ");
                double grossSales = Double.parseDouble(sc.nextLine());
                if (grossSales < 0) {
                    throw new UnknownError();
                }

                System.out.print("Basic salary: ");
                double basicSalary = Double.parseDouble(sc.nextLine());
                if (basicSalary < 0) {
                    throw new UnknownError();
                }

                flag = false;
                salariedEmployee = new SalariedEmployee(SSN, firstName, lastName, commissionRate, grossSales, basicSalary);
                salariedEmployee.setSsn(SSN);
                salariedEmployee.setFirstName(firstName);
                salariedEmployee.setLastName(lastName);
                salariedEmployee.setCommissionRate(commissionRate);
                salariedEmployee.setGrossSales(grossSales);
                salariedEmployee.setBasicSalary(basicSalary);
                salariedEmployee.setBirthDay(birthDay);
                salariedEmployee.setEmail(email);
                salariedEmployee.setPhone(phone);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } catch (UnknownError u) {
                System.out.println("Number less than 0 has been entered");
            }
        } while(flag);
        return salariedEmployee;
    }
    
    public SalariedEmployee updateBySSN(HashSet set, String ssn) {
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        ValidationRules rule = new ValidationRules();
        SalariedEmployee s = new SalariedEmployee();

        super.SSN = ssn;
        super.updateBySSN = true;
        super.add(set);
        do {
            try {
                System.out.print("Commission rate: ");
                double commissionRate = Double.parseDouble(sc.nextLine());
                if (commissionRate < 0) {
                    throw new UnknownError();
                }

                System.out.print("Gross sales: ");
                double grossSales = Double.parseDouble(sc.nextLine());
                if (grossSales < 0) {
                    throw new UnknownError();
                }

                System.out.print("Basic salary: ");
                double basicSalary = Double.parseDouble(sc.nextLine());
                if (basicSalary < 0) {
                    throw new UnknownError();
                }

                cont = false;
                s.setBasicSalary(basicSalary);
                s.setBirthDay(birthDay);
                s.setCommissionRate(commissionRate);
                s.setEmail(email);
                s.setFirstName(firstName);
                s.setGrossSales(grossSales);
                s.setLastName(lastName);
                s.setPhone(phone);
                s.setSsn(ssn);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } catch (UnknownError u) {
                System.out.println("Number less than 0 has been entered");
            }
        } while (cont == true);

        return s;
    }
}

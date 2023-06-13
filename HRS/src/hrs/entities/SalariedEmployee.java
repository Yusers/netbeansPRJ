 package hrs.entities;

public class SalariedEmployee extends Employee {

    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    // Object constructors
    public SalariedEmployee() {};

    public SalariedEmployee(String ssn, String firstName, String lastName, double commissionRate, double grossSales,
    double basicSalary) {
        super(ssn, firstName, lastName);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n         " + "commissionRate="
                + commissionRate + ", grossSales=" + grossSales
                + ", basicSalary=" + basicSalary + '}';
    }
}

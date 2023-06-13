 package hrs.entities;

public class HourlyEmployee extends Employee {

    private double wage;
    private double workingHours;

    public double getWage() {
        return wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return super.toString() + "\n         " + "wage=" + wage
                + ", workingHours=" + workingHours + '}';
    }
}

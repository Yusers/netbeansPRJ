package hrs.entities;

import java.util.ArrayList;

public class Department {

    private final String departmentName;
    private ArrayList listOfEmployee = new ArrayList();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public void display() {
        for (int i = 0; i < listOfEmployee.size(); i++) {
            System.out.println(listOfEmployee.get(i));
        }
    }
}

package hrs.services;

import hrs.entities.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

    public void orderByName(ArrayList list) {
        Collections.sort(list, new SortByName());
    }
}

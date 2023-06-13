package hrs.services;

import hrs.entities.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortBySSN implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSsn().compareTo(o2.getSsn());
    }

    public void orderBySSN(ArrayList list) {
        Collections.sort(list, new SortBySSN());
    }
}

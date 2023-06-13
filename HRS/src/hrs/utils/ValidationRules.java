package hrs.utils;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class ValidationRules {

    public void checkBirthDay(String birthDay) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        dateFormat.parse(birthDay);
    }

    public boolean checkPhone(String phone) {
        return phone.matches("\\d{7,}");
    }

    public boolean checkEmail(String email) {
        String pattern = "^.{1,}[@].{1,}[.].{1,}$";
        return (email.matches(pattern));
    }

    public boolean checkSSN(String ssn, HashSet<String> set) {
        return set.add(ssn);
    }
}

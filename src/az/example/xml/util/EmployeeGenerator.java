package az.example.xml.util;

import az.example.xml.model.*;

import java.math.*;
import java.util.*;

public class EmployeeGenerator {

    private static List<String> names = new ArrayList<>();
    private static List<String> surnames = new ArrayList<>();


    static {
        names.add("Elshan");
        names.add("Fariz");
        names.add("Rashad");
        names.add("Hafiz");
        names.add("Cavid");
        names.add("Memmed");
        names.add("Azer");
        names.add("Elvin");
        names.add("Tural");
        names.add("Ali");

        surnames.add("Mammadov");
        surnames.add("Hasanov");
        surnames.add("Suleymanov");
        surnames.add("Gasimov");
        surnames.add("Pasayev");
        surnames.add("Qurbanov");
        surnames.add("Veliyev");
        surnames.add("Ramazanov");
        surnames.add("Ferecov");
        surnames.add("Aliyev");
    }

    public static List<Employee> generate(int count) {
        List<Employee> employees = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            employee.setId(i + 1);
            employee.setFirstName(names.get(random.nextInt(names.size())));
            employee.setLastName(surnames.get(random.nextInt(surnames.size())));
            employee.setSalary(BigDecimal.valueOf(2000 + random.nextDouble() * 1000));
            employees.add(employee);
        }

        return employees;
    }

}

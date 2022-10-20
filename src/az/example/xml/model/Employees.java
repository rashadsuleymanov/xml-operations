package az.example.xml.model;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

    @XmlElement(name = "employee")
    private List<Employee> employees;


    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}

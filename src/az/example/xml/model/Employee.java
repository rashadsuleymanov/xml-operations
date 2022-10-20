package az.example.xml.model;

import javax.xml.bind.annotation.*;
import java.math.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlElement
    private long id;

    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "last_name")
    private String lastName;

    @XmlElement
    private BigDecimal salary;


    public Employee() {
        this(0, "", "", BigDecimal.ZERO);
    }

    public Employee(long id, String firstName, String lastName, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

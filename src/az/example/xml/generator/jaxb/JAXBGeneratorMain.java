package az.example.xml.generator.jaxb;

import az.example.xml.model.*;
import az.example.xml.util.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;


public class JAXBGeneratorMain {

    public static void main(String[] args) {

        try {
            List<Employee> employeess = EmployeeGenerator.generate(100);
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            Employees employees = new Employees();
            employees.setEmployees(employeess);
            marshaller.marshal(employees, new FileOutputStream("employees-jaxb.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

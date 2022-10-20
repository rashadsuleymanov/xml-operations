package az.example.xml.parser.jaxb;

import az.example.xml.model.*;

import javax.xml.bind.*;
import java.io.*;

public class JaxbParserMain {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new FileInputStream("employees.xml"));

            System.out.println("Isciler");
            employees.getEmployees().forEach(employee -> System.out.printf("%s %s %s %s\n",
                    employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

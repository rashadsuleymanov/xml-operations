package az.example.xml.generator.dom;

import az.example.xml.model.*;
import az.example.xml.util.*;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.*;

public class DomGeneratorMain {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element employeesElement = document.createElement("employees");

            List<Employee> employees = EmployeeGenerator.generate(10);

            employees.forEach(employee -> {
                Element employeeElement = document.createElement("employee");

                Element idElement = document.createElement("id");
                idElement.setTextContent(String.valueOf(employee.getId()));
                employeeElement.appendChild(idElement);

                Element firstNameElement = document.createElement("first_name");
                firstNameElement.setTextContent(employee.getFirstName());
                employeeElement.appendChild(firstNameElement);

                Element lastNameElement = document.createElement("last_name");
                lastNameElement.setTextContent(employee.getLastName());
                employeeElement.appendChild(lastNameElement);

                Element salaryElement = document.createElement("salary");
                salaryElement.setTextContent(String.valueOf(employee.getSalary()));
                employeeElement.appendChild(salaryElement);


                employeesElement.appendChild(employeeElement);
            });

            document.appendChild(employeesElement);

            //XSLT -Transformation
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //Bu iki setOutputProperty olmasa xml generasiya olunarken yan yana generasiya olunacaq,amma bu iki
            // property-ni active etsek XML seliqeli sekilde generasiya olunacaq.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream("employees-dom.xml")));


        } catch (ParserConfigurationException | FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }
}

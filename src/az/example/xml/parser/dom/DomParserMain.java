package az.example.xml.parser.dom;

import az.example.xml.model.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class DomParserMain {

    public static void main(String[] args) {

        try {
            String file = "employees.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);

            NodeList employeeNodeList = document.getElementsByTagName("employee");

            List<Employee> employees = new ArrayList<>();

            for (int i = 0; i < employeeNodeList.getLength(); i++) {
                Node employeeNode = employeeNodeList.item(i);
                Employee employee = new Employee();
                if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element employeeElement = (Element) employeeNode;

                    String id = employeeElement.getElementsByTagName("id").item(0).getTextContent();
                    employee.setId(Long.parseLong(id));

                    String firstName = employeeElement.getElementsByTagName("first_name").item(0).getTextContent();
                    employee.setFirstName(firstName);

                    String lastName = employeeElement.getElementsByTagName("last_name").item(0).getTextContent();
                    employee.setLastName(lastName);

                    //hansisa employee xml-i icersinde salary olmazsa NullPointer xetasi ata biler.Onun ucun mutleq
                    //check olunmalidir.
                    NodeList salaryNodes = employeeElement.getElementsByTagName("salary");
                    if (salaryNodes.getLength() > 0) {
                        String salary = employeeElement.getElementsByTagName("salary").item(0).getTextContent();
                        employee.setSalary(new BigDecimal(salary));
                    }

                    employees.add(employee);
                }
            }

            System.out.println("Isciler");
            employees.forEach(employee -> System.out.printf("%s %s %s %s\n",
                    employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }
}

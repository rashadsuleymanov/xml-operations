package az.example.xml.parser.sax;

import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;

public class SaxParserMain {

    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            EmployeeSAXHandler handler = new EmployeeSAXHandler();
            String xml = "employees.xml";
            parser.parse(xml, handler);

            handler.getEmployees().forEach(employee -> System.out.printf("%s %s %s %s\n",
                    employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

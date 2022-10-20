package az.example.xml.generator.stax;

import az.example.xml.model.*;
import az.example.xml.util.*;

import javax.xml.stream.*;
import java.io.*;
import java.util.*;

public class StaxGeneratorMain {

    public static void main(String[] args) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("employees-stax.xml"));

            List<Employee> employees = EmployeeGenerator.generate(100);

            writer.writeStartDocument();

            writer.writeStartElement("employees");

            employees.forEach(employee -> {
                try {
                    writer.writeStartElement("employee");

                    writer.writeStartElement("id");
                    writer.writeCharacters(String.valueOf(employee.getId()));
                    writer.writeEndElement();

                    writer.writeStartElement("first_name");
                    writer.writeCharacters(String.valueOf(employee.getFirstName()));
                    writer.writeEndElement();

                    writer.writeStartElement("last_name");
                    writer.writeCharacters(String.valueOf(employee.getLastName()));
                    writer.writeEndElement();

                    writer.writeStartElement("salary");
                    writer.writeCharacters(String.valueOf(employee.getSalary()));
                    writer.writeEndElement();

                    writer.writeEndElement();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            });

            writer.writeEndElement();

            writer.writeEndDocument();

            writer.close();

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

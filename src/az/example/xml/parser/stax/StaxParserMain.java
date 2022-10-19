package az.example.xml.parser.stax;

import az.example.xml.model.*;

import javax.xml.stream.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class StaxParserMain {

    public static void main(String[] args) {

        try {
            String xml = "employees.xml";
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(xml));

            List<Employee> employees = new ArrayList<>();
            Employee temp = null;
            Map<String, Boolean> map = new HashMap<>();
            map.put("employee", false);
            map.put("id", false);
            map.put("first_name", false);
            map.put("last_name", false);
            map.put("salary", false);

            while (reader.hasNext()) {

                int eventType = reader.getEventType();

                //bu SAX-daki startDocument metodudur.
                if (eventType == XMLStreamConstants.START_DOCUMENT) {
                    System.out.println("senedi oxumaga basladiq!");

                    //SAX-daki endDocument metodudur.
                } else if (eventType == XMLStreamConstants.END_DOCUMENT) {
                    System.out.println("senedi oxuyub bitirdik!");

                    //SAX-daki startElement metodudur.
                } else if (eventType == XMLStreamConstants.START_ELEMENT) {
                    String element = reader.getLocalName();
                    System.out.println("start element: " + element);
                    map.put(element, true);

                    if (map.get("employee") && temp == null) {
                        temp = new Employee();
                    }

                    //SAX-daki endElement metodudur.
                } else if (eventType == XMLStreamConstants.END_ELEMENT) {
                    String element = reader.getLocalName();
                    System.out.println("end element: " + element);
                    map.put(element, false);

                    if (element.equals("employee")) {
                        employees.add(temp);
                        temp = null;
                        System.out.println("Yeni isci elave olundu");
                        System.out.println(employees);
                    }

                    //SAX-daki characters metodudur.
                } else if (eventType == XMLStreamConstants.CHARACTERS) {
                    String data = reader.getText();
                    if (map.get("id")) {
                        temp.setId(Long.parseLong(data));
                    } else if (map.get("first_name")) {
                        temp.setFirstName(data);
                    } else if (map.get("last_name")) {
                        temp.setLastName(data);
                    } else if (map.get("salary")) {
                        temp.setSalary(new BigDecimal(data));
                    }
                }

                //bu metodu cagirmaq mutleqdir! Cunki, novbeti event-a kece bilmeyimiz ucun.
                reader.next();
            }
            System.out.println("Isciler");
            employees.forEach(employee -> System.out.printf("%s %s %s %s\n",
                    employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

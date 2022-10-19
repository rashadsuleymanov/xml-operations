package az.example.xml.parser.sax;

import az.example.xml.model.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.math.*;
import java.util.*;

public class EmployeeSAXHandler extends DefaultHandler {


    private List<Employee> employees;
    private Employee temp;
    private boolean isEmployee;
    private boolean isId;
    private boolean isFirstName;
    private boolean isLastName;
    private boolean isSalary;


    public EmployeeSAXHandler() {
        super();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    //start document XML senedini oxuyarken birinci bu metodu cagirir.
    @Override
    public void startDocument() throws SAXException {
        // super.startDocument();
        // System.out.println("XML senedi oxumaga basladi");
        this.employees = new ArrayList<>();
    }

    //end document XML senedini oxuyub bitirerken bu metodu cagirir.
    @Override
    public void endDocument() throws SAXException {
        //  super.endDocument();
        // System.out.println("XML senedi oxuyub bitirdik");
    }

    //yeni element oxumaga basliyanda bu metodu cagirir
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // super.startElement(uri, localName, qName, attributes);
        // System.out.println(qName + " elementini oxumaga basladi");

        if (qName.equals("employee")) {
            temp = new Employee();
            isEmployee = true;
        } else if (qName.equals("id")) {
            isId = true;
        } else if (qName.equals("first_name")) {
            isFirstName = true;
        } else if (qName.equals("last_name")) {
            isLastName = true;
        } else if (qName.equals("salary")) {
            isSalary = true;
        }
    }

    //hemin elementi oxuyub bitirende bu metodu cagirir.
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // super.endElement(uri, localName, qName);
        // System.out.println(qName + " elementini oxuduq bitirdik");

        if (qName.equals("employee")) {
            this.employees.add(temp);
            temp = null;
            System.out.println("Yeni isci elave olundu");
            System.out.println(employees);
        } else if (qName.equals("id")) {
            isId = false;
        } else if (qName.equals("first_name")) {
            isFirstName = false;
        } else if (qName.equals("last_name")) {
            isLastName = false;
        } else if (qName.equals("salary")) {
            isSalary = false;
        }
    }

    //bosluq goren kimi ve ya elementin datasini goren kimi bu metodu cagirir.Oxuyub bitiren kimi elementin datasini
    //oturur.
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // super.characters(ch, start, length);

        //startElement() metodu elementi oxuduqca bu metoda muraciet edecek
        String data = new String(ch, start, length);
        // System.out.println("oxudugumuz elementin datasi = " + data);

        if (isId) {
            temp.setId(Long.parseLong(data));
        } else if (isFirstName) {
            temp.setFirstName(data);
        } else if (isLastName) {
            temp.setLastName(data);
        } else if (isSalary) {
            temp.setSalary(new BigDecimal(data));
        }

    }
}

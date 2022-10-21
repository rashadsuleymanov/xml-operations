package az.example.xml.validator;

import org.xml.sax.*;

import javax.xml.*;
import javax.xml.transform.stream.*;
import javax.xml.validation.*;
import java.io.*;

public class XsdValidator {

    public static void main(String[] args) {
        //XML senedi
        //XSD qaydalari

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("employees.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new FileInputStream("employees-jaxb.xml")));
            System.out.println("XML validation successfuly!");

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

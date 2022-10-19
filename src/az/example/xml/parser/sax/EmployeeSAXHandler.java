package az.example.xml.parser.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class EmployeeSAXHandler extends DefaultHandler {

    public EmployeeSAXHandler() {
        super();
    }

    //start document XML senedini oxuyarken birinci bu metodu cagirir.
    @Override
    public void startDocument() throws SAXException {
        // super.startDocument();
        System.out.println("XML senedi oxumaga basladi");
    }

    //end document XML senedini oxuyub bitirerken bu metodu cagirir.
    @Override
    public void endDocument() throws SAXException {
        //  super.endDocument();
        System.out.println("XML senedi oxuyub bitirdik");
    }

    //yeni element oxumaga basliyanda bu metodu cagirir
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // super.startElement(uri, localName, qName, attributes);
        System.out.println(qName + " elementini oxumaga basladi");
    }

    //hemin elementi oxuyub bitirende bu metodu cagirir.
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // super.endElement(uri, localName, qName);
        System.out.println(qName + " elementini oxuduq bitirdik");
    }

    //bosluq goren kimi ve ya elementin datasini goren kimi bu metodu cagirir.Oxuyub bitiren kimi elementin datasini
    //oturur.
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // super.characters(ch, start, length);

        //startElement() metodu elementi oxuduqca bu metoda muraciet edecek
        String data = new String(ch, start, length);
        System.out.println("oxudugumuz elementin datasi = " + data);
    }
}

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by jeril on 2014/08/04.
 */
public class Xml2Java {

    public static void main(String[] args) {

        try {
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setContentHandler(new CatalogContentHandler());
            try {
                xmlreader.parse("cat.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < CatalogContentHandler.list.size(); i++) {
            if (CatalogContentHandler.list.get(i) instanceof Asset) {
                System.err.println("" + CatalogContentHandler.list.get(i).toString());
            }
        }

    }
}

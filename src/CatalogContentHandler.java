import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;

/**
 * Created by jeril on 2014/08/04.
 */
public class CatalogContentHandler implements ContentHandler {

    public static ArrayList list = new ArrayList();
    private Asset asset = new Asset();

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        System.err.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.err.println("endDocument");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    boolean startCapture = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        System.err.println("startElement");
        System.err.println("localName       " + localName);
        if (localName.equals("Asset")) {
            startCapture = true;
        }

        if (startCapture) {

            if (localName.equals("AMS")) {
                for (int i = 0; i < atts.getLength(); i++) {
                    System.err.println("atts  " + i + atts.getLocalName(i));
                    if (atts.getLocalName(i).equals("Asset_Class") && (atts.getValue("Asset_Class").equals("package"))){
                        System.err.println("Package");

                        for (int j=0;j<atts.getLength();j++)
                        {
                            if (atts.getLocalName(j).equals("Asset_ID"))
                            {
                                asset.setAsset_ID(atts.getValue(atts.getLocalName(j)));
                                break;
                            }
                        }
                    }
                    else if (atts.getLocalName(i).equals("Asset_Class") && atts.getValue("Asset_Class").equals("poster"))
                    {
                        System.err.println("Poster");
                        for (int j=0;j<atts.getLength();j++)
                        {
                            if (atts.getLocalName(j).equals("Asset_ID"))
                            {
                                asset.setPosterId(atts.getValue(atts.getLocalName(j)));
                                break;
                            }
                        }
                    }
                }
            }
            if (localName.equals("App_Data"))
            {
                for (int j=0;j<atts.getLength();j++)
                {
                    if (atts.getLocalName(j).equals("Name") && atts.getValue("Name").equals("Title"))
                    {
                        asset.setTitle(atts.getValue(atts.getLocalName(j+1)));
                        break;
                    }
                    else if (atts.getLocalName(j).equals("Name") && atts.getValue("Name").equals("URL"))
                    {
                        asset.setPosterUrl(atts.getValue(atts.getLocalName(j+1)));
                        break;
                    }
                }
            }




        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        System.err.println("end Element"+ localName);
        if (localName.equals("Asset")) {
            startCapture = false;
            if (asset.getAsset_ID()!= null)
            {
                try {
                    list.add(asset.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                asset =new Asset();
            }

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}

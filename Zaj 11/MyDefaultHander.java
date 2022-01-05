import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHander extends DefaultHandler {
    @Override
    public void characters(char[] ch, int start, int length){
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        System.out.print("<" + qName);
        for (int i = 0; i < attributes.getLength(); i++){
            if (i==0) {
                System.out.print(" ");
            }
            System.out.print(attributes.getQName(i) + "=\"");
            System.out.print(attributes.getValue(i) + "\"");
        }
        System.out.print(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        System.out.print("<" + qName + ">");
    }
}

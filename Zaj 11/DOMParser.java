import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder  = factory.newDocumentBuilder();
        FileInputStream fis = new FileInputStream("en.xml");
        Document doc = builder.parse(fis);
        Node n = doc.getDocumentElement().getChildNodes().item(1);
        NodeList nl = n.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++){
            System.out.println(nl.item(i).getNodeName());
        }

    }
}

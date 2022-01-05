import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        FileInputStream fis = new FileInputStream("en.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(fis, new MyDefaultHander());
        

    }
}

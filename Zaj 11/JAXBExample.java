import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
    public static void main(String[] args) throws JAXBException{
        Student s1, s2, s3;
        s1 = new Student();
        s1.setId(1); s1.setName("Alicja");
        s2 = new Student();
        s2.setId(2); s2.setName("Barbara");

        File f = new File("Alicja.xml");
        JAXBContext ctx = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(s1, System.out);
        marshaller.marshal(s2, f);

        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        s3 = (Student)unmarshaller.unmarshal(f);
        marshaller.marshal(s3, System.out);
    }
}

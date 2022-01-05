import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    String name;
    int id;

    @XmlElement
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    @XmlElement
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}

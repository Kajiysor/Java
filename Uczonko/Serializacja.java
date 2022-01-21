import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializacja implements Serializable {
    public int i;
    public String str;

    public Serializacja(int i, String str){
        this.i = i;
        this.str = str;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Serializacja ser1 = new Serializacja(7, "Ala");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output_object"));
        oos.writeObject(ser1);
        oos.close();
    }
}

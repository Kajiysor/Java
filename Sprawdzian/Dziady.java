import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;

public class Dziady{
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> tekst = new ArrayList<String>();
        FileInputStream fis = new FileInputStream("Improwizacja.ArrayList.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        tekst = (ArrayList) ois.readObject();
        ois.close();
        fis.close();

        Collections.sort(tekst, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }
        
            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        
        System.out.println(tekst);

        FileWriter writer = new FileWriter("output.txt"); 
        for(String str: tekst) {
        writer.write(str + System.lineSeparator());
        }
        writer.close();
    }


}

/// Źródła: https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
///         https://stackoverflow.com/questions/13973503/sorting-strings-that-contains-number-in-java
///         https://beginnersbook.com/2013/12/how-to-serialize-arraylist-in-java/

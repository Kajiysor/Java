import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Wyjatki {
    public static void main(String[] args) throws IOException{
        String s;
        //s = args[0];
        //System.out.println(s);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("mojplik.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Niestety nie ma pliku");
            //return;
            System.exit(0);
        } finally {
            System.out.println("finally");
        }
        System.out.println("dalej...");
        
        int i;
        while ((i=fis.read()) != -1){
            System.out.print(i);
        }
    }
    
}

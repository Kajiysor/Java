import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void encrypt() throws IOException{
        FileReader fr = new FileReader("HelloWorld.txt");
        OutputCesarCipher occ = new OutputCesarCipher(new FileWriter("mojplik_encrypted.txt"), 3);
        int c;
        while ((c = fr.read()) != -1){
            occ.write(c);
        }
        occ.close();
        fr.close();
    }
    public static void decrypt() throws IOException{
        InputCesarCipher occ = new InputCesarCipher(new FileReader("mojplik_encrypted.txt"), 3);
        FileWriter fw = new FileWriter("mojplik_decrypted.txt");
        int c;
        while ((c = occ.read()) != -1){
            fw.write(c);
        }
        occ.close();
        fw.close();
    }

    public static void loading() throws InterruptedException{
        for (int i = 0; i < 20; i++){
            Thread.sleep(100);
            System.out.print("=");
        }
        System.out.println("");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Encrypting file");
        encrypt();
        loading();
        System.out.println("Decrypting file");
        decrypt();
        loading();
    }
}

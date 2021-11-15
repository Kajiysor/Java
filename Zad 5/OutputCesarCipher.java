import java.io.FileWriter;
import java.io.IOException;

public class OutputCesarCipher {
    int offset;
    FileWriter output;

    public OutputCesarCipher(FileWriter out, int off){
        offset = off;
        output = out;
    }

    public void write(int c) throws IOException{
        offset = offset % 26 + 26;
        if (Character.isLetter((char) c)){
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            output.write(base + (c - base + offset) % 26);
        }
        else{
            output.write(c);
        }
    }
    public void close() throws IOException{
        output.close();
    }

}

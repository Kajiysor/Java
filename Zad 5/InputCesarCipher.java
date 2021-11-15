import java.io.FileReader;
import java.io.IOException;

public class InputCesarCipher {
    int offset;
    FileReader input;

    public InputCesarCipher(FileReader in, int off){
        offset = 26-off;
        input = in;
    }

    public int read() throws IOException{
        int c = input.read();
        offset = offset % 26 + 26;
        if (Character.isLetter((char) c)){
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            c = (base + (c - base + offset) % 26);
        }
        return c;

    }
    public void close() throws IOException{
        input.close();
    }
}

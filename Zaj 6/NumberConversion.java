import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class NumberConversion extends Writer {

    private Writer writer;
    private int base;
    private int number;

    public NumberConversion(Writer w, int b){
        this.writer = w;
        this.base = b;
    }

    private char[] convert(int number){
        return Integer.toString(number, this.base).toCharArray();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off+len; i++){
            char c = cbuf[i];
            if (Character.isDigit(c)){
                number = 10*number + Character.digit(c, 10);
            }
            else{
                if (number != 0){
                    char[] cNumber = this.convert(number);
                    this.writer.write(cNumber, 0, cNumber.length);
                    this.number = 0;
                }
                this.writer.write(c);
            }
        }
        
    }

    @Override
    public void flush() throws IOException {
        this.writer.flush();
        
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
        
    }

    public static void main(String[] args) throws IOException {
        String s = "Ala 123 cos 12 tralala";
        NumberConversion nc = new NumberConversion(new PrintWriter(System.out), 2);
        nc.write(s.toCharArray());
        nc.close();
    }
    

}
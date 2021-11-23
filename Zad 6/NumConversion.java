import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class NumConversion extends Writer {

    private Writer writer;
    private int from_base;
    private int to_base;
    private int number;
    private int read_number;

    public NumConversion(Writer w, int from_base, int to_base){
        this.writer = w;
        this.from_base = from_base;
        this.to_base = to_base;
        if (this.from_base < 2 || this.from_base > 10 || this.to_base < 2 || this.to_base > 10){
            System.out.println("The bases need to be in range [2, 10]");
            System.exit(-2);
        }
    }

    private char[] convert(int number){
        return Integer.toString(Integer.parseInt(Integer.toString(number), this.from_base), this.to_base).toCharArray();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off+len; i++){
            char c = cbuf[i];
            if (Character.isDigit(c)){
                read_number = Character.digit(c, from_base);
                if (read_number < 0 && number != 0){ // Przypadek kiedy zly numer jest w srodku liczby
                    char[] cNumber = this.convert(number);
                    this.writer.write(cNumber, 0, cNumber.length);
                    this.number = 0;
                    this.writer.write(c);
                }
                else if (read_number < 0 && number == 0){ // Przypadek kiedy zly numer jest na poczatku liczby
                    this.writer.write(c);
                }
                else if(i == off+len-1){ // Przypadek kiedy dojdziemy do konca tekstu
                    number = 10*number + read_number;
                    char[] cNumber = this.convert(number);
                    this.writer.write(cNumber, 0, cNumber.length);
                    this.number = 0;
                }
                else{
                    number = 10*number + read_number; // Przpadek kiedy system liczby sie zgadza
                }
            }
            else{ // Przypadek kiedy dojdziemy do nowego wyrazu
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
        String s = "Ala 11210 ma 101 słonia 3310111";
        NumConversion nc = new NumConversion(new PrintWriter(System.out), 2, 10);
        nc.write(s.toCharArray());
        nc.close();
    }
    

}

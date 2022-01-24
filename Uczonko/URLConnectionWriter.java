import java.io.*;
import java.net.*;
public class URLConnectionWriter {
public static void main(String[] args) throws Exception { URL url = new URL("http://www.google.pl/");
    URLConnection con = url.openConnection(); con.setDoOutput(true);
    OutputStreamWriter out = new OutputStreamWriter( con.getOutputStream());
            for (int i = 1; i < 2; i++)
                out.write("http://www.google.pl/");
            out.close();
        }
}
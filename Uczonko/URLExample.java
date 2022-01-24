import java.net.*;
import java.io.*;
public class URLExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.google.pl/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String s;
        while ((s = in.readLine()) != null)
            System.out.println(s); in.close();
    }
}
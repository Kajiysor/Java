import java.net.*;
import java.io.*;
public class URLConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.google.pl/");
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String s;
        while ((s = in.readLine()) != null)
            System.out.println(s); in.close();
    } 
}
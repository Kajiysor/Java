import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Procesy {
    public static void main(String[] args) {
        try {
            String s;
            Process ps = Runtime.getRuntime().exec("ls -l");
            BufferedReader bri = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
            while ((s = bri.readLine()) != null)
                System.out.println(s + " bri");
            bri.close();
            while ((s = bre.readLine()) != null)
                System.out.println(s + " bre");
            bre.close();
            ps.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gotowe.");
    }
}

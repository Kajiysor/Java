import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.*;

public class BobBudowniczyProcesu {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder("ls", "-l");
        builder.directory(new File("."));
        builder.redirectErrorStream(true);
        builder.redirectOutput(Redirect.INHERIT);
        Process ps;
        try {
            ps = builder.start();
            ps.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gotowe.");

    }
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class WriteFile {
	
	public static void store() throws IOException {
		FileOutputStream fos = new FileOutputStream("mojplik.txt");
		fos.write("Hello".getBytes());
		fos.close();
		
	}
	
	public static void restore() throws IOException {
		FileInputStream fis = new FileInputStream("mojplik.txt");
		int c;
		while((c = fis.read())!=-1){
      System.out.print((char)c);
		}
		fis.close();
	}
    public static void restore_fr() throws IOException {
		FileReader fr = new FileReader("mojplik.txt");
		int c;
		while((c = fr.read())!=-1){
			System.out.print((char)c);
		}
		fr.close();
	}
    public static void restore_br() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mojplik.txt"));
		String s;
		while((s = br.readLine())!=null){
			System.out.print(s);
		}
		br.close();
	}

    public static void restore_isr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mojplik.txt")));
		String s;
		while((s = br.readLine())!=null){
			System.out.print(s);
		}
		br.close();
	}
    public static void compress() throws IOException {
		FileInputStream fis = new FileInputStream("mojplik.txt");
		GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream("mojplik.gz"));
		int c;
		while((c=fis.read())!=-1) {
			gos.write(c);
		}
		fis.close();
		gos.close();
	}
    public static void decompress() throws IOException {
		GZIPInputStream gis = new GZIPInputStream(new FileInputStream("mojplik.gz"));
		int c;
		while ((c=gis.read())!=-1) {
			System.out.print((char)c);
		}
        gis.close();
	}
	
	public static void main(String[] args) throws IOException {
		// store();
		// restore();
        // System.out.println("");
        // restore_fr();
        // System.out.println("");
        // restore_br();
        // System.out.println("");
        // restore_isr();
        compress();
        decompress();
	}

}


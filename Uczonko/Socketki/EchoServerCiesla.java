package Socketki;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerCiesla {
	
	
	
	public static void acceptAndServe(Socket s) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					int c;
					while((c=is.read())!=-1) {
						os.write(c);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Disconnected with " + s.getInetAddress());
				}
			}
		});
		t.start();
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
		while(true) {
			Socket s = ss.accept();
			System.out.println("Connected with " + s.getInetAddress());
			acceptAndServe(s);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

public class MathServer {

	public static void main(String args[]) throws IOException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final int portNumber = 8001;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
            pw.println("Wprowadź nazwy funkcji, na których wykonać obliczenia");
            pw.println("Aby wykonań obliczenia na danej wartości, wpisz x={wartosc}");
			pw.println("Czekam na funkcje do wykonania...");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String str = "";
            Method m;
            Object wynik = null;
            double x = 0;
            List<Method> methods = new ArrayList<Method>();
            List<String> methods_names = new ArrayList<String>();
            Hashtable<String, Method> ht = new Hashtable<>();
            Hashtable<String, String> ht2 = new Hashtable<>();
            
            while (!(str.startsWith("x="))){
                try{
                    str = br.readLine();
                    m = Class.forName("java.lang.Math").getDeclaredMethod(str, double.class);
                    methods.add(m);
                    methods_names.add(str);
                    ht.put(str, m);
                    pw.println("Dzialanie: " + str);
                }
                catch (NoSuchMethodException e){
                    if (!(str.startsWith("x="))){
                        pw.println("Niepoprawna nazwa funkcji! - " + str);
                    }
                }
                finally{
                }
            }

            x = Double.parseDouble(str.split("=")[1]);
            for (Method method : methods){
                wynik = method.invoke(null, x);
                pw.println("Wynik: " + wynik);
            }
            // pw.println(ht.values());
            // for (Method method : ht.values()){
            //     wynik = method.invoke(null, x);
            //     String wynik2 = "(" + wynik + ")"; 
            //     ht2.put("Wynik", wynik2);
            // }
            // ht.entrySet().forEach(entry -> {
            //     ht2.put()
            // });

            // ht2.entrySet().forEach( entry -> {
            //     pw.println( entry.getKey() + "->" + entry.getValue() );
            // });
			// pw.println("Hello, " + wynik);
			pw.close();
			socket.close();

			System.out.println("Wlasnie wykonano dzialanie: " + str);
		}
	}
}
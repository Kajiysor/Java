package pl2.edu.uj.javaframe;

import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EchoServer {
    private static final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        System.out.println("(zajete miejsce na serwerze/ilosc wszystkich miejsc)");
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.print("Przychodzi nowy klient, ilosc miejsc: ");
                ClientHandler clSocket = new ClientHandler(clientSocket);
                System.out.println(executor.getActiveCount() + "/" + executor.getMaximumPoolSize());
                executor.submit(new Thread(clSocket));
            } catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
            }
        }
    }
}

package pl2.edu.uj.javaframe;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private final Socket clientSocket;

    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    public void run()
    {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("ID" + this.getId() + " Sent from the client: " + line);
                String[] interval = line.split(" ");
                ArrayList<Integer> primes = new ArrayList<Integer>();
                for (int i = Integer.parseInt(interval[0]); i <= Integer.parseInt(interval[1]); i++) {
                    if (i == 1 || i == 0)
                        continue;
                    int flag = 1;
                    for (int j = 2; j <= i / 2; ++j) {
                        if (i % j == 0) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1)
                        primes.add(i);
                }
                //String message = "";
                //for(int prime : primes)
                //    message += prime + " ";
                System.out.println("ID" + this.getId() + " Sending " + primes.size() + " primes");
                out.println("Amount of primes =  " + primes.size());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientSocket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
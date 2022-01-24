package pl.edu.uj.javaframe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("I got a message: " + inputLine);
            String parts[] = inputLine.split(" ");
            String outcome = "Error";
            try {
                double first = Double.parseDouble(parts[0]);
                double second = Double.parseDouble(parts[2]);
                if(parts.length != 3) throw new Exception();
                switch (parts[1]) {
                    case "+":
                        outcome = Double.toString(first + second);
                        break;
                    case "-":
                        outcome = Double.toString(first - second);
                        break;
                    case "*":
                        outcome = Double.toString(first * second);
                        break;
                    case "/":
                        outcome = Double.toString(first / second);
                        break;
                    default:
                        outcome = "No operator (+-*/) found";
                        break;
                }
            } catch (Exception e) {
                outcome = "Couldn't evaluate";
            } finally {
                System.out.println("Outcome = " + outcome);
                out.println("Outcome = " + outcome);
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}

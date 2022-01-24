package Socketki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {

	public static void sendToAll(Socket s, String sText) throws IOException {
		for (Socket other : clientsSet) {
			(new PrintStream(other.getOutputStream())).println(sText);
		}
	}

	public static void acceptAndServe(Socket s) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				String sName = "NULL";
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println("What is your nickname?");
					String sText = br.readLine();
					sName = sText;
					ps.println("Hello " + sName + " you can strart chat now");
					System.out.println("Connected with " + s.getInetAddress() + "[" + sName + "]");
					sendToAll(s, sName + "[" + s.getInetAddress() + "] has joined to the chat");

					while ((sText = br.readLine()) != null) {
						sendToAll(s, "[" + sName + "] " + sText);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Disconnected with " + s.getInetAddress() + "[" + sName + "]");
					clientsSet.remove(s);
				}
			}
		});
		t.start();
	}

	public static void controlService() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String sCommand;
					while ((sCommand = br.readLine()) != null) {
						if (sCommand.startsWith("kick")) {
							String sIP = sCommand.substring(4, sCommand.length()).trim();
							for (Socket s : clientsSet) {
								if (s.getInetAddress().toString().endsWith(sIP)) {
									(new PrintStream(s.getOutputStream()))
											.println("Sorry, you have been kicked out :)");
									s.close();
									clientsSet.remove(s);
								}

							}
						}
					}
				} catch (IOException ex) {
					// do nothing
				}

			}

		});
		t.start();
	}

	static HashSet<Socket> clientsSet = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
		controlService();
		while (true) {
			Socket s = ss.accept();
			clientsSet.add(s);
			acceptAndServe(s);
		}
	}
}
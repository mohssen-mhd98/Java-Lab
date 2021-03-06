package multiClient.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static Boolean onServer = true;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new ServerHandler());
        int count = 0;
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.print("Server started.\nWaiting for a client ... \n");
            //Assume only 3 clients are acceptable
            while (Main.onServer) {
                Socket connectionSocket = server.accept();
                count++;
                System.out.println("client" + count + " accepted!");
                pool.execute(new ClientHandler(connectionSocket, count));
            }
            pool.shutdown();
            System.out.print("Closing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.\n");
    }

}

class ServerHandler implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Enter 'done' to turn off server.");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            if (cmd.equals("done")) {
                Main.onServer = false;
                break;
            }
        }
        System.out.println("Server gonna be off.");
    }
}

class ClientHandler implements Runnable {

    private Socket connectionSocket;
    private int clientNum;
    public ClientHandler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum=clientNum;
    }
    @Override
    public void run() {
        try {
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];
            String response = "";
            while (true){

                int read = in.read(buffer);
                System.out.println("RECV"+ clientNum + ": " + new String(buffer, 0, read));
                String temp = new String(buffer,0,read);
                if(temp.equals("over")){
                    break;
                }
                response += temp;
                out.write(response.getBytes());
                System.out.println("SENT to " + clientNum + ": " + response);
                //Thread.sleep(2000);
            }
            System.out.print("All messages sent successfully.\nClosing client " + clientNum + "\n ");
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
    Java program to create a simple HTTP Server that servers client HTTP requests with the current date
    @author Joel Lijo Mathew
 */

public class HTTPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server Started...");
        System.out.println("Listening for connection on port 5000...");
        while(true){
            try(Socket clientSocket = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));

                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }

            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
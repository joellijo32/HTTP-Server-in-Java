import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {

    public static void main(String[] args) throws Exception {
        final ServerSocket server = new ServerSocket(5000);
        System.out.println("Server Started...");
        System.out.println("Listening for connection on port 5000...");
        while(true){
            final Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while(!line.isEmpty()){
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }

}
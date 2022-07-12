import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class HotelServer {
   public HotelServer() throws IOException {
        try (ServerSocket server = new ServerSocket(3030)) {
            System.out.println("Server running on port:3030...");
            Socket conn = server.accept();
            DataInputStream fromClient = new DataInputStream(conn.getInputStream());
            DataOutputStream toClient = new DataOutputStream(conn.getOutputStream());
            if (conn.isConnected() == true) {
                System.out.println("Server connected to client....");
            } 
            while (true) {
            conn.setKeepAlive(true);

            //  send the message to client
                toClient.writeUTF("Hello from server");
            // receive data from toClient
               String clientMsg = fromClient.readUTF();
            System.out.println("Server logs: "+clientMsg);
            }
        }
        
   }
    public static void main(String[] args) {
        try {
            new HotelServer();
        } catch (IOException e) {
               JOptionPane.showMessageDialog(null, "Server exeption : "+ e.getMessage());
        }
    }
}

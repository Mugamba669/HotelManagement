import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.Delayed;

public class UDPClient {
    static DatagramSocket client = null;
    public static void main(String[] args) {
        // initialse udp client
        try  {
            InetAddress host = InetAddress.getByName(args[1]);
            byte[] message = args[0].getBytes();

            client  = new DatagramSocket();
            while(true){
            // send request to serverSocket
            DatagramPacket request  = new DatagramPacket(message,message.length, host, 2020);
            // System.out.println("Client:"+args[0]);
            client.send(request);
            // System.out.println("Waiting fro server response....");
            // working on the reply
            byte[] buffer = new byte[50];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            client.receive(reply);
            // wait(0);
            System.out.println("Server: " + new String(reply.getData()));
            }
        
        } catch (Exception e) {
         e.printStackTrace();
        }
    }
}

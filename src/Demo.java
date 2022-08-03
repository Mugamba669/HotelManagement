import java.net.DatagramSocket;
import java.net.InetAddress;
// import java.net.SocketException;
public class Demo {
   
    public static void main(String[] args) {
        System.out.println("Demo inside");
        try{
            // DatagramSocket  client = new DatagramSocket();
            System.out.println(InetAddress.getByName("www.muele.mak.ac.ug"));
            // client.setSoTimeout(500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
      
    }
   
}
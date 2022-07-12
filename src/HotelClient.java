import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class HotelClient implements Client{

   public Socket socket = null;
   public DataInputStream fromServer = null;
   public DataOutputStream toServer = null;

    public void runClient(String arg) {
       try {
        String host = "localhost";
        int port = 3030;
        socket = new Socket(host, port);

        // check if connection accepted
        System.out.println("Connection successfull...");
        fromServer  = new DataInputStream(socket.getInputStream());
        toServer = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String message = fromServer.readUTF();
            System.out.println("Client logs:"+ message);
            // message to server
            toServer.writeUTF("Halo from "+ arg);
        }
       
       } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    public void printHelpMessage(){
        System.out.println("Welcome to Hotel management System");
        System.out.println();
        System.out.println("Usage: ");
        System.out.println("======================================================================================================");
        System.out.println(" > list\t\t -\t To list the available number of rooms in each price range (eg list <server-address>)");
        System.out.println(" > book\t\t -\t To books a room of the specified type (if available), and registers the name of the guest.(eg: book <server address> <room type> <guest name>)");
        System.out.println(" > address\t -\t To list the names of all the registered guests (eg: guests <server address )" );
        System.out.println(" > revenue\t -\t To prints the revenue breakdown based on the booked rooms and their types.( eg: revenue <server address>)");
        System.out.println();

        // System.out.println("+----------------------------------------------------------------------+");


    }
    public static void main(String[] args) {
        HotelClient client = new HotelClient();
        if (args[0] == "") {
            client.printHelpMessage();
        } else {
        client.runClient(args[0]);
        }
    }
}
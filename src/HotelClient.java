import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.Naming;

import javax.swing.JOptionPane;

public class HotelClient implements Client{

   public Socket socket = null;
   public DataInputStream fromServer = null;
   public DataOutputStream toServer = null;

    public void runClient(String arg[]) {
       try {
        // String host = "localhost";
        // int port = 3033;
        // socket = new Socket(arg[1], port);
       RoomManager roomManager = (RoomManager) Naming.lookup("rmi://localhost:5000/rooms");
       styledMessage("Connection accepted, handshake successfull");

       for (String rooms : roomManager.getAvailbaleRooms()) {
        System.out.println(rooms);
       }
    //    "".getBytes();
        // check if connection accepted
        // System.out.println("Connection successfull...");
        // fromServer  = new DataInputStream(socket.getInputStream());
        // toServer = new DataOutputStream(socket.getOutputStream());
        // if (arg[0].equals("book")) {
        //     toServer.writeUTF(arg[0]+","+arg[2]+","+arg[3]);
        // } else {
        //     toServer.writeUTF(arg[0]+","+arg[1]);
        // }
          // message to server
         
        // while (true) {
            // String message = fromServer.readUTF();
         
            // System.out.println(message);
            // socket.close();
          
        // }
            // if (socket.isClosed() == true) {
            //   JOptionPane.showMessageDialog(null, "Connection closed by server");
            // }
       } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    public void styledMessage(String message){
        System.out.println(" +-------------------------------------------------------------------------------------------+");
        System.out.printf(" |                            %s                                   |\n",message);
        System.out.println(" +-------------------------------------------------------------------------------------------+");
    }
    public void printHelpMessage(){
        System.out.println();

        System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println(" |                             Welcome to Hotel Room Reservation System                                                                                         |");
        System.out.println(" +--------------------------------------------------------------------------------------------------------------------------------------------------------------+");

        System.out.println();
        System.out.println(" +==============================================================================================================================================================+");
        System.out.println(" | Usage:                                                                                                                                                       | ");
        System.out.println(" +============+=================================================================================================================================================+");
        System.out.println(" | list       | To list the available number of rooms in each price range (eg list <server-address>)                                                            |");
        System.out.println(" +============+=================================================================================================================================================+");
        System.out.println(" | book       | To books a room of the specified type (if available), and registers the name of the guest.(eg: book <server address> <room type> <guest name>)  |");
        System.out.println(" +============+=================================================================================================================================================+");
        System.out.println(" | address    | To list the names of all the registered guests (eg: guests <server address )                                                                    |" );
        System.out.println(" +============+=================================================================================================================================================+");
        System.out.println(" | revenue    | To prints the revenue breakdown based on the booked rooms and their types.( eg: revenue <server address>)                                       |");
        System.out.println(" +============+=================================================================================================================================================+");
        System.out.println();

        // System.out.println("+----------------------------------------------------------------------+");


    }
    public static void main(String[] args) {
        HotelClient client = new HotelClient();
        if (args.length == 0) {
            client.printHelpMessage();
        } else {
        client.runClient(args);
        }
    }
}
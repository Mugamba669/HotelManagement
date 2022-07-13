// import java.io.DataInputStream;
// import java.io.DataOutputStream;
// import java.io.File;
// import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.*;
// import java.io.PrintWriter;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.Scanner;

import javax.swing.JOptionPane;

public class HotelServer  {
    public String[] rooms = {"w room","v room","x room","y room","z room"};
   public HotelServer() {
    // System.setSecurityManager(new RMISecurityManager());
    try {
  
    RoomManager stub = new RoomManagerImpl();
        // try (ServerSocket server = new ServerSocket(3033)) {
            // try{
                // UnicastRemoteObject.exportObject()
            System.out.println();
            System.out.println("+=======================================+");
            System.out.println("|           Server side                 |");
            System.out.println("|=======================================|");
            System.out.println("|     Server running on port:5000...    |");
            System.out.println("|=======================================|");
            System.out.println("|     Binding client on port:5000...    |");
            System.out.println("|=======================================|");

            Naming.rebind("rmi://localhost:5000/rooms",stub);
            System.out.println("|     Client bound on port:5000...      |");
            // Socket conn = server.accept();
            // DataInputStream fromClient = new DataInputStream(conn.getInputStream());
            // DataOutputStream toClient = new DataOutputStream(conn.getOutputStream());

            // if (conn.isConnected() == true) {
            //     System.out.println("|       Server connected to client....  |");
            //     System.out.println("+=======================================+");
            //     System.out.println();
            // } 

            // if (conn.isClosed() == true) {
            //     JOptionPane.showMessageDialog(null, "Connection closed by client");
            //     }

            // while (true) {
            // conn.setKeepAlive(true);
            // receive data from toClient
            // String buffer = fromClient.readUTF();
            // System.out.println(buffer);
            //    String[] clientMessage = buffer.split(",");
            // System.out.println("Server executing command: "+clientMessage[0]);
            // System.out.println(clientMessage.split(",").length);

            //    switch (clientMessage[0]){
            //     case "list":
            //     String output = "\nServer response: executed => "+clientMessage[0]+" \n"+
            //                     "+-------------------------------------------------------------+\n"+
            //                     "| v rooms of type 0 are available for 55,000 UGX per night    |\n"+
            //                     "| w rooms of type 1 are available for 75,000 UGX per night    |\n"+
            //                     "| x rooms of type 2 are available for 80,000 UGX per night    |\n"+
            //                     "| y rooms of type 3 are available for 150,000 UGX per night   |\n"+
            //                     "| z rooms of type 4 are available for 230,000 UGX per night   |\n"+
            //                     "+-------------------------------------------------------------+\n";
            //             //  send the message to client
            //     toClient.writeUTF(output);
            //     toClient.close();
            //     break;

            //     case "book":

            //    System.out.println();
            //    String out = "Server response: executed => "+clientMessage[0]+"\n"+
            //                 clientMessage[2]+"'s room has been booked\n";
            //                 String jsonMessage = "";
            //             File file =  new File("guests.json");
            //             Scanner readFile = new Scanner(file);

            //             PrintWriter outWriter = new PrintWriter(file);

            //     if (file.exists() == true) {
            //         System.out.println("We are here");
            //         // reads the records from file
            //      while (readFile.hasNext()) {
            //         // jsonMessage += readFile.nextLine();
            //         System.out.println("From file: ");
            //      }
            //      jsonMessage +=  "{\"name\":\""+clientMessage[2]+"\",\"room\":\""+rooms[Integer.parseInt(clientMessage[1])]+"\"}";

            //       outWriter.append(jsonMessage);
            //         outWriter.close();
            //     } else {
            //        System.out.println("File exists");
            //     }
            //    toClient.writeUTF(out);
            //     toClient.close();
            //     conn.close();
            //     break;

            //     case "revenue":
            //     toClient.writeUTF("Server response: executed => "+clientMessage[0]);
            //     break;

            //     case "address":
            //     toClient.writeUTF("Server response: executed => "+clientMessage[0]);
            //     System.out.flush();
            //     break;

            //     default:
            //         toClient.writeUTF("Server response: Command not found");
            //         toClient.close();
            //         conn.close();
            //     break;
            //    }
            // }
        // }catch (Exception e){
        //    System.out.println("Error: " + e.getMessage());
        // }
        // }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server exeption : "+ e.getMessage());
    }
   }
    public static void main(String[] args) {
        new HotelServer();
    }
}

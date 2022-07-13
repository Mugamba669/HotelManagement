import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
   static DatagramSocket server = null;

    public static void main(String[] args) {
    // initalise server socket
    try {
        server = new DatagramSocket(2020);
        System.out.println("Server running on port 2020");
        // work on request fromclient
        byte[] buffer = new byte[1000];
        while (true) {
        DatagramPacket clientRequest = new DatagramPacket(buffer, buffer.length);
        // System.out.println("Waiting for client request");
        server.receive(clientRequest);
        String data = "/home/blabs/Music/UG";

        // send server sresponse to clientRequest
       for (String f : recursiveFolders(data)) {
        
       
        DatagramPacket response = new DatagramPacket(f.getBytes(),f.getBytes().length, clientRequest.getAddress(),clientRequest.getPort());
        server.send(response);
        System.out.println("Fetching song from: " + new String(data+"/"+new String(response.getData())));

       }
    }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    }
   public static String[] recursiveFolders(String path){
        File file = new File(path);
        // String[] result = {};
        // File[] files = file.listFiles();
        // for (int i = 0; i < files.length; i++) {
        //     if (files[i].isDirectory()) {
        //         recursiveFolders(path+"/"+files[i]);
        //     } 
        // }
          return file.list();
        }

}

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class HotelClient {

    public static String printHelpMessage(){
        String msg=  " +==============================================================================================================================================================+\n"+
                     " |                                                    Welcome to Hotel Room Reservation System                                                                  |\n"+
                    //  " +==============================================================================================================================================================+\n"+
                     " | Usage:                                                                                                                                                       | \n"+
                     " +============+=================================================================================================================================================+\n"+
                     " | list       | To list the available number of rooms in each price range (eg list <server-address>)                                                            |\n"+
                     " +============+=================================================================================================================================================+\n"+
                     " | book       | To books a room of the specified type (if available), and registers the name of the guest.(eg: book <server address> <room type> <guest name>)  |\n"+
                     " +============+=================================================================================================================================================+\n"+
                     " | guests     | To list the names of all the registered guests (eg: guests <server address )                                                                    |\n" +
                     " +============+=================================================================================================================================================+\n"+
                     " | revenue    | To prints the revenue breakdown based on the booked rooms and their types.( eg: revenue <server address>)                                       |\n"+
                     " +============+=================================================================================================================================================+\n";
             
               return msg;
           }

           public static void runCommand(String[] command) throws MalformedURLException, RemoteException, NotBoundException {
            //   client looks up a remote object by name
                 RoomManager stub = (RoomManager) Naming.lookup(command[1]);

                if (command[0].equals("list")) {
                    // this function displays all the available rooms for booking
                    System.out.println(stub.showRoomList());
                    
                } else if(command[0].equals("book")){
                    // here the invoked function `executeBooking` takes in the guest's name and the room booked
                    System.out.println(stub.executeBooking(command[2], command[3]));
                } else if(command[0].equals("guests")){
                    // invoking the method holding registered guests
                    System.out.println();
                    ArrayList<String[]> store = stub.printSavedClients();
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|      Saved Guests          |          Room  |");
                        System.out.println("+---------------------------------------------+");
                    for (int i = 0; i < store.size(); i++) {
                        System.out.println("|    "+store.get(i)[0]+"      ->         "+store.get(i)[1]+"  ");
                    }
                        System.out.println("+---------------------------------------------+");
                } else if(command[0].equals("revenue")){
                    System.out.println(stub.printRevenue());
                } else if(command[0].equals("exit")){
                    // System.exit(0);
                    // clear("exit");
                
                } else{
                    System.err.println();
                    System.out.println("Command not found please follow the instructions below");
                    System.out.println();
                    System.out.println(printHelpMessage());
                }
        }
    public static void main(String[] args)  {
        try{
            // Incase no arguments are available that's when the `printHelpMessage()` method is called
            if (args.length == 0) {
                System.out.println(printHelpMessage());
            } else {
            //  function to execute all cli commands
               runCommand(args);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

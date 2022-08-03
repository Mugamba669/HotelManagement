import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;

public class HotelClient {

    static int x = 0,w = 0,y = 0,z = 0, v = 0;

    static int a = 0, b =0, c =0, d =0 ,e =0;

    static int[][] available = {{0,0,0,0,0,0},{10,10,10,10,10}};

    static int totalRevenue = 0;

    static File file = new File("available.db");

  public static String printHelpMessage(){
        String msg=  " +==============================================================================================================================================================+\n"+
                     " |                                                    Welcome to Hotel Room Reservation System                                                                  |\n"+
                    //  " +==============================================================================================================================================================+\n"+
                     " | Usage:                                                                                                                                                       | \n"+
                     " +------------+-------------------------------------------------------------------------------------------------------------------------------------------------+\n"+
                     " | list       | To list the available number of rooms in each price range (eg list <server-address>)                                                            |\n"+
                     " +------------+-------------------------------------------------------------------------------------------------------------------------------------------------+\n"+
                     " | book       | To books a room of the specified type (if available), and registers the name of the guest.(eg: book <server address> <room type> <guest name>)  |\n"+
                     " +------------+-------------------------------------------------------------------------------------------------------------------------------------------------+\n"+
                     " | guests     | To list the names of all the registered guests (eg: guests <server address )                                                                    |\n" +
                     " +------------+-------------------------------------------------------------------------------------------------------------------------------------------------+\n"+
                     " | revenue    | To prints the revenue breakdown based on the booked rooms and their types.( eg: revenue <server address>)                                       |\n"+
                     " +------------+-------------------------------------------------------------------------------------------------------------------------------------------------+\n";

               return msg;
           }

           public static void runCommand(String[] command) throws NotBoundException, FileNotFoundException, IOException {
            //   client looks up a remote object by name
                 RoomManager stub = (RoomManager) Naming.lookup("rmi://"+command[1]+":1099/RoomManager");

                if (command[0].equals("list")) {
                    // this function displays all the available rooms for booking
                    System.out.println(stub.showRoomList());
                    
                } else if(command[0].equals("book")){
                    // here the invoked function `executeBooking` takes in the guest's name and the room booked
                    System.out.println(stub.executeBooking(command[2], command[3]));
                } else if(command[0].equals("guests")){
                    // invoking the method holding registered guests
                    System.out.println();
                    ArrayList<Guests> store = stub.printSavedClients();
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|      Saved Guests          |   Booked Room  |");
                        System.out.println("+---------------------------------------------+");
                        if (store.size() == 0) {
                        // System.out.println("+---------------------------------------------+");
                        System.out.println("|               No guests Saved               |");
                        System.out.println("+---------------------------------------------+");
                        } else {
                            for (int i = 0; i < store.size(); i++) {
                                System.out.println("|    "+store.get(i).guestName+"      ->         "+store.get(i).room+"  ");
                            }
                                System.out.println("+---------------------------------------------+");
                        }
                    
                } else if(command[0].equals("revenue")){
                    System.out.println();
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("|                      Computed revenue                      |");
                    // System.out.println("+---------------------------------------------+");
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("|    Room   |    Type    |   Booked (Times)  |    Amount     |");
                    System.out.println("+------------------------------------------------------------+");
                if(stub.printRevenue().size() == 0){
                    System.out.println("|                      No Revenue                            |");
                    System.out.println("+------------------------------------------------------------+");


                } else {
                    var store = stub.printRevenue();
// iterating through saved bookings
                    for (int i = 0; i < store.size(); i++) {

                        if(store.get(i).room.equals(Rooms.rooms[0])){
                            if(v == 0){
                            System.out.println("|  "+store.get(i).room+" |    "+store.get(i).roomType+"    |           "+Rooms.countRooms(store, store.get(i).room)+"        |    "+(store.get(i).amount * Rooms.countRooms(store, store.get(i).room))+"    |");
                           available[0][0] = Rooms.countRooms(store, store.get(i).room);
                            totalRevenue += (store.get(i).amount * Rooms.countRooms(store, store.get(i).room)); 
                            v++;
                            }
                            // 
                        } else  if(store.get(i).room.equals(Rooms.rooms[1])){
                            if(w == 0){
                            System.out.println("|  "+store.get(i).room+" |    "+store.get(i).roomType+"    |           "+Rooms.countRooms(store, store.get(i).room)+"        |    "+(store.get(i).amount * Rooms.countRooms(store, store.get(i).room))+"    |");
                           available[0][1] = Rooms.countRooms(store, store.get(i).room);
                            totalRevenue += (store.get(i).amount * Rooms.countRooms(store, store.get(i).room));
                            w++;
                            }
                            // 
                        } else  if(store.get(i).room.equals(Rooms.rooms[2])){
                            if(x == 0){
                            System.out.println("|  "+store.get(i).room+" |    "+store.get(i).roomType+"    |           "+Rooms.countRooms(store, store.get(i).room)+"        |    "+(store.get(i).amount * Rooms.countRooms(store, store.get(i).room))+"    |");
                            available[0][2] = Rooms.countRooms(store, store.get(i).room);
                            totalRevenue += (store.get(i).amount * Rooms.countRooms(store, store.get(i).room));
                            x++;
                            }
                            // 
                        } else  if(store.get(i).room.equals(Rooms.rooms[3])){
                            if(y == 0){
                            System.out.println("|  "+store.get(i).room+" |    "+store.get(i).roomType+"    |           "+Rooms.countRooms(store, store.get(i).room)+"        |    "+(store.get(i).amount * Rooms.countRooms(store, store.get(i).room))+"    |");
                           available[0][3] = Rooms.countRooms(store, store.get(i).room);
                            totalRevenue += (store.get(i).amount * Rooms.countRooms(store, store.get(i).room)); 
                            y++;
                            }
                            // 
                        } else  if(store.get(i).room.equals(Rooms.rooms[4])){
                            if(z == 0){
                            System.out.println("|  "+store.get(i).room+" |    "+store.get(i).roomType+"    |           "+Rooms.countRooms(store, store.get(i).room)+"        |    "+(store.get(i).amount * Rooms.countRooms(store, store.get(i).room))+"    |");
                            available[0][4] = Rooms.countRooms(store, store.get(i).room);
                            totalRevenue += (store.get(i).amount * Rooms.countRooms(store, store.get(i).room)); 
                            z++;
                            }
                        }
                        // System.out.println(y);
                       
                    }
                    // System.out.println("+------------------------------------------------------------+");
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("|  Total  Revenue generated    |        UGX:"+totalRevenue+"          |");
                    System.out.println("+------------------------------------------------------------+");
                    
                  
              for (int i = 0; i < 5; i++) {
                    available[1][i] = (available[1][i] - available[0][i]);
              }
                    
                        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("available.db"));
                        writer.writeObject(available);
                        writer.close();
                    // }
                       
                    }
                    System.out.println();
                }  else{
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
                System.out.println();
                System.out.println(printHelpMessage());
            } else {
            //  function to execute all cli commands
               runCommand(args);
            }
        }catch(Exception e){
            // System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

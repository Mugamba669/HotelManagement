import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
    protected RoomManagerImpl() throws RemoteException {
        super();
    }
    // storage for booked rooms and guests
    ArrayList<Guests> storage = new ArrayList<Guests>();
    // Array of available rooms
    String[] rooms = {"v rooms","w rooms","x rooms","y rooms","z rooms"};
    // Array of room types
    String[] roomsType = {"Zero","One","Two","Three","Four"};
    
    // amount for each room
    int[] amount = {55000,75000,80000,150000,230000};
    @Override
    public String showRoomList() {
    String  list =  "\n"+
                    "+===========================================================+\n"+
                    "| v rooms of type 0 are available for 55,000 UGX per night  |\n"+
                    "| w rooms of type 1 are available for 75,000 UGX per night  |\n"+
                    "| x rooms of type 2 are available for 80,000 UGX per night  |\n"+
                    "| y rooms of type 3 are available for 150,000 UGX per night |\n"+
                    "| z rooms of type 4 are available for 230,000 UGX per night | \n"+
                    "+===========================================================+\n";

        return list;
    }

    @Override
    public String executeBooking(String room, String client) throws RemoteException {
        int count = 0;
        // saving booked rooms together with the client's name
        Guests data = new Guests(client, rooms[Integer.parseInt(room)], roomsType[Integer.parseInt(room)],  amount[Integer.parseInt(room)], count+=1);
        storage.add(data);

        return commonMsg(client+"'s room booked successfully");
    }
     
    @Override 
    public ArrayList<Guests> printSavedClients() throws RemoteException {
        return storage;
    }

    @Override
    public ArrayList<Guests> printRevenue() throws RemoteException {
        /// Tracking the booked 
        return storage;
    }
   public String commonMsg(String data){
    String msg = "+=======================================================+\n"+
                 "|        "+data+"                                          \n"+
                 "+=======================================================+\n";
        return msg;
   }
}
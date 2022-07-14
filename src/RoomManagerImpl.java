import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
    protected RoomManagerImpl() throws RemoteException {
        super();
    }
    ArrayList<String[]> storage = new ArrayList<String[]>();
    /**
     *
     */
    ArrayList<String[]> revenue = new ArrayList<String[]>();
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
        // saving booked rooms together with the client's name
        String[] data = {client,room};
        storage.add(data);

        return commonMsg(client+"'s room booked successfully");
    }
    @Override 
    public ArrayList<String[]> printSavedClients() throws RemoteException {
        return storage;
    }
    @Override
    public String printRevenue() throws RemoteException {
        /// Tracking the booked 
        int count = 0;
        for(int i = 0; i < storage.size(); i++){
            if(storage.get(i)[1].equals("w")){
                count++;
                String[] w = {"w",String.valueOf(count)};
                revenue.add(w);
            }
        }
        return ""+count+"";
    }
   public String commonMsg(String data){
    String msg = "+===========================================+\n"+
                 "|    "+data+"                               |\n"+
                 "+===========================================+\n";
        return msg;
   }
}

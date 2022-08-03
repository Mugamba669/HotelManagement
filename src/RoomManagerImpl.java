import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
    static  Object record;
    RoomManagerImpl() throws RemoteException {
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
    // File check
    File file = new File("record.db");

    public int[][] retriveAvailable(){
         int[][] ret = new int[2][5];
        try {
            FileInputStream in = new FileInputStream("available.db");
            ObjectInputStream reader = new ObjectInputStream(in);
           //  saving object record in files
           ret = (int[][]) reader.readObject();
            reader.close();
            in.close();
           
       } catch (Exception e) {
           System.out.println("Error "+ e.getMessage());
       }
        return ret;
    }

    @Override
    public String showRoomList() {
        if(new File("available.db").exists()){
        int[][] x = retriveAvailable();

    String  list =  "\n"+
                    "+-------------------------------------------------------------------------+\n"+
                    "|                     Available rooms Hotel                               |\n"+
                    "+-------------------------------------------------------------------------+\n"+
                    "| "+x[1][0]+" v  rooms for 55,000 UGX per night                           \n"+
                    "+                                                                         +\n"+
                    "| "+x[1][1]+" w rooms  for 75,000 UGX per night     \n"+
                    "+                                                                         +\n"+
                    "| "+x[1][2]+" x rooms  for 80,000 UGX per night     \n"+
                    "+                                                                         +\n"+
                    "| "+x[1][3]+" y rooms for 150,000 UGX per night    \n"+
                    "+                                                                         +\n"+
                    "| "+x[1][4]+" z rooms for 230,000 UGX per night     \n"+
                    "+-------------------------------------------------------------------------+\n";

        return list;
        }else{
            int[][] available = {{0,0,0,0,0,0},{10,10,10,10,10}};
          
                        try {
                            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("available.db"));
                            writer.writeObject(available);
                            writer.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int[][] x = retriveAvailable();
                        String  list =  "\n"+
                        "+-------------------------------------------------------------------------+\n"+
                        "|                     Available rooms Hotel                               |\n"+
                        "+-------------------------------------------------------------------------+\n"+
                        "| "+x[1][0]+" v  rooms for 55,000 UGX per night                           \n"+
                        "+                                                                         +\n"+
                        "| "+x[1][1]+" w rooms  for 75,000 UGX per night     \n"+
                        "+                                                                         +\n"+
                        "| "+x[1][2]+" x rooms  for 80,000 UGX per night     \n"+
                        "+                                                                         +\n"+
                        "| "+x[1][3]+" y rooms for 150,000 UGX per night    \n"+
                        "+                                                                         +\n"+
                        "| "+x[1][4]+" z rooms for 230,000 UGX per night     \n"+
                        "+-------------------------------------------------------------------------+\n";
    
            return list;
        }
    }

    public  void saveRecord(Object obj) {
        try {
         FileOutputStream out = new FileOutputStream("record.db");
             ObjectOutputStream writer = new ObjectOutputStream(out);
            //  saving object record in files
            writer.writeObject(obj);
            writer.close();
            out.close();
            
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
    }
    // retriving the saved record from file
    /**
     * @return
     */
    public Object retrivedSaved(){
       
        try {
            FileInputStream in = new FileInputStream("record.db");
            ObjectInputStream reader = new ObjectInputStream(in);
           //  saving object record in files
           record = reader.readObject();
            reader.close();
            in.close();
           
       } catch (Exception e) {
           System.out.println("Error "+ e.getMessage());
       }
        return record;
    }

    @Override
    public String executeBooking(String room, String client) throws RemoteException {
        int count = 0;
        // saving booked rooms together with the client's name
        if (retriveAvailable()[1][Integer.parseInt(room)] < 1) {
            return commonMsg("No available rooms of type "+rooms[Integer.parseInt(room)]);
        }else{
            Guests data = new Guests(client, rooms[Integer.parseInt(room)], roomsType[Integer.parseInt(room)],  amount[Integer.parseInt(room)], count+=1);
            storage.add(data);
            saveRecord(storage);
            return commonMsg(client+"'s room booked successfully");
        }
       
    }
     
    @Override 
    public ArrayList<Guests> printSavedClients() throws RemoteException {
        return file.exists()?(ArrayList<Guests>) retrivedSaved():storage;
    }

    @Override
    public ArrayList<Guests> printRevenue() throws RemoteException {
        /// Tracking the booked 
        return file.exists()?(ArrayList<Guests>) retrivedSaved():storage;
    }
   public String commonMsg(String data){
    String msg = "+=======================================================+\n"+
                 "|        "+data+"                                          \n"+
                 "+=======================================================+\n";
        return msg;
   }
}
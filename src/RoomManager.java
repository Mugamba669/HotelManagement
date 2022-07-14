import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RoomManager extends Remote{

     String showRoomList() throws RemoteException;
    String executeBooking(String room, String client) throws RemoteException;
    ArrayList<String[]> printSavedClients() throws RemoteException;
    String printRevenue() throws RemoteException;
}

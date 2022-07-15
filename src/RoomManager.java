import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RoomManager extends Remote{

     String showRoomList() throws RemoteException;
    String executeBooking(String room, String client) throws RemoteException;
    ArrayList<Guests> printSavedClients() throws RemoteException;
    ArrayList<Guests> printRevenue() throws RemoteException;
}

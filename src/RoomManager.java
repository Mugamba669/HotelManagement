import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoomManager extends Remote {
   String[] getAvailbaleRooms() throws RemoteException;
}

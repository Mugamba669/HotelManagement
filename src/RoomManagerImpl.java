import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
     RoomManagerImpl() throws RemoteException {
        super();
     }

    @Override
    public String[] getAvailbaleRooms() throws RemoteException {
        String[] rooms = {"w room","v room","x room","y room","z room"};
        return rooms;
    }
}
enum Boy{ eat, drink , fish }
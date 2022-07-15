import java.rmi.Naming;


public class HotelServer {
    public static void main(String[] args) {
        try{
            System.out.println();
        System.out.println("+===========================================================+");
        System.out.println("|           HotelServer live                                |");
        System.out.println("|===========================================================|");
        System.out.println("|     Server running on rmi://localhost:1099/RoomManager.   |");
        System.out.println("|===========================================================|");
        System.out.println("|     Binding client on rmi://localhost:1099/RoomManager.   |");
        System.out.println("|===========================================================|");
        // hare we areinstanciating the stub procedure of our server in order Marshall and unmarshall our data
        RoomManager stub = new RoomManagerImpl();
        // Here the server  register the identifier of a remote object by name to the rmi on localhost:1099/RoomManager
        Naming.rebind("rmi://localhost:1099/RoomManager", stub);
        
        System.out.println("|     Client bound on rmi://localhost:1099/RoomManager      |");
        System.out.println("+===========================================================+");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

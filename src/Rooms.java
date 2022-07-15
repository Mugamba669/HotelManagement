import java.util.ArrayList;

public final class Rooms {
   public static String[] rooms = {"v rooms","w rooms","x rooms","y rooms","z rooms"};

//    method to count the number times a room is booked
    public static int countRooms(ArrayList<Guests> storage, String room){
        int count = 0;
        for(int i = 0; i < storage.size(); i++){
            if(storage.get(i).room.equals(room)){
                count++;
            }
        }
        return count;
    }
//    method to calculate the revenue of a room
    public static int revenue(ArrayList<Guests> storage, String room){
        int revenue = 0;
        for(int i = 0; i < storage.size(); i++){
            if(storage.get(i).room.equals(room)){
                revenue += storage.get(i).amount;
            }
        }
        return revenue;
    }
}

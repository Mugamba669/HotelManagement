import java.io.Serializable;

public class Guests implements Serializable {
    public String guestName;
    public String room;
    public String roomType;
    public int booked;
    public int amount;
    
    Guests(String name, String room ,String roomType, int amount, int booked){
        this.guestName = name;
        this.room = room;
        this.roomType = roomType;
        this.amount = amount;
        this.booked = booked;
    }
}

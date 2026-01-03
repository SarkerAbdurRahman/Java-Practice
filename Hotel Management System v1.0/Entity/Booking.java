package Entity;
public class Booking{
    private Guest guest;
    private Room room;
public Booking(){
    System.out.println("Empty Booking Created.");
    }
public Booking(Guest guest,Room room){
    System.out.println("Booking Created.");
    this.guest=guest;
    this.room=room;
    this.room.setAvailable(false);
    }
public void setGuest(Guest guest){
    this.guest=guest;}
public Guest getGuest(){
    return guest;}
public void setRoom(Room room){ 
    this.room=room; 
    room.setAvailable(false);
    }
public Room getRoom(){
return room;}
public String getBookingInfo(){
    return guest.getGuestInfo()+"\n" + room.getRoomInfo();
    }
public void checkOut(){
    if(room!=null){
        room.setAvailable(true);
        System.out.println("Guest checked out.");
        }
    }
}

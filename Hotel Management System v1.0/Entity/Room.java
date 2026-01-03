package Entity;
public class Room{
    private int roomNumber;
    private String type;
    private double price;
    private boolean available;
public Room(){
    System.out.println("Empty Room Created.");
    }
public Room(int roomNumber,String type,double price){
    System.out.println("Room Created.");
    this.roomNumber=roomNumber;
    this.type=type;
    this.price=price;
    this.available=true;
    }	
public void setRoomNumber(int roomNumber){
       this.roomNumber=roomNumber;}
public int getRoomNumber(){
       return roomNumber;}
public void setType(String type){
       this.type=type;}
public String getType(){
       return type;}
public void setPrice(double price){
       this.price=price;}
public double getPrice(){
       return price;}
public void setAvailable(boolean available){
       this.available=available;}
public boolean getAvailable(){
       return available;}
public String getRoomInfo(){
    return "Room Number: " + roomNumber + "\n" +
           "Type: " + type + "\n" +
           "Price: " + price + " USD" + "\n" +
           "Status: " + (available ? "Available" : "Occupied") + "\n";
}
}

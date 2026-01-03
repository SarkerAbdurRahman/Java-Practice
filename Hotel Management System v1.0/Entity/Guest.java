package Entity;
public class Guest{
    private String name;
    private String contact;
public Guest(){
    System.out.println("Empty Guest Created.");
    }
public Guest(String name,String contact){
    System.out.println("Guest Created.");
    this.name=name;
    this.contact=contact;
    }
public void setName(String name){
    this.name=name;}
public String getName(){
    return name;}
public void setContact(String contact){
    this.contact=contact;}    
public String getContact(){
    return contact;}
public String getGuestInfo(){
    return "Guest Name: " + name + "\n" +
           "Contact: " + contact + "\n";
}
}

public class PassengerAirliner extends AirTransporter{
    private int passengerCapacity;
public PassengerAirliner(String manufacturer,double maxAltitude,double maxSpeed,int passengerCapacity){
	super(manufacturer,maxAltitude,maxSpeed);
	this.passengerCapacity = passengerCapacity;
}
public void setPassengerCapacity(int passengerCapacity){
	this.passengerCapacity = passengerCapacity;
}
public int getPassengerCapacity(){
	return passengerCapacity;
}
public void showDetails(){
	System.out.println("Air Transporter Details");
	System.out.println("Manufacturer : " + getManufacturer());
	System.out.println("Maximum Altitude : " + getMaxAltitude()+" ft");
	System.out.println("Maximum Speed : " + getMaxSpeed()+" KM/Hr");
	System.out.println("Passenger Capacity : " + passengerCapacity);
}
}

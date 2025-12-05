public class CargoAirliner extends AirTransporter{
private int maxCargoWeight;
public CargoAirliner(){
    super();
    this.maxCargoWeight=0;
}
public CargoAirliner(String manufacturer,double maxAltitude,double maxSpeed,int maxCargoWeight){
    super(manufacturer,maxAltitude,maxSpeed);
    this.maxCargoWeight=maxCargoWeight;
}
public void setCargoWeight(int weight){
    this.maxCargoWeight=weight;
}
public int getMaxCargoWeight(){
    return maxCargoWeight;
}
public void showDetails(){
    System.out.println("Air Transporter Details");
    System.out.println("Manufacturer : " + getManufacturer());
    System.out.println("Maximum Altitude : " + getMaxAltitude()+" ft");
    System.out.println("Maximum Speed : " + getMaxSpeed()+" KM/Hr");
    System.out.println("Max Weight Capacity : " + maxCargoWeight+" KG");
}
}

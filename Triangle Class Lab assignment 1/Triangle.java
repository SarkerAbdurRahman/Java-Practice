public class Triangle{
	private int x;
	private int y;
	private int z;
public Triangle(){
	this.x=0;
	this.y=0;
	this.z=0;
}
public Triangle(int x,int y,int z){
	this.x=x;
	this.y=y;
	this.z=z;
}
public void setX(int x){
	this.x=x;
}
public void setY(int y){
	this.y=y;
}
public void setZ(int z){
	this.z=z;
}
public int getX(){
	return x;
}
public int getY(){
	return y;
}
public int getZ(){
	return z;
}
public void showInfo(){
System.out.println("The number of X is="+x);
System.out.println("The number of Y is="+y);
System.out.println("The number of Z is="+z);
}
public void testTriangle(){
	if(x==y && y==z){
		System.out.println("The triangle is equilateral.");
	}
	else if(x==y || y==z ||x==z){
		System.out.println("The triangle is isosceles.");
	}
	else{
		System.out.println("The triangle is scalene.");
	}	
}
public static void main(String[] args) {
Triangle t1 = new Triangle(7,7,7);
t1.showInfo();
t1.testTriangle();
Triangle t2 = new Triangle(7,7,8);
t2.showInfo();
t2.testTriangle();
Triangle t3 = new Triangle(7,8,9);
t3.showInfo();
t3.testTriangle();
}
}
import java.util.Scanner;
public class Product{
	public static void main (String[]args){
	Scanner a=new Scanner(System.in);
	String id;
	System.out.print("What is the number of ID:");
	id = a.nextLine();
	Scanner b=new Scanner(System.in);
	String title;
	System.out.print("Please mention your title:");
	title= b.nextLine();
	Scanner c=new Scanner(System.in);
	int price;
	System.out.print("Price of the product:");
	price= c.nextInt();
	Scanner d=new Scanner(System.in);
	String description;
	System.out.print("Description of the product:");
	description=d.nextLine();
	Scanner e=new Scanner(System.in);
	String category;
	System.out.print("Category of the product:");
	category=e.nextLine();
	System.out.println("Id:"+id);
	System.out.println("Mentioned Title:"+title);
	System.out.println("Total Price:"+price);
	System.out.println("Description:"+description);
	System.out.println("Category:"+category);
	}
	}
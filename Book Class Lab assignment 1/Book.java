public class Book{
	private String bookName;
	private String bookAuthor;
	private String bookId;
	private String bookType;
	private int bookCopy;
    private static int uniqueBookCounter=0;
public Book(){
	this.bookName="";
	this.bookAuthor="";
	this.bookId="";
	this.bookType="";
	this.bookCopy=0;
uniqueBookCounter++;}
public Book(String bookName,String bookAuthor,String bookId,String bookType,int bookCopy){
	this.bookName=bookName;
	this.bookAuthor=bookAuthor;
	this.bookId=bookId;
	this.bookType=bookType;
	this.bookCopy=bookCopy;
uniqueBookCounter++;}
public void setBookName(String bookName){
	this.bookName=bookName;
}
public void setBookAuthor(String bookAuthor){
	this.bookAuthor=bookAuthor;
}	
public void setBookId(String bookId){
	this.bookId=bookId;
}	
public void setBookType(String bookType){
	this.bookType=bookType;
}	
public void setBookCopy(int bookCopy){
	this.bookCopy=bookCopy;
}	
public String getBookName(){
	return bookName;
}	
public String getBookAuthor(){
	return bookAuthor;
}	
public String getBookId(){
	return bookId;
}	
public String getBookType(){
	return bookType;
}	
public int getBookCopy(){
	return bookCopy;
}	
public void showDetails(){
	System.out.println("Book Name:"+bookName);
	System.out.println("Book Author:"+bookAuthor);
	System.out.println("Book ID:"+bookId);
	System.out.println("Book Type:"+bookType);
	System.out.println("Book Copies:"+bookCopy);
}
public void addBookCopy(int x){
	if(x>0){
		bookCopy+=x;
	}
}	
public static void totalNumberofUniqueBooks(){
	System.out.println("The total number of unique book is="+uniqueBookCounter);
}
public static void main(String[]args){
	Book book1= new Book("Dopamine Detox","Thibaut Meurisse","Book1","Practical, actionable guides",78);
	Book book2= new Book("The Alchemist","Paulo Coelho","Book2","Fantasy Fiction",15);
    Book book3= new Book("Perfume","Patrick Süskind","Book3","Mystery",75);
	Book book4= new Book("Harry Potter","J. K. Rowling","Book4","Fantasy Fiction",30);
book1.showDetails();
book2.showDetails();	
book3.showDetails();	
book4.showDetails();
book1.addBookCopy(10);	
book2.addBookCopy(20);
book1.showDetails();
book2.showDetails();
Book.totalNumberofUniqueBooks();
}
}
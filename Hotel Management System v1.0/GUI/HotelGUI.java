package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import File.*;
public class HotelGUI extends JFrame implements ActionListener{
    Font font16=new Font("Consolas",Font.BOLD,16);
    Font font11=new Font("Consolas",Font.ITALIC,11);
	Font font12=new Font("Consolas", Font.PLAIN, 12);
	
	JLabel title;
	JLabel roomLabel,guestLabel,bookingLabel,changeRoomLabel;
	JLabel roomNoLabel,roomTypeLabel,roomPriceLabel;
	JLabel guestNameLabel,guestContactLabel;
	JLabel bookingGuestLabel,bookingRoomLabel,checkInLabel,checkOutLabel;
	JLabel changeRoomFromLabel,changeRoomToLabel;

	JLabel roomPic,guestPic,bookingPic,changeRoomPic;

	JButton addRoomButton,removeRoomButton,availableRoomsButton;
	JButton addGuestButton;
	JButton bookRoomButton,checkOutButton;
	JButton changeRoomButton;
	JButton roomClearButton,guestClearButton,bookingClearButton,changeRoomClearButton;

	JTextField roomNoTextField,roomTypeTextField,roomPriceTextField;
	JTextField guestNameTextField,guestContactTextField;
	JTextField bookingGuestTextField,bookingRoomTextField,checkInTextField,checkOutTextField;
	JTextField changeRoomFromTextField,changeRoomToTextField;

	JTextArea screen;

	Room[]rooms=new Room[100];
	Guest[]guests=new Guest[100];
	Booking[]bookings=new Booking[100];
	String[]bookingCheckIn=new String[100];
	String[]bookingCheckOut=new String[100];
	
	int roomCount=0;
	int guestCount=1;
	int bookingCount=0;
    //for having greeting text file for the first time
	boolean firstOpen=true; 

	String checkOutHistory= "";
	String changeRoomHistory= "";
	
	public HotelGUI(){
		super("Hotel Management System");
		this.setSize(850,745);
		this.setLocation(200,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("./images/icon.png").getImage());
		this.setLayout(null);

		JLabel background=new JLabel(new ImageIcon("./images/background.png"));
		background.setBounds(0,0,850,745);
		background.setLayout(null);
		this.setContentPane(background);
        
		title=createLabel(10,0,300,25,"Hotel Management System");
		title.setFont(font16);
		title.setForeground(Color.BLACK);
		
		roomLabel=createLabel(10,35,150,25,"Create New Room");
		roomLabel.setForeground(Color.BLACK);
        
		roomPic=new JLabel(new ImageIcon("./images/room.png"));
		roomPic.setBounds(160,35,30,25);
		this.add(roomPic);
        
		roomClearButton=new JButton(new ImageIcon("./images/refresh.png"));
		roomClearButton.setBounds(250,35,30,25);
		roomClearButton.addActionListener(this);
		this.add(roomClearButton);
        
		roomNoLabel=createLabel(10,65,120,25,"Room No:");
		roomNoLabel.setForeground(new Color(0,0,255));
		
		roomNoTextField = createTextField(130,65,150,25,"");

		roomTypeLabel=createLabel(10,95,120,25,"Type:");
		roomTypeLabel.setForeground(new Color(0,0,255));
		
		roomTypeTextField = createTextField(130,95,150,25,"");

		roomPriceLabel=createLabel(10,125,120,25,"Price:");
		roomPriceLabel.setForeground(new Color(0,0,255));
		
		roomPriceTextField = createTextField(130,125,150,25,"");

		addRoomButton=createButton(10,155,280,30,"Add Room");
		addRoomButton.setBackground(new Color(126,33,212));
		addRoomButton.setForeground(Color.WHITE);

		availableRoomsButton=createButton(10,190,135,30,"Rooms");
		availableRoomsButton.setForeground(new Color(0,0,255));
		availableRoomsButton.setBackground(new Color(0,35,149));
		availableRoomsButton.setForeground(Color.WHITE);

		removeRoomButton=createButton(155,190,135,30,"Remove");
		removeRoomButton.setForeground(new Color(0,0,255));
		removeRoomButton.setBackground(Color.RED);
		removeRoomButton.setForeground(Color.WHITE);

		guestLabel=createLabel(10,230,150,25,"Create Guest");
		guestLabel.setForeground(Color.BLACK);

		guestPic=new JLabel(new ImageIcon("./images/Guest.png"));
		guestPic.setBounds(160,230,30,25);
		this.add(guestPic);

		guestClearButton=new JButton(new ImageIcon("./images/refresh.png"));
		guestClearButton.setBounds(250,230,30,25);
		guestClearButton.addActionListener(this);
		this.add(guestClearButton);

		guestNameLabel=createLabel(10,260,120,25,"Name:");
		guestNameLabel.setForeground(new Color(0,0,255));
		
		guestNameTextField=createTextField(130,260,150,25,"");

		guestContactLabel=createLabel(10,290,120,25,"Contact No:");
		guestContactLabel.setForeground(new Color(0,0,255));
		
		guestContactTextField=createTextField(130,290,150,25,"");

		addGuestButton=createButton(10,320,280,30,"Add Guest");
		addGuestButton.setBackground(new Color(126,33,212));
		addGuestButton.setForeground(Color.WHITE);

		bookingLabel=createLabel(10,360,150,25,"Bookings");
		bookingLabel.setForeground(Color.BLACK);

		bookingPic=new JLabel(new ImageIcon("./images/Booking.png"));
		bookingPic.setBounds(160,360,30,25);
		this.add(bookingPic);

		bookingClearButton=new JButton(new ImageIcon("./images/refresh.png"));
		bookingClearButton.setBounds(250,360,30,25);
		bookingClearButton.addActionListener(this);
		this.add(bookingClearButton);

		bookingGuestLabel=createLabel(10,390,120,25,"Guest ID:");
		bookingGuestLabel.setForeground(new Color(0,0,255));
		
		bookingGuestTextField=createTextField(130,390,150,25,"");

		bookingRoomLabel=createLabel(10,420,120,25,"Room No:");
		bookingRoomLabel.setForeground(new Color(0,0,255));
		
		bookingRoomTextField=createTextField(130,420,150,25,"");

		checkInLabel=createLabel(10,450,120,25,"Check In:");
		checkInLabel.setForeground(new Color(0,0,255));
		
		checkInTextField=createTextField(130,450,150,25,"");
		
		JLabel checkInHint=createLabel(10,470,280,20,"(DD-MM-YYYY HH:MM)");
		checkInHint.setFont(font11);
		checkInHint.setForeground(new Color(0,0,255));

		checkOutLabel=createLabel(10,495,120,25, "Check Out:");
		checkOutLabel.setForeground(new Color(0,0,255));
		
		checkOutTextField=createTextField(130,495,150,25,"");
		
		JLabel checkOutHint=createLabel(10,515,280,20,"(DD-MM-YYYY HH:MM)");
		checkOutHint.setFont(font11);
		checkOutHint.setForeground(new Color(0,0,255));

		bookRoomButton=createButton(10,540,135,30,"Book Room");
		bookRoomButton.setBackground(new Color(126,33,212));
        bookRoomButton.setForeground(Color.WHITE);
		
		checkOutButton=createButton(155,540,135,30,"Check Out");
		checkOutButton.setBackground(Color.ORANGE);

		changeRoomLabel=createLabel(10,580,150,25,"Change Room");
		changeRoomLabel.setForeground(Color.BLACK);
		
		changeRoomPic=new JLabel(new ImageIcon("./images/ChangeRoom.png"));
		changeRoomPic.setBounds(160,580,30,25);
		this.add(changeRoomPic);
		
		changeRoomClearButton=new JButton(new ImageIcon("./images/refresh.png"));
		changeRoomClearButton.setBounds(250,580,30,25);
		changeRoomClearButton.addActionListener(this);
		this.add(changeRoomClearButton);

		changeRoomFromLabel=createLabel(10,610,120,25,"From:");
		changeRoomFromLabel.setForeground(new Color(0,0,255));
		
		changeRoomFromTextField=createTextField(130,610,150,25,"");

		changeRoomToLabel=createLabel(10,640,120,25,"To:");
		changeRoomToLabel.setForeground(new Color(0,0,255));
		
		changeRoomToTextField=createTextField(130,640,150,25,"");

		changeRoomButton=createButton(10,670,280,30,"Change Room");
		changeRoomButton.setBackground(Color.ORANGE);

		screen = new JTextArea();
		screen.setEditable(false);
		screen.setFont(font12);

		JScrollPane scrollPane=new JScrollPane(screen);
		scrollPane.setBounds(310,35,870,620);
		this.add(scrollPane);

//first time message
		screen.setText(FileIO.loadFile());

		this.setVisible(true);
	}

	JLabel createLabel(int x,int y,int w,int h,String text){
		JLabel c=new JLabel(text);
		c.setBounds(x,y,w,h);
		c.setFont(font16);
		this.add(c);
		return c;
	}

	JTextField createTextField(int x,int y,int w,int h,String text){
		JTextField c=new JTextField(text);
		c.setBounds(x,y,w,h);
		c.setFont(font16);
		this.add(c);
		return c;
	}

	JButton createButton(int x,int y,int w,int h,String text){
		JButton c=new JButton(text);
		c.setBounds(x,y,w,h);
		c.setFont(font16);
		c.setBackground(new Color(66,245,179));
		c.addActionListener(this);
		this.add(c);
		return c;
	}

	public void updateScreen(){

		String data="===== ROOMS =====\n";
		for(int i=0;i<roomCount;i++){
			if(rooms[i]!=null){
				data+=rooms[i].getRoomNumber()+" | "+rooms[i].getType()+" | "+" $ "+rooms[i].getPrice()+" | "+(rooms[i].getAvailable()?"Available" : "Occupied")+"\n";			
			}
		}
		data+="\n===== GUESTS =====\n";
		for(int i=1;i<guestCount;i++){
			if(guests[i]!=null){
				data +=i+" | "+guests[i].getName()+" | "+guests[i].getContact()+"\n";
			}
		}

		data+="\n===== BOOKINGS =====\n";
		for(int i=0;i<bookingCount;i++){
			if(bookings[i]!=null){
				String checkin=(bookingCheckIn[i]==null?"":bookingCheckIn[i]);
				String checkout=(bookingCheckOut[i]==null?"":bookingCheckOut[i]);

				data +=bookings[i].getRoom().getRoomNumber()+"=====> "
						+bookings[i].getGuest().getName()+" | CheckIn: "+checkin+"| CheckOut: "+checkout+"\n";				
			}
		}

		data +="\n===== CHECK OUT =====\n";
		if(checkOutHistory.equals("")){
			data +="(~~~No One Checked Out yet)~~~\n";
		}else{
			data +=checkOutHistory;
		}

		data +="\n===== CHANGE ROOM =====\n";
		if(changeRoomHistory.equals("")){
			data +="(~~~~No One changed There Room yet)~~~~\n";
		}else{
			data +=changeRoomHistory;
		}

		screen.setText(data);
	}

	public void showAvailableRoomsOnly(){
		String data ="===== AVAILABLE ROOMS =====\n";
		for(int i=0;i<roomCount;i++){
			if(rooms[i]!=null && rooms[i].getAvailable()){
				data +=rooms[i].getRoomNumber()+" | "+rooms[i].getType()+" | "+" $ "+rooms[i].getPrice()+"\n";			
			}
		}
		screen.setText(data);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		//greeting message to functionality 
		if(firstOpen){
			firstOpen=false;
			updateScreen();
		}
		//clear button working
		if(e.getSource()==roomClearButton){
			roomNoTextField.setText("");
			roomTypeTextField.setText("");
			roomPriceTextField.setText("");
		}
		else if(e.getSource()==guestClearButton){
			guestNameTextField.setText("");
			guestContactTextField.setText("");
		}
		else if(e.getSource()==bookingClearButton){
			bookingGuestTextField.setText("");
			bookingRoomTextField.setText("");
			checkInTextField.setText("");
			checkOutTextField.setText("");
		}

		//room button working
		else if(e.getSource()==addRoomButton){
			try {
				int roomNo=Integer.parseInt(roomNoTextField.getText());
				String type=roomTypeTextField.getText();
				double price= Double.parseDouble(roomPriceTextField.getText());

				rooms[roomCount++]=new Room(roomNo,type,price);
				
				roomNoTextField.setText("");
				roomTypeTextField.setText("");
				roomPriceTextField.setText("");

				updateScreen();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Room Input!");
			}
		}
		//remove room button working
		else if(e.getSource()==removeRoomButton){
			try{
				int roomNo=Integer.parseInt(roomNoTextField.getText());

				for(int i=0;i<roomCount;i++){
					if(rooms[i]!=null && rooms[i].getRoomNumber()==roomNo){
						rooms[i]=null;
						break;
					}
				}
				updateScreen();
			} catch (Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Room Number!");
			}
		}
        //available room button working
		else if(e.getSource()==availableRoomsButton){
			showAvailableRoomsOnly();
		}

		//add guest button working
		else if(e.getSource()==addGuestButton){
			String name=guestNameTextField.getText();
			String contact=guestContactTextField.getText();

			if(name.isEmpty()||contact.isEmpty()){
				JOptionPane.showMessageDialog(this,"Please Enter the Guest Name and Contact Info!");
				return;
			}

			guests[guestCount++]=new Guest(name, contact);

			guestNameTextField.setText("");
			guestContactTextField.setText("");

			updateScreen();
		}

		//book room buttton working
		else if(e.getSource()==bookRoomButton){
			try{
				int guestid=Integer.parseInt(bookingGuestTextField.getText());
				int roomno=Integer.parseInt(bookingRoomTextField.getText());

				String checkin=checkInTextField.getText();
				String checkout=checkOutTextField.getText();

				if(guestid<=0 || guestid >= guestCount || guests[guestid]==null){
					JOptionPane.showMessageDialog(this, "The Guest ID is Incorrect!");
					return;
				}

				boolean roomFound=false;
				for(int i=0;i<roomCount;i++){
					if(rooms[i]!= null && rooms[i].getRoomNumber()==roomno){
						roomFound=true;

						if(!rooms[i].getAvailable()){
							JOptionPane.showMessageDialog(this, "Room is already occupied!");
							return;
						}

						bookings[bookingCount]=new Booking(guests[guestid],rooms[i]);
						bookingCheckIn[bookingCount]=checkin;
						bookingCheckOut[bookingCount]=checkout;

						rooms[i].setAvailable(false);
						bookingCount++;
						break;
					}
				}

				if(!roomFound){
					JOptionPane.showMessageDialog(this,"The Mentioned Room not found!");
				}

				bookingGuestTextField.setText("");
				bookingRoomTextField.setText("");
				checkInTextField.setText("");
				checkOutTextField.setText("");

				updateScreen();

			} catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Booking Input!");
			}
		}

		//check out button working
		else if(e.getSource()==checkOutButton){
			try{
				int roomno=Integer.parseInt(bookingRoomTextField.getText());
				boolean found=false;

				for(int i=0;i<bookingCount;i++){
					if(bookings[i]!=null && bookings[i].getRoom().getRoomNumber()==roomno){

						String guestName=bookings[i].getGuest().getName();
						String checkin=bookingCheckIn[i];
						String checkout=bookingCheckOut[i];

						bookings[i].getRoom().setAvailable(true);

						checkOutHistory += "Room " +roomno+" ===> "+"Guest MX "+guestName+" | Checked In: " + checkin+" | Checked Out: " + checkout + "\n";
								
						bookings[i].checkOut();
						bookings[i]=null;
						bookingCheckIn[i]=null;
						bookingCheckOut[i]=null;

						found=true;
						break;
					}
				}

				if(!found){
					JOptionPane.showMessageDialog(this,"No booking found for this Room!");
				}

				updateScreen();

			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Check Out Input!");
			}
		}

		//change room button working
		else if(e.getSource()==changeRoomButton){
			try{
				int fromRoom=Integer.parseInt(changeRoomFromTextField.getText());
				int toRoom=Integer.parseInt(changeRoomToTextField.getText());

				boolean bookingFound=false;

				for(int i=0;i<bookingCount;i++){
					if(bookings[i]!=null && bookings[i].getRoom().getRoomNumber()==fromRoom){

						bookingFound=true;
						String guestName=bookings[i].getGuest().getName();

						boolean toFound=false;

						for(int j=0;j<roomCount;j++){
							if(rooms[j]!=null && rooms[j].getRoomNumber()==toRoom){
								toFound=true;

								if(!rooms[j].getAvailable()){
									JOptionPane.showMessageDialog(this,"Selected room is occupied!");
									return;
								}

								//Now the previous room is available
								bookings[i].getRoom().setAvailable(true);

								// Changing to the new room
								bookings[i].setRoom(rooms[j]);
								rooms[j].setAvailable(false);

								//change room history upgradation
								changeRoomHistory +="Guest MX " +guestName+" Successfully changed room: "+ fromRoom + " to " + toRoom + "\n";
										
								break;
							}
						}

						if(!toFound){
							JOptionPane.showMessageDialog(this, "The Mentioned Room not found!");
						}

						break;
					}
				}

				if(!bookingFound){
					JOptionPane.showMessageDialog(this, "No booking found for From Room!");
				}

				changeRoomFromTextField.setText("");
				changeRoomToTextField.setText("");

				updateScreen();

			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Change Room Input!");
			}
		}
	}
}
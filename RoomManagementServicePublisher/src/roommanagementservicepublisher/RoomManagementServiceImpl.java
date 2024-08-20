package roommanagementservicepublisher;

import java.util.ArrayList;
import java.util.Collections;

public class RoomManagementServiceImpl implements RoomManagementService{
	
	float Total_Room_Charge = (float) 0.0;
	int Release_Room;

	@Override
	public void startService() {
		System.out.println("Room Management services Started");
		
	}
	
	@Override
	public void Add_Ac_NonAc_Room(String RoomType, ArrayList Avaiable_AC_Rooms, ArrayList Avaiable_NON_AC_Rooms, int roomno) {
		if(RoomType.equals("AC") || RoomType.equals("ac"))
		{
			Avaiable_AC_Rooms.add(roomno);
			System.out.println("\nNEW A/C ROOM (ROOM NO " +roomno+ ") IS ADDED TO THE SYSTEM.");  
			
			Collections.sort(Avaiable_AC_Rooms);
			Collections.sort(Avaiable_NON_AC_Rooms);
			System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
			System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
			
		}
		 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
        {
       	   Avaiable_NON_AC_Rooms.add(roomno);
       	   System.out.println("\nNEW NON A/C ROOM (ROOM NO " +roomno+ ") IS ADDED TO THE SYSTEM.");  
       	  
       	   Collections.sort(Avaiable_AC_Rooms);
		   Collections.sort(Avaiable_NON_AC_Rooms);
		   System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
		   System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
        }
		
	}

	@Override
	public void Remove_Ac_NonAc_Room(String RoomType, ArrayList Avaiable_AC_Rooms, ArrayList Avaiable_NON_AC_Rooms, int roomno) {
		if(RoomType.equals("AC") || RoomType.equals("ac"))
		{
			for(int i=0;i<Avaiable_AC_Rooms.size();i++)
			{
				if(roomno == (int)Avaiable_AC_Rooms.get(i))
				{
					Avaiable_AC_Rooms.remove(i);
					System.out.println("\nA/C ROOM "+roomno+" IS REMOVED.");  
			       	  
				    
				    Collections.sort(Avaiable_AC_Rooms);
				    Collections.sort(Avaiable_NON_AC_Rooms);
				    System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
				    System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
				}
				
			}
		}
		 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
        { 
			 for(int i=0;i<Avaiable_NON_AC_Rooms.size();i++)
				{
					if(roomno == (int)Avaiable_NON_AC_Rooms.get(i))
					{
						Avaiable_NON_AC_Rooms.remove(i);
						System.out.println("\nNON A/C ROOM "+roomno+ " IS REMOVED.");  
			
						Collections.sort(Avaiable_AC_Rooms);
						Collections.sort(Avaiable_NON_AC_Rooms);
						System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
						System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
					}
					
				}
        }
		
	}

	@Override
	public void Book_AC_Room(int no_of_rooms, ArrayList Avaiable_AC_Rooms, ArrayList Avaiable_NON_AC_Rooms, ArrayList ReserveRooms, String name) {
		if(no_of_rooms <= Avaiable_AC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{
			  int j=0;
			  int room = (int) Avaiable_AC_Rooms.remove(j);
			  ReserveRooms.add(room);
			}
			
			Total_Room_Charge = no_of_rooms * 5000;
			
            System.out.println("\n" + no_of_rooms + " ROOMS ARE RESERVED FOR MR/MRS." + name + ".");
            System.out.println("\n\t\t\t===================================== Reservation Details ===============================\n");
            System.out.println("\t\t\t\t\t\t Room Type:          AC Room");
            System.out.println("\t\t\t\t\t\t Customer Name:      " + name);
            System.out.println("\t\t\t\t\t\t No of Rooms:        " + no_of_rooms);
            System.out.println("\t\t\t\t\t\t Total Amount:       Rs." + Total_Room_Charge +"\n");
            System.out.println("\t\t\t==============================================================================================\n\n");
		    
		    Collections.sort(Avaiable_AC_Rooms);
		    Collections.sort(Avaiable_NON_AC_Rooms);
		    System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
		    System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
		    System.out.print("\n");
			
		}
		else
		{
			System.out.println("Sorry!!Number of Available AC Rooms are lesser than the No of Rooms that You want ");
		}
		
	}

	@Override
	public void Book_NON_AC_Room(int no_of_rooms, ArrayList Avaiable_NON_AC_Rooms, ArrayList Avaiable_AC_Rooms, ArrayList ReserveRooms, String name) {
		if(no_of_rooms <= Avaiable_NON_AC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{  
				int j=0;
			    int room = (int) Avaiable_NON_AC_Rooms.remove(j);
			    ReserveRooms.add(room);
			    
			}
			
			Total_Room_Charge = no_of_rooms * 3500;
			
			System.out.println("\n" + no_of_rooms + " ROOMS ARE RESERVED FOR MR/MRS." + name + ".");
			System.out.println("\n\t\t\t===================================== Reservation Details ===============================\n");
            System.out.println("\t\t\t\t\t\t Room Type:          AC Room");
            System.out.println("\t\t\t\t\t\t Customer Name:      " + name);
            System.out.println("\t\t\t\t\t\t No of Rooms:        " + no_of_rooms);
            System.out.println("\t\t\t\t\t\t Total Amount:       Rs." + Total_Room_Charge +"\n");
            System.out.println("\t\t\t==============================================================================================\n\n");
		    
		    System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
		    System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
		    System.out.print("\n");
		}
		else
		{
			System.out.println("Sorry!! Number of Available NON AC Rooms are lesser than the No of Rooms that You want ");
		}
		
	}

	@Override
	public void ReleaseRoom(int Booked_Roomno, ArrayList Avaiable_AC_Rooms, ArrayList Avaiable_NON_AC_Rooms, ArrayList Booked_Rooms) {
		for(int i=0;i<Booked_Rooms.size();i++)
		  {
			   if(Booked_Roomno == (int)Booked_Rooms.get(i))
			   {
				   if((int)Booked_Rooms.get(i) <= 5)
				   {
					   Avaiable_AC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   System.out.println("\nROOM NO " + Booked_Roomno + " IS RELEASED.");  
					   Collections.sort(Avaiable_AC_Rooms);
					   Collections.sort(Avaiable_NON_AC_Rooms);
					   System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
					   System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
					   System.out.print("\n");
				   }
				   else if((int)Booked_Rooms.get(i) >=5 && (int)Booked_Rooms.get(i) <=10 )
				   {
					   Avaiable_NON_AC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   System.out.println("\nROOM NO " + Booked_Roomno + " IS RELEASED.");
					   Collections.sort(Avaiable_AC_Rooms);
					   Collections.sort(Avaiable_NON_AC_Rooms);
					   System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
					   System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
					   System.out.print("\n");
				   }
				   
				   
				   
			   }
			  
			  
		  }
		
	}

	@Override
	public void displayMenu() {
		
		System.out.println("\t\t\t\t\t\t\t                   ROOM MANAGEMENT                 ");
        System.out.println("\t\t\t\t\t\t\t    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\t\t\t\t\t\t\t\t    1. ADD Room");
        System.out.println("\t\t\t\t\t\t\t\t    2. A/C Room Reservation");
        System.out.println("\t\t\t\t\t\t\t\t    3. Non A/C Room Reservation");
        System.out.println("\t\t\t\t\t\t\t\t    4. RELEASE Reserved Room");
        System.out.println("\t\t\t\t\t\t\t\t    5. REMOVE Room");
        System.out.println("\t\t\t\t\t\t\t\t    6. Exit");
        System.out.println("\n\t\t\t\t\t\t\t    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
	}

}

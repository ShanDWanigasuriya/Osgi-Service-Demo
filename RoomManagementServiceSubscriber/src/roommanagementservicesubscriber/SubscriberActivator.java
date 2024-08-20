package roommanagementservicesubscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import roommanagementservicepublisher.RoomManagementService;

public class SubscriberActivator implements BundleActivator {

	private ServiceReference roomManagementRef;
	private ServiceRegistration roomManagementReg;
	private RoomManagementService roomService;
	
	Scanner sc = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Room management publisher service started.");
		roomManagementReg = context.registerService(this.getClass().getName(), this, null);
		roomManagementRef = context.getServiceReference(RoomManagementService.class.getName());
		roomService = (RoomManagementService) context.getService(roomManagementRef);
		
		roomService.startService();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Room management publisher service ended.");
		context.ungetService(roomManagementRef);
	}
	
	public void displayMenu() {
		
		try {
			String Book_Release_Room,Room_Add_type;
	    	int Booked_Room_No,Add_Room_No,Remove_Room_No;
	    	String Room_type = null;
			int no_of_rooms = 0;
			float Total_Room_Charge;
			 
			
			ArrayList<Integer> Avaiable_AC_Rooms  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_NON_AC_Rooms  = new ArrayList<Integer>();
			ArrayList<Integer> Booked_Rooms = new ArrayList<Integer>();
			 
			 
			 Avaiable_AC_Rooms.add(1);
			 Avaiable_AC_Rooms.add(2);
			 Avaiable_AC_Rooms.add(3);
			 Avaiable_AC_Rooms.add(4);
			 Avaiable_AC_Rooms.add(5);
			 
			 
			 Avaiable_NON_AC_Rooms.add(6);
			 Avaiable_NON_AC_Rooms.add(7);
			 Avaiable_NON_AC_Rooms.add(8);
			 Avaiable_NON_AC_Rooms.add(9);
			 Avaiable_NON_AC_Rooms.add(10);
			
		    char menuinput = 'Y';
		    do{
		    	roomService.displayMenu();
		    	int choice;
		    	System.out.print("SELECT THE NO:");
		    	choice = sc.nextInt();
		    	char input='Y';
		    	
		      	do{
		      		
		      		if(choice == 1){
		      			System.out.println("\nAVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
		      			System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
					
		      			System.out.print("\nEnter Room Type [AC,ac or NONAC,nonac]:");
		      			Room_Add_type = sc.next();
			          
		      			System.out.print("Enter New Room No :");
		      			Add_Room_No = sc.nextInt();
			          
		      			roomService.Add_Ac_NonAc_Room(Room_Add_type,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Add_Room_No);
		    	  
		      			System.out.print("\nDO YOU WISH TO CONTINUE:");
		      			input=sc.next().charAt(0);
		          
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      		}
		      		else if(choice == 2){
		      			System.out.println("\n\n\t\t\t===================================== AC Room Reservation ===============================\n");
		      			System.out.println("\t\t    =========================================================================================================");
		                System.out.println("\t\t    	Room Type		                Price");
		                System.out.println("\t\t    =========================================================================================================");
		                System.out.println("\t\t    1. AC Room                                Rs.5000");
		                System.out.println("\t\t    2. NonAC Room                             Rs.3500");
		                System.out.println("\t\t    =========================================================================================================\n\n");
		                System.out.println("\nAVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
		      			System.out.print("\nEnter No Of Rooms:");
		      			no_of_rooms = sc.nextInt();
		      			System.out.print("Please Enter Your Name: ");
		                String name = sc.next();
			         
		      			roomService.Book_AC_Room(no_of_rooms,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms, name);
		      			
		      			System.out.print("\nDO YOU WISH TO CONTINUE:");
		      			input=sc.next().charAt(0);
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      			System.out.println("---------------------------------");
		      		}
		      		else if(choice == 3){
		      			System.out.println("\n\n\t\t\t===================================== Non Ac Room Reservation ===============================\n");
		      			System.out.println("\t\t    =========================================================================================================");
		                System.out.println("\t\t    	Room Type		                Price");
		                System.out.println("\t\t    =========================================================================================================");
		                System.out.println("\t\t    1. AC Room                                Rs.5000");
		                System.out.println("\t\t    2. NonAC Room                             Rs.3500");
		                System.out.println("\t\t    =========================================================================================================\n\n");
		                System.out.println("\nAVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
		      			System.out.print("\nEnter No Of Rooms:");
		      			no_of_rooms = sc.nextInt();
		      			System.out.print("Please Enter Your Name: ");
		                String name = sc.next();
			         
		      			roomService.Book_NON_AC_Room(no_of_rooms,Avaiable_NON_AC_Rooms,Avaiable_AC_Rooms,Booked_Rooms, name);
		    	  
		      			System.out.print("\nDO YOU WISH TO CONTINUE:");
		      			input=sc.next().charAt(0);
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      			System.out.println("---------------------------------");
		      		}
		      		else if(choice == 4){
		      			System.out.println("\nRESERVED ROOMS : "+ Booked_Rooms);
		      			System.out.print("Enter Release Room No:");
		      			Booked_Room_No = sc.nextInt();
					 
		      			roomService.ReleaseRoom(Booked_Room_No,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms);
                  
		      			System.out.print("\nDO YOU WISH TO CONTINUE:");
		      			input=sc.next().charAt(0);
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      			System.out.println("---------------------------------");  
		      		}
		      		else if(choice == 5) {
		      			System.out.println("AVAILABLE A/C ROOMS : "+Avaiable_AC_Rooms);
						System.out.println("AVAILABLE NON A/C ROOMS : "+Avaiable_NON_AC_Rooms);
		      			System.out.print("\nEnter Room Type [AC,ac or NONAC,nonac]:");
		      			Room_Add_type = sc.next();
		          
		      			System.out.print("Enter Remove Room No:");
		      			Remove_Room_No = sc.nextInt();
					
		      			roomService.Remove_Ac_NonAc_Room(Room_Add_type, Avaiable_AC_Rooms, Avaiable_NON_AC_Rooms, Remove_Room_No);
		          
		      			System.out.print("\nDO YOU WISH TO CONTINUE:");
		      			input=sc.next().charAt(0);
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      			System.out.println("---------------------------------");
		      		}
		      		else if(choice == 6) {
		      			System.out.println("Thank You For Using Service");
		      			input = 'n';
		      			menuinput = 'n';
		      			break;
		      		}
		      		else{
		      			System.out.println("\nInvalid Selection Please Input");
		      			input= 'n';
		      			System.out.print("DO YOU WISH GO TO MAIN MENU:");
		      			menuinput = sc.next().charAt(0);
		      			System.out.println("---------------------------------");
		      		}  
		    
		      	}while(input=='Y' || input=='y');
		      
		    }while(menuinput=='Y' || menuinput=='y');
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

}

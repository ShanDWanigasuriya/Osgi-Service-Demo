package eventmanagementservicepublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class EventManageServiceImpl implements EventManageService{
	
	Scanner scan = new Scanner(System.in);
	private ArrayList<Event> eventlist = new ArrayList<Event>();
	
	@Override
	public String publishService() {
		// TODO Auto-generated method stub
		return "Execute the publish service of EventServicePublisher";
	}

	@Override
	public void startService() {
		// TODO Auto-generated method stub
		System.out.println("-----------Welcome to Event Management------------");
		
		Event event1 = new Event(1, "Wedding", "Wedding Hall", 50);
		Event event2 = new Event(2, "Wedding", "Wedding Hall", 150);
		Event event3 = new Event(3, "Wedding", "Wedding Hall", 40);
		Event event4 = new Event(4, "Wedding", "Wedding Hall", 95);
		
		eventlist.add(event1);
		eventlist.add(event2);
		eventlist.add(event3);
		eventlist.add(event4);
		
	}

	@Override
	public ArrayList<Event> viewEvents() {
		// TODO Auto-generated method stub
		return eventlist;
	}

	@Override
	public int addEvents(int event_id, String event_name, String event_location, int noOfAttendees) {
		// TODO Auto-generated method stub
		Event newEvent = new Event(event_id, event_name, event_location, noOfAttendees);
		eventlist.add(newEvent);
		
		return 1;
	}

	@Override
	public int removeEvent(int event_id) {
		// TODO Auto-generated method stub
		eventlist.remove(event_id - 1);
		
		return 1;
	}

	@Override
	public void updateEvent(int event_id) {
		// TODO Auto-generated method stub
		ArrayList<Event> eventlist = viewEvents(); // temporary customer list is created
		
		for(int i = 0; i < eventlist.size(); i++) {
			Event event = eventlist.get(i); // temporary customer to store the customer details
			
			if(event_id == event.getEvent_id()) {
				System.out.println("Event ID: " + event.getEvent_id());
				System.out.println("Event Name: " + event.getEvent_name());
				System.out.println("Event Location: " + event.getEvent_location());
				System.out.println("No of Attendees: " + event.getNoOfAttendees());
				
				System.out.println("--------------------------------------");
				
				System.out.print("Are you sure you want to update: ");
				char user = scan.next().charAt(0);
				scan.nextLine();
				if(user == 'Y' || user == 'y') {
					System.out.print("Enter the Event name: ");
					String event_name = scan.nextLine();
					
					System.out.print("Enter the Event Location: ");
					String event_location = scan.nextLine();
					
					System.out.print("Enter the No of Attendees: ");
					int noOfAttendees = scan.nextInt();
					
					event.setEvent_name(event_name);
					event.setEvent_location(event_location);
					event.setNoOfAttendees(noOfAttendees);
				}
			}
		}
		
	}

	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Menu----");
		System.out.println("1. Add Event");
		System.out.println("2. View Events");
		System.out.println("3. Delete Event");
		System.out.println("4. Update Event");
		System.out.println("5. Make Reservations");
		System.out.println("6. Exit");
		
	}

	@Override
	public void eventManagement() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        
        int eventOption = 2;
        
            System.out.println("\n\n\t\t\t\t    ***************** Welcome to Hotel Event Management Publisher Service******************\n\n");
            System.out.println("\t\t    =========================================================================================================");
            System.out.println("\t\t    	Event Type		                Price");
            System.out.println("\t\t    =========================================================================================================");
            System.out.println("\t\t    1. Conference Room Rental           $500");
            System.out.println("\t\t    2. Banquet Hall Rental              $1000");
            System.out.println("\t\t    =========================================================================================================\n\n");
            
            System.out.print("Please Choose The Event Type: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Please Enter Your Name: ");
                    String name = scanner.next();
                    
                    System.out.print("Please Enter Your Organization: ");
                    String organization = scanner.next();
                    
                    System.out.print("Pick a Date for the Conference: ");
                    String date = scanner.next();
                    
                    System.out.println("\n\n\t\t\t===================================== Your Reservation Details ===============================\n\n");
                    System.out.println("\t\t\t\t\t\t Event Type: Conference Room Rental");
                    System.out.println("\t\t\t\t\t\t Guest Name: " + name);
                    System.out.println("\t\t\t\t\t\t Organization: " + organization);
                    System.out.println("\t\t\t\t\t\t Date: " + date);
                    System.out.println("\t\t\t\t\t\t Total Amount: $500\n\n");
                    System.out.println("\t\t\t==============================================================================================\n\n");
                    break;
                
                case 2:
                    System.out.print("Please Enter Your Name: ");
                    String guestName = scanner.next();
                    
                    System.out.print("Please Enter Your Organization: ");
                    String guestOrganization = scanner.next();
                    
                    System.out.print("Pick a Date for the Event: ");
                    String eventDate = scanner.next();
                    
                    System.out.println("\n\n\t\t\t===================================== Your Reservation Details ===============================\n\n");
                    System.out.println("\t\t\t\t\t\t Event Type: Banquet Hall Rental");
                    System.out.println("\t\t\t\t\t\t Guest Name: " + guestName);
                    System.out.println("\t\t\t\t\t\t Organization: " + guestOrganization);
                    System.out.println("\t\t\t\t\t\t Date: " + eventDate);
                    System.out.println("\t\t\t\t\t\t Total Amount: $1000\n\n");
                    System.out.println("\t\t\t==============================================================================================\n\n");
                    break;
                    
                
                default:
                    System.out.println("\n\nInvalid option. Please try again.\n\n");
                    break;
            }
            
         
        
	}

}

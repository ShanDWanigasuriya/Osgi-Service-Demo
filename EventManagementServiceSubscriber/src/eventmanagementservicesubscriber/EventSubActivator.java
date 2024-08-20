package eventmanagementservicesubscriber;

import eventmanagementservicepublisher.Event;
import eventmanagementservicepublisher.EventManageService;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class EventSubActivator implements BundleActivator {

	Scanner scan = new Scanner(System.in);
	
	private ServiceReference serviceReference;
	private ServiceRegistration eventServiceReg;
	private EventManageService eventService;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Event Subscriber Service");
		eventServiceReg = context.registerService(this.getClass().getName(), this, null);
		serviceReference = context.getServiceReference(EventManageService.class.getName());
		eventService = (EventManageService) context.getService(serviceReference);
		eventService.startService();
	}

	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Event Subscriber Stop");
		context.ungetService(serviceReference);
	}
	
	public void displayMenu() {
		try {
			
			int indexNo = 0;
			int noOfAttendees;
			String eventName, eventLocation;
			
			
			char menuInput = 'y';
			do {
				
				eventService.displayMenu();
				
				System.out.print("\nSelect the No: ");
				int choice = scan.nextInt();
				
				if(choice == 1) { 
					ArrayList<Event> eventList = eventService.viewEvents(); 
					boolean exist = false;
					 
						System.out.print("Enter the event id: ");
						indexNo = scan.nextInt();
						
						for(Event event : eventList) { 
							if(event.getEvent_id() == indexNo) {
								System.out.println("Event with this number already exist!");
								exist = true;
								break;
							}
						}
					
					scan.nextLine();
					System.out.print("Enter the event name: ");
					eventName = scan.nextLine();
					
					System.out.print("Enter the event Location: ");
					eventLocation = scan.nextLine();
					
					System.out.print("Enter the no Of Attendees: ");
					noOfAttendees = scan.nextInt();
					
					eventService.addEvents(indexNo, eventName, eventLocation, noOfAttendees);
					System.out.println("Event successfully added to the system\n");
				} else if(choice == 2) {
					
					ArrayList<Event> eventList = eventService.viewEvents();
					
					for(Event event : eventList) {
						System.out.println("Event Number: " + event.getEvent_id());
						System.out.println("Event Name: " + event.getEvent_name());
						System.out.println("Event Location: " + event.getEvent_location());
						System.out.println("No of Attendies: " + event.getNoOfAttendees()); 
						System.out.println("\n------------------------------------------------\n");
					}
					
				} else if(choice == 3) {
					
					ArrayList<Event> eventList = eventService.viewEvents();
					
					System.out.print("Enter the event number to delete: ");
					indexNo = scan.nextInt();
					
					for(Event event : eventList) {
						if(event.getEvent_id() == indexNo) {
							System.out.println("Event Name: " + event.getEvent_name());
							System.out.println("Event Location: " + event.getEvent_location());
							System.out.println("No of Attendies: " + event.getNoOfAttendees() + "\n");
							
							System.out.print("Are you sure you want to delete(y/n): ");
							char delete = scan.next().charAt(0);
							if(delete == 'Y' || delete == 'y') {
								eventService.removeEvent(indexNo);
								System.out.println("Event Remove successfully\n");
							}
						}
					}
					
				} else if(choice == 4) {
					
					System.out.print("Enter the event number to UPDATE: ");
					indexNo = scan.nextInt();
					
					eventService.updateEvent(indexNo);
					System.out.println("Event Updated successfully\n");
					
				} else if(choice == 5) {					
					eventService.eventManagement();
				}else if(choice == 6) {					
					System.out.println("Exiting the event management system!");
					menuInput = 'n';
				} else {
					System.out.println("Invalid Input, please try again!!!");
				}
				
			}while(menuInput == 'Y' || menuInput == 'y');
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

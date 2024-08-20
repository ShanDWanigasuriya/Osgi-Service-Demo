package mainconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import customermanagementserviceconsumer.CusConActivator;
import eventmanagementservicesubscriber.EventSubActivator;
import restaurantmanageservicesubscriber.RestaurantActivator;
import roommanagementservicesubscriber.SubscriberActivator;

public class MainConsumerActivator implements BundleActivator {
	private ServiceReference roomRef;
	private ServiceReference restRef;
	private ServiceReference cusRef;
	private ServiceReference eventRef;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		MainConsumerActivator.context = bundleContext;
		
		//connect to room management consumer
		roomRef = context.getServiceReference(SubscriberActivator.class.getName());
		SubscriberActivator roomManagement = (SubscriberActivator) bundleContext.getService(roomRef);
		
		//connect to customer management consumer
		cusRef = context.getServiceReference(CusConActivator.class.getName());
		CusConActivator cusManagement = (CusConActivator) bundleContext.getService(cusRef);
		
		//connect to restaurant management consumer
		restRef = context.getServiceReference(RestaurantActivator.class.getName());
		RestaurantActivator restaurantManagement = (RestaurantActivator) bundleContext.getService(restRef);
		
		//connect to event management consumer
		eventRef = context.getServiceReference(EventSubActivator.class.getName());
		EventSubActivator eventtManagement = (EventSubActivator) bundleContext.getService(eventRef);
		
		System.out.println("Main menu Loading.....");
		Scanner sc = new Scanner(System.in);
				
		while(true) {
			int option = 0;
			
			System.out.println("\n\n\t\t\t\t\t    ********************** Welcome to Hotel Management System ***********************\n");
            System.out.println("\t\t\t\t\t\t\t                    SERVICES                 ");
            System.out.println("\t\t\t\t\t\t\t    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\n\t\t\t\t\t\t\t\t    1. Room Management & Reservation");
            System.out.println("\t\t\t\t\t\t\t\t    2. Customer Management");
            System.out.println("\t\t\t\t\t\t\t\t    3. Event Management");
            System.out.println("\t\t\t\t\t\t\t\t    4. Restaurant Management");
            System.out.println("\t\t\t\t\t\t\t\t    5. Exit");
            System.out.println("\n\t\t\t\t\t\t\t    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			System.out.print("\nYOUR OPTION :");
			option = sc.nextInt();

			switch (option) {
				case 1:
					roomManagement.displayMenu();
					break;
				case 2:
					cusManagement.displayMenu();
					break;
				case 3:
					eventtManagement.displayMenu();
					break;
				case 4:
					restaurantManagement.displaymenu();
					break;
				case 5:
					break;
                default:
                    System.out.println("\nInvalid Input. Please try again.\n");
                    break;
			}
					
			if(option == 5) {
				break;
			}			
					
		}
				
		System.out.println("Thank you");
				
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		MainConsumerActivator.context = null;
		System.out.println("Main menu closed");
	}

}

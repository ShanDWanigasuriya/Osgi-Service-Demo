package customermanagementserviceconsumer;

import customermanagementservicepublisher.Customer;
import customermanagementservicepublisher.CustomerManageService;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class CusConActivator implements BundleActivator {
	
	Scanner scan = new Scanner(System.in);
	
	private ServiceReference serviceReference;
	private ServiceRegistration cusServiceReg;
	private CustomerManageService customerService;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Customer Subscriber Service");
		cusServiceReg = context.registerService(this.getClass().getName(), this, null);
		serviceReference = context.getServiceReference(CustomerManageService.class.getName());
		customerService = (CustomerManageService) context.getService(serviceReference);
		customerService.startService();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		context.ungetService(serviceReference);
	}
	
	public void displayMenu() {
		try {
			
			int indexNo = 0;
			String customerName, customerEmail, customerNumber;
			
			
			char menuInput = 'y';
			do {
				
				customerService.displayMenu();
				
				System.out.print("\nSelect the No: ");
				int choice = scan.nextInt();
				
				if(choice == 1) { // choice 1 add customer
					ArrayList<Customer> customerList = customerService.viewCustomers(); // get the customer list from the publisher
					boolean exist = false;
					
						System.out.print("Enter the customer registation number: ");
						indexNo = scan.nextInt();
						
						for(Customer customer : customerList) { // to check if a customer id already exist
							if(customer.getCustomer_id() == indexNo) {
								System.out.println("Customer with the registration number already exist!");
								exist = true;
								break;
							}
						}
					
					scan.nextLine();
					System.out.print("Enter the customer name: ");
					customerName = scan.nextLine();
					
					System.out.print("Enter the customer email: ");
					customerEmail = scan.nextLine();
					
					System.out.print("Enter the customer contact no: ");
					customerNumber = scan.nextLine();
					
					customerService.addCustomers(indexNo, customerName, customerEmail, customerNumber);
					System.out.println("Customer successfully added to the system\n");
				} else if(choice == 2) {
					
					ArrayList<Customer> customerList = customerService.viewCustomers();
					
					for(Customer customer : customerList) {
						System.out.println("Customer Registration Number: " + customer.getCustomer_id());
						System.out.println("Customer Name: " + customer.getCustomer_name());
						System.out.println("Customer Email: " + customer.getCustomer_email());
						System.out.println("Customer Contact Number: " + customer.getCustomer_contactno());
						System.out.println("\n------------------------------------------------\n");
					}
					
				} else if(choice == 3) {
					
					ArrayList<Customer> customerList = customerService.viewCustomers();
					
					System.out.print("Enter the customer registration number to delete: ");
					indexNo = scan.nextInt();
					
					for(Customer customer : customerList) {
						if(customer.getCustomer_id() == indexNo) {
							System.out.println("Customer Name: " + customer.getCustomer_name());
							System.out.println("Customer Email: " + customer.getCustomer_email());
							System.out.println("Customer Contact Number: " + customer.getCustomer_contactno() + "\n");
							System.out.print("Are you sure you want to delete(y/n): ");
							char delete = scan.next().charAt(0);
							if(delete == 'Y' || delete == 'y') {
								customerService.removeCustomer(indexNo);
								System.out.println("Customer Remove successfully");
								break;
						}
						}
					}
					
				} else if(choice == 4) {
					
					System.out.print("Enter the customer registration number to UPDATE: ");
					indexNo = scan.nextInt();
					
					customerService.updateCustomer(indexNo);
					
				} else if(choice == 5) {					
					System.out.println("Exiting the customer management system!");
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

package customermanagementservicepublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManageServiceImpl implements CustomerManageService{
	
	Scanner scan = new Scanner(System.in);
	private ArrayList<Customer> customerlist = new ArrayList<Customer>();
	
	@Override
	public String publishService() {
		// TODO Auto-generated method stub
		return "Execute the publish service of ServicePublisher";
	}

	@Override
	public void startService() {
		// TODO Auto-generated method stub
		System.out.println("-----------Welcome to customer------------");
		
		Customer customer1 = new Customer(1, "Malshan Rathnayaka", "malshan@gmail.com", "0762388567");
		Customer customer2 = new Customer(2, "Shan Dilhara", "shandilhara@gmail.com", "0762388567");
		Customer customer3 = new Customer(3, "Chamodi", "chamodi@gmail.com", "0762388567");
		Customer customer4 = new Customer(4, "Jehan Silva", "jehansilva@gmail.com", "0762388567");
		
		customerlist.add(customer1);
		customerlist.add(customer2);
		customerlist.add(customer3);
		customerlist.add(customer4);
	}

	@Override
	public ArrayList<Customer> viewCustomers() {
		// TODO Auto-generated method stub
		return customerlist;
	}

	@Override
	public int addCustomers(int customer_id, String customer_name, String customer_email, String customer_contactno) {
		// TODO Auto-generated method stub
		Customer newCustomer = new Customer(customer_id, customer_name, customer_email, customer_contactno);
		customerlist.add(newCustomer);
		
		return 1;
	}

	@Override
	public int removeCustomer(int customer_id) {
		// TODO Auto-generated method stub
		customerlist.remove(customer_id - 1);
		
		return 1;
	}

	@Override
	public void updateCustomer(int customer_id) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerlist = viewCustomers(); // temporary customer list is created
		
		for(int i = 0; i < customerlist.size(); i++) {
			Customer customer = customerlist.get(i); // temporary customer to store the customer details
			
			if(customer_id == customer.getCustomer_id()) {
				System.out.println("Customer Index: " + customer.getCustomer_id());
				System.out.println("Customer Name: " + customer.getCustomer_name());
				System.out.println("Customer Email: " + customer.getCustomer_email());
				System.out.println("Customer Contact No: " + customer.getCustomer_contactno());
				
				System.out.println("--------------------------------------");
				
				System.out.print("Are you sure you want to update: ");
				char user = scan.next().charAt(0);
				scan.nextLine();
				if(user == 'Y' || user == 'y') {
					System.out.print("\nEnter the customer name: ");
					String customer_name = scan.nextLine();
					
					System.out.print("Enter the customer email: ");
					String customer_email = scan.nextLine();
					
					System.out.print("Enter the customer contact number: ");
					String customer_contactno = scan.nextLine();
					
					customer.setCustomer_name(customer_name);
					customer.setCustomer_email(customer_email);
					customer.setCustomer_contactno(customer_contactno);
					System.out.println("Customer details updated succesfully\n");
				}
			}
		}
	}

	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Menu----");
		System.out.println("1. Add Customer");
		System.out.println("2. View Customers");
		System.out.println("3. Delete Customer");
		System.out.println("4. Update Customer");
		System.out.println("5. Exit");
	}

}

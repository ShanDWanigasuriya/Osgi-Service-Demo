package customermanagementservicepublisher;

import java.util.ArrayList;

public interface CustomerManageService {
	public String publishService();
	public void startService();
	public ArrayList<Customer> viewCustomers();
	public int addCustomers(int customer_id, String customer_name, String customer_email, String customer_contactno);
	public int removeCustomer(int customer_id);
	public void updateCustomer(int customer_id);
	public void displayMenu();
}

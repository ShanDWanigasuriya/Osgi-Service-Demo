package customermanagementservicepublisher;

public class Customer {
	private int customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_contactno;
	
	public Customer(int customer_id, String customer_name, String customer_email, String customer_contactno) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_contactno = customer_contactno;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_contactno() {
		return customer_contactno;
	}

	public void setCustomer_contactno(String customer_contactno) {
		this.customer_contactno = customer_contactno;
	}
}

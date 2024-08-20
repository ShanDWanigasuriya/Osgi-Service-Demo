package restaurantmanageservicesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import restaurantmanageservicepublisher.RestaurantManageService;

public class RestaurantActivator implements BundleActivator {

	private ServiceReference serviceReference;
	private ServiceRegistration restaurantManagementReg;
	private RestaurantManageService CustomerService;

	 
	public void start(BundleContext context) throws Exception {
		System.out.println(" ********** ...Subscriber started... **********");
		restaurantManagementReg = context.registerService(this.getClass().getName(), this, null);
		serviceReference = context.getServiceReference(RestaurantManageService.class.getName());
		CustomerService = (RestaurantManageService) context.getService(serviceReference);
		
		
 	}

	 
	public void stop(BundleContext context) throws Exception {
		 System.out.println("Subscriber service terminated...");
		 context.ungetService(serviceReference);
	}
	
	public void displaymenu(){
		System.out.println(CustomerService.createMenu());
		boolean askAgain = true;
		float totalBillAmount = 0;
		
		//Below loop is for iterate each adding of food over and over.
        //When user inserts 'n' then the loop will be over
		
		do {
			boolean codeNotFound = true;
			Scanner food = new Scanner(System.in); 
			float priceFood = 0;
			int codeFood;
			String foodName="";
			
			float quatityprice;
			
			do {
				System.out.println("Enter code: ");
				codeFood=food.nextInt();
				
				codeNotFound = CustomerService.checkFoodCode(codeFood);
			}while(codeNotFound);
			
			System.out.println("Enter Quantity: ");
			food = new Scanner(System.in);
			int Quantity = food.nextInt();
			
			CustomerService.storeQuantity(codeFood, Quantity);
			
			boolean invalidDecisionCharacter = true; //to stop the whole process
			try {
				do {
					//needs to insert a valid Y or No otherwise it will be iterated
					String generatedBill = CustomerService.generateBill();
					System.out.println(""
                    		+ "\n----------------------------------------------\n"
                    		+ "01.Insert 'Y' to add more food.\n\n"
                    		+ "02.Insert 'N' to finalize the order."
                    		+ "\n\n03.Enter 's' to view the bill summary.\n\n"
                    		+ "04.Insert 'd' to cancel the order(Terminate the program).\n\n"
                    		+ "05.Insert 'r' to remove an item.\n\n"
                    		+ "06.insert 'q' to remove quantity of an item."
                    		+"\n----------------------------------------------\n"
                    		+ "\n\nInsert:-");
					food = new Scanner(System.in);
					String decision=food.nextLine();
					
					if((decision.equalsIgnoreCase("y"))) {
						invalidDecisionCharacter=false;
					}else if((decision.equalsIgnoreCase("n"))) {
						
						if(generatedBill==null) {
							System.out.println("\n\nThere's no bill to generate...");
						}else {
							askAgain = false;
							invalidDecisionCharacter = false;
							System.out.println(generatedBill+CustomerService.finalizeBill());
						}
					}else if((decision.equalsIgnoreCase("s"))) {
						System.out.println(generatedBill);
					}else if((decision.equalsIgnoreCase("d"))) {
						invalidDecisionCharacter=false;
                    	askAgain=false;
                        System.out.println("\nOrder Cancelled...");
					}else if((decision.equalsIgnoreCase("r"))) {
						System.out.println("Enter code: ");
						food = new Scanner(System.in);
						codeFood=food.nextInt();
						codeNotFound=true;
						codeNotFound = CustomerService.checkFoodCode(codeFood);
						if(codeNotFound==false) {
							CustomerService.removeItem(codeFood);
						}
					}else if (decision.equalsIgnoreCase("q")) {
						System.out.println("Enter code: ");
						food = new Scanner(System.in);
						codeFood= food.nextInt();
						
						codeNotFound = true;
						codeNotFound = CustomerService.checkFoodCode(codeFood);
						
						if(codeNotFound==false) {
							System.out.println("Enter Quantity: ");
							food = new Scanner(System.in); 
							Quantity = food.nextInt();
							
							CustomerService.removeQuantity(codeFood, Quantity);
						}
						
					}else {
						System.out.println("\n\n X( The character you inserted is invalid !! Try Again X( ");
					}
				}while(invalidDecisionCharacter);
				
			}catch(Exception e) {
				System.out.println("Error Found: "+e);
			}
		}while(askAgain);
	}

}

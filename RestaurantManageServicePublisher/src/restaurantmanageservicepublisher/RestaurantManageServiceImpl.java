package restaurantmanageservicepublisher;

import java.util.HashMap;
import java.util.Map;

public class RestaurantManageServiceImpl implements RestaurantManageService{
	
	private float[][] priceList = {
			{1, 1000},
			{2, 2500},
			{3, 3000}
	};
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>(){
		{
		put(1, "French Fries");
		put(2, "Pasta");
		put(3, "Fried Rice");
		}
	};
	
	HashMap<Integer, Integer> quantityManage = new HashMap<Integer, Integer>();
	
	@Override
	public boolean checkFoodCode(int codeFood) {
		// TODO Auto-generated method stub
		
		for(int c=0; c<priceList.length; c++) { //algorithm to check food code
			if(codeFood == priceList[c][0]) {
				c=priceList.length;
				return false;
			}else {
				if((c+1)==priceList.length) {
					System.out.println("\n------------------------------------------------\n"
							+"Food code you entered is invalid...Please try again\n"
							+"------------------------------------------------\n\n"
							+ "\n");
					return true;
				}
			}
		}
		return true;
		 
	}
	@Override
	public void storeQuantity(int code, int quantity) {
		// TODO Auto-generated method stub
		boolean codeExists = quantityManage.containsKey(code);
		
		if(codeExists) {
			int existingQuantity = quantityManage.get(code);
			existingQuantity+=quantity;
			quantityManage.replace(code, existingQuantity);
		}else {
			quantityManage.put(code, quantity);
		}
		
	}

	@Override
	public float getFoodPrice(int codeFood) {
		// TODO Auto-generated method stub
		for(int c=0;c<priceList.length;c++) {
			if(codeFood == priceList[c][0]) {
				return priceList[c][1];
			}
		}
		System.out.println("Value Not Found");
		return 0;
	}

	

	@Override
	public float calculatePerQuantity(int quantity, float price) {
		// TODO Auto-generated method stub
		return ((float)(quantity * price));
	}

	@Override
	public String initializeBill() {
		// TODO Auto-generated method stub
		
		return "\n------------------------------Bill Summary------------------------------\n"+
		"Food code | Food Name          | Quantity  | Price | Quantity Price ";
	}

	@Override
	public String finalizeBill() {
		// TODO Auto-generated method stub
		return "\n\nTotal  				=			"+totalBillAmount()+"\n\n"
		+ "\nThank you ! Enjoy your order!\n" +
        "\n-----------------------------------------------------------------------------------\n";	}

	@Override
	public String createMenu() {
		// TODO Auto-generated method stub
		String listViewForMenu = "";
		
		for(int count=0; count<priceList.length; count++) {
			listViewForMenu+="\n"+(int)priceList[count][0]+"	   "+hm.get((int)priceList[count][0])+"    "+"--------------------------------"+priceList[count][1]+"\\=";
		}
		
		return "Food code | Food Name 				     | Price (LKR)\n"
		+listViewForMenu+"\n\n"
		+"\n--------------------------------------------------------------------------------\n\n";
	}

	@Override
	public String generateBill() {
		// TODO Auto-generated method stub
		String billReturn = initializeBill();
		
		for(Map.Entry m : quantityManage.entrySet()) {
			int code = (int)m.getKey();
			int quantity = quantityManage.get(code);
			float quantityPrice = calculatePerQuantity(quantity, getFoodPrice(code));
			
			billReturn+= "\n"+code+"          "+hm.get(code)+ "           "+quantity+"         "+getFoodPrice(code)+"         "+quantityPrice+"\n";
		}
		if(quantityManage.isEmpty()) {
			return null;
		}else {
			return billReturn;
		}
	}

	@Override
	public float totalBillAmount() {
		// TODO Auto-generated method stub
		float total = 0;
		for(Map.Entry m : quantityManage.entrySet()){ 
			int code=(int)m.getKey();
			total+=(getFoodPrice(code)*quantityManage.get(code));

		}
		return total;
		 
	}

	@Override
	public void removeQuantity(int code, int quantity) {
		// TODO Auto-generated method stub
		boolean codeExists = quantityManage.containsKey(code);
		
		if(codeExists) {
			
			int existingQuantity = quantityManage.get(code);
			
			if(existingQuantity == quantity) {
				removeItem(code);
			}else if(existingQuantity>quantity) {
				existingQuantity-=quantity;
				quantityManage.replace(code, existingQuantity);
			}else {
				System.out.println("\nPlease check existing quantity for the food selected.. \n");
			}
		}else {
			System.out.println("\nYou haven't added that item... check your summary properly.\n");
		}
		
	}

	@Override
	public void removeItem(int code) {
		// TODO Auto-generated method stub
		boolean codeExists = quantityManage.containsKey(code);
		
		if(codeExists) {
			int removedItem = quantityManage.remove(code);
			if(removedItem>0) {
				System.out.println("Item removed");
			}
		}else {
			System.out.println("\nYou haven't added that item...Check your summary properly.\n");
		}
		
	}

}

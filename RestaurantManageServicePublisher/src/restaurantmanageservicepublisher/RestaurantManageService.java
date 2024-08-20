package restaurantmanageservicepublisher;

public interface RestaurantManageService {
	public void storeQuantity(int code, int quantity);
	public float getFoodPrice(int codeFood);
	public boolean checkFoodCode(int codeFood);
	public float calculatePerQuantity(int quantity, float price);
	public String initializeBill();
	public String finalizeBill();
	public String createMenu();
	public String generateBill();
	public float totalBillAmount();
	public void removeQuantity(int code, int quantity);
	public void removeItem(int code);

}

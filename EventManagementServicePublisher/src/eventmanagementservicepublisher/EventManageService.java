package eventmanagementservicepublisher;

import java.util.ArrayList;

public interface EventManageService {
	public String publishService();
	public void startService();
	public ArrayList<Event> viewEvents();
	public int addEvents(int event_id, String event_name, String event_location, int noOfAttendees);
	public int removeEvent(int event_id);
	public void updateEvent(int event_id);
	public void displayMenu();
	public void eventManagement();
}

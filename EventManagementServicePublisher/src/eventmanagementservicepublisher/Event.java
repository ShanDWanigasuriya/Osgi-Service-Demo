package eventmanagementservicepublisher;

public class Event {
	private int event_id;
	private String event_name;
	private String event_location;
	private int noOfAttendees;
	
	public Event(int event_id, String event_name, String event_location, int noOfAttendees) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_location = event_location;
		this.noOfAttendees = noOfAttendees;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_location() {
		return event_location;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public int getNoOfAttendees() {
		return noOfAttendees;
	}

	public void setNoOfAttendees(int noOfAttendees) {
		this.noOfAttendees = noOfAttendees;
	}
}

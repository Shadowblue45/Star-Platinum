package attendance;

public class Student implements Attendee {
	
	private boolean present = false;
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		present = true;
	}
	
	
}

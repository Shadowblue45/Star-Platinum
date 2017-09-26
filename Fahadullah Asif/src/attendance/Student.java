package attendance;

public class Student implements Attendee {
	
	private boolean present = false;
	String firstName;
	String lastName;
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		present = true;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	//returns true if 'first' and 'last' match this Attendee's firstName and lastName. This should NOT be case sensitive. 
	public boolean mathces(String first, String last) {
		if(matches(last) && firstName == first) {
			return true;
		}
		return false;
	}

	
	//returns true if 'last' matches this Attendee's lastName. This should NOT be case sensitive.
	public boolean matches(String last) {
		if(lastName == last) {
			return true;
		}
		return false;
	}

	//returns three words separated by 20 spaces: 
	//at index 0, the last name
	//at index 20, the first name
	//at index 40, the word PRESENT or ABSENT
	//ADDED CHALLENGE:
	//if last name or first name is longer than 20 characters, 
	//cut off the last three letters and replace with "..."
	public String getReportString() {
		 int index;
		 
	}
	
	
}

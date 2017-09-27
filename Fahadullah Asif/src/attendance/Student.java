package attendance;

public class Student implements Attendee {
	
	private boolean present;
	String firstName;
	String lastName;
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		present = false;
	}
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		this.present = true;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}
	
	public boolean matches(String last) {
		return last.toLowerCase().equals(lastName.toLowerCase());
	}


	public String getReportString() {
		 String report = lastName;
		 report = restrictStringToLength(report,20);
		 report+=firstName;
		 report = restrictStringToLength(report,40);
		 if(present) {
			 report+="PRESENT\n";
		 }
		 else {
			 report+="ABSENT\n";
		 }
		 return report;
	}
	
	public String restrictStringToLength(String s1, int x) {
		if(s1.length() > x) {
			s1 = s1.substring(0,x-3) + "...";
		}
		else {
			while (s1.length() < x) {
				s1+=" ";
			}
		}
		return s1;
	}
}

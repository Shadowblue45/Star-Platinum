package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"F", "D", "T", "G","M"};
	public static final String[] FIRST_MIDDLE = {"aha", "avi", "yle", "arre","arya"};
	public static final String[] FIRST_END = {"r", "d", "tt", "g","m"};

	public static final String[] LAST_START = {"A", "Y", "O", "Ch"};
	public static final String[] LAST_MIDDLE = {"si", "asha", "ven", "e"};
	public static final String[] LAST_END = {"f", "yev", "den", "n"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	public Person(String firstName, String lastName, Borough home){
		this.firstName =  firstName;
		this.lastName = lastName;
		this.home = home;
	}
	
	public String toString() {
		return "My name is  " + firstName + " " + lastName + " and i live in " + home + ".";
	}
}

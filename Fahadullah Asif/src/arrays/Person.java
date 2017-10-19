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
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String firstName, String lastName, Borough home){
		this.firstName =  firstName;
		this.lastName = lastName;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		this.friends = new Person[3];
	}
	
	public void mingle(Person[] people) {
		for (Person p: people){
			if(p != this) {
				p = betterFriend(p,friends[0]);
				
				addFriendToFirstPlace(p);
			}
		}
	}
	public void printFriends() {
		System.out.println("My name is " + firstName + " " + lastName + " and these are all my friends:");
		for (Person f: friends) {
			if(f!= null) {
				System.out.println(f);
			}
		}
	}
	public void addFriendToFirstPlace(Person p) {
		for(int i =friends.length-1; i > 0;i--){
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == q.getClass() && p.getClass() == this.getClass()) {
			if(p.hobby == this.hobby) {
				return p;
			}
			if(q.hobby == this.hobby) {
				return q;
			}
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		return q;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and i live in " + home + ". I like " + hobby + ". ";
	}
}

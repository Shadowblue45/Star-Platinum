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
	private String nickname;
	
	public Person(String firstName, String lastName, Borough home){
		this.firstName =  firstName;
		this.lastName = lastName;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		this.friends = new Person[3];
		this.nickname = createNickname(firstName);
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
		if(q.getClass() == this.getClass() && p.getClass() == this.getClass()) {
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
	
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
		nickname = createNickname(firstName);
	}
	
	// JAVA IS PASS-BY-VALUE
	//meaning the parameters of a method are just values, not references
	//so if you change those values, the original objects is not affected.
	//in this case, 'name' will not be changed. In fact, Nothing can Change
	//this.firstname via name
	public static String createNickname(String name) {
		int vowelPos = findSecond(name);
		String nickname = name.substring(0,vowelPos);
		return nickname;
	}
	private static int findSecond(String name) {
		boolean foundVowel = false;
		name = name.toLowerCase();
		int index = name.length();
		for(int i = 0; i< name.length();i++) {
			if(i+1< name.length()) {
				if(name.substring(i,i+1).equals("a") || name.substring(i,i+1).equals("e") || name.substring(i,i+1).equals("i") || name.substring(i,i+1).equals("o") || name.substring(i,i+1).equals("u")) {
					if(!foundVowel) {
						foundVowel = true;
					}
					else {
						return i;
					}
				}
			}
		}
		return index;
	}

	public String toString() {
		return "My name is " + firstName + " " + lastName + ". Call me " + nickname + ". ";
	}
}

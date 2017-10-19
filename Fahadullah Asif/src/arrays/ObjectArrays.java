package arrays;

import java.util.Arrays;

public class ObjectArrays {
	public ObjectArrays(){
		Person[] people = new Person [40];
		populate(people);
		for (Person p: people){
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}
	}

	private void populate(Person[] people) {
		for(int i = 0; i< people.length;i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			if(Math.random() < .6) {
				people[i] = new Student(firstName, lastName, b, (int)(Math.random() * 5) + 9);
			}
			else {
				people[i] = new Person(firstName, lastName,b);
			}
		}
	}
	
	public Person[] selectGroup(Person[] population, int length) {
		Person[] group = new Person[length];
		group[0] = selectAPerson(population);
		for(int i = 0; i < population.length;i++) {
			Person nextPerson = selectAPerson(population);
			while(personInGroup(group, nextPerson)) {
				nextPerson = selectAPerson(population);
			}
			group[i] = nextPerson;
		}
		return group;
	}

	public static boolean personInGroup(Person[] group, Person nextPerson) {
		for(int i = 0; i < group.length;i++) {
			if(group[i] == nextPerson) {
				return true;
			}
		}
		return false;
	}

	public Person selectAPerson(Person[] population) {
		int randNum = (int)(Math.random() * population.length);
		return population[randNum];
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random() * Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}
}

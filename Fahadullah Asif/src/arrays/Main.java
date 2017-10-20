package arrays;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		ObjectArrays oA = new ObjectArrays();
		Person s = new Person("Fahadllah", "Asif",Borough.NY_BOROUGHS[0]);
		int x = 10;
		int[] a = {5,6,7};
		test2(s,x,a);
		System.out.println(s + ", " + x + ", " + Arrays.toString(a));
	}
	
	/*
	 * PASS-By-Values Examples
	 * NO VOID METHOD CAN PERMANENTLY CHANGE AN INT
	 * (you can if you set it as return)
	 */
	public static void test(Person s, int x, int[] arr) {
		String name = s.getFirstName();
		name = "Shadow";
		x = 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	public static void test2(Person s, int x, int[] arr) {
		s.setFirstName("Shadow");
		x = 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
}

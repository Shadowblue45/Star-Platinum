package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] testArray;
	private int[] intRay;
	public ArraysMain() {
		intRay = new int[50];
		populate(intRay);
		checkOccurences(intRay,2,12);
		//Arrays is a Utility class included in java for formatting output;
		System.out.println(Arrays.toString(intRay));
	}
	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start + 1];
		for(int value: arr) {
			counter[value - start]++;
		}
		for(int i = 0; i< counter.length;i++) {
			System.out.println("A " + (start + i) + " was rolled " + counter[i] + " times.");
		}
	}
	private void populate(int[] intRay) {
		for(int i = 0; i< intRay.length;i++) {
			intRay[i] = diceRoll(2);
		}
	}
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	public int diceRoll(int numberOfDice) {
		int roll = 0;
		for(int i = 0;i<numberOfDice;i++) {
			roll = roll + 1 + (int)(Math.random() * 6);
		}
		return roll;
	}
	public void notes() {
		//1.collection of primitive objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2.Size can not be modified
		
		/*3. Elements of an array are REFERENCES to objects.
		 * In other words, changing an element of an array changes
		 * the REFERENCE, not the object(more on this later)
		 * 
		 */
		
		//there are two types of constructors, the first we have already seen:
		int[] firstType = {3,14,-9,10};
		//this constructor can only be used at the declaration. Error:
		//firstType = {12,13,14,15};
		
		//the 2nd type:
		testArray = new String[50];
		//SPECIAL NOTE: for primative arrays, when 
		
		//standard 'for' loop
		for(int i = 0; i<testArray.length;i++) {
			System.out.println("The " + i + " item is: " + testArray[i]);
		}
		
		//for each loop(useful only when you don't need to keep track of an index)
		for(String value:testArray) {
			//"for each int in test array..."
			System.out.println(value);
		}
	}
}

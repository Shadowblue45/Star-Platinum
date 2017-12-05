package sequence;

public class Recursion {

	public static void main(String[] args) {
		hanoi(3,"A","B","C");
	}

	public static void hanoi(int i, String start, String help, String end) {
		if(i == 1) {
			print(start + " to " + end);
		}
		else {
			hanoi(i-1,start,end,help);
			print(start + " to " + end);
			hanoi(i-1,help,start,end);
		}
	}

	private static void print(String s) {
		System.out.println(s);
	}

}

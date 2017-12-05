package sequence;

public class FibonacciSequence {

	public static void main(String[] args) {
		for(int i = 0; i < 45; i++) {
			System.out.println(fibbonacci(i));
		}
	}

	public static int fibbonacci(int num) {
		if(num <= 1) {
			return 1;
		}
		else {
			return fibbonacci(num-1) + fibbonacci(num-2);
		}
	}
}

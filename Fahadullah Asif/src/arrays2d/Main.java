package arrays2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * This idea is another major topic in AP CSA
	 * It is the idea of avoiding an ArrayIndexOutOfBoundsException
	 * you will see it on quizzes, tests and projects
	 * So ALWAYYS BE MINDFUL!
	 */
	public static void changeNeighbors(int[] arr, int psn) {
		arr[psn] += 1;
		
		if(arr.length > 1) {
			
			if(psn == 0) {
				arr[psn + 1]-=1;
			}
			else if(psn == arr.length -1) {
				
			}
		}
	}
}

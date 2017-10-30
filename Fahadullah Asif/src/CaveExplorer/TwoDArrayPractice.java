package CaveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][]pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length; col++) {
				pic[row][col] = " ";
			}
		}
		//drawHorizontalLine(pic,1);
		//drawHorizontalLine(pic,4);
		//drawVerticalLine(pic,1);
		//drawVerticalLine(pic,3);
		//drawVerticalLine(pic,5);
		//drawSlot(pic,0,0);
		drawBox(pic,5,1);
		print(pic);
	}
	
	private static void drawBox(String[][] pic, int row, int col) {
		pic[row][col] = "*";
		drawSlot(pic,row,col);
		drawSlot(pic,row+1,col);
		drawTopAndBottom("_",pic,row,col);
		
	}

	private static void drawTopAndBottom(String symbol, String[][] pic, int row, int col) {
		if(row  > 0) {
			pic[row-1][col] = symbol;
			if(col  > 0) {
				pic[row-1][col-1] = symbol;
			}
			if(col  < pic[row].length-1) {
				pic[row-1][col+1] = symbol;
			}
		}
		if(row  < pic.length-1) {
			pic[row+1][col] = symbol;
		}
	}

	private static void drawSlot(String[][] pic, int row, int col) {
		if(row >= 0 && row< pic.length) {
			if(col  > 0) {
				pic[row][col-1] = "|";
			}
			if(col  < pic[row].length-1) {
				pic[row][col+1] = "|";
			}
		}
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
	}
	
	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
	}

	private static void print(String[][] pic) {
		String result = "";
		for(int row = 0;row < pic.length;row++) {
			for(int col = 0;col < pic[row].length;col++){
				result += pic[row][col];
			}
			result += "\n";
		}
		System.out.println(result);
	}

}

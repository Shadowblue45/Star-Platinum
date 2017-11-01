package CaveExplorer;

public class NPC {

	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	
	public NPC(){
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person waiting to talk to you.";
		this.inactiveDescription = "The person you spoke to earlier is standing there.";
		this.currentRow = -1;
		this.currentCol = -1;
		this.currentRoom = null;
		this.active = true;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setPosition(int  row, int col) {
		if(row >= 0 && row < floor.length && col >=0 && col< floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
		}
		currentRow = row;
		currentCol = col;
		currentRoom = (NPCRoom)floor[row][col];
		currentRoom.enterNPC(this);
	}
	
	public void interact() {
		CaveExplorer.print("Hi! I'm an NPC! I say Nothing at all until you say 'bye'.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")){
			CaveExplorer.print("...");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Well, that was fun. later!");
		active = false;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getActiveDescription() {
		return activeDescription;
	}

	public void act() {
		if(active) {
			int[] move = calculateMovement();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow,newCol);
		}
	}

	public int[] calculateMovement() {
		int[] moves = new int[2];
		int[][] possiblemoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int rand = (int)(Math.random() * 4);
		moves[0] = possiblemoves[rand][0]+currentRow;
		moves[1] = possiblemoves[rand][1]+currentRow;
		return null;
	}

}

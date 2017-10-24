package CaveExplorer;

public class CaveRoom {

	private String descriptions;//what room looks like
	private String directions;//what you can do
	private String contents;//a symbol representing whats in the room
	private String defaultContents;
	//The rooms are organized by directions,'null' signifies no room/door in that directions
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	public CaveRoom(String description) {
		this.descriptions = description;
		setDefaultContents("");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	/*
	 * for every door in doors[] appends a string to "directions" describing the access
	 * if there are no doors, directions should say,
	 * "There are no doors, you are trapped;
	 */
	private void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i< doors.length;i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n There is a" + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions += "There is no way out. You are trapped here.";
		}
	}
	
	/*
	 * converts an int to a direction
	 * toDirection(0) -> "the North"
	 */
	public static String toDirection(int dir) {
		String[] arr = {"the North","the East","the South","the West"};
		return arr[dir];
	}
	
	public void enter() {
		contents = "x";
	}
	
	public void setConnetion(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction,anotherRoom,door);
		anotherRoom.addRoom(oppositeDirection(direction),this,door);
	}
	
	public static int oppositeDirection(int direction) {
		return(direction + 2)%4;
	}
	
	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(isValid(input)) {
			System.out.println("You can only enter 'w','a','s' or'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}
	
	public boolean isValid(String input) {
		String validEntries = "wasd";
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}
	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	
	//this will be there your group sets up all the caves
	//and all the connections;
	public static void setUpCaves() {
		
	}
	public void leave() {
		contents = defaultContents;
	}

	public String getDescriptions() {
		return descriptions;
	}



	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

}

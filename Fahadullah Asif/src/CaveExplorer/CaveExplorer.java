package CaveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom[][] caves;//every room
	public static Scanner in;//user input
	public static CaveRoom currentRoom;//changes on user navigation
	public static Inventory inventory;//where all objects found are kept;
	public static boolean playing = true;
	public static NPC[] npcs;


	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();
	}


	private static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}

	private static void npcActions() {
		for(NPC n: npcs) {
			n.act();
		}
		inventory.updateMap();
	}


	public static void print(String s) {
		//NOTE: later you can replace this with more sophisticated code
		System.out.println(s);
	}
}

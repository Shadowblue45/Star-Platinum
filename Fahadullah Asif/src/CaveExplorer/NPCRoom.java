package CaveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC presentNPC;

	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}
	
	public boolean canEnter() {
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m){
		presentNPC = m;
	}
	
	public void leaveNPC(NPC m) {
		presentNPC = null;
	}
	
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w','a','s' or'd' to move or you can press 'e' to talk to the NPC");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}
			else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
		else {
			System.out.println("That Key Does Nothing.");
		}
	}
	
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "M";
		}
		else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n" + presentNPC.getInactiveDescription();
		}
		else {
			return super.getDescription();
		}
	}

}
// The above methods are NEW features to a Caveroom
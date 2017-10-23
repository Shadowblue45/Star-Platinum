package CaveExplorer;

public class Door {

	private boolean locked;
	private boolean opened;
	private String description;
	private String details;
	
	public Door() {
		locked = false;
		opened = true;
		description = "passage";
		details = "";
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

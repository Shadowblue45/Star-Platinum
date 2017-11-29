package pocketMonster;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int level){
		this.name = name;
		this.level = level;
		setHp(100);
		setPoisoned(false);
	}
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
		 
			public void attack(Pokemon target) {
				int hp = target.getHp();
				target.setHp(hp/2);
				}
			});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
		 
			public void attack(Pokemon target) {
				target.setPoisoned(true);
				}
			});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
	}
	
	public static void printScore(Pokemon a, Pokemon b) {
		System.out.println(a.getName() + ", HP = " + a.getHp());
		System.out.println(b.getName() + ", HP = " + b.getHp());
	}
	
	public void iChooseYou() {
		System.out.println(this.name + " " + this.name);
	}
	
	public void lapse() {
		if(this.poisoned) {
			this.hp = this.hp-15;
		}
	}
	
	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}
		else{
			System.out.println("The attack missed");
		}
	}
	
	public void levelUp(Effect e) {
		this.level++;
		e.happen();
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
	
	
	

}

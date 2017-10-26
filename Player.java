package bb;

public class Player {
	int totalWalk = 0;
	 int id;
	 String name;
	 int position = 0;
	 boolean brokeout = false;
	 Money money = new Money(10000);
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName(){
		
		return name;
	}
	public int getTotalWalk() {
		return totalWalk;
	}

	public int rollDie(Die die) {
		int face = die.getValue();
		prompt.print(this,getName()+"player toss die and its face value is"+ face);
		
		return face;
	}
	public int getCurrentPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void nextTurn() {
		totalWalk++;
	}
	
	public Money getMoney() {
		return money;
	}
	

	public int getID() {
		return id;
	}
	
	public void setBrokeOut(boolean brokeout) {
		this.brokeout = brokeout;
	}
	
	public boolean isBrokeOut() {
		return brokeout;
	}
}
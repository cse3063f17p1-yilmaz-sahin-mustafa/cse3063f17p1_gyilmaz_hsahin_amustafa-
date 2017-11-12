public class GoJailSquare extends Square {
	public GoJailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		prompt.print(player, player.getName() + " has go to Jail");
		player.setJail(true);
		board.movePlayer(player, -20, true);
		
		
		
	}
}
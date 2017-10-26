package bb;

public class piece extends Square {
	public piece(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		prompt.print(player, player.getName() + " is at Go... Giving 1000 money");
		player.getMoney().addMoney(1000);
	}
}
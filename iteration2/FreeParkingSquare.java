
public class FreeParkingSquare extends Square {
	
		public FreeParkingSquare(String name) {
			super(name);
		}
		
		@Override
		public void doAction(Player player, Board board) {
			prompt.print(player, player.getName() + " is at free parking square, no action here");
			
		}
}

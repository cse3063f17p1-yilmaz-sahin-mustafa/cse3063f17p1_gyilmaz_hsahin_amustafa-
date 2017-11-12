
import java.util.*;
public class MonopolyGame {
	
		
		Die die = new Die();
		Board board;
		
		public MonopolyGame(int totalPlayer) {
			board = new Board(totalPlayer);
		}
		
		public static void main(String[] args) {
			System.out.println("\tMonopoly\n");
			Scanner scanner = new Scanner(System.in);
			int totalPlayer = 0;
			while (totalPlayer < 2 || totalPlayer > 8) {
				try {
					
					System.out.println("How many people are playing?");
					System.out.print("Players (2 - 8): ");
					totalPlayer = scanner.nextInt();
				}
				catch(Exception e) {
					System.err.println("Error: Number too large.");
					continue;
				}
				if((totalPlayer > 8) ||(totalPlayer<2)) {
					System.err.println("Error: Invalid player count.");
				}
			}
			scanner.close();
			MonopolyGame game = new MonopolyGame(totalPlayer);
			game.startGame();
		}
		
		public void startGame() {
			System.out.println("Game start!");
			System.out.println("========");
			while (board.iterationNumber < 20){
				if(!board.getCurrentPlayer().bankruptcy()){
					int face = board.getCurrentPlayer().rollDie(die);
					board.movePlayer(board.getCurrentPlayer(), face);
				}else if(board.getCurrentPlayer().bankruptcy()){
					prompt.print(board.getCurrentPlayer(), " removed from the game because of bankruptcy.");
				}
				board.nextTurn();
			}
			System.out.println("========");
			
			System.out.println("Game over!");
		}
		
	
						
					
					
}



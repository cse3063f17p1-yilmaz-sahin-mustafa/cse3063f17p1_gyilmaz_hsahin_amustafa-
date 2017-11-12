
public class prompt {
	
		public static void print(Player player, String msg) {
			System.out.println("[Iteration " + (player.getTotalMove() + 1) + "] [" + player.getCurrentPosition() + "] [$" + player.getMoney().getMoney() + "] " + msg);
		}

	
	

}

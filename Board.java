package bb;

public class Board {
	int turnIteration = 0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	
	
	public Board(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
	}

	public Square movePlayer(Player player, int face) {
		return movePlayer(player, face,true);
	}
	public Square movePlayer(Player player, int face, boolean count) {
		if(player.isBrokeOut()){ 
			return squares[player.getCurrentPosition()]; 
		}
		int newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		System.out.println( player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
		if(player.getMoney().isBrokeOut()){
			prompt.print(player, player.getName() + " has been broke out!");
			player.setBrokeOut(true);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	
	public int normalizePosition(int position) {
		return position % squares.length;
	}
	
	public Player getCurrentPlayer() {
		return players[turnIteration];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++turnIteration >= players.length){
			turnIteration = 0;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	}

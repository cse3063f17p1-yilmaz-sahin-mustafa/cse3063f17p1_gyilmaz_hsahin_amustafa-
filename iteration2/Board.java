
public class Board {
	private int turnIteration = 0;
	int iterationNumber=0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	
	
	public Board(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		
		for(int i = 0;i < squares.length;i++){
			if(i == 0){
				squares[i] = new GoSquare("GO");
			}else if(i == 4){
				squares[i] = new IncomeTaxSquare("Income Tax Square");
			}else if(i == 10){
				squares[i] = new JailSquare("Jail");
			}else if(i == 20){
				squares[i] = new FreeParkingSquare("Free Parking");
			}else if(i == 30){
				squares[i] = new GoJailSquare("Go to Jail");
			}else if(i == 38){
				squares[i] = new LuxuryTaxSquare("Luxury Tax Square");
			}else{
				squares[i] = new OrdinarySquare("Ordinary Square");
			}
		}
	}

	public Square movePlayer(Player player, int face) {
		return movePlayer(player, face,true);
	}
	public Square movePlayer(Player player, int face, boolean count) {
		int newPosition=0;
		int counter=0;
		if(player.bankruptcy()){ return squares[player.getCurrentPosition()]; }
		 if((player.isJail())&&(player.getCurrentPosition()==10)&&(player.getMoney().getMoney()>50)){
			    counter++;
				prompt.print(player, player.getName() + " is in Jail and lose 50 money to roll dice!");
				player.getMoney().substractMoney(50);
				System.out.println(player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
				if(player.isRolledDouble()){
					prompt.print(player, player.getName() + " has been out of jail by rolling double!");
					player.setPosition(player.getCurrentPosition()+face);
					player.setJail(false);
			    }else if(player.getMoney().getMoney()>500){
			    	prompt.print(player, player.getName() + " has been out of jail by paying 500 money!");
			    	player.setPosition(player.getCurrentPosition());
					player.setJail(false);
					player.getMoney().substractMoney(500);
			    }else if(counter==3){
			    	prompt.print(player, player.getName() + " has been out of jail because of there is been 3 turn!");
			    	player.setPosition(player.getCurrentPosition());
					player.setJail(false);
			    }else{
				prompt.print(player, player.getName() + "  still in jail!");
				player.setPosition(player.getCurrentPosition());
				player.setJail(true);
		        }
				if(player.getMoney().isBankRuptcy()){
					prompt.print(player, player.getName() + " has been bankruptcy!");
					player.setBankruptcy(true);
				}else{
					if(count){
						player.nextTurn();
					}
				}
				return squares[player.getCurrentPosition()];
		}else{
		 newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		System.out.println(player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
	
		if(player.getMoney().isBankRuptcy()){
			prompt.print(player, player.getName() + " has been bankruptcy!");
			player.setBankruptcy(true);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
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
			iterationNumber++;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	}

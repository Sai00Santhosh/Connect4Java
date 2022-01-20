public class ConnectFour {

	private Player player1;
	private Player player2;
	private boolean isP1Turn; //true iff it is player one's turn to play.
	private Board board;
	
	public ConnectFour(Board board) {
		this.board = board;
		isP1Turn = true;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1; 
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2; 
	}
	
	public void playGame(){
		board.reset();
		board.printBoard();
		while(!gameIsOver()) {
			System.out.println("It is " + getCurrentPlayer().getName() + "'s turn.");
			getCurrentPlayer().makeMove(board);
			board.printBoard();
			changeTurns();
		}
		if(board.containsWin()) {
			changeTurns();
			System.out.println("Congratulations " + getCurrentPlayer().getName() + ", you have won!");
		}
		else {
			System.out.println("The game is a tie. You both lose.");
		}
	}
	
	private boolean gameIsOver() {
		return board.containsWin() || board.isTie();
	}
	
	private Player getCurrentPlayer() {
		if(isP1Turn) {
			return player1;
		}
		return player2;
	}
	
	private void changeTurns() {
		isP1Turn = !isP1Turn;
	}
	
}

public abstract class Player {
	
	protected char symbol;
	protected Board board;
	protected String name; 
	
	public Player(char symbol, Board board, String name) {
		this.symbol = symbol;
		this.board = board;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void makeMove(Board board);
	
	
}

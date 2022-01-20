public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;

	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class if you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */
	
	public Board() {

		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = ' ';
			}
		}

	}

	public boolean validate(int column){
		if (board[0][column - 1] != ' '){
			return false;
		}
		
		return true;
	}

	public void dropPieceAt(int column, char symbol){

		for (int row = board.length - 1; row >= 0; row--){
			if(board[row][column - 1] == ' '){
				board[row][column - 1] = symbol;
				break;
			}
		}
	}
	
	
	public void printBoard() {
		for (int row = 0; row < board.length; row++){
			System.out.print("|");
			for (int col = 0; col < board[row].length; col++){
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
		}
		
	}
	
	public boolean containsWin() {
		//check for horizontal win
		for(int row = 0; row<board.length; row++){
			for (int col = 0;col < board[0].length - 3;col++){
				if (board[row][col] == board[row][col+3] && 
					board[row][col+1] == board[row][col+3] && 
					board[row][col+2] == board[row][col+3] &&
					board[row][col+3] != ' ' )
					{
					return true;
				}
			}			
		}
		//check for vertical win
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length; col++){
				if (board[row][col] == board[row+3][col]   && 
				    board[row+1][col] == board[row+3][col] &&
					board[row+2][col] == board[row+3][col] &&
					board[row+3][col] != ' ')
					{
					return true;
				}
			}
		}
		//check upward diagonal
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == board[row-3][col+3]   && 
					board[row-1][col+1] == board[row-3][col+3] &&
					board[row-2][col+2] == board[row-3][col+3] &&
					board[row-3][col+3] != ' ')
					{
					return true;
				}
			}
		}
		//check backslash diagonal
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == board[row+3][col+3] && 
				    board[row+1][col+1] == board[row+3][col+3] &&
					board[row+2][col+2] == board[row+3][col+3] &&
					board[row+3][col+3] != ' ')
					{
					return true;
				}
			}
		}
		return false;
	}

	
	public boolean isTie() {
		if (board[0][0] != ' ' && 
			board[0][1] != ' ' && 
		    board[0][2] != ' ' && 
			board[0][3] != ' ' && 
			board[0][4] != ' ' && 
			board[0][5] != ' ' && 
			board[0][6] != ' ')
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reset() {

		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = ' ';
			}
		}
	}

	/**
	 * The code below checks for the case on whether the board is close to a player winning.
	 * If suppose the AI player has one move to win, the AI would place it at the winning position.
	 * If the opponent is going to win, then the AI would block that win (if it is the AI's turn)
	 * 
	 * There are 4 functions:
	 *   - Checks Horizontally for a win
	 *   - Checks Vertically for a win
	 *   - Checks Diagonally for a win (downward and upward) [2 functions]
	 */

	public int AlmostWinH() {
		for(int row = 0; row<board.length; row++){
			for (int col = 0;col < board[0].length - 3;col++){
				if (board[row][col] == board[row][col+2] && 
					board[row][col+1] == board[row][col+2] && 
					board[row][col+2] != ' ' &&
					board[row][col+3] == ' ' )
					{
					return col+4;
				}
				else if (board[row][col] == board[row][col+3] && 
					board[row][col+1] == board[row][col+3] && 
					board[row][col+2] == ' ' &&
					board[row][col+3] != ' ' )
					{
					return col+3;
				}
				else if (board[row][col] == board[row][col+3]  && 
				board[row][col+1] == ' ' && 
				board[row][col+2] == board[row][col+3]  &&
				board[row][col+3] != ' '   )
				{
				return col+2;
			}
				else if (board[row][col] == ' ' && 
				board[row][col+1] == board[row][col+3] && 
				board[row][col+2] == board[row][col+3] &&
				board[row][col+3] != ' ' )
				{
				return col+1;
			}
			}			
		}
		return 0;
	}

	public int AlmostWinV() {
		//check for 4 up and down
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length; col++){
				if (board[row][col] == ' '      && 
					board[row+1][col] == board[row+3][col] &&
					board[row+2][col] == board[row+3][col] &&
					board[row+3][col] != ' ')
					{
				return col+1;
				}
			}
		}
		return 0;
	}

	public int AlmostWinD1() {
		//check upward diagonal
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == board[row-2][col+2]   && 
					board[row-1][col+1] == board[row-2][col+2] &&
					board[row-2][col+2] != ' ' &&
					board[row-3][col+3] == ' ')
					{
					return col+4;
				}
				else if (board[row][col] == board[row-3][col+3]   && 
					board[row-1][col+1] == board[row-3][col+3] &&
					board[row-2][col+2] == ' ' &&
					board[row-3][col+3] != ' ' )
					{
					return col+3;
				}
				else if (board[row][col] == board[row-3][col+3]   && 
					board[row-1][col+1] == ' ' &&
					board[row-2][col+2] == board[row-3][col+3] &&
					board[row-3][col+3] != ' ')
					{
					return col+2;
				}
				else if (board[row][col] == ' ' && 
					board[row-1][col+1] == board[row-3][col+3] &&
					board[row-2][col+2] == board[row-3][col+3] &&
					board[row-3][col+3] != ' ')
					{
					return col+1;
				}
			}
		}
		return 0;
	}

	public int AlmostWinD2() {
		//check downward diagonal
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == board[row+2][col+2] && 
					board[row+1][col+1] == board[row+2][col+2] &&
					board[row+2][col+2] != ' ' &&
					board[row+3][col+3] == ' ')
					{
					return col+4;
				}
				if (board[row][col] == board[row+3][col+3] && 
					board[row+1][col+1] == board[row+3][col+3] &&
					board[row+2][col+2] == ' ' &&
					board[row+3][col+3] != ' ')
					{
					return col+3;
				}
				if (board[row][col] == board[row+3][col+3] && 
					board[row+1][col+1] == ' ' &&
					board[row+2][col+2] == board[row+3][col+3] &&
					board[row+3][col+3] != ' ')
					{
					return col+2;
				}
				if (board[row][col] == ' ' && 
					board[row+1][col+1] == board[row+3][col+3] &&
					board[row+2][col+2] == board[row+3][col+3] &&
					board[row+3][col+3] != ' ')
					{
					return col+1;
				}
			}
		}
		return 0;		
	}
	
}

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {

		int place;

        Scanner val = new Scanner(System.in);
        System.out.print(name + ", please input your move: ");
        place = val.nextInt();

        while (board.validate(place) == false) {
            System.out.println("Please Enter a valid move");
            System.out.print(name + ", please input your move: ");
            place = val.nextInt();
        }

		//drop the checker
		board.dropPieceAt(place, symbol);
        
    }
    
}
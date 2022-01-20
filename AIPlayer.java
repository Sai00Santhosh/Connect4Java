import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {

        int val;

        if (Almostwin(board) == 0){
            val = randInt(1, 7);
        } else {
            val = Almostwin(board);
        }

        System.out.print(name + ", please input your move: "  + val + "\n");

        while (board.validate(val) == false) {
            System.out.println("Please Enter a valid move");
            val = randInt(1, 7);
            System.out.print(name + ", please input your move: " + val + "\n");
        }

		//drop the checker
		board.dropPieceAt(val, symbol);
        
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();
    
        int randomNum = rand.nextInt((max - min) + 1) + min;
    
        return randomNum;
    }

    public static int Almostwin(Board board) {

        int a = board.AlmostWinV();
        int b = board.AlmostWinD1();
        int c = board.AlmostWinD2();
        int d = board.AlmostWinH();

        if (a != 0){
            return a;
        }
        else if (b != 0){
            return b;
        }
        else if (c != 0){
            return c;
        }
        else if (d != 0){
            return d;
        }
        else {
            return 0;
        }

    }
    
}

public class Main {
    public static void main(String[] args) {
        Board board = new Board(); 
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new AIPlayer('S', board, "Yo"));
        game.setPlayer2(new AIPlayer('B', board, "Bot"));
        game.playGame();
    }

}

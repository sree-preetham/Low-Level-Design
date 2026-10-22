import entities.Board;
import entities.Player;
import entities.Token;
import observer.BoardObserver;
import observer.PrintBoardObserver;
import strategy.HumanPlayerStrategy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Tic tac toe");
        Board board = new Board(3);
        TicTacToeService game = new TicTacToeService(board);
        HumanPlayerStrategy humanPlayerStrategy = new HumanPlayerStrategy();
        Player player1 = new Player("Player 1", Token.X, humanPlayerStrategy);
        Player player2 = new Player("Player 2", Token.O, humanPlayerStrategy);

        game.addPlayer(player1);
        game.addPlayer(player2);

        BoardObserver observer = new PrintBoardObserver();

        game.addObserver(observer);

        game.play();
    }
}

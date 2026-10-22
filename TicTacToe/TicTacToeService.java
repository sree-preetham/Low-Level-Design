import entities.*;
import java.util.ArrayList;
import java.util.List;
import observer.BoardObserver;

public class TicTacToeService {

    List<Player> players;
    Board board;
    int currentPlayer;
    List<BoardObserver> observers;

    public TicTacToeService(Board board) {
        this.board = board;
        this.players = new ArrayList<>();
        this.currentPlayer = 0;
        this.observers = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<BoardObserver> getObservers() {
        return observers;
    }

    public void addObserver(BoardObserver observer) {
        this.observers.add(observer);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        while (true) {
            Player player = players.get(currentPlayer);
            Cell cell = player.move();
            if (!board.makeMove(cell)) {
                System.out.println(
                    "Incorrect Move by " +
                        player.getName() +
                        " please try again "
                );
                continue;
            }
            notifyObservers();
            if (board.isWin()) {
                System.out.println(player.getName() + " wins the game ");
                return;
            } else if (board.isDraw()) {
                System.out.println(" Game drawn ");
                return;
            }
            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }

    private void notifyObservers() {
        for (BoardObserver observer : observers) observer.update(board);
    }
}

// makeMove
// isGameOver - isWin, isDraw

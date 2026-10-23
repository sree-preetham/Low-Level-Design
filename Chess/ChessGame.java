
import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPlayer;
import entities.Move;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    private ChessPlayer player1;
    private ChessPlayer player2;
    private ChessPlayer activePlayer;

    private List<Move> moveLog;
    private boolean isGameOver;
    ChessBoard chessBoard;

    public ChessGame(ChessPlayer player1, ChessPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.activePlayer = player1;
        this.moveLog = new ArrayList<>();
        this.chessBoard = new ChessBoard(8);

        this.isGameOver = false;
    }

    public void play() {
        while (!isGameOver) {
            Move playerMove = activePlayer.getPlayerMovementStrategy().getMove(activePlayer.isWhiteSide(),
                    isPlayerInCheck(), this.chessBoard);
            ChessCell targetCell = playerMove.getTargetCell();
            if (targetCell == null) {
                System.err.println("Game is Over, " + activePlayer.getName() + " lost ");
                isGameOver = true;

            } else {
                activePlayer.getPlayerMovementStrategy().makeMove(playerMove);
                moveLog.add(playerMove);
            }
            activePlayer = activePlayer == player1 ? player2 : player1;
        }
    }

    private boolean isPlayerInCheck() {
        return false;
    }

    public void addPlayer(ChessPlayer player) {
        this.players.add(player);
    }
}
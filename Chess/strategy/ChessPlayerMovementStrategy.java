package strategy;

import entities.ChessBoard;
import entities.Move;

public interface ChessPlayerMovementStrategy {
    public Move getMove(boolean isWhite, boolean isInCheck, ChessBoard chessBoard);
    public void makeMove(Move move);
}
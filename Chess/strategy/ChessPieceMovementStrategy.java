package strategy;

import entities.ChessBoard;
import entities.Move;

public interface ChessPieceMovementStrategy {

	boolean isValidMove(Move move, ChessBoard board);
}
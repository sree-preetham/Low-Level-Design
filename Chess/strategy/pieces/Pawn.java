package strategy.pieces;

import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPiece;
import entities.Move;
import java.util.HashSet;
import java.util.Set;
import strategy.ChessPieceMovementStrategy;

public class Pawn implements ChessPieceMovementStrategy {
    @Override
    public boolean isValidMove(Move move, ChessBoard board) {
        ChessCell currentCell = move.getCurrentCell();
        ChessCell targetCell = move.getTargetCell();
        Set<ChessCell> validCells = getValidTargetCells(currentCell, board);
        return validCells.contains(targetCell);
    }

    private Set<ChessCell> getValidTargetCells(ChessCell currentCell, ChessBoard board) {
        ChessPiece piece = currentCell.getPiece();
        Set<ChessCell> cells = new HashSet<>();

        // White moves up the board (row decreases), black moves down (row increases)
        int direction = piece.isWhite() ? -1 : 1;
        int startRow = piece.isWhite() ? board.getSize() - 2 : 1;
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        // one step forward: only onto an empty square
        int oneStep = row + direction;
        if (board.isValidCell(oneStep, col) && board.getCell(oneStep, col).getPiece() == null) {
            cells.add(board.getCell(oneStep, col));

            // two steps forward: only from the starting row, both squares empty
            int twoStep = row + 2 * direction;
            if (row == startRow && board.isValidCell(twoStep, col)
                    && board.getCell(twoStep, col).getPiece() == null) {
                cells.add(board.getCell(twoStep, col));
            }
        }

        // diagonal captures: only onto a square holding an enemy piece
        for (int dCol : new int[] { -1, 1 }) {
            int targetCol = col + dCol;
            if (!board.isValidCell(oneStep, targetCol))
                continue;

            ChessPiece targetPiece = board.getCell(oneStep, targetCol).getPiece();
            if (targetPiece != null && targetPiece.isWhite() != piece.isWhite()) {
                cells.add(board.getCell(oneStep, targetCol));
            }
        }

        return cells;
    }
}
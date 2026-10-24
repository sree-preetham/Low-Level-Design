package strategy.pieces;

import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPiece;
import entities.Move;
import java.util.HashSet;
import java.util.Set;
import strategy.ChessPieceMovementStrategy;

public class King implements ChessPieceMovementStrategy {
    private static final int[][] KING_DIRECTIONS = {
            { -1, -1 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

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

        for (int[] dir : KING_DIRECTIONS) {
            int row = currentCell.getRow() + dir[0];
            int col = currentCell.getCol() + dir[1];

            if (board.isValidCell(row, col)) {
                ChessCell targetCell = board.getCell(row, col);
                ChessPiece targetPiece = targetCell.getPiece();

                if (targetPiece == null) {
                    cells.add(targetCell); // empty square: keep sliding
                } else {
                    if (targetPiece.isWhite() != piece.isWhite()) {
                        cells.add(targetCell); // enemy piece: capture
                    }
                    break; // any piece blocks further movement
                }
            }
        }
        return cells;
    }
}
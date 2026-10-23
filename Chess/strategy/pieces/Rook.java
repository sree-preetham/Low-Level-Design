package strategy.pieces;

import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPiece;
import entities.Move;
import java.util.HashSet;
import java.util.Set;
import strategy.ChessPieceMovementStrategy;

public class Rook implements ChessPieceMovementStrategy {
    private static final int[][] ROOK_DIRECTIONS = {
            { -1, 0 }, // up
            { 1, 0 }, // down
            { 0, -1 }, // left
            { 0, 1 } // right
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

        for (int[] dir : ROOK_DIRECTIONS) {
            int row = currentCell.getRow() + dir[0];
            int col = currentCell.getCol() + dir[1];

            while (board.isValidCell(row, col)) {
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

                row += dir[0];
                col += dir[1];
            }
        }
        return cells;
    }
}

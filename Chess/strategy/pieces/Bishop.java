package strategy.pieces;

import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPiece;
import entities.Move;

import java.util.HashSet;
import java.util.Set;
import strategy.ChessPieceMovementStrategy;

public class Bishop implements ChessPieceMovementStrategy {
    private static final int[][] BISHOP_DIRECTIONS = {
            { -1, -1 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 }
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

        for (int[] dir : BISHOP_DIRECTIONS) {
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
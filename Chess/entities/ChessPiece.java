package entities;

import strategy.ChessPieceMovementStrategy;

public class ChessPiece {

    ChessPieceType pieceType;
    ChessPieceMovementStrategy pieceMovementStrategy;
    ChessCell cell;
    boolean isWhite;

    public ChessPiece(
            ChessPieceType pieceType,
            ChessPieceMovementStrategy pieceMovementStrategy,
            ChessCell cell,
            boolean isWhite) {
        this.pieceType = pieceType;
        this.pieceMovementStrategy = pieceMovementStrategy;
        this.cell = cell;
        this.isWhite = isWhite;
    }

    public ChessPieceType getPieceType() {
        return pieceType;
    }

    public ChessPieceMovementStrategy getPieceMovementStrategy() {
        return pieceMovementStrategy;
    }

    public ChessCell getCell() {
        return cell;
    }

    public boolean isWhite() {
        return isWhite;
    }

}

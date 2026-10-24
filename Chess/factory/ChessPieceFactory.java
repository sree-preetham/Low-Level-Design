package factory;

import entities.ChessPiece;
import entities.ChessPieceType;

import strategy.pieces.Pawn;
import strategy.pieces.Queen;
import strategy.pieces.Rook;
import strategy.pieces.Bishop;
import strategy.pieces.King;
import strategy.pieces.Knight;

public class ChessPieceFactory {
    public static ChessPiece createPiece(boolean isWhite, ChessPieceType chessPieceType) {
        return switch (chessPieceType) {
            case PAWN -> new ChessPiece(chessPieceType, new Pawn(), null, isWhite);
            case ROOK -> new ChessPiece(chessPieceType, new Rook(), null, isWhite);
            case QUEEN -> new ChessPiece(chessPieceType, new Queen(), null, isWhite);
            case KING -> new ChessPiece(chessPieceType, new King(), null, isWhite);
            case KNIGHT -> new ChessPiece(chessPieceType, new Knight(), null, isWhite);
            case BISHOP -> new ChessPiece(chessPieceType, new Bishop(), null, isWhite);
            case EMPTY -> null;
        };
    }
}

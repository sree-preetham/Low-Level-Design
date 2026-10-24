package strategy;

import entities.ChessBoard;
import entities.ChessCell;
import entities.ChessPieceType;
import entities.Move;
import java.util.Scanner;

public class HumanPlayerMovementStrategy implements ChessPlayerMovementStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Move getMove(boolean isWhite, boolean isInCheck, ChessBoard chessBoard) {

        ChessCell selectedCell;
        while (true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (chessBoard.isValidCell(row, col)) {
                if (isInCheck && chessBoard.getGrid()[row][col].getPiece().getPieceType() != ChessPieceType.KING) {
                    System.err.println("You are in check, select the king to make a move");
                    continue;
                }
                if (chessBoard.getGrid()[row][col].getPiece().isWhite() == isWhite) {
                    selectedCell = chessBoard.getGrid()[row][col];
                    break;
                } else
                    System.err.println("Please choose a cell of your color");
            } else {
                System.err.println("Invalid cell selection, please try again");
            }

        }

        ChessCell targetCell;
        while (true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (chessBoard.isValidCell(row, col)) {
                if (chessBoard.getGrid()[row][col].getPiece() == null
                        || chessBoard.getGrid()[row][col].getPiece().isWhite() != isWhite) {
                    targetCell = chessBoard.getGrid()[row][col];
                    break;
                } else
                    System.err.println("Please choose a cell of opponent color or an empty cell");
            } else {
                System.err.println("Invalid cell selection, please try again");
            }

        }

        Move move = new Move(selectedCell, targetCell);
        if (selectedCell.getPiece().getPieceMovementStrategy().isValidMove(move, chessBoard)) {
            return move;
        }
        return null;
    }

    @Override
    public void makeMove(Move move) {
        // TODO
    }
}

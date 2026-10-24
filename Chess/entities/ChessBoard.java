package entities;

import factory.ChessPieceFactory;

public class ChessBoard {

    int size;
    ChessCell[][] grid;

    public ChessBoard(int size) {
        this.size = size;
        this.grid = new ChessCell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new ChessCell(i, j);
        setupBoard();
        printBoard();
    }

    public ChessCell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isValidCell(int row, int col) {
        return row < size && col < size && row >= 0 && col >= 0;
    }

    public int getSize() {
        return size;
    }

    private void setupBoard() {
        setPieceRow(true, size - 1);
        setPieceRow(false, 0);
        setPawnRow(true, size - 2);
        setPawnRow(false, 1);
    }

    private void setPieceRow(boolean isWhite, int row) {
        ChessPiece rook = ChessPieceFactory.createPiece(isWhite, ChessPieceType.ROOK);
        ChessPiece knight = ChessPieceFactory.createPiece(isWhite, ChessPieceType.KNIGHT);
        ChessPiece bishop = ChessPieceFactory.createPiece(isWhite, ChessPieceType.BISHOP);
        ChessPiece queen = ChessPieceFactory.createPiece(isWhite, ChessPieceType.QUEEN);
        ChessPiece king = ChessPieceFactory.createPiece(isWhite, ChessPieceType.KING);

        ChessPiece rook2 = ChessPieceFactory.createPiece(isWhite, ChessPieceType.ROOK);
        ChessPiece knight2 = ChessPieceFactory.createPiece(isWhite, ChessPieceType.KNIGHT);
        ChessPiece bishop2 = ChessPieceFactory.createPiece(isWhite, ChessPieceType.BISHOP);

        grid[row][0].setPiece(rook);
        rook.cell = grid[row][0];

        grid[row][1].setPiece(knight);
        knight.cell = grid[row][1];

        grid[row][2].setPiece(bishop);
        bishop.cell = grid[row][2];

        grid[row][3].setPiece(queen);
        queen.cell = grid[row][3];

        grid[row][4].setPiece(king);
        king.cell = grid[row][4];

        grid[row][5].setPiece(bishop2);
        bishop2.cell = grid[row][5];

        grid[row][6].setPiece(knight2);
        knight2.cell = grid[row][6];

        grid[row][7].setPiece(rook2);
        rook2.cell = grid[row][7];

    }

    private void setPawnRow(boolean isWhite, int row) {
        for (int j = 0; j < size; j++) {
            ChessPiece chessPiece = ChessPieceFactory.createPiece(isWhite, ChessPieceType.PAWN);
            grid[row][j].setPiece(chessPiece);
            chessPiece.cell = grid[row][j];
        }
    }

    public void printBoard() {
        System.out.print("   ");
        for (int col = 0; col < size; col++)
            System.out.print(" " + (char) ('a' + col) + " ");
        System.out.println();

        for (int row = 0; row < size; row++) {
            // row 0 is black's back rank, so it's rank 8
            System.out.print((size - row) + "  ");
            for (int col = 0; col < size; col++) {
                ChessPiece piece = grid[row][col].getPiece();
                System.out.print(" " + (piece == null ? '.' : getSymbol(piece)) + " ");
            }
            System.out.println(" " + (size - row));
        }

        System.out.print("   ");
        for (int col = 0; col < size; col++)
            System.out.print(" " + (char) ('a' + col) + " ");
        System.out.println();
    }

    // Uppercase = white, lowercase = black
    private char getSymbol(ChessPiece piece) {
        char symbol = switch (piece.getPieceType()) {
            case KING -> 'K';
            case QUEEN -> 'Q';
            case ROOK -> 'R';
            case BISHOP -> 'B';
            case KNIGHT -> 'N';
            case PAWN -> 'P';
            case EMPTY -> '.';
        };
        return piece.isWhite() ? symbol : Character.toLowerCase(symbol);
    }

    public ChessCell[][] getGrid() {
        return grid;
    }
}

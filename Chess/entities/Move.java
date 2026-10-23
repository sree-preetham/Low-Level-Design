package entities;

public class Move {
    ChessCell currentCell;
    ChessCell targetCell;

    public Move(ChessCell currentCell, ChessCell targetCell) {
        this.currentCell = currentCell;
        this.targetCell = targetCell;
    }

    public ChessCell getCurrentCell() {
        return currentCell;
    }

    public ChessCell getTargetCell() {
        return targetCell;
    }

}

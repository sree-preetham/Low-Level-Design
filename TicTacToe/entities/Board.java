package entities;

public class Board {

    Cell[][] grid;
    int size;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell(i, j);
    }

    public boolean isWin() {
        // check every row
        for (int row = 0; row < size; row++) {
            boolean isWin = true;
            for (int col = 1; col < size; col++) {
                if (grid[row][col].getToken() != grid[row][col - 1].getToken() ||
                        grid[row][col].getToken() == Token.EMPTY) {
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin;
        }

        // column
        for (int col = 0; col < size; col++) {
            boolean isWin = true;
            for (int row = 1; row < size; row++) {
                if (grid[row][col].getToken() != grid[row - 1][col].getToken() ||
                        grid[row][col].getToken() == Token.EMPTY) {
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin;
        }

        for (int row = 1; row < size; row++) {
            boolean isWin = true;
            for (int col = 1; col < size; col++) {
                if (grid[row][col].getToken() != grid[row - 1][col - 1].getToken() ||
                        grid[row][col].getToken() == Token.EMPTY) {
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin;
        }

        for (int row = 1; row < size; row++) {
            boolean isWin = true;
            for (int col = size - 2; col >= 0; col--) {
                if (grid[row][col].getToken() != grid[row - 1][col + 1].getToken() ||
                        grid[row][col].getToken() == Token.EMPTY) {
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin;
        }

        return false;
    }

    public boolean isDraw() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].getToken() == Token.EMPTY)
                    return false;
            }
        }
        return true;
    }

    public boolean makeMove(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();
        if (row < 0 ||
                col < 0 ||
                row == size ||
                col == size ||
                grid[row][col].getToken() != Token.EMPTY)
            return false;
        this.grid[row][col] = cell;
        return true;
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].getToken() == Token.EMPTY)
                    System.out.print(
                            ". ");
                else
                    System.out.print(grid[row][col].getToken() + " ");
            }
            System.out.println();
        }
    }
}

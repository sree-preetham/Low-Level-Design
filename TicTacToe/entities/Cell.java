package entities;

public class Cell {

    Token token;
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.token = Token.EMPTY;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    
}

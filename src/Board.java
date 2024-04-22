import java.util.Arrays;

public class Board {
    private int width;
    private int length;
    private Cell[][] board;


    public Board(int width, int length) {
        this.width = width;
        this.length = length;
        board = new Cell[width][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += board[i][0].toString();
            for (int j = 1; j < width; j++) {
                s += "," + board[i][j];
            }
            s += "\n";
        }
        return s;
    }
}
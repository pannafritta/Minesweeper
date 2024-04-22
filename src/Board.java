import java.util.Random;

public class Board {
    private int width;
    private int length;
    private Cell[][] board;
    private String mode;
    private int bombnumber;

    public Board(String mode) {
        this.mode = mode.toUpperCase();
        switch (this.mode) {
            case "EASY":
                this.width = 9;
                this.length = 9;
                bombnumber = 10;
                break;

            case "MEDIUM":
                this.width = 16;
                this.length = 16;
                bombnumber = 40;
                break;

            case "HARD":
                this.width = 30;
                this.length = 16;
                bombnumber = 99;
                break;
            default:
                System.out.println("Errore nella difficoltà di gioco");
        }
        generateEmptyBoard();
        fillWithBombs();
    }

    private void generateEmptyBoard() {
        board = new Cell[width][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[j][i] = new Cell();
            }
        }
    }


    private void fillWithBombs() {
        Random random = new Random();
        for (int i = 0; i < bombnumber; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(length);
            if (board[x][y].getProximity() == 9) {
                i--;
            } else {
                board[x][y].setProximity(9);
                updateBoard(x, y);
            }
        }

    }


    private void updateBoard(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                try {
                    if (board[i][j].getProximity() != 9) {
                        board[i][j].setProximity(board[i][j].getProximity() + 1);
                    }
                } catch (Exception e) {
                }
            }
        }
    }


    @Override

    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += board[i][0].toString();
            for (int j = 1; j < width; j++) {
                s += "," + board[j][i];
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Board board = new Board("harD");
        System.out.println(board);
    }
}
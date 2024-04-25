import java.util.Random;

public class Board {
    private final int width;
    private final int length;
    private final int bombnumber;
    public Cell[][] getCellArray;
    private Cell[][] cellArray;
    private boolean firstClickMade;

    public Board(int width, int length, int bombnumber) {
        this.width = width;
        this.length = length;
        this.bombnumber = bombnumber;
        generateEmptyBoard();
    }

    private void generateEmptyBoard() {
        cellArray = new Cell[width][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                cellArray[j][i] = new Cell(0); //forse meglio -1, poi ne parliamo
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getCellArray() {
        return cellArray;
    }

    public boolean isFirstClickMade() {
        return firstClickMade;
    }

    // se non è stato fatto ancora un click setta la flag del first click
    public boolean checkFirstClick(Cell c) {
        if (isFirstClickMade()) {
            return true;
        } else {
            firstClickMade = true;
            c.setFirstClick();
            return false;
        }
    }

    protected void fillWithBombs(int firstX, int firstY) {
        Random random = new Random();
        for (int i = 0; i < bombnumber; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(length);
            if (x == firstX || x == firstX - 1 || x == firstX + 1) {
                if (y == firstY || y == firstY - 1 || y == firstY + 1) {
                    continue;
                }
            }
            if (cellArray[x][y].getProximity() == 9) {
                i--;
            } else {
                cellArray[x][y].setProximity(9);
                cellArray[x][y].setText("B");
                updateBoard(x, y);
            }
        }

    }

    private void updateBoard(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                try {
                    Cell c = cellArray[i][j];
                    if (c.getProximity() != 9) {
                        c.setProximity(c.getProximity() + 1);
                    }
                } catch (Exception e) {
                    // bisognerebbe dirgli cosa deve fare nel caso catturi un'eccezione
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += cellArray[i][0].toString();
            for (int j = 1; j < width; j++) {
                s += "," + cellArray[j][i];
            }
            s += "\n";
        }
        return s;
    }
}
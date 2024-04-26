import java.util.Random;

public class Board {
    private final int width;
    private final int length;
    private final int bombNumber;
    private Cell[][] cellArray;
    private boolean firstClickMade;

    public Board(int width, int length, int bombNumber) {
        this.width = width;
        this.length = length;
        this.bombNumber = bombNumber;
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
            return false;
        }
    }

    protected void fillWithBombs(int firstX, int firstY) {
        Random random = new Random();
        for (int i = 0; i < bombNumber; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(length);
            if (x == firstX || x == firstX - 1 || x == firstX + 1) {
                if (y == firstY || y == firstY - 1 || y == firstY + 1) {
                    i--;
                    continue;
                }
            }
            if (cellArray[x][y].getProximity() == 9) {
                i--;
            } else {
                cellArray[x][y].setProximity(9);
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

    public void showCell(Cell c) {
        switch (c.getProximity()) {
            case 9:
                c.setText("B");
                break;
            case 0:
                showIfZero(c.getGridX(), c.getGridY());
                break;
            default:
                c.setText(String.valueOf(c.getProximity()));
        }
    }

    //algoritmo ricorsivo per le celle adiacenti agli spazi vuoti
    public void showIfZero(int x, int y) {
        try {
            //se non ho uno 0 mostro la cella e basta
            if (cellArray[x][y].getProximity() != 0) {
                showCell(cellArray[x][y]);
            } else {
                //se ho uno 0 controllo le celle adiacenti e chiamo ricorsivamente la funzione
                //inoltre segno la casella con lo 0 come "già controllata"
                if (!cellArray[x][y].isChecked()) {
                    cellArray[x][y].setChecked(true);
                    cellArray[x][y].setText(String.valueOf(cellArray[x][y].getProximity()));
                    showIfZero(x - 1, y - 1);
                    showIfZero(x, y - 1);
                    showIfZero(x + 1, y - 1);
                    showIfZero(x - 1, y);
                    showIfZero(x + 1, y);
                    showIfZero(x - 1, y + 1);
                    showIfZero(x, y + 1);
                    showIfZero(x + 1, y + 1);
                }

            }
        } catch (Exception ignored) {
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(cellArray[i][0].toString());
            for (int j = 1; j < width; j++) {
                s.append(",").append(cellArray[j][i]);
            }
            s.append("\n");
        }
        return s.toString();
    }

}
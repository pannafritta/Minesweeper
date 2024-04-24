import java.util.Random;

public class Board {
    private int width;
    private int length;
    private Cell[][] cellArray;
    private int bombnumber;

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


    protected void fillWithBombs() {
        Random random = new Random();
        for (int i = 0; i < bombnumber; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(length);
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
                    if (cellArray[i][j].getProximity() != 9) {
                        cellArray[i][j].setProximity(cellArray[i][j].getProximity() + 1);
                    }
                } catch (Exception e) {
                    // bisognerebbe dirgli cosa deve fare nel caso catturi un'eccezione
                }
            }
        }
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setCellArray(Cell[][] cellArray) {
        this.cellArray = cellArray;
    }

    public void setBombnumber(int bombnumber) {
        this.bombnumber = bombnumber;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getBombnumber() {
        return bombnumber;
    }

    public Cell[][] getCellArray() {
        return cellArray;
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
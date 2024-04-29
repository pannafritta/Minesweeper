import javax.swing.*;

public class Cell extends JButton {
    private int proximity;
    private int gridX;
    private int gridY;
    private boolean isBomb;
    private boolean isClicked;

    public Cell(int proximity, boolean isBomb, boolean isClicked) {
        super("  ");
        this.proximity = proximity;
        this.isBomb = isBomb;
        this.isClicked = isClicked;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public void setProximity(int proximity) {
        this.proximity = proximity;
    }

    public int getProximity() {
        return proximity;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setCoordinates(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    @Override
    public String toString() {
        return Integer.toString(proximity);
    }
}

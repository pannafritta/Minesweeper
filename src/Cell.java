import javax.swing.*;

public class Cell extends JButton {
    private int proximity;
    private int gridX;
    private int gridY;

    public Cell(int proximity) {
        super("  ");
        this.proximity = proximity;
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

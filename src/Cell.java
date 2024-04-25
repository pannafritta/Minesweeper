import javax.swing.*;

public class Cell extends JButton {
    private int proximity;
    private int gridX;
    private int gridY;
    private boolean isFirstClick = false; // forse non serve come field

    public Cell(int proximity) {
        super(String.valueOf(proximity));
        this.proximity = proximity;
    }

    public void setProximity(int proximity) {
        this.proximity = proximity;
        this.setText(String.valueOf(proximity));
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

    public void setFirstClick() {
        isFirstClick = true;
    }

    @Override
    public String toString() {
        return Integer.toString(proximity);
    }
}

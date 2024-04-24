import javax.swing.*;

public class Cell extends JButton {
    private int proximity;

    public Cell(int proximity) {
        this.proximity = proximity;
    }

    public void setProximity(int proximity) {
        this.proximity = proximity;
    }

    public int getProximity() {
        return proximity;
    }

    @Override
    public String toString() {
        return Integer.toString(proximity);
    }
}

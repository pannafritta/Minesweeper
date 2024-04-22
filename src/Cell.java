public class Cell {
    private int proximity;
    public Cell() {
        proximity = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(proximity);
    }
}

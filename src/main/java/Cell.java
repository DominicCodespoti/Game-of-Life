public class Cell {
    private boolean state = false;
    String posMarker = ".";

    public void makeCellAlive() {
        state = true;
    }

    public void makeCellDead() {
        state = false;
    }

    public boolean isCellAlive() {
        return state;
    }
}

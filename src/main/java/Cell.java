public class Cell {
    enum cellState {
        ALIVE,
        DEAD
    }

    cellState Mortality = cellState.DEAD;
    String posMarker = ".";

    public void setCellState(boolean life)
    {
        if (life == true)
        {
            Mortality = cellState.ALIVE;
        }
        else
        {
            Mortality = cellState.DEAD;
        }
    }

    public boolean isCellAlive()
    {
        if (Mortality == cellState.ALIVE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

import org.junit.Assert;
import org.junit.Test;

public class ConwaysTesting {
    @Test
    public void newWorldIsEmpty() {
        Board world = new Board();
        world.initBoard(5, 5);

        Assert.assertTrue(world.checkCells() == 0);
    }

    @Test
    public void canAddACellToTheWorld() {
        Board world = new Board();
        world.initBoard(5, 5);

        Assert.assertFalse(world.boardSpaces.get(1).get(1).isCellAlive());
        world.spawnLife(1, 1);
        Assert.assertTrue(world.boardSpaces.get(1).get(1).isCellAlive());
    }

    @Test
    public void canKillACellInWorld() {
        Board world = new Board();
        world.initBoard(5, 5);

        world.spawnLife(1, 1);
        Assert.assertTrue(world.boardSpaces.get(1).get(1).isCellAlive());

        world.killLife(1, 1);
        Assert.assertFalse(world.boardSpaces.get(1).get(1).isCellAlive());
    }

    @Test
    public void cellsCorrectlyUpdate() {
        Board world = new Board();
        world.initBoard(5, 5);

        world.spawnLife(1, 3);
        world.spawnLife(1, 2);
        world.spawnLife(1, 1);

        world.updateBoard();

        Assert.assertTrue(world.boardSpaces.get(0).get(2).isCellAlive());
        Assert.assertTrue(world.boardSpaces.get(1).get(2).isCellAlive());
        Assert.assertTrue(world.boardSpaces.get(2).get(2).isCellAlive());
    }
}

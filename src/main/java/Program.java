import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String rawInput = "";
        Board gameBoard = new Board();
        Scanner readInput = new Scanner(System.in);
        Integer boardWidth, boardHeight;
        Integer posX = 0;
        Integer posY = 0;

        System.out.println("How many lines wide would you like the board? ");
        boardWidth = Integer.parseInt(readInput.nextLine());
        System.out.println("How many lines high would you like the board? ");
        boardHeight = Integer.parseInt(readInput.nextLine());

        gameBoard.initBoard(boardHeight, boardWidth);
        gameBoard.printBoard();

        while (!rawInput.equals("start")) {
            System.out.println("Select a board position to spawn the first cell on (x,y) or type ('start') to begin: ");
            rawInput = readInput.nextLine();
            if (!rawInput.equals("start")) {
                posX = Integer.parseInt(rawInput.split(",", 2)[0]);
                posY = Integer.parseInt(rawInput.split(",", 2)[1]);
                gameBoard.spawnLife(posX, posY);
                gameBoard.printBoard();
            }
        }

        while (gameBoard.checkCells() > 0) {
            gameBoard = gameBoard.updateBoard();
            gameBoard.printBoard();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

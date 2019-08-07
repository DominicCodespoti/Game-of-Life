import java.util.ArrayList;
import java.util.List;

public class Board {
    Integer boardWidth;
    Integer boardHeight;

    List<List<Cell>> boardSpaces = new ArrayList<List<Cell>>();

    void initBoard(Integer height, Integer width) {
        this.boardWidth = width;
        this.boardHeight = height;

        for (int i = 0; i < boardHeight; i++) {
            ArrayList newRow = new ArrayList<Cell>();
            for (int j = 0; j < boardWidth; j++) {
                newRow.add(new Cell());
            }
            boardSpaces.add(newRow);
        }
    }

    public void spawnLife(int posX, int posY) {
        boardSpaces.get(posX).get(posY).Mortality = Cell.cellState.ALIVE;
        boardSpaces.get(posX).get(posY).posMarker = "O";
        boardSpaces.get(posX).get(posY).setCellState(true);
    }

    public void killLife(int posX, int posY) {
        boardSpaces.get(posX).get(posY).Mortality = Cell.cellState.DEAD;
        boardSpaces.get(posX).get(posY).posMarker = ".";
        boardSpaces.get(posX).get(posY).setCellState(false);
    }

    public void updateBoard() {
        Board gameBoard = new Board();
        gameBoard.initBoard(boardHeight, boardWidth);
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (boardSpaces.get(i).get(j).Mortality == Cell.cellState.ALIVE) {
                    System.out.println(checkSurrounding(i, j) + " " + i + " " + j);
                    if (checkSurrounding(i, j) < 2) {
                        gameBoard.killLife(i, j);
                    }
                    if (checkSurrounding(i, j) > 3) {
                        gameBoard.killLife(i, j);
                    }
                    if (checkSurrounding(i, j).equals(2) || checkSurrounding(i, j).equals(3)) {
                        gameBoard.spawnLife(i, j);
                    }
                }
                if (boardSpaces.get(i).get(j).Mortality == Cell.cellState.DEAD) {
                    if (checkSurrounding(i, j).equals(3)) {
                        gameBoard.spawnLife(i, j);
                    }
                }
            }
        }
        boardSpaces = gameBoard.boardSpaces;
    }

    void printBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(boardSpaces.get(i).get(j).posMarker);
            }
            System.out.println("");
        }
    }

    Integer checkCells() {
        Integer amountAlive = 0;
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                try {
                    if (boardSpaces.get(i).get(j).isCellAlive()) {
                        amountAlive += 1;
                    }
                } catch (Exception e) {
                }
            }
        }
        return amountAlive;
    }

    public Integer checkSurrounding(int X, int Y) {
        Integer total = 0;
        try {
            if (boardSpaces.get(X).get(Y + 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            if (boardSpaces.get(X).get(0).isCellAlive() == true) {
                total += 1;
            }
        }

        try {
            if (boardSpaces.get(X).get(Y - 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            if (boardSpaces.get(X).get(boardSpaces.size() - 1).isCellAlive() == true) {
                total += 1;
            }
            ;
        }

        try {
            if (boardSpaces.get(X + 1).get(Y).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            if (boardSpaces.get(0).get(Y).isCellAlive() == true) {
                total += 1;
            }
        }

        try {
            if (boardSpaces.get(X - 1).get(Y).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            if (boardSpaces.get(boardSpaces.size() - 1).get(Y).isCellAlive() == true) {
                total += 1;
            }
        }

        try {
            if (boardSpaces.get(X + 1).get(Y + 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            try {
                if (boardSpaces.get(0).get(Y + 1).isCellAlive() == true) {
                    total += 1;
                }
            } catch (Exception ex) {
                try {
                    if (boardSpaces.get(X + 1).get(0).isCellAlive() == true) {
                        total += 1;
                    }
                } catch (Exception exe) {
                    if (boardSpaces.get(0).get(0).isCellAlive() == true) {
                        total += 1;
                    }
                }
            }
        }

        try {
            if (boardSpaces.get(X + 1).get(Y - 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            try {
                if (boardSpaces.get(0).get(Y - 1).isCellAlive() == true) {
                    total += 1;
                }
            } catch (Exception ex) {
                try {
                    if (boardSpaces.get(X + 1).get(boardSpaces.size() - 1).isCellAlive() == true) {
                        total += 1;
                    }
                } catch (Exception exe) {
                    if (boardSpaces.get(0).get(boardSpaces.size() - 1).isCellAlive() == true) {
                        total += 1;
                    }
                }
            }
        }

        try {
            if (boardSpaces.get(X - 1).get(Y + 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            try {
                if (boardSpaces.get(boardSpaces.get(X).size() - 1).get(Y + 1).isCellAlive() == true) {
                    total += 1;
                }
            } catch (Exception ex) {
                try {
                    if (boardSpaces.get(X + 1).get(0).isCellAlive() == true) {
                        total += 1;
                    }
                } catch (Exception exe) {
                    if (boardSpaces.get(boardSpaces.size() - 1).get(0).isCellAlive() == true) {
                        total += 1;
                    }
                }
            }
        }

        try {
            if (boardSpaces.get(X - 1).get(Y - 1).isCellAlive() == true) {
                total += 1;
            }
        } catch (Exception e) {
            try {
                if (boardSpaces.get(boardSpaces.get(X).size() - 1).get(Y - 1).isCellAlive() == true) {
                    total += 1;
                }
            } catch (Exception ex) {
                try {
                    if (boardSpaces.get(X - 1).get(boardSpaces.size() - 1).isCellAlive() == true) {
                        total += 1;
                    }
                } catch (Exception exe) {
                    if (boardSpaces.get(boardSpaces.size() - 1).get(boardSpaces.size() - 1).isCellAlive() == true) {
                        total += 1;
                    }
                }
            }
        }
        return total;
    }
}

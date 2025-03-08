package src.game;

public class Grid {

    private Square[][] grid;
    public static final int SIZE = 3;

    public Grid() {
        grid = new Square[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char vCoordinate = (char) ('A' + j); // Converts column index to 'A', 'B', 'C', ...
                grid[i][j] = new Square(i + 1, vCoordinate);
            }
        }
    }

    public Square getSquare(int hCoordinate, char vCoordinate) {
        return grid[hCoordinate - 1][vCoordinate - 'A']; // Converts 'A', 'B', 'C', ... to column index
    }

    public boolean move(String coordinates, Symbol symbol) {
        int hCoordinate = coordinates.charAt(1) - '0'; // converts char '1'-'3' to int
        char vCoordinate = coordinates.charAt(0);
        Square square = getSquare(hCoordinate, vCoordinate);
        if (!square.isOccupied()) {
            square.setSymbol(symbol);
            return true;
        }
        return false;
    }

    public boolean isWinningHorizontal() {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0].isOccupied() && grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2]))
                return true;
        }
        return false;
    }

    public boolean isWinningVertical() {
        for (int j = 0; j < SIZE; j++) {
            if (grid[0][j].isOccupied() && grid[0][j].equals(grid[1][j]) && grid[1][j].equals(grid[2][j]))
                return true;
        }
        return false;
    }

    public boolean isWinningDiagonal() {
        if ((grid[0][0].isOccupied() && grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2]))
                || (grid[2][0].isOccupied() && grid[2][0].equals(grid[1][1]) && grid[1][1].equals(grid[0][2])))
            return true;

        return false;
    }

    public boolean isWinning() {
        return isWinningHorizontal() || isWinningVertical() || isWinningDiagonal();
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!grid[i][j].isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String out = "";

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                out = out + "| " + grid[i][j].toString() + " ";
            }
            out = out + "|"; // End each row with a border
            out = out + "\n"; // New line after each row
        }

        return out;
    }
}

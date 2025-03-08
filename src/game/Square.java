package src.game;

public class Square {

    private int hCoordinate;
    private char vCoordinate;
    private Symbol symbol;
    private boolean occupied;

    public Square(int hCoordinate, char vCoordinate) {
        this.hCoordinate = hCoordinate;
        this.vCoordinate = vCoordinate;
        symbol = new Symbol(' '); // Initially, the square is empty
        this.occupied = false; // Initially, the square is not occupied
    }

    public int getHCoordinate() {
        return hCoordinate;
    }

    public char getVCoordinate() {
        return vCoordinate;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        if (symbol.getMark() != ' ')
            this.occupied = true; // The square is now occupied
    }

    public String toString() {
        return symbol.getMark() + "";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof Square))
            return false;
        Square square = (Square) obj;
        return this.symbol.equals(square.symbol);
    }

}

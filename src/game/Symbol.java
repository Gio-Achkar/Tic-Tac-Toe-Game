package src.game;

public class Symbol {

    private char mark;

    public Symbol(char symbol) {
        this.mark = symbol;
    }

    public char getMark() {
        return mark;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof Symbol))
            return false;
        Symbol symbol = (Symbol) obj;
        return this.mark == symbol.mark;
    }

}
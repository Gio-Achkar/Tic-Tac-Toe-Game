package src.players;

import src.game.Symbol;

public class Computer extends Player {

    public static final String NAME = "Computer";

    public Computer(Symbol symbol) {
        super(NAME, symbol);
    }

    public String getMove() {
        return "Not implemented yet";
    }

}

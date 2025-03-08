package src.players;

import src.game.Symbol;
import java.util.Scanner;

public class Human extends Player {

    Scanner scanner = new Scanner(System.in);

    public Human(String name, Symbol symbol) {
        super(name, symbol);
    }

    public String getMove() { // validates and gets the move from user
        String move;
        do {
            move = scanner.nextLine().trim().toUpperCase();

            if (move.length() == 2) {
                char row = move.charAt(0);
                char col = move.charAt(1);

                if ((row >= 'A' && row <= 'C') && (col >= '1' && col <= '3')) {
                    return move;
                }
            }

            System.out.println("Invalid move, try again.");

        } while (true);
    }

}

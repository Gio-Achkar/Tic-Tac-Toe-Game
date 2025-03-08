package src;

import src.game.*;
import src.players.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int exitOption = 0;
        int playerOption = 1;
        int computerOption = 2;
        int option;

        do {
            System.out.println("Welcome to Tic-Tac-Toe!");
            do {
                System.out.println("Choose your game mode: ");
                System.out.println("1- Play with a friend\n2- Play against the computer\n0- exit");

                option = scan.nextInt();
                if (option != 0 && option != 1 && option != 2)
                    System.out.println("Invalid input! Please try again.");
            } while (option != 0 && option != 1 && option != 2);

            if (option == computerOption)
                System.out.println("Not implemented yet");

            if (option == playerOption) {
                Grid grid = new Grid();
                Symbol xSymbol = new Symbol('X');
                Symbol oSymbol = new Symbol('O');
                Human p1 = new Human("p1", xSymbol);
                Human p2 = new Human("p2", oSymbol);

                System.out.println("Enter the coordinates where you want to place your symbol (e.g., A1): \n");

                String invalidMove = "Invalid move, try again.";
                boolean gameOver = false;
                boolean playerTurn = true; // true = Player 1's turn, false = Player 2's turn
                while (!gameOver) {
                    System.out.println(grid.toString());

                    if (playerTurn) {
                        System.out.println("Player 1's (X) turn:");
                        String move = p1.getMove();
                        if (grid.move(move, p1.getSymbol())) {
                            if (grid.isWinning()) {
                                System.out.println(grid.toString());
                                System.out.println("Player 1 (X) wins!\n");
                                gameOver = true;
                            }
                        } else {
                            System.out.println(invalidMove + "\n");
                            continue;
                        }
                    } else {
                        System.out.println("Player 2's (O) turn:");
                        String move = p2.getMove();
                        if (grid.move(move, p2.getSymbol())) {
                            if (grid.isWinning()) {
                                System.out.println(grid.toString());
                                System.out.println("Player 2 (O) wins!\n");
                                gameOver = true;
                            }
                        } else {
                            System.out.println(invalidMove + "\n");
                            continue;
                        }
                    }

                    if (grid.isFull()) {
                        System.out.println(grid.toString());
                        System.out.println("It's a draw! The grid is full.\n");
                        gameOver = true;
                    }

                    playerTurn = !playerTurn; // Switch turns between Player 1 and Player 2
                }
            }

        } while (option != exitOption);
        System.out.println("Exiting the game...");

        scan.close();

    }

}

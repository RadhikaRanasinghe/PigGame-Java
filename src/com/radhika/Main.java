package com.radhika;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] playerPoints = { 0, 0, 0, 0};
        int turn = 0;
        int currentPlayersPoints;
        boolean gameIsRunning = true;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players willing to play (between 2 and 4): ");
        int numberOfPlayers = scanner.nextInt();

        while (gameIsRunning) {
            if (numberOfPlayers > 1 && numberOfPlayers < 5) {
                System.out.print("Points scored at the end of the last round by each player:\n");
                for (int i = 0; i < playerPoints.length; i++) {
                    System.out.println("Player " + playerPoints[i]);
                }
                turn++;
                System.out.print("\n║   R O U N D   " + turn + "   ║\n");
                for (int x = 0; x < numberOfPlayers; x++) {
                    System.out.print("\nPlayer" + (x + 1) + "'s turn\n");
                    currentPlayersPoints = 0;

                    while (playerPoints[x] < 100) {
                        System.out.print("Enter 'R' for ROLL and 'H' for HOLD: ");
                        String userTurn = scanner.next();

                        if (userTurn.equals("r")) {
                            int roll = (int) (Math.random() * 6 + 1);

                            if (roll != 1) {
                                currentPlayersPoints += roll;
                                System.out.print("You rolled: " + roll + "\nYour score in this round: " + currentPlayersPoints);
                                playerPoints[x] += roll;

                                if (playerPoints[x] >= 100) {
                                    System.out.println("◀  P L A Y E R " + (x + 1) + "   H A S   W O N   T H E   G A M E  ▶");
                                    gameIsRunning = false;
                                    break;
                                } else {
                                    playerPoints[x] -= currentPlayersPoints;
                                    System.out.print("\nYou rolled: " + roll + "\n0 points earned\nCurrent score: " + playerPoints[x]);
                                    break;
                                }

                            }
                        } else if (userTurn.equals("h")) {
                            System.out.print("\nYou have chosen to hold......\nYour score: " + playerPoints[x]);
                            break;
                        } else {
                            System.out.print("Please input only 'R' for ROll or 'H' for HOLD\n");
                        }
                    }
                    if (!gameIsRunning) {
                        break;
                    }
                }
            } else {
                System.out.println("The number of players should be between 2 and 4. Try again!\n");
            }
        }

    }
}

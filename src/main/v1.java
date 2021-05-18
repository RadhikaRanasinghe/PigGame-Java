package main;

import java.util.Scanner;

public class v1 {public static void main(String[] args) {
    main_loop();
}

    public static void main_loop() {
        int[] playerPoints = {0, 0, 0, 0};
        int turn = 0;
        int currentPlayersPoints;
        boolean gameIsRunning = true;
        System.out.print("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣\n");
        System.out.print("▣              W E L C O M E   T O   T H E   P I G   D I C E   G A M E              ▣\n");
        System.out.print("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣\n");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("● Enter number of players (between 2 and 4):\t");
            int numberOfPlayers = scanner.nextInt();

            while (gameIsRunning) {
                if (numberOfPlayers > 1 && numberOfPlayers < 5) {
                    turn++;
                    System.out.print("\n\n▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫   R   O   U   N   D   " + turn + "   ▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫\n");

                    for (int i = 0; i < numberOfPlayers; i++) {
                        System.out.print("\n\t\t\t\t\t\t\t◂◂◂◂◂◂◂◂◂◂ PLAYER " + (i + 1) + " ▸▸▸▸▸▸▸▸▸▸\n");
                        System.out.print("\t\t\t\t\t\t\t\t  S C O R E :   "+playerPoints[i]);
                        currentPlayersPoints = 0;

                        while (playerPoints[i] < 100) {

                            System.out.print("\n\n● Enter 'R' for ROLL and 'H' for HOLD:\t ");
                            String userTurn = scanner.next();

                            if (userTurn.equals("r") || userTurn.equals("R")) {
                                int roll = (int) (Math.random() * 6 + 1);

                                if (roll != 1) {
                                    currentPlayersPoints += roll;
                                    playerPoints[i] += roll;
                                    System.out.print("\tYou rolled: " + roll + "\n\tRound score: " + currentPlayersPoints+ "\n\tTotal score: " + playerPoints[i]);


                                    if (playerPoints[i] >= 100) {
                                        System.out.println("\n◀  P L A Y E R " + (i + 1) + "   H A S   W O N   T H E   G A M E  ▶");
                                        gameIsRunning = false;
                                        break;
                                    }

                                } else {
                                    playerPoints[i] -= currentPlayersPoints;
                                    System.out.print("\n\tYou rolled: " + roll + "\n\t0 points earned\n\tCurrent score: " + playerPoints[i]);
                                    break;
                                }

                            } else if (userTurn.equals("h") || userTurn.equals("H")) {
                                System.out.println("\n\tYou have chosen to hold......\n\tYour score: " + playerPoints[i]);
                                break;
                            } else {
                                System.out.println("Enter a valid input!");
                            }
                        }
                        if (!gameIsRunning) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Enter number between 2 and 4!");
                    main_loop();
                }
            }
        } catch (Throwable error) {
            System.out.println("Invalid input. Please input integers only\n");
            main_loop();
        }
    }
}



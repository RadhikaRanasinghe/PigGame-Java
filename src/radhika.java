import java.util.Scanner;

public class radhika {

    public static void main(String[] args) {
        main_loop();
    }

    public static void main_loop() {
        int[] playerPoints = {0, 0, 0, 0};
        int turn = 0;
        int currentPlayersPoints;
        boolean gameIsRunning = true;
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║              W E L C O M E   T O   T H E   P I G   D I C E   G A M E              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of players willing to play (between 2 and 4): ");
            int numberOfPlayers = scanner.nextInt();

            while (gameIsRunning) {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                if (numberOfPlayers > 1 && numberOfPlayers < 5) {
                    System.out.println("┃◾◾◾◾◾◾◾◾   S C O R E   B O A R D   ◾◾◾◾◾◾◾◾┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

                    for (int player = 0; player < playerPoints.length; player++) {
                        System.out.println("   Player " + (player + 1) + " :" + playerPoints[player]) ;
                    }

                    turn++;
                    System.out.print("\n╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳   R O U N D   " + turn + "   ╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳╳\n");

                    for (int i = 0; i < numberOfPlayers; i++) {
                        System.out.print("\n\n◂◂◂◂◂◂◂◂◂◂ Player " + (i + 1) + " ▸▸▸▸▸▸▸▸▸▸\n");
                        currentPlayersPoints = 0;

                        while (playerPoints[i] < 100) {

                            System.out.print("\n\nEnter 'R' for ROLL and 'H' for HOLD: ");
                            String userTurn = scanner.next();

                            if (userTurn.equals("r") || userTurn.equals("R")) {
                                int roll = (int) (Math.random() * 6 + 1);

                                if (roll != 1) {
                                    currentPlayersPoints += roll;
                                    System.out.print("You rolled: " + roll + "\nRound score: " + currentPlayersPoints);
                                    playerPoints[i] += roll;

                                    if (playerPoints[i] >= 100) {
                                        System.out.println("\n◀  P L A Y E R " + (i + 1) + "   H A S   W O N   T H E   G A M E  ▶");
                                        gameIsRunning = false;
                                        break;
                                    }

                                } else {
                                        playerPoints[i] -= currentPlayersPoints;
                                        System.out.print("\nYou rolled: " + roll + "\n0 points earned\nCurrent score: " + playerPoints[i]);
                                        break;
                                }

                            } else if (userTurn.equals("h") || userTurn.equals("H")) {
                                    System.out.println("\nYou have chosen to hold......\nYour score: " + playerPoints[i]);
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

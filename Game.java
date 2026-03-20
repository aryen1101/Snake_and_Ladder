
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final DifficultyStrategy strategy;
    private final Scanner scanner;

    public Game(Board board, Dice dice, List<Player> playersList, DifficultyStrategy strategy) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(playersList);
        this.strategy = strategy;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("-----GAME STARTED-----");
        boolean won = false;

        while (!won) {
            Player currPlayer = players.poll();
            System.out.println(currPlayer.getName() + " will move!");

            int consecutiveSix = 0;
            boolean isNextTurn = true;

            int startPosition = currPlayer.getPosition();

            while (isNextTurn && !won) {

                System.out.print("Press [ENTER] to roll the dice...");
                scanner.nextLine();

                int roll = dice.roll();
                System.out.println("It is a " + roll);

                if (roll == 6) {
                    consecutiveSix++;
                    if (consecutiveSix == 3) {
                        if (strategy.isTurnLost()) {
                            System.out.println(" Turn Lost because of 3 six.");
                            currPlayer.setPosition(startPosition);
                            // consecutiveSix = 0;
                            break;
                        } else {
                            consecutiveSix = 0;
                        }
                    }

                } else {
                    consecutiveSix = 0;
                }

                int finalPosition = board.resolveMove(currPlayer.getPosition(), roll);
                currPlayer.setPosition(finalPosition);
                System.out.println(currPlayer.getName() + " is moved to " + currPlayer.getPosition());

                if (board.isWinning(currPlayer.getPosition())) {
                    System.out.println(currPlayer.getName() + " has won the game.");
                    won = true;
                    break;
                }

                if (roll != 6) {
                    isNextTurn = false;
                }
                if (isNextTurn) {
                    System.out.println("Rolled a 6! Next turn is yours");
                }
            }
            if (!won) {
                players.add(currPlayer);
            }
        }
    }

}

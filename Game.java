import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final DifficultyStrategy strategy;
    private final Scanner sc;

    public Game(Board board, Dice dice, List<Player> playersList, DifficultyStrategy strategy, Scanner sc) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(playersList);
        this.strategy = strategy;
        this.sc = sc;
    }

    public void play() {
        System.out.println("-----GAME STARTED-----");
        
        int currentRank = 1;

        while (players.size() > 1) {
            Player currPlayer = players.poll();
            System.out.println("\n" + currPlayer.getName() + " will move!");

            int consecutiveSix = 0;
            boolean isNextTurn = true;
            
            int startPosition = currPlayer.getPosition();

            while (isNextTurn) {
                System.out.print("Press [ENTER] to roll the dice...");
                sc.nextLine();

                int roll = dice.roll();
                System.out.println("It is a " + roll);

                if (strategy.getExtraTurn(roll)) {
                    consecutiveSix++;
                    
                    if (strategy.isTurnLost(roll, consecutiveSix)) {
                        System.out.println("Turn lost because of 3 sixes.");
                        currPlayer.setPosition(startPosition); 
                        break;
                    } else {
                        System.out.println("Rolled a 6, Got one more turn");
                        isNextTurn = true; 
                    }
                } else {
                    consecutiveSix = 0;
                    isNextTurn = false;
                }

                int finalPosition = board.resolveMove(currPlayer.getPosition(), roll);
                currPlayer.setPosition(finalPosition);
                System.out.println(currPlayer.getName() + " is moved to " + currPlayer.getPosition());

                if (board.isWinning(currPlayer.getPosition())) {
                    System.out.println(currPlayer.getName() + " has won the game! Rank: " + currentRank);
                    currentRank++;
                    break; 
                }
            }
            
            if (!board.isWinning(currPlayer.getPosition())) {
                players.offer(currPlayer);
            }
        }

        if (!players.isEmpty()) {
            Player lastPlace = players.poll();
            System.out.println("\n-----GAME OVER-----");
            System.out.println(lastPlace.getName() + " finished in last place.");
        }
    }
}
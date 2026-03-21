
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFactory {

    public static Game createGame(int size, int snakeCount, int ladderCount, int playerCount, String difficulty, Scanner sc) {

        Board board = BoardFactory.createBoard(size, snakeCount, ladderCount);
        Dice dice = DiceFactory.createDice();

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            players.add(new Player("Player " + i));
        }

        DifficultyStrategy strategy;
        if (difficulty != null && difficulty.equalsIgnoreCase("hard")) {
            strategy = new HardStrategy();
        } else {
            strategy = new EasyStrategy();
        }

        return new Game(board, dice, players, strategy, sc);
    }

}

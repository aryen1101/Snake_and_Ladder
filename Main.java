import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Snake and Ladder!");

        System.out.print("Enter grid size: ");
        int size = sc.nextInt();

        System.out.print("Enter number of snakes: ");
        int snakeCount = sc.nextInt();

        System.out.print("Enter number of ladders: ");
        int ladderCount = sc.nextInt();

        System.out.print("Enter number of players: ");
        int playerCount = sc.nextInt();

        System.out.print("Enter difficulty (easy/hard): ");
        String difficulty = sc.next();

        sc.nextLine();

        System.out.println("Grid Size: " + size + "x" + size + " (" + (size * size) + " squares)");
        System.out.println("Difficulty: " + difficulty.toUpperCase());
        System.out.println("Total Players: " + playerCount);

        Game game = GameFactory.createGame(
            size, 
            snakeCount, 
            ladderCount, 
            playerCount,
            difficulty,
            sc
        );

        game.play();
        
    }
}
public class Main {
    public static void main(String[] args) {
        int size = 10;     
        int snakeCount = 6;    
        int ladderCount = 6;  
        String difficulty = "easy"; 
        int playerCount = 3;  

        System.out.println("Starting Snake and Ladder Game");
        System.out.println("Grid Size: " + size + "x" + size + " (" + (size * size) + " squares)");
        System.out.println("Difficulty: " + difficulty.toUpperCase());
        System.out.println("Total Players: " + playerCount);

        Game game = GameFactory.createGame(
            size, 
            snakeCount, 
            ladderCount, 
            playerCount,
            difficulty
        );

        game.play();
    }
}
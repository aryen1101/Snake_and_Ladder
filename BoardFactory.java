

import java.util.*;

public class BoardFactory {

    public static Board createBoard(int size, int snakeCount, int ladderCount) {
        int totalSquare = size * size;
        Map<Integer, BoardEntity> entities = new HashMap<>();

        int maxAllowedEntities = totalSquare / 4; 
        
        if ((snakeCount + ladderCount) > maxAllowedEntities) {
            throw new IllegalArgumentException(
                "The board is too small! A " + totalSquare + 
                "-square board can safely hold a maximum of " + maxAllowedEntities + 
                " total snakes and ladders."
            );
        }

        generateEntities(entities, totalSquare, snakeCount, ladderCount);

        return new Board(totalSquare, entities);
    }

    private static void generateEntities(Map<Integer, BoardEntity> entities, int totalSquare, int snakeCount, int ladderCount) {
        Random random = new Random();
        Set<Integer> usedSquares = new HashSet<>();

        usedSquares.add(1);
        usedSquares.add(totalSquare);

        for (int i = 0; i < snakeCount; i++) {
            while (true) {
                int start = random.nextInt(totalSquare - 2) + 2;
                int end = random.nextInt(start - 1) + 1;

                if (!usedSquares.contains(start) && !usedSquares.contains(end)) {
                    entities.put(start, new Snake(start, end));
                    usedSquares.add(start);
                    usedSquares.add(end);
                    break;
                }

            }
        }

        for (int i = 0; i < ladderCount; i++) {
            while (true) {
                int start = random.nextInt(totalSquare - 2) + 2;
                int end = random.nextInt(totalSquare - start) + start + 1;
                if (!usedSquares.contains(start) && !usedSquares.contains(end)) {
                    entities.put(start, new Ladder(start, end));
                    usedSquares.add(start);
                    usedSquares.add(end);
                    break;
                }

            }
        }
    }
}

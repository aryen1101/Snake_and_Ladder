
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer, BoardEntity> entities;

    public Board(int size, Map<Integer, BoardEntity> entities) {
        this.size = size;
        this.entities = entities;
    }

    public int getSize() {
        return this.size;
    }

    public int resolveMove(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > size) {
            System.out.println("Need exactly " + (this.size - currentPosition) + " to win.");
            return currentPosition;
        }

        if (entities.containsKey(newPosition)) {
            return entities.get(newPosition).getEndPosition();
        }

        return newPosition;
    }

    public boolean isWinning(int position){
        return position == this.size;
    }

}

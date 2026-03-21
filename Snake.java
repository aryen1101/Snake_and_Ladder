

public class Snake extends BoardEntity {

    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public int getEndPosition() {
        System.out.println("Bitten by Snake at " + start + ". Moving down to " + end);
        return end;
    }
}

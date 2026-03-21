
public class Ladder extends BoardEntity {

    public Ladder(int start , int end){
        super(start, end);
    }

    @Override
    public int getEndPosition() {
        System.out.println("Climbing a Ladder at " + start + ". Moving up to " + end);
        return end;
    }
    
}

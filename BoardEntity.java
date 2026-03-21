

public abstract  class BoardEntity {

    protected final int start;
    protected final int end;

    public BoardEntity(int start , int end){
        this.start = start;
        this.end = end;
    }

    public int getStartPosition(){
        return this.start;
    }
    public abstract int getEndPosition();

}


public interface DifficultyStrategy {
    
    boolean getExtraTurn(int roll);
    boolean isTurnLost(int roll , int consecutiveSix);    
}

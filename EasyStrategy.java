
public class EasyStrategy implements DifficultyStrategy {

    @Override
    public boolean getExtraTurn(int roll) {
        return roll == 6;
    }

    @Override
    public boolean isTurnLost(int roll , int consecutiveSix) {
        return false;
    }
}
package za.ac.learningnavigation0;

/**
 * Model class for Dice UI State
 */
public class DiceUiState {
    private final Integer firstDieValue;
    private final Integer secondDieValue;
    private final int numberOfRolls;

    public DiceUiState(Integer firstDieValue, Integer secondDieValue, int numberOfRolls) {
        this.firstDieValue = firstDieValue;
        this.secondDieValue = secondDieValue;
        this.numberOfRolls = numberOfRolls;
    }

    public Integer getFirstDieValue() {
        return firstDieValue;
    }

    public Integer getSecondDieValue() {
        return secondDieValue;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }
}

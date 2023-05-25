package za.ac.learningnavigation0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class DiceRollViewModel extends ViewModel {
    // The view model stores MutableLiveData that contains the object of the model class
    private final MutableLiveData<DiceUiState> uiState = new MutableLiveData<>(new DiceUiState(-1, -1, 0));

    /**
     * This is a getter fir the MutableLiveData of the model data
     * @return the live data | ui state
     */
    public LiveData<DiceUiState> getUiState() {
        return uiState;
    }

    /**
     * Makes changes to the MutableLiveData so that we have new data in there
     */
    public void rollDice() {
        Random random = new Random();
        uiState.setValue(
                new DiceUiState(
                        random.nextInt(7) + 1,
                        random.nextInt(7) + 1,
                        uiState.getValue().getNumberOfRolls() + 1
                )
        );
    }
}
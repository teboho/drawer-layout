package za.ac.learningnavigation0;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * This fragment is responsible for the dice roll functionality
 * @see DiceRollViewModel
 * @see DiceUiState
 * @see MainActivity
 * @author teboho
 */
public class DiceRollFragment extends Fragment {

    private DiceRollViewModel mViewModel;

    public static DiceRollFragment newInstance() {
        return new DiceRollFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dice_roll, container, false);

        // The view model storage will be owned by the activity meaning that it will be alive throughout the lifecycle of the activity
        mViewModel = new ViewModelProvider(getActivity()).get(DiceRollViewModel.class);
        ((Toolbar)(getActivity().findViewById(R.id.my_toolbar))).
                setTitle("Dice Roll");

        // Using the ViewModel
        FloatingActionButton rollFAB = view.findViewById(R.id.roll_fab);
        FloatingActionButton refreshRollFAB = view.findViewById(R.id.refresh_roll);
        TextView roll1Result = (TextView)view.findViewById(R.id.roll_1_result);
        TextView roll2Result = (TextView)view.findViewById(R.id.roll_2_result);
        TextView rollCount = view.findViewById(R.id.rollCount);

        // What must happen as the view model live data changes ...
        mViewModel.getUiState().observe(getViewLifecycleOwner(), diceUiState -> {
            roll1Result.setText(diceUiState.getFirstDieValue() + "");
            roll2Result.setText(diceUiState.getSecondDieValue() + "");
            rollCount.setText(diceUiState.getNumberOfRolls()+ "");
        });

        // Make chages to the view model (roll)
        rollFAB.setOnClickListener(l -> {
            mViewModel.rollDice();
        });

        // Make chages to the view model (refresh)
        refreshRollFAB.setOnClickListener(l -> mViewModel.refresh());

        return view;
    }
}
package za.ac.learningnavigation0;

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

public class DiceRollFragment extends Fragment {

    private DiceRollViewModel mViewModel;

    public static DiceRollFragment newInstance() {
        return new DiceRollFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dice_roll, container, false);


        mViewModel = new ViewModelProvider(this).get(DiceRollViewModel.class);

        // TODO: Use the ViewModel
        FloatingActionButton rollFAB = view.findViewById(R.id.roll_fab);
        TextView roll1Result = (TextView)view.findViewById(R.id.roll_1_result);
        TextView roll2Result = (TextView)view.findViewById(R.id.roll_2_result);

        // What must happen as the viewmodel stuf changes ...
        mViewModel.getUiState().observe(getViewLifecycleOwner(), diceUiState -> {
            roll1Result.setText(diceUiState.getFirstDieValue() + "");
            roll2Result.setText(diceUiState.getSecondDieValue() + "");
        });

        // Make chages to the view model
        rollFAB.setOnClickListener(l -> {
            mViewModel.rollDice();
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = new ViewModelProvider(this).get(DiceRollViewModel2.class);
        // TODO: Use the ViewModel

    }

}
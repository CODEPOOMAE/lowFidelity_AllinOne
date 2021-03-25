package coms.example.allinonelowfiproject.ExerciseDiary.ui.BodyPlan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import coms.example.allinonelowfiproject.R;

public class BodyPlanFragment extends Fragment {

    private BodyPlanViewModel bodyPlanViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bodyPlanViewModel =
                new ViewModelProvider(this).get(BodyPlanViewModel.class);
        View root = inflater.inflate(R.layout.fragment_body_plan, container, false);

        bodyPlanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
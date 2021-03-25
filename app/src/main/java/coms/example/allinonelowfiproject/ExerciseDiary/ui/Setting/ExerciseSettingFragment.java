package coms.example.allinonelowfiproject.ExerciseDiary.ui.Setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import coms.example.allinonelowfiproject.R;

public class ExerciseSettingFragment extends Fragment {

    private ExerciseSettingViewModel exerciseSettingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exerciseSettingViewModel =
                new ViewModelProvider(this).get(ExerciseSettingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercise_setting, container, false);

        final TextView textView = root.findViewById(R.id.text_exercise_setting);
        exerciseSettingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
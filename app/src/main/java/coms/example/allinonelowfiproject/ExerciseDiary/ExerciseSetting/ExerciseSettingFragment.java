package coms.example.allinonelowfiproject.ExerciseDiary.ExerciseSetting;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import coms.example.allinonelowfiproject.R;

public class ExerciseSettingFragment extends Fragment {

    private ExerciseSettingViewModel mViewModel;

    public static ExerciseSettingFragment newInstance() {
        return new ExerciseSettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Context context;
        context = container.getContext();
        Toast.makeText(context,"ExerciseSettingFragment",Toast.LENGTH_LONG).show();

        return inflater.inflate(R.layout.exercise_setting_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ExerciseSettingViewModel.class);
        // TODO: Use the ViewModel
    }

}
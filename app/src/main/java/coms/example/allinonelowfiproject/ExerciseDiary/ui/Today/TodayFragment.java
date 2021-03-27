package coms.example.allinonelowfiproject.ExerciseDiary.ui.Today;

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

public class TodayFragment extends Fragment {

    private TodayViewModel todayViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_today, container, false);



        todayViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
package coms.example.allinonelowfiproject.ExerciseDiary.ui.Today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import coms.example.allinonelowfiproject.R;

public class TodayFragment extends Fragment {

    private TodayViewModel todayViewModel;
    private RatingBar ratingBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_today, container, false);

        ratingBar = root.findViewById(R.id.ratio_today_impression);



        /*todayViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });*/
        return root;
    }
}
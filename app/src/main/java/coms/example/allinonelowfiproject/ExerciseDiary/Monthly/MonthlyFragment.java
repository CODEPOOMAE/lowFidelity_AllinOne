package coms.example.allinonelowfiproject.ExerciseDiary.Monthly;

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

public class MonthlyFragment extends Fragment {

    private MonthlyViewModel mViewModel;

    public static MonthlyFragment newInstance() {
        return new MonthlyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Context context;
        context = container.getContext();
        Toast.makeText(context,"MonthlyFragment",Toast.LENGTH_LONG).show();

        return inflater.inflate(R.layout.monthly_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonthlyViewModel.class);
        // TODO: Use the ViewModel
    }

}
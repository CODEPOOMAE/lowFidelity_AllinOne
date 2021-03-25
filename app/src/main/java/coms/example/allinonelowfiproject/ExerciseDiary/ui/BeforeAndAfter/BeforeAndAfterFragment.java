package coms.example.allinonelowfiproject.ExerciseDiary.ui.BeforeAndAfter;

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

public class BeforeAndAfterFragment extends Fragment {

    private BeforeAndAfterViewModel beforeAndAfterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beforeAndAfterViewModel =
                new ViewModelProvider(this).get(BeforeAndAfterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_before_and_after, container, false);


        final TextView textView = root.findViewById(R.id.text_before_and_after);


        beforeAndAfterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
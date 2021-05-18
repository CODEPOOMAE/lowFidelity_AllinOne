package coms.example.allinonelowfiproject.ExerciseDiary.BodyPlan;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import coms.example.allinonelowfiproject.R;

public class BodyPlanFragment extends Fragment {

    private BodyPlanViewModel bodyPlanViewModel;
    private ImageView wannabePhoto;
    private TextView startDay;
    private ImageButton calenderStartDay;
    private TextView finishDay;
    private ImageButton calenderFinishDay;
    private TextView dDay;
    private EditText howMessage;
    private EditText whyMessage;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bodyPlanViewModel = new ViewModelProvider(this).get(BodyPlanViewModel.class);
        View root = inflater.inflate(R.layout.body_plan_fragment, container, false);

        wannabePhoto = root.findViewById(R.id.wannabe_photo);

        startDay = root.findViewById(R.id.text_start_day);
        calenderStartDay=root.findViewById(R.id.button_start_calender);

        finishDay = root.findViewById(R.id.text_finish_day);
        calenderFinishDay = root.findViewById(R.id.button_finish_calender);

        dDay = root.findViewById(R.id.text_dday);

        howMessage = root.findViewById(R.id.text_how);

        whyMessage = root.findViewById(R.id.text_why);

        return root;
    }

}
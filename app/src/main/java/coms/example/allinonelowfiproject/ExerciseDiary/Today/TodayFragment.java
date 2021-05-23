package coms.example.allinonelowfiproject.ExerciseDiary.Today;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import coms.example.allinonelowfiproject.R;

public class TodayFragment extends Fragment {

    final SimpleDateFormat dataFormat = new SimpleDateFormat("MM/dd/yyyy");

    private TodayViewModel todayViewModel;

    private final int GET_GALLERY_IMAGE=200;

    private TextView textDDay;

    private TextView textDate;

    private TextView textWakeup;
    private TextView textNight;

    private TextView textValue;
    private EditText textValueNum;
    private TextView textValueUnit;

    private Button weightBtn;
    private Button waistBtn;
    private Button chestBtn;
    private Button hipBtn;
    private Button fatBtn;
    private Button muscleBtn;

    private Double todayWeight;
    private Double todayWaist;
    private Double todayChest;
    private Double todayHip;
    private Double todayFat;
    private Double todayMuscle;


    private TextView textWater;
    private RatingBar waterValue;

    private RecyclerView todayMealRecyclerView;
    private RecyclerView todayWorkOutRecyclerView;

    private RatingBar todayScore;
    private EditText textTodayImpression;
    private ImageView todayPhoto;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.today_fragment, container, false);
        todayViewModel = new ViewModelProvider(this).get(TodayViewModel.class);

        textDDay = root.findViewById(R.id.text_today_dday);
        textDate = root.findViewById(R.id.text_today_date);

        textWakeup = root.findViewById(R.id.text_today_wakeup);
        textNight = root.findViewById(R.id.text_today_night);

        textValue = root.findViewById(R.id.text_today_record);
        textValueNum = root.findViewById(R.id.text_today_record_value);
        textValueUnit = root.findViewById(R.id.text_today_record_unit);

        weightBtn = root.findViewById(R.id.button_today_weight);
        waistBtn = root.findViewById(R.id.button_today_waist);
        chestBtn = root.findViewById(R.id.button_today_chest);
        hipBtn = root.findViewById(R.id.button_today_hip);
        fatBtn = root.findViewById(R.id.button_today_fat);
        muscleBtn = root.findViewById(R.id.button_today_muscle);

        textWater = root.findViewById(R.id.text_today_water_value);
        waterValue = root.findViewById(R.id.today_water_rating);

        todayMealRecyclerView = root.findViewById(R.id.today_meal_recycler);
        todayWorkOutRecyclerView = root.findViewById(R.id.today_workout_recycler);

        todayScore = root.findViewById(R.id.today_score);
        textTodayImpression = root.findViewById(R.id.text_today_impression);
        todayPhoto = root.findViewById(R.id.today_photo);
//
//        //Set Dday
//
//
        //Set date

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        String nowDay = dataFormat.format(date);
        textDate.setText(nowDay);

//        //Set Wakeup Time
//        textWakeup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimePickerFragment dialogFragment = new TimePickerFragment();
//                textWakeup.setText(dialogFragment.toString());
//            }
//        });
//
//        //Set Night Time
//        textNight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimePickerFragment dialogFragment = new TimePickerFragment();
//                textNight.setText(dialogFragment.toString());
//            }
//        });
//
//        //Button and Set Record Text
//        weightBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("WEIGHT");
//                todayWeight = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("KG");
//            }
//        });
//        waistBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("Waist");
//                todayWaist = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("mm");
//            }
//        });
//        chestBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("Chest");
//                todayChest = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("mm");
//            }
//        });
//        hipBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("Hip");
//                todayHip = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("mm");
//            }
//        });
//        fatBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("Fat");
//                todayFat = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("%");
//            }
//        });
//        muscleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textValue.setText("Muscle");
//                todayMuscle = Double.parseDouble(textValueNum.getText().toString());
//                textValueUnit.setText("%");
//            }
//        });
//
//        //Set Water Rate

        Context context;
        context = container.getContext();
        Toast.makeText(context,"TodayFragment",Toast.LENGTH_LONG).show();
        

        return root;
    }

}
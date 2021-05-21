package coms.example.allinonelowfiproject.ExerciseDiary.BodyPlan;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import coms.example.allinonelowfiproject.R;

public class BodyPlanFragment extends Fragment {

    private BodyPlanViewModel bodyPlanViewModel;

    private ImageView wannabePhoto;
    private final int GET_GALLERY_IMAGE=200;

    final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd");

    private TextView startDayText;
    private ImageButton calenderStartDayBtn;
    private TextView finishDayText;
    private ImageButton calenderFinishDayBtn;
    private TextView dDayText;
    private EditText howMessageText;
    private EditText whyMessageText;

    private Calendar startDay;
    private Calendar finishDay;
    private long diffDay;
    private String how;
    private String why;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bodyPlanViewModel = new ViewModelProvider(this).get(BodyPlanViewModel.class);
        View root = inflater.inflate(R.layout.body_plan_fragment, container, false);

//        wannabePhoto = root.findViewById(R.id.wannabe_photo);
//        startDayText = root.findViewById(R.id.text_start_day);
//        calenderStartDayBtn=root.findViewById(R.id.button_start_calender);
//        finishDayText = root.findViewById(R.id.text_finish_day);
//        calenderFinishDayBtn = root.findViewById(R.id.button_finish_calender);
//        dDayText = root.findViewById(R.id.text_dday);
//        howMessageText = root.findViewById(R.id.text_how);
//        whyMessageText = root.findViewById(R.id.text_why);
//
//        //WannabePhoto Upload
//        wannabePhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
//                startActivityForResult(intent,GET_GALLERY_IMAGE);
//            }
//        });
//
//        //Set Start Day
//        calenderStartDayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDatePicker();
//            }
//        });

        Context context;
        context = container.getContext();
        Toast.makeText(context,"BodyPlanFragment",Toast.LENGTH_LONG).show();


        return root;
    }

    private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate);
        date.show(getFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int month, int day) {
            //날짜 설정됨
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(Calendar.YEAR, year);
            selectedCalendar.set(Calendar.MONTH, month);
            selectedCalendar.set(Calendar.DAY_OF_MONTH, day);
            // 달력의 년월일을 버튼에서 넘겨받은 년월일로 설정

            Date curDate = selectedCalendar.getTime(); // 현재를 넘겨줌
            setSelectedDate(curDate);


        }
    };

    private void setSelectedDate(Date curDate) {
        String selectedDateStr = dataFormat.format(curDate);
    }
}
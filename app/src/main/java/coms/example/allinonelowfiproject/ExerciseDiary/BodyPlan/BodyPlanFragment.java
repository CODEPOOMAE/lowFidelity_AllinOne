package coms.example.allinonelowfiproject.ExerciseDiary.BodyPlan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonParser;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import coms.example.allinonelowfiproject.R;

public class BodyPlanFragment extends Fragment {

    private static final String TAG = "BodyPlanFragment";

    private BodyPlanViewModel bodyPlanViewModel;

    private ImageView wannabePhoto;
    private final int GET_GALLERY_IMAGE=200;

    final SimpleDateFormat dataFormat = new SimpleDateFormat("MM/dd/yyyy");

    private TextView startDayText;
    private ImageButton calenderStartDayBtn;

    private TextView finishDayText;
    private ImageButton calenderFinishDayBtn;
    private TextView dDayText;
    private EditText howMessageText;
    private EditText whyMessageText;

    private String startDay;
    private String finishDay;

    private long diffDay;
    private long calDateDays;
    private Date SD;
    private Date FD;

    private String how;
    private String why;

    private static final int REQUEST_CODE_START = 11; // Used to identify the result
    private static final int REQUEST_CODE_FINISH = 12;
    private OnFragmentInteractionListener mListener;

    public static BodyPlanFragment newInstacne(){
        BodyPlanFragment fragment = new BodyPlanFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bodyPlanViewModel = new ViewModelProvider(this).get(BodyPlanViewModel.class);
        View root = inflater.inflate(R.layout.body_plan_fragment, container, false);

        wannabePhoto = root.findViewById(R.id.wannabe_photo);
        startDayText = root.findViewById(R.id.start_day);
        calenderStartDayBtn=root.findViewById(R.id.button_start_calender);
        finishDayText = root.findViewById(R.id.finish_day);
        calenderFinishDayBtn = root.findViewById(R.id.button_finish_calender);
        dDayText = root.findViewById(R.id.view_dday);
        howMessageText = root.findViewById(R.id.write_how);
        whyMessageText = root.findViewById(R.id.write_why);

        //WannabePhoto Upload
        wannabePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,GET_GALLERY_IMAGE);
            }
        });

        final FragmentManager fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();

        //StartDatePicker
        startDayText.addTextChangedListener(new DateMask());
        calenderStartDayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(BodyPlanFragment.this,REQUEST_CODE_START);
                newFragment.show(fm,"DatePicker");
            }
        });

        //FinishDatePicker
        finishDayText.addTextChangedListener(new DateMask());
        calenderFinishDayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(BodyPlanFragment.this,REQUEST_CODE_FINISH);
                newFragment.show(fm,"DatePicker");
            }
        });

//        Log.e(TAG,"startDay : "+startDay + "finishDay : "+finishDay);
//        //Set D-day
//        if(startDay.length()!=0 && finishDay.length()!=0){
//            Log.i(TAG,"Call getDday");
//            dDayText.setText(getDday(startDay,finishDay));
//        }

        //HOW
        howMessageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                how = howMessageText.getText().toString();
                Log.i(TAG,"how : "+how);
            }
        });

        //WhY
        whyMessageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                why=whyMessageText.getText().toString();
                Log.i(TAG,"why : "+why);
            }
        });


        Context context;
        context = container.getContext();
        Toast.makeText(context,"BodyPlanFragment",Toast.LENGTH_LONG).show();


        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d(TAG,"onActivityResult / requestCode : "+requestCode + " / resultCode :"+resultCode);
        if(requestCode == REQUEST_CODE_START && resultCode == Activity.RESULT_OK){
            startDay = data.getStringExtra("selectedDate");
            Log.d(TAG,"startDayTextSetText / startDay :"+startDay);
            startDayText.setText(startDay);
        }
        else if(requestCode == REQUEST_CODE_FINISH && resultCode == Activity.RESULT_OK){
            finishDay=data.getStringExtra("selectedDate");
            Log.d(TAG,"finishDaySetText / finishDay :"+finishDay);
            finishDayText.setText(finishDay);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement OnFragmentListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mListener=null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private final int ONE_DAY = 24 * 60 * 60 * 1000;

    private String getDday(String SD, String FD){


        try{

            Calendar startday = Calendar.getInstance();
            Calendar finishday = Calendar.getInstance();

            String[] start = SD.split("/");
            String[] finish = FD.split("/");

            int sYear=Integer.getInteger(start[2]);
            int sMonth=Integer.getInteger(start[0]);
            int sDay=Integer.getInteger(start[1]);

            int fYear=Integer.getInteger(finish[2]);
            int fMonth=Integer.getInteger(finish[0]);
            int fDay=Integer.getInteger(finish[1]);

            startday.set(sYear,sMonth,sDay);
            finishday.set(fYear,fMonth,fDay);

            long dday = finishday.getTimeInMillis() / ONE_DAY;
            long tday = startday.getTimeInMillis() / ONE_DAY;

            long result = dday-tday;

            Log.i(TAG,"getDday / result = "+result);

            String strFormat;
            if(result>0) {
                strFormat = "D-%d";
            }else if(result==0){
                strFormat="D-day";
            }else{
                result*=-1;
                strFormat="D+%d";
            }

            return String.format(strFormat,result);
        }catch (Exception e) {
            Log.e(TAG,"getDday Exception");
            e.printStackTrace();
            return null;
        }

    }

}
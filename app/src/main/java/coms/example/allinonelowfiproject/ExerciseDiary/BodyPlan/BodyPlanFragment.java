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

    private String startDay;
    private String finishDay;
    private long diffDay;
    private String how;
    private String why;

    public static final int REQUEST_CODE_START = 11; // Used to identify the result
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
        startDayText = root.findViewById(R.id.text_start_day);
        calenderStartDayBtn=root.findViewById(R.id.button_start_calender);
        finishDayText = root.findViewById(R.id.text_finish_day);
        calenderFinishDayBtn = root.findViewById(R.id.button_finish_calender);
        dDayText = root.findViewById(R.id.text_dday);
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

        //StartDatePicker
        startDayText.addTextChangedListener(new DateMask());
        final FragmentManager fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
        calenderStartDayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(BodyPlanFragment.this,REQUEST_CODE_START);
                newFragment.show(fm,"DatePicker");
            }
        });



        Context context;
        context = container.getContext();
        Toast.makeText(context,"BodyPlanFragment",Toast.LENGTH_LONG).show();


        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE_START && resultCode == Activity.RESULT_OK){
            startDay = data.getStringExtra("selectdDate");
            startDayText.setText(startDay);
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

}
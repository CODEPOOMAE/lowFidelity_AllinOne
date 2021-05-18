package coms.example.allinonelowfiproject.ExerciseDiary.BeforeAndAfter;

import androidx.lifecycle.ViewModelProvider;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import coms.example.allinonelowfiproject.R;

import static android.app.Activity.RESULT_OK;

public class BeforeAndAfterFragment extends Fragment {

    private BeforeAndAfterViewModel beforeAndAfterViewModelViewModel;

    private ImageView beforeImageView;
    private ImageView afterImageView;

    private final int GET_GALLERY_IMAGE=200;

    private EditText beforeWeightText;
    private EditText beforeChestText;
    private EditText beforeWaistText;
    private EditText beforeHipText;
    private EditText beforeFatText;
    private EditText beforeMuscleText;

    private Double beforeWeight;
    private Double beforeChest;
    private Double beforeWaist;
    private Double beforeHip;
    private Double beforeFat;
    private Double beforeMuscle;


    private TextView afterWeightText;
    private TextView afterChestText;
    private TextView afterWaistText;
    private TextView afterHipText;
    private TextView afterFatText;
    private TextView afterMuscleText;

    private Double afterWeight;
    private Double afterChest;
    private Double afterWaist;
    private Double afterHip;
    private Double afterFat;
    private Double afterMuscle;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.before_and_after_fragment, container, false);
        beforeAndAfterViewModelViewModel = new ViewModelProvider(this).get(BeforeAndAfterViewModel.class);

        //Photo Reading
        beforeImageView = root.findViewById(R.id.table_before_photo);
        afterImageView = root.findViewById(R.id.table_after_photo);

        //BeforeData Reading
        beforeWeightText = root.findViewById(R.id.table_value_before_weight);
        beforeChestText = root.findViewById(R.id.table_value_before_chest);
        beforeWaistText = root.findViewById(R.id.table_value_before_waist);
        beforeHipText = root.findViewById(R.id.table_value_before_hip);
        beforeFatText = root.findViewById(R.id.table_value_before_fat);
        beforeMuscleText = root.findViewById(R.id.table_value_before_muscle);

        //AfterData Reading
        afterWeightText = root.findViewById(R.id.table_value_after_weight);
        afterChestText = root.findViewById(R.id.table_value_after_chest);
        afterWaistText = root.findViewById(R.id.table_value_after_waist);
        afterHipText = root.findViewById(R.id.table_value_after_hip);
        afterFatText = root.findViewById(R.id.table_value_after_fat);
        afterMuscleText = root.findViewById(R.id.table_value_after_muscle);

        //before Image Loading
        beforeImageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,GET_GALLERY_IMAGE);
            }
        });
        //before Data
        beforeWeight = Double.parseDouble(beforeWeightText.getText().toString());
        beforeChest =  Double.parseDouble(beforeChestText.getText().toString());
        beforeWaist = Double.parseDouble(beforeWaistText.getText().toString());
        beforeHip = Double.parseDouble(beforeHipText.getText().toString());
        beforeFat = Double.parseDouble(beforeFatText.getText().toString());
        beforeMuscle = Double.parseDouble(beforeMuscleText.getText().toString());

        //afterImage Loading
        afterImageView.setImageDrawable(getResources().getDrawable(R.drawable.common_full_open_on_phone));

        //afterData
        afterWeight=0.0;
        afterChest=0.0;
        afterWaist=0.0;
        afterHip=0.0;
        afterFat=0.0;
        afterMuscle=0.0;
        afterWeightText.setText(afterWeight.toString());
        afterChestText.setText(afterChest.toString());
        afterWaistText.setText(afterWaist.toString());
        afterHipText.setText(afterHip.toString());
        afterFatText.setText(afterFat.toString());
        afterMuscleText.setText(afterMuscle.toString());




        return root;
    }


}
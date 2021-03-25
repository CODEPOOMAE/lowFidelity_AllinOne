package coms.example.allinonelowfiproject.ExerciseDiary.ui.BeforeAndAfter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import coms.example.allinonelowfiproject.R;

import static android.app.Activity.RESULT_OK;

public class BeforeAndAfterFragment extends Fragment {

    private BeforeAndAfterViewModel beforeAndAfterViewModel;
    private ImageView beforeImage;
    private ImageView afterImage;
    private final int GET_GALLERY_IMAGE=200;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beforeAndAfterViewModel =
                new ViewModelProvider(this).get(BeforeAndAfterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_before_and_after, container, false);

        // permission check!!



        beforeImage=(ImageView)root.findViewById(R.id.before_photo);
        beforeImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,GET_GALLERY_IMAGE);
            }
        });


        beforeAndAfterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            beforeImage.setImageURI(selectedImageUri);

        }

    }
}
package coms.example.allinonelowfiproject.ExerciseDiary.BeforeAndAfter;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeforeAndAfterViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;
    private MutableLiveData<Double> mData;
    private MutableLiveData<ImageView> mImage;

    public BeforeAndAfterViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("+");
    }


    //getter
    public LiveData<String> getText(){return mText;}
    public LiveData<Double> getData(){return mData;}
    public LiveData<ImageView> getImage() {return mImage;}

}
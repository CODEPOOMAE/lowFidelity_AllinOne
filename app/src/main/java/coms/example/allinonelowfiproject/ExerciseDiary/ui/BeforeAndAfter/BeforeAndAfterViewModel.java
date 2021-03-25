package coms.example.allinonelowfiproject.ExerciseDiary.ui.BeforeAndAfter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeforeAndAfterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BeforeAndAfterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is BeforeAndAfter fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
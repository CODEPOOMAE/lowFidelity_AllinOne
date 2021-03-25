package coms.example.allinonelowfiproject.ExerciseDiary.ui.Setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExerciseSettingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExerciseSettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ExerciseSetting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
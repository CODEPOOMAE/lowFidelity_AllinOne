package coms.example.allinonelowfiproject.ExerciseDiary.ui.BodyPlan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BodyPlanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BodyPlanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is BodyPlan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
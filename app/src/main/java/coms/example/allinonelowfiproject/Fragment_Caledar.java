package coms.example.allinonelowfiproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.threeten.bp.DayOfWeek;

import coms.example.allinonelowfiproject.decorators.OneDayDecorator;
import coms.example.allinonelowfiproject.decorators.SaturdayDecorator;
import coms.example.allinonelowfiproject.decorators.SundayDecorator;
import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;
import coms.example.allinonelowfiproject.mainCalendar.CalendarMode;
import coms.example.allinonelowfiproject.mainCalendar.DayViewDecorator;
import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;
import coms.example.allinonelowfiproject.mainCalendar.OnDateSelectedListener;

public class Fragment_Caledar extends Fragment {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();

    MaterialCalendarView materialCalendarView;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Fragment_Caledar(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container,false);
    }
}
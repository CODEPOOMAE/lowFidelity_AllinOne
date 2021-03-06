package coms.example.allinonelowfiproject;

import android.content.Intent;
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

    private static MaterialCalendarView materialCalendarView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar,container,false);

        materialCalendarView = view.findViewById(R.id.calendarView_HKB);
        materialCalendarView.addDecorators(new SundayDecorator(), new SaturdayDecorator());
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth();
                int Day = date.getDay();

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "," + Month + "," + Day;

                Log.i("shot_Day test", shot_Day + "");
                materialCalendarView.clearSelection();

                Toast.makeText(getActivity(), shot_Day , Toast.LENGTH_SHORT).show();

                int plus = date.getDay();
                int minus = date.getMonth();
                int sum = plus-minus;

                String sum_of_test = sum+ "."; //good result
                Toast.makeText(getActivity(), sum_of_test , Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
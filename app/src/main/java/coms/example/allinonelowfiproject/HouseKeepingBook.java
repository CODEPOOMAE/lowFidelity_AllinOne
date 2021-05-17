package coms.example.allinonelowfiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.decorators.OneDayDecorator;
import coms.example.allinonelowfiproject.decorators.SaturdayDecorator;
import coms.example.allinonelowfiproject.decorators.SundayDecorator;
import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;
import coms.example.allinonelowfiproject.mainCalendar.CalendarMode;
import coms.example.allinonelowfiproject.mainCalendar.DayViewDecorator;
import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;
import coms.example.allinonelowfiproject.mainCalendar.OnDateSelectedListener;

public class HouseKeepingBook extends AppCompatActivity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping_book);

        /*버튼생성*/
        btn1 = (Button)findViewById(R.id.btn_calendar);
        btn2 = (Button)findViewById(R.id.btn_expense);
        btn3 = (Button)findViewById(R.id.btn_statistics);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_Caledar fragmentCaledar = new Fragment_Caledar();
                transaction.replace(R.id.frame,fragmentCaledar);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_Expense fragmentExpense = new Fragment_Expense();
                transaction.replace(R.id.frame,fragmentExpense);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_Statistics fragmentStatistics = new Fragment_Statistics();
                transaction.replace(R.id.frame,fragmentStatistics);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    public void onButtonClick(View view) {
        finish();
    }
}
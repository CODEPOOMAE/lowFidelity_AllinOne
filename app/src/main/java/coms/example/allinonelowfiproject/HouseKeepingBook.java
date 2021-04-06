package coms.example.allinonelowfiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.utils.Easing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

import java.util.ArrayList;

import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;

public class HouseKeepingBook extends AppCompatActivity {


    MaterialCalendarView materialCalendarView;

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping_book);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton2);
        MaterialCalendarView ClanV = (MaterialCalendarView) findViewById(R.id.CalenderForHKB);
        ClanV.setVisibility(View.INVISIBLE);
        FrameLayout FLOut = (FrameLayout) findViewById(R.id.FrameLayout1);
        FLOut.setVisibility(View.INVISIBLE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.VISIBLE);
                FLOut.setVisibility(View.INVISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.INVISIBLE);
                FLOut.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.INVISIBLE);
                FLOut.setVisibility(View.INVISIBLE);
                pieChart = (PieChart)findViewById(R.id.piechart);

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5,10,5,5);

                pieChart.setDragDecelerationFrictionCoef(0.95f);
                pieChart.setRotationEnabled(false); //차트 돌아감
                pieChart.setDrawHoleEnabled(false);
                pieChart.setHoleRadius(25f);
                pieChart.setCenterText("지출?");
                pieChart.setTransparentCircleRadius(61f);

                Description description = new Description();
                description.setText("수입 내역"); //라벨
                description.setTextSize(15);
                pieChart.setDescription(description);

                //pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

                ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
                yValues.add(new PieEntry(34f,"용돈"));
                yValues.add(new PieEntry(23f,"주식"));
                yValues.add(new PieEntry(14f,"코인"));

                PieDataSet dataSet = new PieDataSet(yValues,"수입 내역");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                PieData data = new PieData((dataSet));
                data.setValueTextSize(10f);
                data.setValueTextColor(Color.YELLOW);

                pieChart.setData(data);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /*private void addDataSet(PieChart chart){
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i<YData.length;i++){
            yEntrys.add(new PieEntry(YData[i],i));
        }
        for(int i = 1; i<XData.length;i++){
            xEntrys.add(XData[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(yEntrys, "테스트1");


         //add Color
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        pieDataSet.setColor(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm
    }*/

    public void onButtonClick(View view) {
        finish();
    }
}
package coms.example.allinonelowfiproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Expense extends Fragment {
    private Button day_btn, week_btn, month_btn;
    int day_plus, day_minus, day_sum;

    public Fragment_Expense(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expense,container,false);

        day_btn = (Button)view.findViewById(R.id.btn_Day);
        week_btn = (Button)view.findViewById(R.id.btn_Week);
        month_btn = (Button)view.findViewById(R.id.btn_Month);

        day_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(),"Day_data",Toast.LENGTH_SHORT).show();
                day_sum = day_minus+day_plus;
                if(day_sum < 0){
                    //파란색
                }
                if(day_sum > 0){
                    //빨간색
                }
            }
        });
        week_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(),"Week_data",Toast.LENGTH_SHORT).show();
            }
        });
        month_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(),"Month_data",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

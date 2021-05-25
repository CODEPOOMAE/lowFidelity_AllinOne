package coms.example.allinonelowfiproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Statistics extends Fragment {

    private Button graph_btn,type_btn;

    public Fragment_Statistics(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statics,container,false);
        graph_btn = (Button)view.findViewById(R.id.btn_graph);
        type_btn = (Button)view.findViewById(R.id.btn_type);

        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        type_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //return inflater.inflate(R.layout.fragment_statics, container,false);
        return view;
    }
}
package com.example.cookingclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TimerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        Button omeletteBtn = view.findViewById(R.id.omelette_btn);
        Button sunnyBtn = view.findViewById(R.id.sunny_side_btn);
        Button poachBtn = view.findViewById(R.id.poached_btn);
        Button spreadBtn = view.findViewById(R.id.spread_btn);

        omeletteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimerDetailsActivity.class);
                intent.putExtra("title", "Omelette");
                intent.putExtra("prep_duration", "10");
                intent.putExtra("cook_duration", "15");
                intent.putExtra("rest_duration", "10");
                startActivity(intent);
            }
        });

        sunnyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimerDetailsActivity.class);
                intent.putExtra("title", "Sunny Side Up");
                intent.putExtra("prep_duration", "5");
                intent.putExtra("cook_duration", "4");
                intent.putExtra("rest_duration", "5");
                startActivity(intent);
            }
        });

        poachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimerDetailsActivity.class);
                intent.putExtra("title", "Poached");
                intent.putExtra("prep_duration", "3");
                intent.putExtra("cook_duration", "4");
                intent.putExtra("rest_duration", "5");
                startActivity(intent);
            }
        });

        spreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimerDetailsActivity.class);
                intent.putExtra("title", "Egg Spread");
                intent.putExtra("prep_duration", "15");
                intent.putExtra("cook_duration", "10");
                intent.putExtra("rest_duration", "5");
                startActivity(intent);
            }
        });



        return view;
    }

}
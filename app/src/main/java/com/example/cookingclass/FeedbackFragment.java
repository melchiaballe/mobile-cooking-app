package com.example.cookingclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FeedbackFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_feedback, container, false);

        Button omeletteBtn = view.findViewById(R.id.rating_omelette_btn);
        Button sunnyBtn = view.findViewById(R.id.rating_sunny_btn);
        Button poachBtn = view.findViewById(R.id.rating_poached_btn);
        Button spreadBtn = view.findViewById(R.id.rating_spread_btn);

        omeletteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedbackRatingActivity.class);
                intent.putExtra("title", "Omelette");
                startActivity(intent);
            }
        });

        sunnyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedbackRatingActivity.class);
                intent.putExtra("title", "Sunny Side Up");
                startActivity(intent);
            }
        });

        poachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedbackRatingActivity.class);
                intent.putExtra("title", "Poached");
                startActivity(intent);
            }
        });

        spreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedbackRatingActivity.class);
                intent.putExtra("title", "Egg Spread");
                startActivity(intent);
            }
        });

        return view;
    }
}
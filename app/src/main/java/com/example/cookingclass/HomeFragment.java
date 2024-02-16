package com.example.cookingclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button omeletteBtn = view.findViewById(R.id.omelette_btn);

        omeletteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecipeDetailsActivity.class);
                intent.putExtra("title", "Omelette");

                intent.putExtra("prep_duration", "10");
                intent.putExtra("cook_duration", "15");
                intent.putExtra("rest_duration", "10");

                intent.putExtra("preparation", "Beat the eggs: Use two or three eggs per " +
                        "omelette, depending on how hungry you are. Beat the eggs lightly with a fork.");
                intent.putExtra("cooking", "Melt the butter over medium-low heat, and " +
                        "keep the temperature low and slow when cooking the eggs so the bottom doesn’t" +
                        " get too brown or overcooked.");

                intent.putExtra("resting", "Fold the omelette in half. Slide it onto a plate" +
                        " with the help of a silicone spatula.");

                startActivity(intent);
            }
        });

        Button sunnyBtn = view.findViewById(R.id.sunny_side_btn);

        sunnyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecipeDetailsActivity.class);
                intent.putExtra("title", "Sunny Side Up");

                intent.putExtra("prep_duration", "5");
                intent.putExtra("cook_duration", "4");
                intent.putExtra("rest_duration", "5");

                intent.putExtra("preparation", "Heat the oil in a medium nonstick skillet" +
                        " over low heat until slightly shimmering,");
                intent.putExtra("cooking", "Crack an egg into a small ramekin and slowly add it to the skillet; " +
                        "repeat with the other egg, adding it to the other side of the skillet.");

                intent.putExtra("resting", "Slide the eggs out of the skillet onto a plate or toast. " +
                        "Season with salt and pepper.");


                startActivity(intent);
            }
        });

        return view;


    }


}
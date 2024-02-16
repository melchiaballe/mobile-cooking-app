package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String prep = intent.getStringExtra("preparation");
        String cook = intent.getStringExtra("cooking");
        String rest = intent.getStringExtra("resting");

        String prep_dur = intent.getStringExtra("prep_duration");
        String cook_dur = intent.getStringExtra("cook_duration");
        String rest_dur = intent.getStringExtra("rest_duration");

        TextView tViewTitle = findViewById(R.id.recipe_title);
        TextView tViewPrep = findViewById(R.id.preparation_desc);
        TextView tViewCook = findViewById(R.id.cooking_desc);
        TextView tViewRest = findViewById(R.id.resting_desc);

        TextView tViewPrepDur = findViewById(R.id.preparation_duration);
        TextView tViewCookDur = findViewById(R.id.cooking_duration);
        TextView tViewRestDur = findViewById(R.id.resting_duration);

        tViewTitle.setText(title);
        tViewPrep.setText(prep);
        tViewCook.setText(cook);
        tViewRest.setText(rest);

        tViewPrepDur.setText(prep_dur);
        tViewCookDur.setText(cook_dur);
        tViewRestDur.setText(rest_dur);

    }
}
package com.example.cookingclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment = new HomeFragment();
    private RecipeFragment recipeFragment = new RecipeFragment();
    private TimerFragment timerFragment = new TimerFragment();
    private FeedbackFragment feedbackFragment = new FeedbackFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, homeFragment, "homeFragment")
                .add(R.id.main_container, recipeFragment, "recipeFragment")
                .add(R.id.main_container, timerFragment, "timerFragment")
                .add(R.id.main_container, feedbackFragment, "feedbackFragment")
                .hide(recipeFragment)
                .hide(timerFragment)
                .hide(feedbackFragment)
                .commit();


        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.home) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(recipeFragment).hide(timerFragment).hide(feedbackFragment)
                            .show(homeFragment)
                            .commit();
                    return true;
                } else if (id == R.id.recipe) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(homeFragment).hide(timerFragment).hide(feedbackFragment)
                            .show(recipeFragment)
                            .commit();
                    return true;
                } else if (id == R.id.timer) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(homeFragment).hide(recipeFragment).hide(feedbackFragment)
                            .show(timerFragment)
                            .commit();
                    return true;
                } else if (id == R.id.feedback) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(homeFragment).hide(recipeFragment).hide(timerFragment)
                            .show(feedbackFragment)
                            .commit();
                    return true;
                }

                return false;
            }
        });

    }

//    public void launchTimerDetailScreen(View v) {
//        Intent intent = new Intent(this, TimerDetailsActivity.class);
//        startActivity(intent);
//    }

//    public void launchRecipeDetailScreen(View v) {
//        Intent intent = new Intent(this, RecipeDetailsActivity.class);
//        startActivity(intent);
//    }

//    public void launchFeedbackDetails(View v) {
//        Intent intent = new Intent(this, FeedbackRatingActivity.class);
//        startActivity(intent);
//    }


}
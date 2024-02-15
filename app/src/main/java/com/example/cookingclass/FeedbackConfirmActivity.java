package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;

public class FeedbackConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_confirm);

        Intent intent = getIntent();

        String title = intent.getStringExtra("Title");
        String comment = intent.getStringExtra("Comment");
        String share = intent.getStringExtra("Share");
        String rating = intent.getStringExtra("Rating");

        TextView tViewTitle = findViewById(R.id.confirmation_title);
        tViewTitle.setText(title);

        TextView tViewComment = findViewById(R.id.confirmation_comment);
        tViewComment.setText(comment);

        String shareText = Boolean.valueOf(share) ? "Feedback Shared" : "Feedback Hidden";
        TextView tViewShare = findViewById(R.id.confirmation_feedback);
        tViewShare.setText(shareText);

        RatingBar ratingBar = findViewById(R.id.confirmation_rating);
        ratingBar.setRating(Float.valueOf(rating));

    }

    public void launchConfirm(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class FeedbackRatingActivity extends AppCompatActivity {

    private SwitchCompat isAgreeTermsSwitch;
    private RatingBar feedbackRating;
    Boolean is_share = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_rating);

        Intent intent = getIntent();

        String title = getIntent().getStringExtra("title");
        TextView tviewTitle = (TextView) findViewById(R.id.rating_title);

        tviewTitle.setText(title);

        isAgreeTermsSwitch = (SwitchCompat) findViewById(R.id.agree_disagree_switch);
        isAgreeTermsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                is_share = isChecked ? true : false;
            }
        });

    }

    public void LaunchFeedbackConfirm(View view) {
        EditText editText = (EditText) findViewById(R.id.feedback_comment);
        TextView titleText = (TextView) findViewById(R.id.rating_title);

        String title = titleText.getText().toString();
        String custFeedback = editText.getText().toString();

        feedbackRating = (RatingBar) findViewById(R.id.feedback_rating);
        Float ratingNumber = feedbackRating.getRating();

        Intent intent = new Intent(this, FeedbackConfirmActivity.class);
        intent.putExtra("Title", title);
        intent.putExtra("Comment", custFeedback);
        intent.putExtra("Rating", String.valueOf(ratingNumber));
        intent.putExtra("Share", String.valueOf(is_share));

        startActivity(intent);
        finish();
    }
}
package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerDetailsActivity extends AppCompatActivity {

    private SeekBar timerDuration;
    private TextView seekbarTextView;
    private TextView genericDurationTextView;
    private ProgressBar timerProgressBar;
    private Button startButton;
    private Button pauseButton;
    private Button resetButton;

    private String cook_duration;
    private String rest_duration;

    private CountDownTimer timer;

    Boolean is_paused = false;
    Long millisecond_in_pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_details);

        Intent intent = getIntent();

        genericDurationTextView = (TextView) findViewById(R.id.duration_generic);
        genericDurationTextView.setText(intent.getStringExtra("prep_duration"));

        cook_duration = intent.getStringExtra("cook_duration");
        rest_duration = intent.getStringExtra("rest_duration");

        TextView tViewTitle = (TextView) findViewById(R.id.recipe_title);
        tViewTitle.setText(intent.getStringExtra("title"));

        timerDuration = (SeekBar) findViewById(R.id.seekbar_timer);
        seekbarTextView = (TextView) findViewById(R.id.timer_value);

        timerDuration.setProgress(Integer.valueOf(intent.getStringExtra("prep_duration")));
        seekbarTextView.setText(String.valueOf(timerDuration.getProgress()) + ":00");

        timerProgressBar = (ProgressBar) findViewById(R.id.timer_progress_bar);
        timerProgressBar.setVisibility(View.INVISIBLE);

        startButton = (Button) findViewById(R.id.timer_start);
        pauseButton = (Button) findViewById(R.id.timer_pause);
        resetButton = (Button) findViewById(R.id.timer_reset);

        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);


        timerDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarTextView.setText(String.valueOf(progress) + ":00");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void startTimerClick(View v) {
        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        resetButton.setEnabled(false);

        timerDuration.setEnabled(false);
        timerProgressBar.setVisibility(View.VISIBLE);

        long timer_dur = is_paused ? millisecond_in_pause : ((timerDuration.getProgress() * 60) * 1000);
        timer = new CountDownTimer(timer_dur, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                millisecond_in_pause = millisUntilFinished;
                int sec = (int) (millisUntilFinished / 1000);

                seekbarTextView.setText((sec / 60) + ":" + (sec % 60));
            }

            @Override
            public void onFinish() {
                seekbarTextView.setText("Complete");
                timerProgressBar.setVisibility(View.INVISIBLE);

                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
                resetButton.setEnabled(false);

                timerDuration.setEnabled(true);

            }
        }.start();
    }

    public void pauseTimerClick(View v) {
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resetButton.setEnabled(true);
        timerProgressBar.setVisibility(View.INVISIBLE);

        timer.cancel();
        is_paused = true;
    }

    public void resetTimerClick(View v) {
        is_paused = false;

        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        timerDuration.setEnabled(true);
        timerProgressBar.setVisibility(View.INVISIBLE);

        timer.cancel();

        timerDuration.setProgress(Integer.valueOf(genericDurationTextView.getText().toString()));
        seekbarTextView.setText(String.valueOf(timerDuration.getProgress()) + ":00");
    }

    public void nextStage(View v) {
        Button nextStageBtn = (Button) findViewById(R.id.next_stage);

        timer.cancel();
        is_paused = false;

        if (!nextStageBtn.getText().toString().toLowerCase().equals("done")) {
            TextView tViewCurrStage = findViewById(R.id.current_stage);
            timerProgressBar.setVisibility(View.INVISIBLE);

            if (tViewCurrStage.getText().toString().toLowerCase().equals("preparation")) {
                tViewCurrStage.setText("COOKING");

                timerDuration.setProgress(Integer.valueOf(cook_duration));
                genericDurationTextView.setText(cook_duration);

            } else if (tViewCurrStage.getText().toString().toLowerCase().equals("cooking")) {
                tViewCurrStage.setText("RESTING");

                timerDuration.setProgress(Integer.valueOf(rest_duration));
                genericDurationTextView.setText(rest_duration);
            }

            if (tViewCurrStage.getText().toString().toLowerCase().equals("resting")) {
                nextStageBtn.setText("Done");

                startButton.setEnabled(false);
                pauseButton.setEnabled(false);
                resetButton.setEnabled(false);

                timerDuration.setEnabled(false);
                genericDurationTextView.setText("0");
                seekbarTextView.setText("You have completed cooking");
            } else {
                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
                resetButton.setEnabled(false);

                seekbarTextView.setText(String.valueOf(timerDuration.getProgress()) + ":00");
                timerDuration.setEnabled(true);
            }
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }


    }


}
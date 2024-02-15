package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerDetailsActivity extends AppCompatActivity {

    private SeekBar timerDuration;
    private TextView seekbarTextView;
    private Button startButton;
    private Button pauseButton;
    private Button resetButton;


    Boolean is_start, is_pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_details);

        timerDuration = (SeekBar) findViewById(R.id.seekbar_timer);
        seekbarTextView = (TextView) findViewById(R.id.timer_value);

        timerDuration.setProgress(20);
        seekbarTextView.setText(String.valueOf(timerDuration.getProgress()) + ":00");

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
        is_start = true;
        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        resetButton.setEnabled(false);

        timerDuration.setEnabled(false);
    }

    public void pauseTimerClick(View v) {
        is_pause = true;
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resetButton.setEnabled(true);
    }

    public void resetTimerClick(View v) {
        is_start = false;
        is_pause = false;
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        timerDuration.setEnabled(true);
    }


}
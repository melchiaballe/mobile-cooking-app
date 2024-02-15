package com.example.cookingclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerDetailsActivity extends AppCompatActivity {

    private SeekBar timerDuration;
    private TextView seekbarTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_details);

        timerDuration = (SeekBar) findViewById(R.id.seekbar_timer);
        seekbarTextView = (TextView) findViewById(R.id.timer_value);

        timerDuration.setProgress(20);
        seekbarTextView.setText(String.valueOf(timerDuration.getProgress()) + ":00");

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
}
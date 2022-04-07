package com.example.mytaimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtSeconds = (TextView)  findViewById(R.id.txtSeconds);
        Button btnStart = (Button) findViewById(R.id.btnStart);


        View.OnClickListener oclbtn = new View.OnClickListener()
        {
          @Override
          public void onClick(View v)
          {
              long seconds = Long.parseLong(txtSeconds.getText().toString());

              CountDownTimer my_timer = new CountDownTimer(seconds*1000, 1000) {
                  @Override
                  public void onTick(long l) {
                      txtSeconds.setText(Long.toString(l/1000));
                  }

                  @Override
                  public void onFinish() {
                      txtSeconds.setText("Конец работы");
                  }
              };

              my_timer.start();
          }
        };
        btnStart.setOnClickListener(oclbtn);


    }
}
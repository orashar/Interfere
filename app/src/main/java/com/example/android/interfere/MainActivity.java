package com.example.android.interfere;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private static String timeToSet;
    private static final int PICKER_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.set_btn);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickerIntent = new Intent(getApplicationContext(), PickerActivity.class);
                startActivityForResult(pickerIntent, PICKER_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICKER_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                timeToSet = data.getStringExtra("TIME_TO_SET");
                TextView textView = findViewById(R.id.text_view);
                textView.setText(timeToSet);
            }
        }
    }
}

package com.example.tasbeehcounterse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btIncrement;
    private Button btReset;
    private TextView tvCounter;
    private int counter = 0;
    private Button btSave;
    SharedPreferences sharedPreferences;
    private List<Integer> counterList = new ArrayList<>();
    private static final String  NAME_PREF = "MyPrefsFile";
    private static final String  KEY_PREF = "MyPrefsKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btIncrement = findViewById(R.id.incrementButton);
        btReset = findViewById(R.id.resetButton);
        btSave = findViewById(R.id.saveButton);
        tvCounter = findViewById(R.id.counterTextView);

        sharedPreferences = getSharedPreferences(NAME_PREF, MODE_PRIVATE);
        counter = sharedPreferences.getInt(KEY_PREF,0);
        tvCounter.setText(String.valueOf(counter));

        btIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(String.valueOf(counter));
                saveCounter();

            }
        });
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                tvCounter.setText(String.valueOf(counter));
                saveCounter();
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CounterListActivity.class);
                intent.putExtra("counterValue", counter);
                startActivity(intent);
            }
        });

    }
    public void saveCounter(){
        SharedPreferences.Editor editor = getSharedPreferences(NAME_PREF,0).edit();
        editor.putInt(KEY_PREF,counter);
        editor.apply();
    }
}
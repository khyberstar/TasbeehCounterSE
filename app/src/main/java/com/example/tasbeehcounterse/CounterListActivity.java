package com.example.tasbeehcounterse;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CounterListActivity extends AppCompatActivity {

    private List<Integer> counterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CounterListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);

        // Receive the counter value from MainActivity
        int counterValue = getIntent().getIntExtra("counterValue", 0);

        // Add the counter value to the list
        counterList.add(counterValue);

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CounterListAdapter(counterList);
        recyclerView.setAdapter(adapter);
    }
}

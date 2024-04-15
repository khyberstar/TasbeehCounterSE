package com.example.tasbeehcounterse;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CounterListAdapter extends RecyclerView.Adapter<CounterListAdapter.ViewHolder> {

    private List<Integer> counterList;

    public CounterListAdapter(List<Integer> counterList) {
        this.counterList = counterList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_counter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int counter = counterList.get(position);
        holder.counterTextView.setText(String.valueOf(counter));
    }

    @Override
    public int getItemCount() {
        return counterList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView counterTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            counterTextView = itemView.findViewById(R.id.counterTextView);
        }
    }
}

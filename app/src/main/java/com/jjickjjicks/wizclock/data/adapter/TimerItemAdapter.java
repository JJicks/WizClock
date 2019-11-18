package com.jjickjjicks.wizclock.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jjickjjicks.wizclock.R;
import com.jjickjjicks.wizclock.data.item.TimerItem;

import java.util.ArrayList;

public class TimerItemAdapter extends RecyclerView.Adapter<TimerItemAdapter.ViewHolder> {
    private ArrayList<TimerItem> list = null;

    public TimerItemAdapter(ArrayList<TimerItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TimerItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.card_timer_item, parent, false);
        TimerItemAdapter.ViewHolder vh = new TimerItemAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getTypeIcon());
        holder.itemName.setText(list.get(position).getTitle());
        holder.itemAuthor.setText(list.get(position).getAuthorName());
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemAuthor;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.typeIconView);
            itemName = itemView.findViewById(R.id.tvTimerTitle);
            itemAuthor = itemView.findViewById(R.id.tvTimerAuthor);
        }
    }
}
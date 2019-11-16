package com.jjickjjicks.wizclock.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjickjjicks.wizclock.R;
import com.jjickjjicks.wizclock.data.item.TimerItem;

import java.util.ArrayList;

public class TimerItemAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<TimerItem> list;

    public TimerItemAdapter(Context context, ArrayList<TimerItem> data) {
        mContext = context;
        list = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public TimerItem getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.card_timer_item, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.typeIconView);
        TextView itemName = (TextView) view.findViewById(R.id.tvTimerTitle);
        TextView itemAuthor = (TextView) view.findViewById(R.id.tvTimerAuthor);

        imageView.setImageResource(getItem(position).getTypeIcon());
        itemName.setText(getItem(position).getTitle());
        itemAuthor.setText(getItem(position).getAuthorName());

        return view;
    }
}
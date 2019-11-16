package com.jjickjjicks.wizclock.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jjickjjicks.wizclock.R;
import com.jjickjjicks.wizclock.data.adapter.TimerItemAdapter;
import com.jjickjjicks.wizclock.data.item.TimerItem;

import java.util.ArrayList;
import java.util.Timer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TimerFragment extends Fragment {
    private ArrayList<TimerItem> timerItmeDataList;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_timer, container, false);

        listView = root.findViewById(R.id.listViewTimeItem);
        final TimerItemAdapter timerItemAdapter = new TimerItemAdapter(getContext(), timerItmeDataList);
        
        initializeFakeItem();

        listView.setAdapter(timerItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), timerItemAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    private void initializeFakeItem() {
        timerItmeDataList = new ArrayList<>();
        timerItmeDataList.add(new TimerItem("제목","설명","제작자","email",0));
        timerItmeDataList.add(new TimerItem("제목","설명","제작자","email",0));
        timerItmeDataList.add(new TimerItem("제목","설명","제작자","email",0));
    }


}
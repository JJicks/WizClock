package com.jjickjjicks.wizclock;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjickjjicks.wizclock.data.item.TimerData;
import com.jjickjjicks.wizclock.data.item.TimerItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;


public class TimerAddActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private long key = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_add);

        RegisterTimerData("test", "test", 1, 1, new ArrayList<>(Arrays.asList(Long.valueOf(100), Long.valueOf(10))));
    }

    private void RegisterTimerData(final String title, final String description, final int type, final int timeCnt, final ArrayList<Long> timeList) {
        databaseReference = FirebaseDatabase.getInstance().getReference("timer");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    key = dataSnapshot.getChildrenCount();
                    Log.d("JsonSaveCheck 2", String.valueOf(key));
                }
                TimerItem item = new TimerItem(key + 1, title, description, user.getEmail(), user.getDisplayName(), type, new TimerData(timeCnt, timeList));
                databaseReference.child(String.valueOf(key + 1)).setValue(item.toMap());

                SharedPreferences preferences = getSharedPreferences("TimerItem", 0);
                SharedPreferences.Editor editor = preferences.edit();

                ArrayList<String> keyList = new ArrayList<>();
                String Json = preferences.getString("key", null);
                if (Json != null) {
                    Log.d("JsonSaveCheck 3", Json);
                    try {
                        JSONArray jsonArray = new JSONArray(Json);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            keyList.add(jsonArray.optString(i));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("JsonSaveCheck 2-1", keyList.toString());

                keyList.add(String.valueOf(key + 1));
                JSONArray jsonArray = new JSONArray();
                for (String i : keyList) {
                    jsonArray.put(i);
                }

                String keyJson = null;
                if (!keyList.isEmpty())
                    keyJson = jsonArray.toString();

                Log.d("JsonSaveCheck 1", keyJson);

                editor.putString("key", keyJson);
                editor.putString(String.valueOf(key + 1), item.toString());
                editor.apply();
                Log.d("JsonSaveCheck", item.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

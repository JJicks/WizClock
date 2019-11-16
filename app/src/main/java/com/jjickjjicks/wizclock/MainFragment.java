package com.jjickjjicks.wizclock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainFragment extends Fragment {
    private TextView tvUserName;
    private FirebaseUser user;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        // Firebase 로드
        user = FirebaseAuth.getInstance().getCurrentUser();
        tvUserName = root.findViewById(R.id.tvUserName);
        tvUserName.setText("반갑습니다! " + user.getDisplayName());

        return root;
    }
}

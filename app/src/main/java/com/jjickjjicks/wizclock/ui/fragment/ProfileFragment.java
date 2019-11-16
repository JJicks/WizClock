package com.jjickjjicks.wizclock.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jjickjjicks.wizclock.R;


public class ProfileFragment extends Fragment {
    private ImageView imageViewHeaderProfile;
    private TextView textViewUserName, textViewUserPhoneNumber, textViewUserEmail, textViewHeaderUserName, textViewHeaderUserEmail;
    private FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        textViewUserName = root.findViewById(R.id.textViewUserName);
        textViewUserPhoneNumber = root.findViewById(R.id.textViewUserPhoneNumber);
        textViewUserEmail = root.findViewById(R.id.textViewUserEmail);
        textViewHeaderUserName = root.findViewById(R.id.textViewHeaderUserName);
        textViewHeaderUserEmail = root.findViewById(R.id.textViewHeaderUserEmail);
        imageViewHeaderProfile = root.findViewById(R.id.imageViewHeaderProfile);

        // Firebase 로드
        user = FirebaseAuth.getInstance().getCurrentUser();
        textViewUserName.setText(user.getDisplayName());
        textViewUserPhoneNumber.setText((!(user.getPhoneNumber() == null) && !user.getPhoneNumber().equals("")) ? user.getPhoneNumber() : "등록되지 않았습니다.");
        textViewUserEmail.setText(user.getEmail());
        textViewHeaderUserName.setText(user.getDisplayName());
        textViewHeaderUserEmail.setText(user.getEmail());
        if (user.getPhotoUrl().equals(null))
            Glide.with(this).load(R.drawable.blank_profile_image).apply(RequestOptions.circleCropTransform()).into(imageViewHeaderProfile);
        else
            Glide.with(this).load(user.getPhotoUrl()).apply(RequestOptions.circleCropTransform()).into(imageViewHeaderProfile);

        return root;
    }
}

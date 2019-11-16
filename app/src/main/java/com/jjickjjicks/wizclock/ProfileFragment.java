package com.jjickjjicks.wizclock;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {
    private CircleImageView imageViewHeaderProfile;
    private TextView textViewUserName, textViewUserPhoneNumber, textViewUserEmail, textViewHeaderUserName, textViewHeaderUserEmail;
    private FirebaseUser user;
    private URL url;

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
        textViewUserPhoneNumber.setText((user.getPhoneNumber().equals("")) ? "등록되지 않았습니다." : user.getPhoneNumber());
        textViewUserEmail.setText(user.getEmail());
        textViewHeaderUserName.setText(user.getDisplayName());
        textViewHeaderUserEmail.setText(user.getEmail());

        return root;
    }
}
